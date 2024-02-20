package com.ttt.wq.pages;

import org.openqa.selenium.By;

import com.ttt.wq.utils.LogHelper;

public class ProfilePage extends BasePage {

    public void goToBookStore() {
        scrollToElement(By.id("gotoStore"));
        click(By.id("gotoStore"));
        LogHelper.getLogger().info("Navigated to Book Store Page");
    }
}
