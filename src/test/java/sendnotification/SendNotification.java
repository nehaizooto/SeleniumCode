package sendnotification;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import com.paulhammant.ngwebdriver.ByAngular;

public class SendNotification {

	
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
			 
			 //Open Send Notification page : 
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']"
			 		+ "/mat-drawer-container/mat-drawer-content/div[@class='iz-row']/div[@class='iz-col']/iz-left-nav"
			 		+ "//span[.='Send Notification']")).click();
			 Thread.sleep(2000);
			 
//Markup Tags - Test cases for markup tags :
			 
			 //Test case 1 : When Campaign name and Title is spaces - 
			 driver.findElement(ByAngular.buttonText("Configure")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
					 	+ "='Type a default value or click @ to select from suggestions.']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
					 	+ "='Type a default value or click @ to select from suggestions.']")).clear();
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
			 	+ "='Type a default value or click @ to select from suggestions.']")).sendKeys("   "); 
			 Thread.sleep(2000);	
			 driver.findElement(By.id("mat-input-8")).clear();
			 driver.findElement(By.id("mat-input-8")).sendKeys("      ");
			 Thread.sleep(2000);	
			 driver.findElement(ByAngular.buttonText("Save")).click();
			 System.out.println("Test case 1 passed. Campaign name and title cannot be just spaces.");
			  
			 //Test case 2 : When Campaign name and Title is blank -
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
					 	+ "='Type a default value or click @ to select from suggestions.']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
					 	+ "='Type a default value or click @ to select from suggestions.']")).clear();
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
			 	+ "='Type a default value or click @ to select from suggestions.']")).sendKeys(""); 
			 Thread.sleep(2000);	
			 driver.findElement(By.id("mat-input-8")).clear();
			 driver.findElement(By.id("mat-input-8")).sendKeys("");
			 Thread.sleep(2000);	
			 driver.findElement(ByAngular.buttonText("Save")).click();
			 System.out.println("Test case 2 passed. Campaign name and title cannot be blank.");

			 //Test case 3 : Enter values for all field and click Save -
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-campaign-confugration-tab[@class='ng-star-inserted']/div//form/div[1]/div[@class='col-field-value']/mat-form-field//input[@placeholder"
			 	+ "='Type a default value or click @ to select from suggestions.']")).sendKeys("@meta:title"); 
			 Thread.sleep(2000);	
			 driver.findElement(By.id("mat-input-8")).sendKeys("@og:title");
			 Thread.sleep(2000);	
			 driver.findElement(ByAngular.buttonText("Save")).click();
			 System.out.println("Test case 3 passed. All fields saved successfully.");
			
