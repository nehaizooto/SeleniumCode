 package demo;
 
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.paulhammant.ngwebdriver.ByAngular;

public class DemoClass {

	public static org.apache.logging.log4j.Logger log;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		log= LogManager.getLogger(DemoClass.class);
		
	
	     //Navigate Chrome Driver
		 WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
		 Thread.sleep(2000);
		 log.info("Chrome logged in");
		 
		 //Open panel
		 driver.get("https://panel.izooto.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
		 log.info("Panel logged in");	
		 
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
		 
		 log.info("panel opened successfully");
		 
		 //Open Send Notification page : 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//app-root/iz-dashboard-root[@class='ng-star-inserted']/iz-layout-one[@class='show-email-banner']"
		 		+ "/mat-drawer-container/mat-drawer-content/div[@class='iz-row']/div[@class='iz-col']/iz-left-nav"
		 		+ "//span[.='Send Notification']")).click();
		 Thread.sleep(2000);
		 
		 Thread.sleep(1000);
         driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("https://abplive.com");
         Thread.sleep(1000);
		 driver.findElement(ByAngular.buttonText("Create")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         System.out.println("Test case 10 passed. Details fetched successfully.");
         
         //Scroll down on a page
		 WebElement elementToScrollTo = driver.findElement(By.xpath("/html//div[@id='display-area']//mat-vertical-stepper[@role='tablist']/div[1]/div/div[@role='tabpanel']"
			 		+ "/div/mat-card[3]/div[2]/div[1]//button[@type='button']"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
         
        
       //Push a campaign using send immediately
         Thread.sleep(2000);
         driver.findElement(ByAngular.buttonText("Send")).click();
         Thread.sleep(3000);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
         
         
         
         
         
         
         
         
         
//         WebElement button = driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span"));
//
//         // Click the button
//         button.click();
//		 
//		 
	        
	        
	}
}
