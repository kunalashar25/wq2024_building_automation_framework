package com.ttt.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    public void search(String bookName) {
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
        click(By.xpath("//button[text()='Add To Your Collection']"));
    }

    public String getAlertMessage() {
        return getAlertText();
    }
}
