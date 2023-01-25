package com.appiumTest.pages.android.contacts;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NewContact {
    public static final By CANCEL_ACCOUNT_ENTRY = AppiumBy.id("com.android.contacts:id/left_button");
    public static final By FIRST_NAME = AppiumBy.xpath("//*[@text = 'First name']");
    public static final By LAST_NAME = AppiumBy.xpath("//*[@text = 'Last name']");
    public static final By ADD_MOBILE_NUMBER = AppiumBy.xpath("//*[@text = 'Phone']");
    public static final By SAVE_PHONE = AppiumBy.id("com.android.contacts:id/editor_menu_save_button");
    public static final By MORE_OPTION = AppiumBy.accessibilityId("More options");
    public static final By DELETE_DROPDOWN = AppiumBy.xpath("//*[@text='Delete']");
    public static final By CONFIRM_DELETE = AppiumBy.id("android:id/button1");
}
