package OmniChannel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.paulhammant.ngwebdriver.ByAngular;

public class OmniChannel {

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
		 Thread.sleep(2000);
		 System.out.println("Panel opened successfully and logged In.");
		 
		 //Open omnichannel page
		 driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']/mat-drawer-container/mat-drawer-content"
		 		+ "/div[@class='iz-row']/div[@class='iz-col']/iz-left-nav//span[.='Omni Channel Push']")).click();
		 System.out.println("Omni channel page opened successfully.");
		 
		 //Select websites for omni push
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@placeholder='www.example.com']")).click();
		 Thread.sleep(2000);
		 WebElement apisWebsiteOption = driver.findElement(By.xpath("//span[contains(text(),'APIS WEBSITE')]"));
		 apisWebsiteOption.click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@placeholder='www.example.com']")).click();
		 Thread.sleep(2000);
	     WebElement androidAppNehaOption = driver.findElement(By.xpath("//span[contains(text(),'android app neha')]"));
	     androidAppNehaOption.click();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//input[@placeholder='www.example.com']")).click();
		 Thread.sleep(2000);
	     WebElement iOSAppNehaOption = driver.findElement(By.xpath("//span[contains(text(),'iOS app neha')]"));    
	     iOSAppNehaOption.click();
		 System.out.println("Websites selected successfully.");
	
