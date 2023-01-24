package com.appiumTest.tests;

import com.appiumTest.pages.ios.contacts.NewContact;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.time.Duration;

public class BaseAndroid {
    public AppiumDriver driver;

    @BeforeClass
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
    }

    public void makeWait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
