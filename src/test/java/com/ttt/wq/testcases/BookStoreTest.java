package com.ttt.wq.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ttt.wq.pages.BookStorePage;
import com.ttt.wq.pages.LoginPage;
import com.ttt.wq.pages.ProfilePage;
import com.ttt.wq.utils.LogHelper;

public class BookStoreTest extends BaseTest {

        @Test(enabled = false)
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

        @Test
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
