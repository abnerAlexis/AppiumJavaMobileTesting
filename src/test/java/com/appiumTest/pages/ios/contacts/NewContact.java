package com.appiumTest.pages.ios.contacts;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NewContact {
    public static final By FIRST_NAME = AppiumBy.accessibilityId("First name");
    public static final By LAST_NAME = AppiumBy.accessibilityId("Last name");
    public static final By COMPANY = AppiumBy.accessibilityId("Company");
    public static final By ADD_PHONE = AppiumBy.accessibilityId("Insert add phone");
    public static final By ADD_MOBILE_NUMBER = AppiumBy.xpath("//XCUIElementTypeTextField[@value='Phone']");
    public static final By DONE = AppiumBy.accessibilityId("Done");
}
