package com.ttt.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        goToUrl("https://demoqa.com/login");
    }

    public void login(String username, String password) {
        fillText(By.id("userName"), username);
        fillText(By.id("password"), password);
        click(By.id("login"));
    }
}
