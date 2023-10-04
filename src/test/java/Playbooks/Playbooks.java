package Playbooks;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class Playbooks {

	public static void main(String[] args) throws InterruptedException {
		
		  //Navigate Chrome Driver
	      WebDriver driver = new ChromeDriver();
	      System.setProperty("webdriver.chrome.driver",
				"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
	 
	      //Open panel
	      driver.get("https://panel.izooto.com/en/signup");
	      driver.manage().window().maximize();
	      Thread.sleep(2000);
		
	      //Do new signup for playbooks everytime
	      driver.findElement(By.xpath("//input[@formcontrolname='username']")).click();
	      driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("Dummy Test");
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='email']")).click();
	      driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("dummyizmithumm@gmail.com"); //have to change everytime
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
	      driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
	      Thread.sleep(2000);
	      WebElement extensionDropdown = driver.findElement(By.xpath("//mat-select[@formcontrolname='prefix']"));
	      extensionDropdown.click();
	      WebElement extensionOption = driver.findElement(By.xpath("//mat-option/span[contains(text(), '+91')]"));
	      extensionOption.click();
	      WebElement phoneNumberInput = driver.findElement(By.xpath("//input[@formcontrolname='number']"));
	      phoneNumberInput.sendKeys("7838398766");
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//iz-input-website-url//input[@formcontrolname='url']")).click();
	      driver.findElement(By.xpath("//iz-input-website-url//input[@formcontrolname='url']")).sendKeys("https://dummyizmithumm.com");  //need to change everytime
	      Thread.sleep(2000);
	      WebElement dropdown = driver.findElement(By.xpath("//mat-select[@formcontrolname='monthlyTraffic']"));
	      dropdown.click();
	      WebElement option = driver.findElement(By.xpath("//mat-option[@value='Less than 100K Unique Visitors']"));
	      option.click();
	      Thread.sleep(2000);
	      driver.findElement(By.cssSelector(".btn-action-main.mat-button-base.mat-primary.mat-raised-button.mt-10")).click();
          System.out.println("Signed up on panel successfully.");
          Thread.sleep(8000);
          
          //To regain back focus again on page 
		  WebElement mainPageElement = driver.findElement(By.linkText("Skip"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(mainPageElement).click().perform();
		  driver.findElement(By.linkText("Skip")).click();
		
//Have to change plan from tars to access all playbook
		  
		  //Open a new tab and navigate to the desired URL
	      ((JavascriptExecutor) driver).executeScript("window.open();");
	      ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	      driver.switchTo().window(tabs.get(1));
	 
	      //Navigate to the Gmail login page
	      Thread.sleep(2000);
	      driver.get("https://tars.izooto.com/en/login");
	      System.out.println("Tars navigated successfully.");
	      
	      Thread.sleep(2000);
	      driver.findElement(By.className("mat-button-wrapper")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.id("identifierId")).sendKeys("neha@datability.co");
	      Thread.sleep(1000);
	      driver.findElement(By.id("identifierNext")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.name("Passwd")).click();
	      driver.findElement(By.name("Passwd")).sendKeys("Neha@199201");
	      Thread.sleep(1000);
	      driver.findElement(By.id("passwordNext")).click();
	      Thread.sleep(3000);
	      System.out.println("Logged in to tars successfully.");
	      
	      //Access tars
	      Thread.sleep(14000);
	      WebElement dropdownButton = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		  dropdownButton.click();
		  Thread.sleep(2000);
		  WebElement myprofileOption = driver.findElement(By.xpath("//span[contains(text(), 'Tars')]"));
		  myprofileOption.click();
		  System.out.println("Tars opened successfully.");
		  
		  //Open Pricing-Plan Manager
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//app-root/iz-tars-root[@class='ng-star-inserted']//iz-left-nav/a[@href='/en/app/tars/pricing-plan-manager']"
		  		+ "/span[.='Pricing Plan Manager']")).click();
          Thread.sleep(2000);
          driver.findElement(By.cssSelector("mat-radio-button[value='2']  .mat-radio-label-content")).click();
          System.out.println("Pricing Plan Manager opened successfully.");
          
          //Seach for the website and update pricing plan
          Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@placeholder='search']")).sendKeys("dummyizmithumm"); //have to replace value everytime with web url
		  WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='search']")); 
	      inputField.click();
	      Thread.sleep(2000);
	      //send the Backspace key at the end
	      Actions actions1 = new Actions(driver);
	      actions1.sendKeys(Keys.END).sendKeys(Keys.BACK_SPACE).build().perform();
	      Actions actions2 = new Actions(driver);
	      actions2.sendKeys(Keys.END).sendKeys(Keys.BACK_SPACE).build().perform();
          Thread.sleep(3000);
          driver.findElement(By.className("cdk-column-uid")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath(".//div[@class='mat-select-arrow-wrapper']")).click();
		  Thread.sleep(2000);
		  String optionText = "enterprise-monetize-mar20";
	        WebElement option1 = driver.findElement(By.xpath("//span[contains(text(), '" + optionText + "')]"));

	        // Click the option to select it
	        option1.click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
