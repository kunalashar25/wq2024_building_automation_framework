package com.ttt.wq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void goToBookStore() {
        click(By.id("gotoStore"));
    }
}
