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

        // to run test case on different browsers, pass this value to createDriver()
        String groupName = result.getMethod().getGroups()[0];
        LogHelper.testLogger(testName);
        LogHelper.getLogger().info("Starting test {} with group {}", testName, groupName);

        DriverFactory.createDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverFactory.getDriverInstance().quit();
        LogHelper.getLogger().info("Closed browser instance");
    }
}
