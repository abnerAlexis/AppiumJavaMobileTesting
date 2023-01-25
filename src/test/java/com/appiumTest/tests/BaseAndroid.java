package com.appiumTest.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseAndroid {
    protected AppiumDriver driver;
    private WebDriverWait wait;
    private static final int WAIT_SECONDS = 20;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("deviceName", "Pixel-4");
        desiredCapabilities.setCapability("udid", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.contacts"); // iPhone doesn't use appPackage and appActivity
        desiredCapabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        desiredCapabilities.setCapability("unicodeKeyboard", true);
        desiredCapabilities.setCapability("resetKeyboard", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
    }

    protected void waitElement(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