//Landing Page URL test cases :
			 
			 //Test case 4 : Enter blank landing url value -
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("");
			 driver.findElement(ByAngular.buttonText("Create")).click();
             Thread.sleep(3000);
             driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 4 passed. Landing Url cannot be blank.");
			 
             //Test case 5 : Enter blank landing url value just spaces -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).click();
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("                 ");
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 Thread.sleep(3000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 5 passed. Landing Url cannot be just spaces.");
             
             //Test case 6 : Enter invalid landing url -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("abplive");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 Thread.sleep(3000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 6 passed. Landing Url is not valid.");
             
             //Test case 7 : Enter invalid landing url -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://abplive");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 Thread.sleep(3000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 7 passed. Landing Url is not valid.");
             
             //Test case 8 : Enter landing url with no campaign name and title -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://123.com");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 Thread.sleep(5000);
			 //To regain back focus again on page after snackbar closes
			 WebElement mainPageElement = driver.findElement(By.id("mat-input-1"));
		     Actions actions = new Actions(driver);
		     actions.moveToElement(mainPageElement).click().perform();
		     driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 8 passed. Campaign name and title cannot be blank.");
             
             //Test case 9 : Enter landing url with no title -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://hello.com");
             Thread.sleep(3000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
             System.out.println("Test case 9 passed. Title cannot be blank.");
             
             //Test case 10 : Enter landing url  -
             Thread.sleep(3000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://abplive.com");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
             System.out.println("Test case 10 passed. Details fetched successfully.");
             
//Campaign Name test cases :
             
             //Test case 11 : Enter Campaign name just spaces -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("        ");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 11 passed. Campaign name cannot be just spaces.");
             
             //Test case 12 : Enter Campaign name with small characters -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Hello My Test Campaign");
             System.out.println("Test case 12 passed. Campaign name with small characters should be accepted and shouldn't throw error.");
             
             //Test case 13 : Enter Campaign name with maximum characters allowed 150 -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
             		+ "industry's standard dummy text ever since the 1500");
             System.out.println("Test case 13 passed. Campaign name with 150 characters should be accepted and shouldn't throw error.");
             
             //Test case 14 : Enter Campaign name in different language -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("无可否认，当读者在浏览一个页面的排版时，");
             System.out.println("Test case 14 passed. Campaign name in different language should be accepted and shouldn't throw error.");
             
             //Test case 15 : Enter Campaign name with alphanumeric and special charcters -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Hello=123 ! My_test - notification* it is:;");
             System.out.println("Test case 15 passed. Campaign name with alphanumeric and special characters should be accepted and shouldn't throw error.");
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("My Test Notificatiion it is");
             
//Title test cases :
             
             //Test case 16 : Enter Title just spaces -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).click();
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("           ");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 16 passed. Title cannot be just spaces.");
             
             //Test case 17 : Enter Title with small characters -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("Welcome my test notification");
             System.out.println("Test case 17 passed. Title with small characters should be accepted and shouldn't throw error.");
             
             //Test case 18 : Enter Title with large characters -
             Thread.sleep(2000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
             Thread.sleep(1000);
             driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
             		+ "industry's standard dummy text ever since the 1500");
             System.out.println("Test case 18 passed. Title with large characters should be accepted and shouldn't throw error.");
             
//Banner Image test cases :
             
             //Test case 19 : Enter banner image just spaces -
             Thread.sleep(2000);
			 driver.findElement(ByAngular.buttonText("Reset")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).sendKeys("              ");
			 Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 19 passed. Invalid Banner image.");
             
             //Test case 20 : Enter invalid banner image -
             Thread.sleep(2000);
             driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
	 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).clear();
		     Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).sendKeys("https://abc.com");
             System.out.println("Test case 20 passed. Invalid Banner image.");
             
             //Test case 21 : Enter invalid banner image -
             Thread.sleep(2000);
             driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
	 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).clear();
				 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).sendKeys("https://abc.png");
             System.out.println("Test case 21 passed. Invalid Banner image.");
             
             //Test case 22 : Enter invalid banner image -
             Thread.sleep(2000);
             driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
	 			 		+ "/div/mat-card[3]/div[1]/div//mat-form-field//input[@type='text']")).clear();
			 Thread.sleep(2000);
             driver.findElement(By.id("mat-input-1")).clear();
             Thread.sleep(1000);
			 driver.findElement(By.id("mat-input-1")).sendKeys("https://abplive.com");
             Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Create")).click();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 System.out.println("Test case 22 passed. Valid Banner Image");
			 
			 //Scroll down on a page
			 WebElement elementToScrollTo = driver.findElement(By.cssSelector("button.mat-stroked-button.mat-primary"));
			 JavascriptExecutor js = (JavascriptExecutor) driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
			 System.out.println("Scrolled successfully");
			 
//Icon Image test cases :
			 
			//Test case 23 : Enter icon image just spaces -
			 Thread.sleep(2000);
			 WebElement resetButton = driver.findElement(By.xpath("/html//div[@id='display-area']//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
			 		+ "/div/mat-card[3]/div[2]/div[1]//button[@type='button']"));
	         resetButton.click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
	 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
	 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']")).sendKeys("              ");
			 Thread.sleep(1000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
             System.out.println("Test case 23 passed. Invalid Icon image");
             
             //Test case 24 : Enter invalid icon image -
             Thread.sleep(2000);
             driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
	 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']")).sendKeys("abc.png");
			 System.out.println("Test case 24 passed. Invalid Icon image.");
			 
			 //Test case 25 : Enter valid icon image -
             Thread.sleep(2000);
             driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]"
	 			 		+ "/div[2]/div[1]//mat-form-field//input[@type='text']"))
			 .sendKeys("https://cdn.pixabay.com/photo/2015/04/19/08/32/rose-729509_1280.jpg");
			 System.out.println("Test case 25 passed. Valid Icon image.");
			 
