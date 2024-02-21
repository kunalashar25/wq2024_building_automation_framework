package com.ttt.wq.testcases;

import org.apache.logging.log4j.ThreadContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ttt.wq.manager.directory.Directory;
import com.ttt.wq.manager.driver.DriverFactory;
import com.ttt.wq.manager.file.reader.PropertyReader;
import com.ttt.wq.utils.LogHelper;

public class BaseTest {

    @BeforeSuite
    public void setupPrerequisites() {
        Directory.clean("output", "allure-results", "allure-report");
        ThreadContext.put("logFilename", "Prerequisites");
        LogHelper.getLogger().info("Setting prerequisites");
        new PropertyReader();
    }

    @BeforeMethod
    public void setupBrowser(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogHelper.testLogger(testName);
        LogHelper.getLogger().info("Starting test {}", testName);

        DriverFactory.createDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.getDriverInstance().quit();
        LogHelper.getLogger().info("Closed browser instance");
    }
}
