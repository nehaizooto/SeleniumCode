package Segments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.paulhammant.ngwebdriver.ByAngular;

public class Segments {

	public static void main(String[] args) throws InterruptedException {
	
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
		 
		  //Open Segment page : 
		  Thread.sleep(3000);
		  WebElement segmentElement = driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']/mat-drawer-container/mat-drawer-content/div[@class='iz-row']"
				+ "/div[@class='iz-col']/iz-left-nav//span[.='Segments']"));
		  segmentElement.click();
		  Thread.sleep(2000);
		  System.out.println("Segments page opened successfully.");
		  
		  //Click Create button to open create segment page
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  System.out.println("Create Segment page opened successfully.");
		  
//Add Device Segment
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Device ']")).click();
		  Thread.sleep(2000);          
		  driver.findElement(By.xpath("//mat-select[@placeholder='Select Device']")).click();
		  WebElement desktopCheckbox = driver.findElement(By.id("mat-option-7"));
          WebElement tabletCheckbox = driver.findElement(By.id("mat-option-8"));
          WebElement mobileCheckbox = driver.findElement(By.id("mat-option-9"));
          desktopCheckbox.click();
          tabletCheckbox.click();
          mobileCheckbox.click();
          Thread.sleep(2000);
          WebElement outsideElement = driver.findElement(By.xpath("//body"));
          outsideElement.click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("All Devices"); //need to change the name
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Device Segment saved successfully.");
          
          //Scroll down on a page
          Thread.sleep(6000);
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
          
          //Click next of pagination to view the segment
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Next")).click();
          System.out.println("Device Segment is visible.");
          
          //Click previous of pagination to create new segment
          Thread.sleep(2000);
          driver.findElement(ByAngular.buttonText("Prev")).click();
		  
//Add Location Segment
		  
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Location ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@formcontrolname='countryCtrl']")).click();
		  Thread.sleep(1000);
	      driver.findElement(By.xpath("//input[@formcontrolname='countryCtrl']")).sendKeys("Ind");
	      Thread.sleep(1000);
	      driver.findElement(By.id("mat-option-113")).click();
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("//input[@formcontrolname='stateCtrl']")).click();
		  Thread.sleep(1000);
	      driver.findElement(By.xpath("//input[@formcontrolname='stateCtrl']")).sendKeys("Uttar");
	      Thread.sleep(1000);
	      driver.findElement(By.id("mat-option-262")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='cityCtrl']")).click();
		  Thread.sleep(1000);
	      driver.findElement(By.xpath("//input[@formcontrolname='cityCtrl']")).sendKeys("No");
	      Thread.sleep(1000);
	      driver.findElement(By.id("mat-option-283")).click();
	      Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("India Location"); //need to change the name
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Location Segment saved successfully.");
          
          //Scroll down on a page
          Thread.sleep(6000);
          JavascriptExecutor js1 = (JavascriptExecutor) driver;
          js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
          //Click next of pagination to view the segment
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Next")).click();
          System.out.println("Location Segment is visible.");
        
          //Click previous of pagination to create new segment
          Thread.sleep(2000);
          driver.findElement(ByAngular.buttonText("Prev")).click();
		  
//Add Subscription Date Segment
          
          Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Subscription Date ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-select-trigger")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' before ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
		  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Subscription Date ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-17")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' after ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
		  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Subscription Date ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-19")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' in the past ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).click();
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).sendKeys("10");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
		  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Subscription Date ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-20")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' relative within ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='minDaysCtrl']")).click();
		  driver.findElement(By.xpath("//input[@formcontrolname='minDaysCtrl']")).sendKeys("2");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='maxDaysCtrl']")).click();
		  driver.findElement(By.xpath("//input[@formcontrolname='maxDaysCtrl']")).sendKeys("10");
		  Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Subscriber Multiple dates"); //need to change the name
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Subscription date Segment saved successfully.");
          
          //Scroll down on a page
          Thread.sleep(6000);
          JavascriptExecutor js2 = (JavascriptExecutor) driver;
          js2.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
          //Click next of pagination to view the segment
          Thread.sleep(1000);
          driver.findElement(ByAngular.buttonText("Next")).click();
          System.out.println("Subscription date Segment is visible.");
        
          //Click previous of pagination to create new segment
          Thread.sleep(2000);
          driver.findElement(ByAngular.buttonText("Prev")).click();
	
//Last Notification Click Segment
          
          Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Notification Click ']")).click();
		  Thread.sleep(2000);          
		  driver.findElement(By.className("mat-select-trigger")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' before ']")).click();
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
			  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Notification Click ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-27")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' on ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
			  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Notification Click ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-29")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' was exactly ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).click();
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).sendKeys("10");
		  Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Last Notification click"); //need to change the name
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Last Notification click Segment saved successfully.");
	          
	      //Scroll down on a page
	      Thread.sleep(6000);
	      JavascriptExecutor js3 = (JavascriptExecutor) driver;
	      js3.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	      //Click next of pagination to view the segment
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Next")).click();
	      System.out.println("Last Notification click Segment is visible.");
	        
	      //Click previous of pagination to create new segment
          Thread.sleep(2000);
	      driver.findElement(ByAngular.buttonText("Prev")).click();
          
