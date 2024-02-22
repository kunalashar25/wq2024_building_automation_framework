package com.ttt.wq.manager.driver;

import org.openqa.selenium.WebDriver;
import com.ttt.wq.manager.driver.browsertypes.ChromeDriverManager;
import com.ttt.wq.manager.driver.browsertypes.FirefoxDriverManager;
import com.ttt.wq.manager.file.reader.PropertyReader;
import com.ttt.wq.utils.LogHelper;

public class DriverFactory {
    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<WebDriver>();

    public static WebDriver createDriver() {
        WebDriver driver = null;

        String browserType = PropertyReader.getProperty("browser");
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriverManager().getDriver();
                break;
            case "firefox":
                driver = new FirefoxDriverManager().getDriver();
                break;
            default:
                LogHelper.getLogger().error("Unable to create browser instance for {}", browserType);
                throw new IllegalArgumentException("Unsupported browser type provided");
        }

        driverThreadLocal.set(driver);
        driver.manage().window().maximize();
        LogHelper.getLogger().info("Created {} browser instance", browserType);
        return driver;
    }

    public static WebDriver getDriverInstance() {
        return driverThreadLocal.get();
    }
}