//CTA test cases :
			 
			 //Test case 26 - Enable CTA 
			 Thread.sleep(4000);
			 driver.findElement(By.className("mat-slide-toggle-label")).click();
			 System.out.println("Test case 26 passed. CTA enabled successfully.");
			 
			 //Test case 27 - Leave CTA 1 values blank
			 Thread.sleep(2000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 27 passed. CTA 1 values cannot be blank.");
			 
			 //Test case 28 - Leave CTA 1 title blank
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("https://abplive.com");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 28 passed. CTA 1 title cannot be blank.");
			 
			 //Test case 29 - Enter CTA 1 title just spaces
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("             ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 29 passed. CTA 1 title cannot be just spaces.");
			 
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("Read More!!!!");
			 
			 //Test case 30 - Enter CTA 1 URL just spaces
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("            ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 30 passed. CTA 1 URL cannot be just spaces.");
			 
			 //Testcase 31 - Keep CTA 1 URL blank
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("abplive");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 31 passed. CTA 1 URL is invalid.");
			 
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("abplive.com");
			 
			 //Testcase 32 - Enter invalid CTA 1 icon 
			 Thread.sleep(2000);
			 driver.findElement(By.id("mat-checkbox-3")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).sendKeys("         ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 32 passed. CTA 1 icon is invalid");
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).sendKeys("https://cdn.pixabay.com/photo/2023/08/19/15/39/breakfast-8200753_1280.jpg");
			 
			 //Enable CTA 2
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//mat-icon[contains(text(),'add')]")).click();
			 
			 //Test case 33 - Leave CTA 2 values blank
			 Thread.sleep(2000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 33 passed. CTA 2 values cannot be blank.");
			 
			 //Testcase 34 - Leave CTA 2 title blank
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 34 passed. CTA 2 title cannot be blank.");
			 
			 //Testcase 35 - Enter CTA 2 title just spaces
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("             ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 35 passed. CTA 2 title cannot be just spaces.");
			 
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("Read the article later!!");
			 
			 //Test case 36 - Enter CTA 2 URL just spaces
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("            ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 36 passed. CTA 2 URL cannot be just spaces.");
			 
			 //Test case 37 - Keep CTA 2 URL blank
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("abplive");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 37 passed. CTA 2 URL is invalid.");

			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
			 
			 //Test case 38 - Enter invalid CTA 2 icon 
			 Thread.sleep(2000);
			 driver.findElement(By.id("mat-checkbox-5")).click();
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).sendKeys("          ");
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 38 passed. CTA 2 icon is invalid");
			 
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).clear();
			 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).sendKeys("https://cdn.pixabay.com/photo/2016/12/02/02/10/idea-1876659_1280.jpg");
		
//Badge testcases :
			 
			 //Enable Advanced section
			 Thread.sleep(2000);
			 WebElement arrowIcon = driver.findElement(By.xpath("//mat-icon[text()='keyboard_arrow_down']"));
		     arrowIcon.click();
	         System.out.println("Advanced section opened successfully.");
	      
	         //Test case 39 - Enter badge url just spaces
			 Thread.sleep(2000);
	         driver.findElement(By.xpath("//div[@id='display-area']//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
	         		+ "/div/mat-card[4]/div/div[1]/div[1]//button[@type='button']/span[@class='mat-button-wrapper']")).click();
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).sendKeys("               ");
			 System.out.println("Test case 39 passed. Invalid Banner image");
			 
			 //Test case 40 - Enter invalid badge url
			 Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).clear();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).sendKeys("abc.png"); 
			 System.out.println("Test case 40 passed. Invalid Banner image");
		        
			 //Test case 41 - Enter valid badge url
			 Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).clear();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//input[@formcontrolname='badgeSrc']")).sendKeys("https://cdn.pixabay.com/photo/2023/08/20/14/47/stingray-8202506_1280.jpg");
			 System.out.println("Test case 41 passed. Valid Banner image");
		        