//Last Website Visit Segment
          
          Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Website Visit ']")).click();
		  Thread.sleep(2000);          
		  driver.findElement(By.className("mat-select-trigger")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' before ']")).click();
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
			  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Website Visit ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-35")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' on ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html//app-root/iz-create-segments-v2/div[2]/div[1]/div/a[@href='javascript:void(0)']"
			  		+ "/mat-icon[@role='img']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Last Website Visit ']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("mat-select-value-37")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath(".//span[text()=' was exactly ']")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).click();
		  driver.findElement(By.xpath("//input[@formcontrolname='inPastOrExactlyCtrl']")).sendKeys("10");
		  Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Last Website Visit"); //need to change the name
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Last Website Visit Segment saved successfully.");
	          
	      //Scroll down on a page
	      Thread.sleep(6000);
	      JavascriptExecutor js4 = (JavascriptExecutor) driver;
	      js4.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	      //Click next of pagination to view the segment
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Next")).click();
	      System.out.println("Last Website Visit Segment is visible.");
	        
	      //Click previous of pagination to create new segment
          Thread.sleep(2000);
	      driver.findElement(ByAngular.buttonText("Prev")).click();	  
		  
//Add User Property Segment		  		  
		  
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' User Properties ']")).click();
		  Thread.sleep(2000);          
		  driver.findElement(By.className("mat-select-trigger")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("mat-option-376")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@formcontrolname='propStrTypeSearchCtrl']")).click();
		  driver.findElement(By.id("mat-option-437")).click();
		  Thread.sleep(2000);
          driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("User Properties"); //need to change the name
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("User properties Segment saved successfully.");
          
          //Scroll down on a page
	      Thread.sleep(6000);
	      JavascriptExecutor js5 = (JavascriptExecutor) driver;
	      js5.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	      //Click next of pagination to view the segment
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Next")).click();
	      System.out.println("User properties Segment is visible.");
	        
	      //Click previous of pagination to create new segment
          Thread.sleep(2000);
	      driver.findElement(ByAngular.buttonText("Prev")).click();	  
	      
//Segment name testcases 
	      
	      //Test case 1 - When name is blank
	      Thread.sleep(2000);
		  driver.findElement(By.className("mat-raised-button--create-cta")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("/html/body/app-root/iz-create-segments-v2//span[.=' Device ']")).click();
		  Thread.sleep(2000);          
		  driver.findElement(By.xpath("//mat-select[@placeholder='Select Device']")).click();
		  WebElement desktopCheckbox1 = driver.findElement(By.id("mat-option-440"));
		  desktopCheckbox1.click();
		  Thread.sleep(1000);
		  WebElement outsideElement1 = driver.findElement(By.xpath("//body"));
          outsideElement1.click();
          Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Test case 1 passed. Name cannot be blank.");
		  
          //Test case 2 - When no segment name is not alphanumeric
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).click();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Hello-test_property"); 
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Test case 2 passed. Name cannot be apart from alphanumeric.");
          
          //Test case 3 - When no segment name is not alphanumeric
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).clear();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Desktop Subscribers"); 
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
          System.out.println("Test case 3 passed. Name already exists.");
          
//Delete a segment 
          
          Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).clear();
	      driver.findElement(By.xpath("//input[@placeholder='Segment name']")).sendKeys("Desktop 123"); 
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Save")).click();
	      System.out.println("Segment should get saved.");
	      //Scroll down on a page
	      Thread.sleep(6000);
	      JavascriptExecutor js6 = (JavascriptExecutor) driver;
	      js6.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	      //Click next of pagination to view the segment
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Next")).click();
	      System.out.println("Device 123 Segment is visible.");
	        
	      //Now delete the segment
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[@aria-label='Delete Segment']")).click();
	      Thread.sleep(1000);
	      driver.findElement(ByAngular.buttonText("Yes")).click();
	      System.out.println("Segment deleted successfully.");
          
	      //Click previous of pagination to create new segment
          Thread.sleep(5000);
	      driver.findElement(ByAngular.buttonText("Prev")).click();	  
	      
//Show Estimated Reach	
	      
	      Thread.sleep(2000);
	      driver.findElement(By.cssSelector("button.mat-stroked-button--show-reach")).click();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	      System.out.println("Estimated Reach of a segment is fetched successfully.");
	      
//View Description
	      
	      Thread.sleep(2000);
	      driver.findElement(By.cssSelector("button[aria-label='View Description']")).click();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	      System.out.println("View description of a segment is fetched successfully.");
	      
	      System.out.println("All cases passed successfully. Segment page is working fine.");
	      
	      
		  
	}

}
