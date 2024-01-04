package com.ttt.wq;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTest {

    @Test
    public void searchBook() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys("wq-basic");
        driver.findElement(By.id("password")).sendKeys("Wq-basic&01");
        driver.findElement(By.id("login")).click();
        wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gotoStore")));
        WebElement storeButton = driver.findElement(By.id("gotoStore"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", storeButton);
        storeButton.click();

        wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
        driver.findElement(By.id("searchBox")).sendKeys("Programming JavaScript Applications");

        driver.quit();
    }

    @Test
    public void addBookToProfile() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("userName")).sendKeys("wq-basic");
        driver.findElement(By.id("password")).sendKeys("Wq-basic&01");
        driver.findElement(By.id("login")).click();
        wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gotoStore")));
        WebElement storeButton = driver.findElement(By.id("gotoStore"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", storeButton);
        storeButton.click();

        wait.until(driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
        driver.findElement(By.id("searchBox")).sendKeys("Programming JavaScript Applications");

        driver.findElement(By.cssSelector("[id='see-book-Programming JavaScript Applications']")).click();

        boolean bookDetailsVisible = driver
                .findElement(By.xpath("//label[text()='Programming JavaScript Applications']")).isDisplayed();

        Assert.assertTrue(bookDetailsVisible, "Book details are not visible");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gotoStore")));
        WebElement addToCollectionButton = driver.findElement(By.xpath("//button[text()='Add To Your Collection']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCollectionButton);
        addToCollectionButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Book added to your collection.");

        driver.quit();
    }
}
