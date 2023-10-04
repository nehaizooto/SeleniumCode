package testNG2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;

public class Testng2 {

	@Test
	public void reporting() throws InterruptedException {
		 //Navigate Chrome Driver
	      WebDriver driver = new ChromeDriver();
	      System.setProperty("webdriver.chrome.driver",
				"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
	 
	      //Open panel
	      driver.get("https://panel.izooto.com/");
	      driver.manage().window().maximize();
	      Thread.sleep(2000);
		
	      //Login on panel
        driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
	      driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("dummyizmogra@gmail.com");
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
	      Thread.sleep(2000);
	      driver.findElement(ByAngular.buttonText("Sign In")).click();
	      Thread.sleep(5000);
	      driver.navigate().refresh();
	      System.out.println("Panel opened successfully and logged In.");
		 
		  //Open Campaign Report page : 
		  Thread.sleep(3000);
		  WebElement segmentElement = driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']/mat-drawer-container/mat-drawer-content/div[@class='iz-row']"
				+ "/div[@class='iz-col']/iz-left-nav//span[.='Campaign Reports']"));
		  segmentElement.click();
		  Thread.sleep(2000);
		  System.out.println("Campaign Reports page opened successfully.");
		  
//Click Refresh Button
		  
		  Thread.sleep(2000);
		  driver.findElement(ByAngular.buttonText("refresh")).click();
		  System.out.println("Campaign Reports page refreshed successfully.");

		
		
		
		
		
		
	}

}