////Landing Url testcases
//		 
//	     //Testcase 1 - When landing url is blank
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("");
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//         Thread.sleep(3000);
//         driver.findElement(ByAngular.buttonText("Send")).click();
//         System.out.println("Test case 1 passed. Landing Url cannot be blank.");
//		 
//		 //testcase 2 - When landing url is just spaces
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("             ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 2 passed. Landing Url cannot be just spaces.");
//		 
//		 //Testcase 3 - When landing url is invalid
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("abplive");
//		 Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//		 Thread.sleep(3000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 3 passed. Landing Url is invalid.");
//		 
//		 //Test case 4 : Enter invalid landing url -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://abplive");
//         Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//		 Thread.sleep(3000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//         System.out.println("Test case 4 passed. Landing Url is not valid.");
//         
//         //Test case 5 : Enter landing url with no campaign name and title -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://123.com");
//         Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//		 Thread.sleep(5000);
//		 //To regain back focus again on page after snackbar closes
//		 WebElement mainPageElement = driver.findElement(By.id("mat-input-1"));
//	     Actions actions = new Actions(driver);
//	     actions.moveToElement(mainPageElement).click().perform();
//	     driver.findElement(ByAngular.buttonText("Send")).click();
//         System.out.println("Test case 5 passed. Campaign name and title cannot be blank.");
//         
//         //Test case 6 : Enter landing url with no title -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://hello.com");
//         Thread.sleep(3000);
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//         System.out.println("Test case 6 passed. Title cannot be blank.");
//         
//         //Test case 7 : Enter landing url  -
//         Thread.sleep(3000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://abplive.com");
//         Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Create")).click();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         System.out.println("Test case 7 passed. Details fetched successfully.");
//		 
////Campaign Name testcases
//		 
//         //Test case 8 : Enter Campaign name just spaces -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("        ");
//         Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//         System.out.println("Test case 8 passed. Campaign name cannot be just spaces.");
//         
//         //Test case 9 : Enter Campaign name with small characters -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Hello My Test Campaign");
//         System.out.println("Test case 9 passed. Campaign name with small characters should be accepted and shouldn't throw error.");
//         
//         //Test case 10 : Enter Campaign name with maximum characters allowed 150 -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
//         		+ "industry's standard dummy text ever since the 1500");
//         System.out.println("Test case 10 passed. Campaign name with 150 characters should be accepted and shouldn't throw error.");
//         
//         //Test case 11 : Enter Campaign name in different language -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("无可否认，当读者在浏览一个页面的排版时，");
//         System.out.println("Test case 11 passed. Campaign name in different language should be accepted and shouldn't throw error.");
//         
//         //Test case 12 : Enter Campaign name with alphanumeric and special charcters -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Hello=123 ! My_test - notification* it is:;");
//         System.out.println("Test case 12 passed. Campaign name with alphanumeric and special characters should be accepted and shouldn't throw error.");
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("My Test Notificatiion it is");
//         
////Title testcases
//         
//         //Test case 13 : Enter Title just spaces -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).click();
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("           ");
//         Thread.sleep(1000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//         System.out.println("Test case 13 passed. Title cannot be just spaces.");
//         
//         //Test case 14 : Enter Title with small characters -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("Welcome my test notification");
//         System.out.println("Test case 14 passed. Title with small characters should be accepted and shouldn't throw error.");
//         
//         //Test case 15 : Enter Title with large characters -
//         Thread.sleep(2000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).clear();
//         Thread.sleep(1000);
//         driver.findElement(By.xpath("//textarea[@formcontrolname='campaignTitle']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the "
//         		+ "industry's standard dummy text ever since the 1500");
//         System.out.println("Test case 15 passed. Title with large characters should be accepted and shouldn't throw error.");
//         
////CTA testcases
//		 
//		 //Testcase 16 - Enable CTA 
//		 Thread.sleep(4000);
//		 driver.findElement(By.className("mat-slide-toggle-label")).click();
//		 System.out.println("Testcase 16 passed. CTA enabled successfully.");
//		 
//		 //Testcase 17 - Leave CTA 1 values blank
//		 Thread.sleep(2000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 17 passed. CTA 1 values cannot be blank.");
//		 
//		 //Testcase 18 - Leave CTA 1 title blank
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("https://abplive.com");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 18 passed. CTA 1 title cannot be blank.");
//		 
//		 //Testcase 19 - Enter CTA 1 title just spaces
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("             ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 19 passed. CTA 1 title cannot be just spaces.");
//		 
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1Title']")).sendKeys("Read More!!!!");
//		 
//		 //Testcase 20 - Enter CTA 1 URL just spaces
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("            ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 20 passed. CTA 1 URL cannot be just spaces.");
//		 
//		 //Testcase 21 - Keep CTA 1 URL blank
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("abplive");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 21 passed. CTA 1 URL is invalid.");
//		 
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta1LandingUrl']")).sendKeys("abplive.com");
//		 
//		 //Testcase 22 - Enter invalid CTA 1 icon 
//		 Thread.sleep(2000);
//		 driver.findElement(By.id("mat-checkbox-3")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).sendKeys("         ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 22 passed. CTA 1 icon is invalid");
//		 
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA1Src']")).sendKeys("https://cdn.pixabay.com/photo/2023/08/19/15/39/breakfast-8200753_1280.jpg");
//		 
//		 //Enable CTA 2
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("/html//div[@id='display-area']//mat-vertical-stepper[@role='tablist']/div[2]/div/div[@role='tabpanel']"
//		 		+ "/div/mat-card[3]/div[3]/div[2]/div[2]/button//span[.='Add another ']")).click();
//		 
//		 //Testcase 23 - Leave CTA 2 values blank
//		 Thread.sleep(2000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 23 passed. CTA 2 values cannot be blank.");
//		 
//		 //Testcase 24 - Leave CTA 2 title blank
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 24 passed. CTA 2 title cannot be blank.");
//		 
//		 //Testcase 25 - Enter CTA 2 title just spaces
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("             ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 25 passed. CTA 2 title cannot be just spaces.");
//		 
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2Title']")).sendKeys("Read the article later!!");
//		 
//		 //Testcase 26 - Enter CTA 2 URL just spaces
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("            ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 26 passed. CTA 2 URL cannot be just spaces.");
//		 
//		 //Testcase 27 - Keep CTA 2 URL blank
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("abplive");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 27 passed. CTA 2 URL is invalid.");
//
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='cta2LandingUrl']")).sendKeys("https://abplive.com");
//		 
//		 //Testcase 28 - Enter invalid CTA 2 icon 
//		 Thread.sleep(2000);
//		 driver.findElement(By.id("mat-checkbox-5")).click();
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).sendKeys("          ");
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 System.out.println("Testcase 28 passed. CTA 2 icon is invalid");
//		 
//		 Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).clear();
//		 driver.findElement(By.xpath("//input[@formcontrolname='addIconCTA2Src']")).sendKeys("https://cdn.pixabay.com/photo/2016/12/02/02/10/idea-1876659_1280.jpg");
//	
////Push a Campaign		 
//		 
//		 Thread.sleep(3000);
//		 driver.findElement(ByAngular.buttonText("Send")).click();
//		 Thread.sleep(3000);
//		 WebElement button = driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span"));
//	     button.click();
//	     System.out.println("Campaign pushed successfully.");
//	     Thread.sleep(10000);
//	     
//	     //Go back to omni channel
//	     driver.findElement(By.linkText("Go back")).click();
//	     
//	     //Open Omni-channel page again
//	     Thread.sleep(3000);
//	     driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']/mat-drawer-container/mat-drawer-content"
//			 		+ "/div[@class='iz-row']/div[@class='iz-col']/iz-left-nav//span[.='Omni Channel Push']")).click();
//	     
////Push a campiagn on Segments
	     
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).click();
	     driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("abplive.com");
		 driver.findElement(ByAngular.buttonText("Create")).click();
	     
		 //Scroll down on a page
		 Thread.sleep(2000);
		 JavascriptExecutor js1 = (JavascriptExecutor) driver;
	     js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	    
	     Thread.sleep(2000);
	     java.util.List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@value='send-to-segment']"));

	        // Click each radio button
	        for (WebElement radioButton : radioButtons) {
	            radioButton.click();
	        }

	     
	     
	     
	    }
}
	     
	            
	        
	     
	     
	     
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

		 
		 
		 
		 
		 
		
		 
		 
		 

		 
		 
		
		

	


