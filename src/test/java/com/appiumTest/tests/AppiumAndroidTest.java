package com.appiumTest.tests;

import com.appiumTest.pages.android.Add;
import com.appiumTest.pages.android.NewContact;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class AppiumAndroidTest extends BaseAndroid{

    @Test
    public void appiumAndroidTest() {
        String firstname = "Felicity";
        String lastname = "Bronston";
        String phoneNumber = "5840512397";

        //AddNewContactButton setup and click
        driver.findElement(Add.ADD_CONTACT).click();

        //Add wait time
        makeWait(NewContact.CANCEL_ACCOUNT_ENTRY);
        //CancelButton cancels the account entry for google
        driver.findElement(NewContact.CANCEL_ACCOUNT_ENTRY).click();

        //Fill contact info
        driver.findElement(NewContact.FIRST_NAME).sendKeys(firstname);
        driver.findElement(NewContact.LAST_NAME).sendKeys(lastname);
        driver.findElement(NewContact.ADD_MOBILE_NUMBER).sendKeys(phoneNumber);

        //Save contact info
        makeWait(NewContact.SAVE_PHONE);
        driver.findElement(NewContact.SAVE_PHONE).click();
        //Add wait time and click three dots for more option;
        makeWait(NewContact.MORE_OPTION);
        driver.findElement(NewContact.MORE_OPTION).click();

        //Delete contact;
        makeWait(NewContact.DELETE_DROPDOWN);
        driver.findElement(NewContact.DELETE_DROPDOWN).click();

        //Confirm Delete
        makeWait(NewContact.CONFIRM_DELETE);
        driver.findElement(NewContact.CONFIRM_DELETE).click();
    }
}
