import javax.print.DocFlavor.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.http.HttpClient.Factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Calculator<MobileElement> {


	AndroidDriver driver;
	
	public static void main(String[] args) {
			openCAlculator();
	}
	
	public static <MobileElement> void openCAlculator() {
	
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Pixel 4a" );
		capabilities.setCapability("udid", "18261JEC201175");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("appPackage", "com.android.Calculator2.Calculator");
		capabilities.setCapability("appActivity", "com.google.android.calculator");
		
		
		@SuppressWarnings("unused")
		AndroidDriver driver = new AndroidDriver((Factory) new URL("http://localhost:4723/wd/hub"), capabilities);


		
		
		
		
		
		
		
		
	}

}
