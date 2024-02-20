package com.ttt.wq.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ttt.wq.manager.driver.DriverFactory;

public class Screenshot {

    public static void capture(String dirName, String fileName) {
        String destination = "output/" + dirName + "/" + fileName + ".png";
        File file = ((TakesScreenshot) DriverFactory.getDriverInstance()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
