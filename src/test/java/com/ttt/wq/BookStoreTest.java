package com.ttt.wq;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreTest {

    @Test
    public void searchBook() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("userName")).sendKeys("hello");
        driver.findElement(By.id("password")).sendKeys("world");
        driver.findElement(By.id("login")).click();

        driver.findElement(By.id("gotoStore")).click();
        driver.findElement(By.id("searchBox")).sendKeys("Programming JavaScript Applications");

        driver.quit();
    }

    @Test
    public void addBookToProfile() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");

        driver.findElement(By.id("userName")).sendKeys("hello");
        driver.findElement(By.id("password")).sendKeys("world");
        driver.findElement(By.id("login")).click();

        driver.findElement(By.id("gotoStore")).click();
        driver.findElement(By.id("searchBox")).sendKeys("Programming JavaScript Applications");

        driver.findElement(By.cssSelector("[id='see-book-Programming JavaScript Applications']")).click();

        boolean bookDetailsVisible = driver
                .findElement(By.xpath("//label[text()='Programming JavaScript Applications']")).isDisplayed();

        Assert.assertTrue(bookDetailsVisible, "Book details are not visible");

        driver.findElement(By.id("addNewRecordButton")).click();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Book added to your collection.");

        driver.quit();
    }
}
