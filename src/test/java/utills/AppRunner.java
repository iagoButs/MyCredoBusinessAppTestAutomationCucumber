package utills;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppRunner {
     public static AndroidDriver driver;



    public static void setupCapabilities() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UIAutomator2");
        caps.setCapability("appium:deviceName", "Pixel");
        caps.setCapability("appium:avd", "Pixel");
        caps.setCapability("appium:appPackage", "com.credobusiness");
        caps.setCapability("appium:appActivity", "com.credobusiness.MainActivity");
        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:noReset", true);
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:enableMultiWindows", true);
        caps.setCapability("appium:uiautomator2ServerInstallTimeout", 30000);
        caps.setCapability("appium:adbExecTimeout", 20000);
        caps.setCapability("appium:newCommandTimeout", 300);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
    }

    public static void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

    }


