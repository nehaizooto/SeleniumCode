package appium;


import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;


public class appium {

	@SuppressWarnings("deprecation")
	public static <MobileElement> void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "18261JEC201175"); 
//		desiredCapabilities.setCapability(MobileCapabilityType.APP, "com.example.myapp.MainActivity"); 
		desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
		 desiredCapabilities.setCapability("appPackage", "com.android.systemui");
	        desiredCapabilities.setCapability("appActivity", "com.android.systemui.statusbar.phone.StatusBar");
	        desiredCapabilities.setCapability("noReset", true);
        @SuppressWarnings("deprecation")
		AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), desiredCapabilities);
        
        
        @SuppressWarnings("rawtypes")
		TouchAction touchAction = new TouchAction(driver);

        // Swipe down to open the notification center
        int startX = 300;
        int startY = 0;
        int endX = 300;
        int endY = 1000;
        touchAction.press(PointOption.point(startX, startY))
                .waitAction()
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

        // Wait for a moment to ensure the notification center is fully open
        Thread.sleep(5000);
       
        String notificationTitleToFind = "new test";

        // Use the MobileBy.AndroidUIAutomator selector to locate the notification by its title
        By notificationByTitle = MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + notificationTitleToFind + "\")");

        try {
            // Scroll and locate the notification by its title
            driver.findElement(notificationByTitle).click();

            // Perform further actions on the opened notification, if needed
            // ...

        } catch (Exception e) {
            System.out.println("Notification not found or could not be clicked: " + e.getMessage());
        }
        
	}
        
        
        

	private static void clickNotification(AndroidDriver driver, String notificationTextToClick) {
		// TODO Auto-generated method stub
		
	}
}
