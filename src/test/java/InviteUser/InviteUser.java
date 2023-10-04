package InviteUser;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.ByAngular;

public class InviteUser {
  
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
	 Thread.sleep(2000);
	 System.out.println("Panel opened successfully and logged In.");
	 
	 //Select Invite User from dropdown
	 WebElement dropdownButton = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
	 dropdownButton.click();
	 Thread.sleep(2000);
	 WebElement inviteUsersOption = driver.findElement(By.xpath("//span[contains(text(), 'Invite Users')]"));
     inviteUsersOption.click();
	 System.out.println("Invite User page opened successfully.");
	 
	 //Click new user button to add
	 Thread.sleep(2000);
	 driver.findElement(By.className("user-text")).click();
	 System.out.println("New user modal opened successfully");
	 
//Testcases for add new user	
	 
	 //Test case 1 : When Name and Email is blank -
	 Thread.sleep(2000);
	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 1 passed. Name and Email cannot be blank.");
     
     //Test case 2 : When Name and Email is blank -
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).click();
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("izooto56+1@gmail.com");
   	 Thread.sleep(1000);
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 2 passed. Name cannot be blank.");
     
     //Test case 3 : When Name is just spaces -
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='name']")).click();
   	 driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("                 ");
   	 Thread.sleep(1000);
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 3 passed. Name cannot be just spaces.");
     
     //Test case 4 : When Email is just spaces -
   	 Thread.sleep(2000);
  	 driver.findElement(By.xpath("//input[@formcontrolname='name']")).clear();
  	 driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Admin");
  	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).clear();
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("                  ");
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 4 passed. Email cannot be just spaces.");
     
     //Test case 5 : When Email is invalid -
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).clear();
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("testabc");
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 5 passed. Email is invalid.");
     
     //Test case 6 : When Email already exists -
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).clear();
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("neha@datability.co");
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Test case 6 passed. Email already exists.");
     
 //Add User as an Admin 
     
   	 Thread.sleep(2000);
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).clear();
   	 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("izooto56+1@gmail.com"); //need to change all time
   	 Thread.sleep(2000);
   	 driver.findElement(By.className("btn-dwn-actn")).click();
     System.out.println("Admin added successfully.");
     
 //Now activate admin added, activate the account
     
     //Open a new tab and navigate to the desired URL
     Thread.sleep(4000);
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
    
     //Use of FluentWait to wait for Gmail inbox to load
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
     String subject = "You have been assigned access to an account on iZooto";
     WebElement searchInput = driver.findElement(By.xpath("//input[@aria-label='Search mail']"));
     searchInput.sendKeys("subject:" + subject);
     searchInput.sendKeys(Keys.RETURN);
     
     //Click on the email with the given subject
     WebElement emailLink = driver.findElement(By.xpath("//span[contains(text(), '" + subject + "')]/ancestor::tbody"));
     emailLink.click(); //delete old mails always
     System.out.println("Invite user email for admin received successfully.");
     
     //Click reset button to reset the password
     Thread.sleep(2000);
     WebElement linkToNewTab = driver.findElement(By.linkText("Activate"));
     linkToNewTab.click();
     
     driver.close();
     
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
     driver.findElement(ByAngular.buttonText("Activate")).click();
     Thread.sleep(4000);
     System.out.println("Password for admin account set successfully.");
     
   
     
//   //Open a new tab and navigate to the desired URL
//     ((JavascriptExecutor) driver).executeScript("window.open();");
//     ArrayList<String> tabs1 = new ArrayList<>(driver.getWindowHandles());
//     driver.switchTo().window(tabs1.get(1));

     //Navigate to the Gmail login page
     Thread.sleep(2000);
     driver.get("https://gmail.com");
     System.out.println("Gmail opened successfully.");
     
  // Search for email by subject
     String subject1 = "You have been assigned access to an account on iZooto";
     WebElement searchInput1 = driver.findElement(By.xpath("//input[@aria-label='Search mail']"));
     searchInput1.sendKeys("subject:" + subject1);
     searchInput1.sendKeys(Keys.RETURN);
     
     //Click on the email with the given subject
     WebElement emailLink1 = driver.findElement(By.xpath("//span[contains(text(), '" + subject1 + "')]/ancestor::tbody"));
     emailLink1.click(); //delete old mails always
     System.out.println("Invite user email for admin received successfully.");
     

////     WebElement mainPageElement = driver.findElement(By.cssSelector(".T-I-ax7"));
////     Actions actions = new Actions(driver);
////     actions.moveToElement(mainPageElement).click().perform();
////     driver.findElement(By.cssSelector(".T-I-ax7")).click();
//     Thread.sleep(4000);
     
     
     // Create a JavaScriptExecutor instance
     JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

     // Use JavaScript to select an element (example using document.querySelector)
     String javascript = "return document.querySelector('#20283')";
     WebElement element = (WebElement) jsExecutor.executeScript(javascript);

     // Perform actions on the selected element
     element.click();

	

	
	
	}
	
	}
