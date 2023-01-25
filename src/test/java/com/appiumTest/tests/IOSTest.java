package com.appiumTest.tests;

import com.appiumTest.pages.ios.contacts.Add;
import com.appiumTest.pages.ios.contacts.NewContact;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class IOSTest extends BaseIOS {

    @Test
    public void appiumIOSTest() throws MalformedURLException {
        String firstname = "Christine";
        String lastname = "Bell";
        String company = "Google";
        String mobilePhone = "7538671209";

        driver.findElement(AppiumBy.accessibilityId("Contacts")).click();

        driver.findElement(Add.ADD_CONTACT).click();
        waitElement(NewContact.FIRST_NAME);
        driver.findElement(NewContact.FIRST_NAME).sendKeys(firstname);
        driver.findElement(NewContact.LAST_NAME).sendKeys(lastname);
        driver.findElement(NewContact.COMPANY).sendKeys(company);

        driver.findElement(NewContact.ADD_PHONE).click();
        waitElement(NewContact.ADD_MOBILE_NUMBER);
        driver.findElement(NewContact.ADD_MOBILE_NUMBER).sendKeys(mobilePhone);

        driver.findElement(NewContact.DONE).click();
        waitElement(AppiumBy.name(firstname + " " + lastname));
        driver.findElement(AppiumBy.accessibilityId("iPhone")).click();
    }
}
