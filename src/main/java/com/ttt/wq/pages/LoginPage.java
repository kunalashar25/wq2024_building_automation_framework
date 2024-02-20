package com.ttt.wq.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void open() {
        goToUrl("login");
    }

    public void login(String username, String password) {
        fillText(By.id("userName"), username);
        fillText(By.id("password"), password);
        click(By.id("login"));
    }
}
