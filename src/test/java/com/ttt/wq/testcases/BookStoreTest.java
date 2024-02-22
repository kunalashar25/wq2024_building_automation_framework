package com.ttt.wq.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ttt.wq.manager.file.reader.PropertyReader;
import com.ttt.wq.pages.BookStorePage;
import com.ttt.wq.pages.LoginPage;
import com.ttt.wq.pages.ProfilePage;
import com.ttt.wq.utils.LogHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BookStoreTest extends BaseTest {

        @Test(groups = "chrome")
        @Severity(SeverityLevel.BLOCKER)
        @Description("Search for a random book")
        @Epic("Book Search")
        @Feature("Search with pagination")
        public void searchBook() {
                LoginPage loginPage = new LoginPage();
                ProfilePage profilePage = new ProfilePage();
                BookStorePage bookStorePage = new BookStorePage();
                String bookName = "Programming JavaScript Applications";

                loginPage.open();
                loginPage.login(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));

                profilePage.goToBookStore();

                bookStorePage.search(bookName);
                Assert.assertTrue(bookStorePage.isBookVisible(bookName));
        }

        @Test(enabled = false)
        @Severity(SeverityLevel.MINOR)
        @Description("Add Book to Profile")
        @Epic("Book Search")
        @Feature("Book Profiling")
        @Flaky
        public void addBookToProfile() {
                LoginPage loginPage = new LoginPage();
                ProfilePage profilePage = new ProfilePage();
                BookStorePage bookStorePage = new BookStorePage();
                String bookName = "Programming JavaScript Applications";

                loginPage.open();
                loginPage.login(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));

                profilePage.goToBookStore();

                bookStorePage.search(bookName);
                bookStorePage.openBook(bookName);
                boolean bookDetailsVisible = bookStorePage.isBookDetailsVisible(bookName);
                Assert.assertTrue(bookDetailsVisible, "Book details are not visible");

                bookStorePage.addToCollection();
                String alertMessage = bookStorePage.getAlertMessage();
                Assert.assertEquals(alertMessage, "Book added to your collection.");
        }

        @Test(groups = "firefox")
        @Severity(SeverityLevel.BLOCKER)
        @Description("Add Book to Cart")
        @Epic("Book Search")
        @Feature("Book Profiling")
        public void addBookToCart() {
                LogHelper.getLogger().info("inside addBookToCart");
                Assert.assertTrue(false, "Book not added in the cart!");
        }
}
