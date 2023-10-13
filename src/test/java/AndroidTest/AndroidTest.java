package AndroidTest;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.awt.Dimension;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidTest {

	

		  private static final String AndroidKeyCode = null;
		private static final int AppiumDriver = 0;
		private static final int MobileElement = 0;

		@SuppressWarnings("deprecation")
//		public static <AndroidElement> void main(String[] args) throws Exception {
//		        DesiredCapabilities caps = new DesiredCapabilities();
//
//		        // Set up your desired capabilities
//		        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4a");
//		        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//		        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		        caps.setCapability(MobileCapabilityType.UDID, "18261JEC201175");
//		        caps.setCapability(MobileCapabilityType.APP, "/Users/nehasingh/Desktop/app-release.apk");
		        
	//	        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.systemui"); // The package name for the system UI
	//	        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.systemui.SystemUIApplication"); // The activity for the system UI

//		        // Initialize the driver
//		        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), caps);
//
//		        // Swipe down to open the notification center
//		        driver.openNotifications();
//
//		        // Wait for the notification element to become visible
//		        @SuppressWarnings("unchecked")
//				AndroidElement notificationElement = (AndroidElement) driver.findElement(By.id("Your_Notification_Element_Id"));
//
//		        // Click the notification
//		        ((WebElement) notificationElement).click();
//
//		        // Close the notification center (optional)
		  //      driver.pressKey(new KeyEvent(AndroidKey.BACK));
		

				    public static void main(String[] args) throws Exception {
//				        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//				        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//				        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy F13");
//				        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//				        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8T812BYDA");
//				        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
				        
			  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			  desiredCapabilities.setCapability("platformName", "Android");
			  desiredCapabilities.setCapability("deviceName", "Pixel 7 Pro"); // Replace with your emulator's name or ID
			//  desiredCapabilities.setCapability("appPackage", "com.example.app"); // Replace with your app's package name
			  desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity"); // Replace with your app's main activity
			  desiredCapabilities.setCapability("automationName", "UiAutomator2"); // Use UiAutomator2 for Android automation
			  desiredCapabilities.setCapability("adb_shell", true);
			//  desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			  desiredCapabilities.setCapability("relaxedSecurity", true);
			  desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
			  desiredCapabilities.setCapability(MobileCapabilityType.APP, ".statusbar.phone.StatusBar"); // Activity name for notification center
		        desiredCapabilities.setCapability("noReset", true);
				        // Add other desired capabilities as needed

				        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), desiredCapabilities);

				        Thread.sleep(6000);
				        
				        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				        // Swipe down to open the notification center
				        swipeDown();

				        // Wait for a moment to ensure the notification center is fully open
				        Thread.sleep(2000);
				     
				        // Find and click on a notification by its text (replace with your notification text)
				        String notificationTextToClick = "SASAAS";
				        WebElement notificationElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + notificationTextToClick + "']"));
				        notificationElement.click();

				        // Perform actions on the opened notification as needed

				      
				        
	
		  }

		private static void swipeDown() {
			// TODO Auto-generated method stub
			
		}

	
		}
	
		  


