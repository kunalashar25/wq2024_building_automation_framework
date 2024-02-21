package com.ttt.wq.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.ttt.wq.manager.driver.DriverFactory;
import io.qameta.allure.Attachment;

public class Screenshot {

    @Attachment("Screenshot {name}")
    public static byte[] capture(String name) {
        return ((TakesScreenshot) DriverFactory.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
