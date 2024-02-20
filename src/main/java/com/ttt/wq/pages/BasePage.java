package com.ttt.wq.pages;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ttt.wq.manager.driver.DriverFactory;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // only accessible in same package and to child class
    protected BasePage() {
        this.driver = DriverFactory.getDriverInstance();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected BasePage(int waitInSeconds) {
        this.driver = DriverFactory.getDriverInstance();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
    }

    protected void goToUrl(String url) {
        driver.get(url);
        waitForPageLoad();
    }

    protected void fillText(By by, String text) {
        getElement(by).sendKeys(text);
    }

    protected void click(By by) {
        getElement(by).click();
        waitForPageLoad();
    }

    protected String getText(By by) {
        return getElement(by).getText();
    }

    protected boolean isDisplayed(By by) {
        return getElement(by).isDisplayed();
    }

    protected String getAlertText() {
        return getAlert().getText();
    }

    protected void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(by));
    }

    private Alert getAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    private WebElement getElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void waitForPageLoad() {
        wait.until(driver -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
    }

}
