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
import com.ttt.wq.manager.file.reader.PropertyReader;
import com.ttt.wq.utils.LogHelper;
import io.qameta.allure.Step;

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

    @Step
    protected void goToUrl(String url) {
        String path = PropertyReader.getProperty("baseUrl") + url;
        LogHelper.getLogger().info("Navigating to " + path);
        driver.get(path);
        waitForPageLoad();
    }

    @Step
    protected void fillText(By by, String text) {
        getElement(by).sendKeys(text);
    }

    @Step
    protected void click(By by) {
        getElement(by).click();
        waitForPageLoad();
        LogHelper.getLogger().info("Clicked on Element: " + by);
    }

    @Step
    protected String getText(By by) {
        return getElement(by).getText();
    }

    @Step
    protected boolean isDisplayed(By by) {
        return getElement(by).isDisplayed();
    }

    @Step
    protected String getAlertText() {
        return getAlert().getText();
    }

    @Step
    protected void scrollToElement(By by) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(by));
    }

    @Step
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
