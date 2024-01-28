package com.ttt.wq.pages;

import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    public void goToBookStore() {
        scrollToElement(By.id("gotoStore"));
        click(By.id("gotoStore"));
    }
}
