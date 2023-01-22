package com.appiumTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDemo {
    public static AppiumDriver driver;

    @Test
    public void appiumTest1() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "11");
        caps.setCapability("deviceName", "Pixel-4");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        caps.setCapability("unicodeKeyboard", true);
        caps.setCapability("resetKeyboard", true);
        String firstName = "Alexis";
        String lastName = "Abner";
        String phoneNumber = "2234567890";

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub/");
            driver = new AppiumDriver(url, caps);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //AddNewContactButton setup and click
            WebElement addContactButton = driver.findElement(By.id("com.android.contacts:id/floating_action_button_container"));
            addContactButton.click();

            //Add wait time
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.contacts:id/left_button")));

            //CancelButton cancels the account entry for google
            WebElement cancelButton = driver.findElement(By.id("com.android.contacts:id/left_button"));
            cancelButton.click();

            //Fill contact info
            WebElement firstNameBox = driver.findElement(By.xpath("//*[@text = 'First name']"));
            firstNameBox.click();
            firstNameBox.sendKeys(firstName);

            WebElement lastNameBox = driver.findElement(By.xpath("//*[@text = 'Last name']"));
            lastNameBox.click();
            lastNameBox.sendKeys(lastName);

            WebElement phoneNumberBox = driver.findElement(By.xpath("//*[@text = 'Phone']"));
            phoneNumberBox.click();
            phoneNumberBox.sendKeys(phoneNumber);

            //Save contact info
//            WebElement saveButton = driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button"));
            WebElement saveBtn = driver.findElement(AppiumBy.id("com.android.contacts:id/editor_menu_save_button"));
//            saveButton.click();
            saveBtn.click();

            //Add wait time and click three dots for more option
            By moreOption = AppiumBy.accessibilityId("More options");
            wait.until(ExpectedConditions.presenceOfElementLocated(moreOption));
            driver.findElement(moreOption).click();

            //Delete contact
            By deleteDropDown = AppiumBy.xpath("//*[@text='Delete']");
            wait.until(ExpectedConditions.presenceOfElementLocated(deleteDropDown));
            driver.findElement(deleteDropDown).click();

            //Confirm Delete
            By confirmDelete = AppiumBy.id("android:id/button1");
            wait.until(ExpectedConditions.presenceOfElementLocated(confirmDelete));
            driver.findElement(confirmDelete).click();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
