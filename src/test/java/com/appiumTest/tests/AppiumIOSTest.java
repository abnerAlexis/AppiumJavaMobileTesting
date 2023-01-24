package com.appiumTest.tests;

import com.appiumTest.pages.ios.contacts.Add;
import com.appiumTest.pages.ios.contacts.NewContact;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.time.Duration;

public class AppiumIOSTest extends BaseIOS{

    @Test
    public void appiumIOSTest() throws MalformedURLException {
        String firstname = "Christine";
        String lastname = "Bell";
        String company = "Google";
        String mobilePhone = "7538671209";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Contacts Button-click
        driver.findElement(AppiumBy.accessibilityId("Contacts")).click();

        //Add contact '+' button
        driver.findElement(Add.ADD_CONTACT).click();
        makeWait(NewContact.FIRST_NAME);
        driver.findElement(NewContact.FIRST_NAME).sendKeys(firstname);
        driver.findElement(NewContact.LAST_NAME).sendKeys(lastname);
        driver.findElement(NewContact.COMPANY).sendKeys(company);

        driver.findElement(NewContact.ADD_PHONE).click();
        makeWait(NewContact.ADD_MOBILE_NUMBER);
        driver.findElement(NewContact.ADD_MOBILE_NUMBER).sendKeys(mobilePhone);

        driver.findElement(NewContact.DONE).click();
        makeWait(AppiumBy.name(firstname + " " + lastname));
        driver.findElement(AppiumBy.accessibilityId("iPhone")).click();
    }
}