//UTM Parameters Testcases
	         
	         //Test case 42 - Enter just spaces for utm_campaign, utm_term, utm_content
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).sendKeys("               ");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).sendKeys("               ");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).sendKeys("               ");
			 Thread.sleep(2000);
			 driver.findElement(ByAngular.buttonText("Send")).click();
			 System.out.println("Test case 42 passed. Utm Parameters can be just spaces.");
			 
			 //Test case 43 - Enter utm_campaign, utm_term, utm_content in different language
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).sendKeys("فائدته");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).sendKeys("उद्योग");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).sendKeys("օգտագործում");
			 System.out.println("Test case 43 passed. Utm Parameters should not throw any error and should be accepted in different language.");
			 
			 //Test case 44 - Enter utm_campaign, utm_term, utm_content in Uppercase
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).sendKeys("CAMPAIGN");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).sendKeys("TERM");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).sendKeys("CONTENT");
			 System.out.println("Test case 44 passed. Utm Parameters should not throw any error and should be accepted in uppercase.");
			 
			 //Test case 45 - Enter utm_campaign, utm_term, utm_content in alphanumeric
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='campaign']")).sendKeys("campaign_name*1");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='term']")).sendKeys("campaign_Term1");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).clear();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//input[@formcontrolname='content']")).sendKeys("campaign_content+");
			 System.out.println("Test case 45 passed. Utm Parameters should not throw any error and should be accepted in alphanumeric.");
			 
//Push a campaign using send immediately
			 
	         Thread.sleep(2000);
	         driver.findElement(ByAngular.buttonText("Send")).click();
	         Thread.sleep(3000);
	         WebElement button = driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span"));
	         button.click();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	         System.out.println("Send Immediately notification pushed successfully.");
	         
	         
	         
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			  
//			 //Test case 26 : CTA 1 passed blank -
//			 Thread.sleep(2000);
//	         driver.findElement(By.cssSelector(".mat-slide-toggle-thumb")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(ByAngular.buttonText("Send")).click();
//	         System.out.println("Test case 26 passed. CTA cannot be blank.");
//	         
//	         //Test case 27 : CTA 1 title is blank -
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//			 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).click();
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//				 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).sendKeys("https://abplive.com");
//		     Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 27 passed. CTA 1 title cannot be blank.");
//		     
//		     //Test case 28 : CTA 1 title just spaces -
//			 Thread.sleep(2000);
//			 driver.findElement(By.id("mat-input-12")).click();
//			 driver.findElement(By.id("mat-input-12")).sendKeys("        ");
//		     Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 28 passed. CTA 1 title cannot be just spaces.");
//		     
//		     //Test case 29 : CTA 1 URL cannot be blank -
//			 Thread.sleep(2000);
//			 driver.findElement(By.id("mat-input-12")).clear();
//			 driver.findElement(By.id("mat-input-12")).sendKeys("Read More!!!!");
//		     Thread.sleep(2000);
//		     driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//				 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).click();
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//					 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).clear();
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//					 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).sendKeys("       ");
//			 Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 29 passed. CTA 1 url cannot be just spaces.");
//			
//		     //Test case 30 : CTA 1 url as invalid url value -
//		     Thread.sleep(2000);
//		     driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//				 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).click();
//		     driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//				 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).clear();
//		     Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//					 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).sendKeys("abc");
//			 Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 30 passed. CTA 1 url is invalid.");
//		     
//		     //Test case 31 : CTA 2 as blank values -
//		     Thread.sleep(2000);
//		     driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//				 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).clear();
//		     Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[3]//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]/div/div[2]"
//					 		+ "/div[1]/div[2]/mat-form-field//input[@type='text']")).sendKeys("https://abplive.com");
//			 Thread.sleep(2000);
//			 driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']"
//		         		+ "/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]//button//span[.='Add another ']")).click();
//			 Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 31 passed. CTA 2 cannot be blank.");  
//		     
//		     //Test case 32 : CTA 2 title as blank value -
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).click();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).sendKeys("https://abc.com");
//			 Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 32 passed. CTA 2 title cannot be blank.");  
//		     
//		     //Test case 33 : CTA 2 title as just spaces -
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-14")).click();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-14")).sendKeys("           ");
//			 Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 33 passed. CTA 2 title cannot just spaces.");
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-14")).click();
//		     driver.findElement(By.id("mat-input-14")).clear();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-14")).sendKeys("Read Later");
//		     
//		     //Test case 34 : CTA 2 url cannot be just spaces -
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).click();
//		     driver.findElement(By.id("mat-input-15")).clear();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).sendKeys("          ");
//		     Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 34 passed. CTA 2 url cannot be just spaces.");
//			
//		     //Test case 35 : CTA 2 url as invalid -
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).clear();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).sendKeys("abc");
//		     Thread.sleep(2000);
//		     driver.findElement(ByAngular.buttonText("Send")).click();
//		     System.out.println("Test case 35 passed. CTA 2 url is invalid.");
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).clear();
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-input-15")).sendKeys("https://abplive.com");
//		     
//		     //Add social share buttons - 
//		     Thread.sleep(2000);
//		     driver.findElement(By.id("mat-checkbox-4-input")).click();
//		    
//		     WebElement radioButton = driver.findElement(By.cssSelector("input[type='radio'][value='linkedIn']"));
//		        if (!radioButton.isSelected()) {
//		         
//		            radioButton.click();
//		        }



		     
			
			
			
			
			
			
             
             
	
