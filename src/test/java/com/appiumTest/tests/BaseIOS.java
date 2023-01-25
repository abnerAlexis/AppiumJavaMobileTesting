package com.appiumTest.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseIOS {
    protected AppiumDriver driver;
    private WebDriverWait wait;
    private static final int WAIT_SECONDS = 20;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ios");
        desiredCapabilities.setCapability("appium:platformVersion", "16.2");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", false);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
    }

    protected void waitElement(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
