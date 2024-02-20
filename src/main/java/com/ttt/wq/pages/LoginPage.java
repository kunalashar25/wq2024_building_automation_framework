package com.ttt.wq.pages;

import org.openqa.selenium.By;

import com.ttt.wq.utils.LogHelper;

public class LoginPage extends BasePage {

    public void open() {
        goToUrl("login");
    }

    public void login(String username, String password) {
        fillText(By.id("userName"), username);
        fillText(By.id("password"), password);
        click(By.id("login"));
        LogHelper.getLogger().debug("Logging in with credentials: {} and {}", username, password);
    }
}
