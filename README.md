# AppiumJavaMobileTesting
Appium

It is an open source tool for automating native, mobile web, and hybrid applications on IOS mobile, Android mobile and Windows desktop platforms.

Native Apps
Native apps are written using IOS, Android or Windows SDKs.
Mobile Web Apps
Mobile web apps are apps accessed using a mobile browser.

Appium is a cross-platform that allows you to write tests against multiple platforms.(IOS, Android, Windows) using the same API.

Programming Languages
You can write Appium tests with Java, Python, JS, C# and Ruby.

Mobile Testing
By running tests against your mobile app, you can verify your app’s correctness, functional behavior and usability before releasing the app to the public.
Mobile Testing Tools
Native
Cross platform
Cross-platform vs Native

Cross-platform
Native
Supports all mobile platforms (IOS, Android, Windows).
Developes, releases and supports one single platform. e.g. Espresso for Android or XCUITest for IOS.
Supports many programming languages.
You can use only Java or Kotlin for espresso,
Swift or Objective-C for XCUITest.


Mobile Platforms
Android
It is both an OS and a software platform for mobile devices. e.g. smartphones, tablets, tvs, media players, cars

IOS
Mobile operating system developed by Apple for Iphone and Ipad.

Windows Phone
Operating system for smartphones developed by Microsoft.

Virtual vs Real Devices

Virtual
Real - physical devices
Emulators - runs the same operating system as the physical device that it is emulating. Good option for mobile testing.
It is best for accurate test results.
Disadvantage of using emulators - they have limitations including hardware components. e.g. cameras, Bluetooth receivers, GPS receivers.
You can use only Java or Kotlin for espresso,
Swift or Objective-C for XCUITest.

Install Appium
Check if appium is installed.		appium –v 		if not;
If you don’t have Homebrew installed. Install it first. Check	 brew –v
Install appium.	Google ‘appium mobile app automation’ https://appium.io/ bottom of this web page. Enter below commands one at a time.
brew install node      # get node.js and Check  node –v
npm install -g appium  # installs appium globally
npm install wd         # gets appium client
appium                # start appium
Install desktop version of appium. It allows us to inspect elements in a GUI feel.
Google ‘appium desktop releases’. & find https://github.com/appium/appium-desktop/releases Download the newest .dmg file for MacOS. Then drop the icon to the applications folder.
Open appium server GUI from the applications. Your mac machine won’t want to open it for safety. So go to the path below and make a change. System Preferences > Security & Privacy > General and click ‘open anyway’.
Install Android Studio
Android Studio has the emulators that allow us to interact with appium.
Google ‘android studio’. Find ‘Download Android Studio and SDK’.  https://developer.android.com/studio Download the one with ‘Mack with Apple chip’. Check allow and download.
Find your downloaded file in your ‘Downloads’ folder. Get it installed and move the icon to the Applications folder.
Install Appium Inspector & Setup the Desired Capabilities
Go to https://github.com/appium/appium-inspector/releases  click on the latest version and download the .dmg file.  Move the  icon to applications folder.  
Open Appium Inspector. Fill Remote Host ‘127.0.0.1’ Remote Port ‘4723’ and Remote Path ‘/wd/hub/’.

Desired Capabilities
Documentation => https://appium.io/docs/en/writing-running-appium/caps/

How to find appPackage and appActivity:
Mac: adb shell dumpsys window | grep -E 'mCurrentFocus'
Windows: adb shell dumpsys window | find "mCurrentFocus"

Then tap ‘start session’.
Setup Appium in Java
Add dependency ‘Java Client’ from https://mvnrepository.com/artifact/io.appium/java-client

Add dependency ‘Selenium Java’ from
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59

Add JUnit from https://mvnrepository.com/artifact/junit/junit/4.13.1

Desired capabilities in a method;
public static void appiumTest1() {
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability("platformName", "android");
caps.setCapability("platformVersion", "11");
caps.setCapability("deviceName", "Pixel-4");
//find ‘udid’, ‘emulator-5554’ typing ‘adb devices’ on your terminal.
caps.setCapability("udid", "emulator-5554");
caps.setCapability("automationName", "UiAutomator2");
caps.setCapability("appPackage", "com.android.contacts");
caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
//find other capabilities from your appium inspector.

    try {
       URL url = new URL("http://127.0.0.1:4723/wd/hub/");
    } catch (MalformedURLException e) {
       throw new RuntimeException(e);
    }
//find URL from appium inspector (“http://REMOTEHOST:REMOTEPORTREMOTEPATH”)
}