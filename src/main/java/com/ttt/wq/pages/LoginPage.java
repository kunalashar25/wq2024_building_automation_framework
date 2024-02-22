package com.ttt.wq.pages;

import org.openqa.selenium.By;
import com.ttt.wq.utils.LogHelper;
import com.ttt.wq.utils.Screenshot;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {

    @Step("Open Login Page")
    public void open() {
        goToUrl("login");
    }

    @Step
    public void login(String username, String password) {
        fillText(By.id("userName"), username);
        fillText(By.id("password"), password);
        click(By.id("login"));
        LogHelper.getLogger().debug("Logging in with credentials: {} and {}", username, password);
        Screenshot.capture("After user login");
    }
}
