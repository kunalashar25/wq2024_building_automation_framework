package com.ttt.wq.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ttt.wq.utils.LogHelper;
import com.ttt.wq.utils.Screenshot;

public class TestListeners implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        LogHelper.getLogger().info("Testcase {} executed Successfully!", result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        LogHelper.getLogger().error("Testcase {} execution FAILED!", testName);
        LogHelper.getLogger().error(result.getThrowable());

        Screenshot.capture(testName, "FAILURE");
    }
}
