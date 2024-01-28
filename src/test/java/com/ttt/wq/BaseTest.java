package com.ttt.wq;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ttt.wq.driverManager.DriverFactory;

public class BaseTest {
    @BeforeMethod
    public void setupBrowser() {
        DriverFactory.createDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.getDriverInstance().quit();
    }
}
