package com.ttt.wq.manager.driver.browsertypes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ttt.wq.manager.driver.IDriverManager;

public class ChromeDriverManager implements IDriverManager {

    @Override
    public WebDriver getDriver() {
        return new ChromeDriver();
    }
}
