package com.appiumTest.tests;

import com.appiumTest.pages.android.contacts.Add;
import com.appiumTest.pages.android.contacts.NewContact;
import org.testng.annotations.Test;

public class AndroidTest extends BaseAndroid{

    @Test
    public void appiumAndroidTest() {
        String firstname = "Felicity";
        String lastname = "Bronston";
        String phoneNumber = "5840512397";

        driver.findElement(Add.ADD_CONTACT).click();
        waitElement(NewContact.CANCEL_ACCOUNT_ENTRY);
        driver.findElement(NewContact.CANCEL_ACCOUNT_ENTRY).click();

        //Fill contact info
        driver.findElement(NewContact.FIRST_NAME).sendKeys(firstname);
        driver.findElement(NewContact.LAST_NAME).sendKeys(lastname);
        driver.findElement(NewContact.ADD_MOBILE_NUMBER).sendKeys(phoneNumber);

        //Save contact info
        waitElement(NewContact.SAVE_PHONE);
        driver.findElement(NewContact.SAVE_PHONE).click();
        waitElement(NewContact.MORE_OPTION);
        driver.findElement(NewContact.MORE_OPTION).click();

        //Delete contact;
        waitElement(NewContact.DELETE_DROPDOWN);
        driver.findElement(NewContact.DELETE_DROPDOWN).click();
        waitElement(NewContact.CONFIRM_DELETE);
        driver.findElement(NewContact.CONFIRM_DELETE).click();
    }
}
