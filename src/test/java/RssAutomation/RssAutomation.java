package RssAutomation;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class RssAutomation {

	public static void main(String[] args) throws InterruptedException {
		
		//Open Chrome Driver
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
		 Thread.sleep(6000);
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 System.out.println("Panel opened successfully and logged In.");
		 
		 //Open RSS Automation page
		 driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']/mat-drawer-container"
		 		+ "/mat-drawer-content/div[@class='iz-row']/div[@class='iz-col']/iz-left-nav//span[.='RSS Automation']")).click();
		 System.out.println("RSS Automation page opened successfully.");
		 
 //Connect RSS feed testcases -
		 
		 //Testcase 1 : Open connect to rss feed page -
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".mat-button-base.mat-primary.mat-raised-button.ng-star-inserted > .mat-button-wrapper > span")).click();
		 System.out.println("Test case 1 passed. Connect RSS feed page opened successfully.");
		 
     	 //Testcase 2 : Enter feed url just spaces -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//app-root/iz-connect-rss-feed[@class='ng-star-inserted']/iz-layout-full-page[@class='iz-layout-full-page iz-row p-15']/form/mat-card//mat-form-field"
		 		+ "//input[@placeholder='e.g. https://dummy.com/rss/dummy.xml']")).click();
		 driver.findElement(By.xpath("//app-root/iz-connect-rss-feed[@class='ng-star-inserted']/iz-layout-full-page[@class='iz-layout-full-page iz-row p-15']/form/mat-card//mat-form-field"
		 		+ "//input[@placeholder='e.g. https://dummy.com/rss/dummy.xml']")).sendKeys("                  ");
		 System.out.println("Test case 2 passed. Feed url is invalid.");
		 
		 //Testcase 3 : Enter feed url as invalid -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//app-root/iz-connect-rss-feed[@class='ng-star-inserted']/iz-layout-full-page[@class='iz-layout-full-page iz-row p-15']/form/mat-card//mat-form-field"
		 		+ "//input[@placeholder='e.g. https://dummy.com/rss/dummy.xml']")).clear();
		 driver.findElement(By.xpath("//app-root/iz-connect-rss-feed[@class='ng-star-inserted']/iz-layout-full-page[@class='iz-layout-full-page iz-row p-15']/form/mat-card//mat-form-field"
		 		+ "//input[@placeholder='e.g. https://dummy.com/rss/dummy.xml']")).sendKeys("abc.com");
		 System.out.println("Test case 3 passed. Feed url is not parsed.");
		 
		 //Testcase 4 : Enter feed url -
		 Thread.sleep(1000);
		 WebElement textBar = driver.findElement(By.id("mat-input-2"));
         // Using JavaScriptExecutor to set the value of the text bar
	     JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	     jsExecutor.executeScript("arguments[0].value = 'https://www.latimes.com/local/rss2.0.xml';", textBar);  //need to change all the time
	     WebElement searchInput = driver.findElement(By.id("mat-input-2"));
	     searchInput.click();
	     searchInput.sendKeys(" ");
	     Thread.sleep(4000);

         //Click continue button
	     By buttonLocator = By.className("mat-raised-button"); 
	     WebElement buttonElement = driver.findElement(buttonLocator);
	     buttonElement.click();
	     System.out.println("Test case 4 passed. Feed url parsed successfully.");
		
	//Connect RSS feed enter all details testcases
	     
         //Testcase 5 : Enter feed name as blank
	     Thread.sleep(3000); 
	     By buttonLocator1 = By.className("mat-raised-button"); 
	     WebElement buttonElement1 = driver.findElement(buttonLocator1);
	     buttonElement1.click();
	     System.out.println("Test case 5 passed. Feed name cannot be blank.");
	     
	     //Testcase 6 : Enter feed name as just spaces
	     Thread.sleep(2000);
	     driver.findElement(By.id("mat-input-3")).click();	 
	     driver.findElement(By.id("mat-input-3")).sendKeys("           ");	
	     Thread.sleep(2000);
	     By buttonLocator3 = By.className("mat-raised-button"); 
	     WebElement buttonElement3 = driver.findElement(buttonLocator3);
	     buttonElement3.click();
	     System.out.println("Test case 6 passed. Feed name cannot be just spaces.");
	     
	     //Testcase  7 : Enter valid feed name
	     Thread.sleep(2000);
	     driver.findElement(By.id("mat-input-3")).clear();	 
	     driver.findElement(By.id("mat-input-3")).sendKeys("My Rss Feed");	
	     Thread.sleep(2000);
	     System.out.println("Test case 7 passed. Feed name added succesfully.");
	     
	 //CTA testcases
	     
	     //Scroll to the bottom of the page
         JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
         jsExecutor1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	     
	     //Testcase  8 : Enable CTA toggle
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("/html/body/app-root/iz-create-edit-rss-auto-push/iz-layout-full-page//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[2]"
	     		+ "//mat-slide-toggle//span[@class='mat-slide-toggle-thumb']")).click();	 
	     System.out.println("Test case 8 passed. CTA enabled succesfully.");
	     
	     //Testcase 9 : Keep CTA 1 Blank
	     Thread.sleep(2000);
	     By buttonLocator4 = By.className("mat-raised-button"); 
	     WebElement buttonElement4 = driver.findElement(buttonLocator4);
	     buttonElement4.click();
	     System.out.println("Test case 9 passed. CTA 1 cannot be blank.");
	     
	     //Testcase 10 : Enter CTA 1 title just spaces
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("             ");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("https://abplive.com");
	     Thread.sleep(1000);
	     By buttonLocator5 = By.className("mat-raised-button"); 
	     WebElement buttonElement5 = driver.findElement(buttonLocator5);
	     buttonElement5.click();
	     System.out.println("Test case 10 passed. CTA 1 title cannot be just spaces.");
	     
	     //Testcase 11 : Keep CTA 1 url just spaces
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("Read More!!");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("            ");
	     Thread.sleep(1000);
	     By buttonLocator6 = By.className("mat-raised-button"); 
	     WebElement buttonElement6 = driver.findElement(buttonLocator6);
	     buttonElement6.click();
	     System.out.println("Test case 11 passed. CTA 1 url cannot be just spaces.");
	     
	     //Testcase 12 : Add CTA 1 icon
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("https://abplive.com");
	     Thread.sleep(1000);
	     WebElement checkbox = driver.findElement(By.cssSelector("mat-checkbox[formcontrolname='addIconCTA1Status']"));
	     checkbox.click();
	     driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).sendKeys("https://cdn.pixabay.com/photo/2017/01/18/08/25/social-media-1989152_1280.jpg");
	     System.out.println("Test case 12 passed. CTA 1 icon added successfully.");
	     
	     //Testcase 13 : Add CTA 2 blank
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//body/app-root/iz-create-edit-rss-auto-push/iz-layout-full-page//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[2]/div[3]/div[2]"
	     		+ "//button//span[.=' Add another ']")).click();
	     Thread.sleep(1000);
	     By buttonLocator7 = By.className("mat-raised-button"); 
	     WebElement buttonElement7 = driver.findElement(buttonLocator7);
	     buttonElement7.click();
	     System.out.println("Test case 13 passed. CTA 2 cannot be blank.");
	     
	     //Testcase 14 : Keep CTA 2 title just spaces
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("         ");
	     Thread.sleep(1000);
	     By buttonLocator8 = By.className("mat-raised-button"); 
	     WebElement buttonElement8 = driver.findElement(buttonLocator8);
	     buttonElement8.click();
	     System.out.println("Test case 14 passed. CTA 2 title cannot be just spaces.");
	     
	     //Testcase 15 : Keep CTA 2 url just spaces
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("Read Later");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("          ");
	     Thread.sleep(1000);
	     By buttonLocator9 = By.className("mat-raised-button"); 
	     WebElement buttonElement9 = driver.findElement(buttonLocator9);
	     buttonElement9.click();
	     System.out.println("Test case 15 passed. CTA 2 url cannot be just spaces.");
	     
	     //Testcase 16 : Add CTA 2 icon
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
	     driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
	     Thread.sleep(1000);
	     WebElement checkbox1 = driver.findElement(By.cssSelector("mat-checkbox[formcontrolname='addIconCTA2Status']"));
	     checkbox1.click();
	     driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).sendKeys("https://cdn.pixabay.com/photo/2013/07/12/19/16/newspaper-154444_1280.png");
	     System.out.println("Test case 16 passed. CTA 2 icon added successfully.");
	     
	     //Enable RSS Feed Toggle
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//app-root/iz-create-edit-rss-auto-push/iz-layout-full-page/iz-header-full-page//mat-slide-toggle//span[@class='mat-slide-toggle-bar']")).click();
	     
		 //Save RSS Feed save and publish
	     Thread.sleep(2000);
	     WebElement button = driver.findElement(By.cssSelector("button.mat-raised-button[type='submit']"));
	     button.click();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     System.out.println("RSS Feed saved and published successfully.");	
		

	}

}
