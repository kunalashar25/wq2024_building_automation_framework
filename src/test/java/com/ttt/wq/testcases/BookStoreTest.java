package com.ttt.wq.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ttt.wq.pages.BookStorePage;
import com.ttt.wq.pages.LoginPage;
import com.ttt.wq.pages.ProfilePage;
import com.ttt.wq.utils.LogHelper;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class BookStoreTest extends BaseTest {

        @Test
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
                loginPage.login("wq-basic", "Wq-basic&01");

                profilePage.goToBookStore();

                bookStorePage.search(bookName);
                Assert.assertTrue(bookStorePage.isBookVisible(bookName));
        }

        @Test(enabled = false)
        public void addBookToProfile() {
                LoginPage loginPage = new LoginPage();
                ProfilePage profilePage = new ProfilePage();
                BookStorePage bookStorePage = new BookStorePage();
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
        }

        @Test
        public void log1() {
                LogHelper.getLogger().info("inside log1");
        }

        @Test
        public void log2() {
                LogHelper.getLogger().info("inside log2");
                Assert.assertTrue(false, "Item not added in the cart!");
        }
}