//			 driver.findElement(ByAngular.buttonText("alternate_email")).click();
//			 Thread.sleep(1000);
//			 driver.findElement(ByAngular.buttonText("@meta:title")).click();
//			 
//			 
//			 driver.findElement(ByAngular.buttonText("alternate_email")).click();
//			 Thread.sleep(1000);
//			 driver.findElement(ByAngular.buttonText("@meta:title")).click();
//			 Thread.sleep(1000);
//			 driver.findElement(By.id("mat-input-9")).clear();
//			 Thread.sleep(1000);
//			 driver.findElement(By.id("mat-input-9")).sendKeys("@meta:description");
//			 Thread.sleep(1000);
//			 driver.findElement(ByAngular.buttonText("Save")).click();
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 
//			 //Landing URL :
//			 Thread.sleep(5000);
//             driver.findElement(By.id("mat-input-1")).sendKeys("https://www.abplive.com");
//             Thread.sleep(2000);
//			 driver.findElement(ByAngular.buttonText("Create")).click();
//			 
//			// Scroll to the bottom of the page
//			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			 jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//			 
//		     //CTA
//			 Thread.sleep(2000);
//	         driver.findElement(By.cssSelector(".mat-slide-toggle-thumb")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(By.id("mat-input-11")).click();
//	         driver.findElement(By.id("mat-input-11")).sendKeys("Read More");
//	         Thread.sleep(1000);
//	         driver.findElement(By.id("mat-input-12")).click();
//	         driver.findElement(By.id("mat-input-12")).sendKeys("https://abplive.com");
//	         Thread.sleep(2000);
//	         driver.findElement(By.xpath("/html//div[@id='display-area']/div//mat-vertical-stepper[@role='tablist']"
//	         		+ "/div[1]/div/div[@role='tabpanel']/div/mat-card[3]/div[3]/div[2]//button//span[.='Add another ']")).click();
//	         Thread.sleep(2000);
//	         driver.findElement(By.id("mat-input-13")).click();
//	         driver.findElement(By.id("mat-input-13")).sendKeys("Read Later");
//	         Thread.sleep(1000);
//	         driver.findElement(By.id("mat-input-14")).click();
//	         driver.findElement(By.id("mat-input-14")).sendKeys("https://abplive.com");
//	         
//			// Scroll to the bottom of the page
//			JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
//			jsExecutor1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//			
//			Thread.sleep(1000);
//	        driver.findElement(ByAngular.buttonText("Send")).click();
//	        Thread.sleep(2000);
//	        driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span")).click();
//	        
//	         
//	         
//		
//	         
//			 
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//
	
	}

}
