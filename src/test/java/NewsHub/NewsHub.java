package NewsHub;




import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import com.paulhammant.ngwebdriver.ByAngular;

public class NewsHub {

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
		 
		 //Open News-Hub page 
		 driver.findElement(By.linkText("News Hub")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//mat-dialog-container[@id='mat-dialog-0']/iz-news-hub-onboarding-dialog"
		 		+ "//div[@class='iz-row iz-row--space-btwn ng-tns-c226-15']/button[1]")).click();
		 System.out.println("Newshub page opened successfully.");
		 
		 //Enable Desktop and Mobile Toggle
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div[@class='iz-col']/mat-card[2]//div[@class='news-hub-control-options-area']/div/div[2]/mat-slide-toggle"
		 		+ "//span[@class='mat-slide-toggle-thumb']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector(".mat-button-base.mat-primary.mat-raised-button.mr-20.ng-star-inserted")).click();
		 System.out.println("Newshub for desktop enabled successfully.");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("/html//div[@id='display-area']/div/div/mat-card[2]//div[@class='news-hub-control-options-area']/div/div[3]/mat-slide-toggle"
		 		+ "//span[@class='mat-slide-toggle-bar mat-slide-toggle-bar-no-side-margin']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector(".mat-button-base.mat-primary.mat-raised-button.mr-20.ng-star-inserted")).click();
		 System.out.println("Newshub for mobile enabled successfully.");
		 
		 //Edit Newshub design 
		 Thread.sleep(2000);
		 driver.findElement(By.linkText("Edit design")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//span[text()='Sticky Side Bar']")).click(); //change for floating icon
		 System.out.println("Edit design opened successfully.");
		 
		 //Change color theme for newshub
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='widgetColorFC']")).click();
		 Thread.sleep(2000);
		 WebElement colorPicker = driver.findElement(By.cssSelector(".saturation-lightness"));
	     int xCoordinate = 0; 
	     int yCoordinate = 0;  
	     Actions actions = new Actions(driver);
	     actions.moveToElement(colorPicker, xCoordinate, yCoordinate).click().build().perform();
         Thread.sleep(2000);
         driver.findElement(ByAngular.buttonText("Ok")).click();
         System.out.println("Color theme changed successfully.");
		 
		 //Change newshub icon
         Thread.sleep(2000);
         WebElement matSelectElement = driver.findElement(By.id("mat-select-6"));
         matSelectElement.click();
         String optionText = "Shout-out"; //change icon name whenever required
         WebElement optionToSelect = driver.findElement(By.xpath("//span[contains(text(), '" + optionText + "')]"));
         optionToSelect.click();
         System.out.println("Icon changed successfully.");
         
         //Change widget placement
         Thread.sleep(2000);
         driver.findElement(By.id("mat-button-toggle-5-button")).click(); //change for left placement
         System.out.println("Widget changed successfully.");
         
         //Save newshub design changes
         Thread.sleep(1000);
         driver.findElement(ByAngular.buttonText("Save")).click();
         Thread.sleep(4000);
         System.out.println("Newshub saved successfully.");
         
         //Open a new tab and navigate to the desired URL
         ((JavascriptExecutor) driver).executeScript("window.open();");
         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));
         driver.get("http://dummyizapis.000webhostapp.com/");
         Thread.sleep(4000);
         System.out.println("Newshub is visible on website.");
         
         //Open Newshub by clicking icon
         driver.findElement(By.id("iz-news-hub-sticky-sidebar")).click();
         System.out.println("Newshub clicked and opened successfully.");
         
         //Close Newshub widget
         Thread.sleep(2000);
         try {
             WebElement closeButton = driver.findElement(By.className("iz-news-hub-close-news-hub-btn"));
             closeButton.click();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
          Thread.sleep(3000);
          System.out.println("Newshub widget closed successfully.");
         }
         
         // Switch back to the original tab
         driver.switchTo().window(tabs.get(0));
         
       
		 
		
		
		
		
		
		
		
         
		

	}

}
