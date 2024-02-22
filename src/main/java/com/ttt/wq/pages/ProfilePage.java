package com.ttt.wq.pages;

import org.openqa.selenium.By;
import com.ttt.wq.utils.LogHelper;
import com.ttt.wq.utils.Screenshot;
import io.qameta.allure.Step;

public class ProfilePage extends BasePage {

    @Step
    public void goToBookStore() {
        scrollToElement(By.id("gotoStore"));
        click(By.id("gotoStore"));
        LogHelper.getLogger().info("Navigated to Book Store Page");
        Screenshot.capture("At Book Store Page");
    }
}
