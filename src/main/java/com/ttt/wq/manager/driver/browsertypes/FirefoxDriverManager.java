package com.ttt.wq.manager.driver.browsertypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ttt.wq.manager.driver.IDriverManager;

public class FirefoxDriverManager implements IDriverManager {

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
