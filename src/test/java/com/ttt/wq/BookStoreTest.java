package com.ttt.wq;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ttt.wq.pages.BookStorePage;
import com.ttt.wq.pages.LoginPage;
import com.ttt.wq.pages.ProfilePage;

public class BookStoreTest {

        @Test(enabled = false)
        public void searchBook() {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                LoginPage loginPage = new LoginPage(driver);
                ProfilePage profilePage = new ProfilePage(driver);
                BookStorePage bookStorePage = new BookStorePage(driver);
                String bookName = "Programming JavaScript Applications";

                loginPage.open();
                loginPage.login("wq-basic", "Wq-basic&01");

                profilePage.goToBookStore();

                bookStorePage.search(bookName);
                Assert.assertTrue(bookStorePage.isBookVisible(bookName));

                driver.quit();
        }

        @Test(enabled = false)
        public void addBookToProfile() {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                LoginPage loginPage = new LoginPage(driver);
                ProfilePage profilePage = new ProfilePage(driver);
                BookStorePage bookStorePage = new BookStorePage(driver);
                String bookName = "Programming JavaScript Applications";

                loginPage.open();
                loginPage.login("wq-basic", "Wq-basic&01");

                profilePage.goToBookStore();

                bookStorePage.search(bookName);
                bookStorePage.openBook(bookName);
                boolean bookDetailsVisible = bookStorePage.isBookDetailsVisible(bookName);
                Assert.assertTrue(bookDetailsVisible, "Book details are not visible");

                bookStorePage.addToCollection();
                String alertMessage = bookStorePage.getAlertMessage();
                Assert.assertEquals(alertMessage, "Book added to your collection.");

                driver.quit();
        }
}
