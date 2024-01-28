package com.ttt.wq.driverManager.browserTypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ttt.wq.driverManager.IDriverManager;

public class ChromeDriverManager implements IDriverManager {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}
