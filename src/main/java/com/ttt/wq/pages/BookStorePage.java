package com.ttt.wq.pages;

import org.openqa.selenium.By;

import com.ttt.wq.utils.LogHelper;

public class BookStorePage extends BasePage {

    public void search(String bookName) {
        LogHelper.getLogger().info("Searching for book: {}", bookName);
        fillText(By.id("searchBox"), bookName);
    }

    public boolean isBookVisible(String bookName) {
        return isDisplayed(By.cssSelector("[id='see-book-" + bookName + "']"));
    }

    public void openBook(String bookName) {
        click(By.cssSelector("[id='see-book-" + bookName + "']"));
    }

    public boolean isBookDetailsVisible(String bookName) {
        return isDisplayed(By.xpath("//label[text()='" + bookName + "']"));
    }

    public void addToCollection() {
        scrollToElement(By.xpath("//button[text()='Add To Your Collection']"));
        click(By.xpath("//button[text()='Add To Your Collection']"));
    }

    public String getAlertMessage() {
        return getAlertText();
    }
}
