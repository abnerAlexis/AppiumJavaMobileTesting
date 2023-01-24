package com.appiumTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class AppiumIOSTest {
    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ios");
        desiredCapabilities.setCapability("appium:platformVersion", "16.2");
        desiredCapabilities.setCapability("appium:deviceName", "iPhone 11");
        desiredCapabilities.setCapability("appium:automationName", "XCUITest");
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", false);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), desiredCapabilities);
    }

    @Test
    public void appiumIOSTest() throws MalformedURLException {
        String firstname = "Alexander";
        String lastname = "Bell";
        String company = "Google";
        String mobilePhone = "7538671209";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Contacts Button-click
        driver.findElement(AppiumBy.accessibilityId("Contacts")).click();

        //Add contact '+' button
        driver.findElement(AppiumBy.accessibilityId("Add")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("First name")));
        driver.findElement(AppiumBy.accessibilityId("First name")).sendKeys(firstname);
        driver.findElement(AppiumBy.accessibilityId("Last name")).sendKeys(lastname);
        driver.findElement(AppiumBy.accessibilityId("Company")).sendKeys(company);

        driver.findElement(AppiumBy.accessibilityId("Insert add phone")).click();
        By addPhone = AppiumBy.xpath("//XCUIElementTypeTextField[@value='Phone']");
        wait.until(ExpectedConditions.presenceOfElementLocated(addPhone));
        driver.findElement(addPhone).sendKeys(mobilePhone);

        driver.findElement(AppiumBy.accessibilityId("Done")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.name(firstname + " " + lastname)));
        driver.findElement(AppiumBy.name("iPhone")).click();

        driver.findElement(AppiumBy.name(firstname + " " + lastname)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Edit")));
        driver.findElement(AppiumBy.accessibilityId("Edit")).click();

//        deleteContact();
    }

    private void deleteContact() {
        WebElement element = driver.findElement(AppiumBy.name("Delete Contact"));

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((RemoteWebElement) element).getId());
        jsExecutor.executeScript("mobile:scroll", scrollObject);

        driver.findElement(AppiumBy.name("Delete contact")).click();
    }
}
