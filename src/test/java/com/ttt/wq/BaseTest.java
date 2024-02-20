package com.ttt.wq;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ttt.wq.manager.driver.DriverFactory;
import com.ttt.wq.manager.file.reader.PropertyReader;

public class BaseTest {

    @BeforeSuite
    public void setupPrerequisites() {
        new PropertyReader();
    }

    @BeforeMethod
    public void setupBrowser() {
        DriverFactory.createDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.getDriverInstance().quit();
    }
}
