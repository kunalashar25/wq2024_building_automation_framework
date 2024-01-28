package com.ttt.wq.driverManager.browserTypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ttt.wq.driverManager.IDriverManager;

public class FirefoxDriverManager implements IDriverManager {

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
