package com.ttt.wq.pages;

import org.openqa.selenium.By;

import com.ttt.wq.utils.LogHelper;
import com.ttt.wq.utils.Screenshot;

import io.qameta.allure.Step;

public class BookStorePage extends BasePage {

    @Step
    public void search(String bookName) {
        LogHelper.getLogger().info("Searching for book: {}", bookName);
        fillText(By.id("searchBox"), bookName);
        Screenshot.capture("searching book");
    }

    @Step
    public boolean isBookVisible(String bookName) {
        return isDisplayed(By.cssSelector("[id='see-book-" + bookName + "']"));
    }

    @Step
    public void openBook(String bookName) {
        click(By.cssSelector("[id='see-book-" + bookName + "']"));
        Screenshot.capture("opening book");
    }

    @Step
    public boolean isBookDetailsVisible(String bookName) {
        return isDisplayed(By.xpath("//label[text()='" + bookName + "']"));
    }

    @Step
    public void addToCollection() {
        scrollToElement(By.xpath("//button[text()='Add To Your Collection']"));
        click(By.xpath("//button[text()='Add To Your Collection']"));
        Screenshot.capture("adding book to collection");
    }

    @Step
    public String getAlertMessage() {
        return getAlertText();
    }
}
