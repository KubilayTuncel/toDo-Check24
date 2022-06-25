package AufgabeCucumber.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AufgabeDriver {
    private static AppiumDriver<MobileElement> appiumDriver;

    public static AppiumDriver getAppiumDriver()  {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET,true);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigReader.getProperty("aufgabePath"));

            //desiredCapabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");
            //desiredCapabilities.setCapability("appPackage","com.amazon.mShop.navigation.MainActivity");
            //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, false);
            desiredCapabilities.setCapability("autoAcceptAlert",true);
            desiredCapabilities.setCapability("fullReset","false");
            if (ConfigReader.getProperty("platformName").equals("android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"
                //desiredCapabilities.setCapability("appPackage","");
                //desiredCapabilities.setCapability("appActivity","");
                //desiredCapabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
                //desiredCapabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");


                appiumDriver = new AndroidDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            } else if (ConfigReader.getProperty("platformName").equals("ios")) {
                //if you do not provide app path so you should use "bundleId"
                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
                appiumDriver = new IOSDriver(appiumServerURL,desiredCapabilities);
                appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
        }
        return appiumDriver;
    }


    public static void quitAppiumDriver(){
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}

