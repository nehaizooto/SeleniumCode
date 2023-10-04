package ForgotPassword;

import java.time.Duration;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.ByAngular;



public class ForgotPassword {

	public static void main(String[] args) throws InterruptedException {
		

		 //Open Chrome Driver
		 WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
	
		 //Navigate panel
		 driver.get("https://panel.izooto.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 System.out.println("Panel opened successfully.");
			
		 //Open forgot password page
         driver.findElement(By.className("forget-password-link")).click();
         Thread.sleep(2000);
         System.out.println("Forgot Password page opened successfully.");
         
         //Enter email id and click forgot password reset link
         driver.findElement(By.className("mat-input-element")).click();
         driver.findElement(By.className("mat-input-element")).sendKeys("izooto56@gmail.com");
         Thread.sleep(2000);
         driver.findElement(By.className("mat-button-wrapper")).click();
         Thread.sleep(3000);
         System.out.println("Forgot Password email sent successfully.");
         
         //Open a new tab and navigate to the desired URL
         ((JavascriptExecutor) driver).executeScript("window.open();");
         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));
 
         //Navigate to the Gmail login page
         Thread.sleep(2000);
         driver.get("https://gmail.com");
         System.out.println("Gmail opened successfully.");
         
         //Login to your gmail account
         Thread.sleep(2000);
         driver.findElement(By.id("identifierId")).sendKeys("izooto56@gmail.com");
         Thread.sleep(1000);
         driver.findElement(By.id("identifierNext")).click();
         Thread.sleep(3000);
         driver.findElement(By.name("Passwd")).click();
         driver.findElement(By.name("Passwd")).sendKeys("Izooto@123");
         Thread.sleep(1000);
         driver.findElement(By.id("passwordNext")).click();
         Thread.sleep(3000);
         System.out.println("Gmail account logged in successfully.");
        
         //Use FluentWait to wait for Gmail inbox to load
         Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                 .withTimeout(Duration.ofSeconds(20))
                 .pollingEvery(Duration.ofMillis(500))
                 .ignoring(org.openqa.selenium.NoSuchElementException.class);

         fluentWait.until(new Function<WebDriver, WebElement>() {
             public WebElement apply(WebDriver driver) {
                 return driver.findElement(By.xpath("//div[@role='main']"));
             }
         });
         
	     // Search for email by subject
	     String subject = "iZooto: Forgot Password Request";
	     WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label='Search mail']"));
	     searchInput.sendKeys("subject:" + subject);
	     searchInput.sendKeys(Keys.RETURN);
	     
	     // Click on the email with the given subject
	     WebElement emailLink = driver.findElement(By.xpath("//span[contains(text(), '" + subject + "')]/ancestor::tbody"));
	     emailLink.click(); //delete old mails always
	     System.out.println("Password reset email opened successfully.");
	     
	     //Click reset button to reset the password
	     Thread.sleep(2000);
	     WebElement linkToNewTab = driver.findElement(By.linkText("Reset"));
	     linkToNewTab.click();

	     driver.close(); //close the opened tab
	     
	     //Switch to new tab and locate   
	     String newTabHandle = driver.getWindowHandles().toArray()[1].toString();
	     driver.switchTo().window(newTabHandle);
	     
	     //locate and interact with elements and send desired values
	     driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("Izooto@123");
	     Thread.sleep(2000);
	     driver.findElement(ByAngular.buttonText("Submit")).click();
	     System.out.println("Password reset successfully.");
	     
	     driver.close(); //close the opened tab

	    
		}
	}	
		
	
	


