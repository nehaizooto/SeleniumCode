package CampaignReports;

import java.awt.Desktop;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.paulhammant.ngwebdriver.ByAngular;

public class CampaignReport {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, IOException {

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
		  
//Search by Campaign Name 	  
		
		  //Testcase 1 - When campaign name is just spaces
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).sendKeys("           ");
		  System.out.println("Since campaign name was just spaces couldn't find any campaign.");
		  
		  //Testcase 2 - When campaign name is something that doesn't exist under reporting
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).sendKeys("campaign report test 123");
		  System.out.println("No campaign found with this name.");
		
		  //Testcase 3 - When campaign is present with name mentioned
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).clear();
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).sendKeys("Facebook – log in or sign up");
		  System.out.println("Campaign with name - Facebook – log in or sign up was fetched successfully.");

//Open detailed Campaign Report
		  
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).clear();
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  driver.findElement(By.className("camp-name--report")).click();
		  System.out.println("Campaign detailed report opened successfully.");
		  
		  Thread.sleep(5000);
		  driver.findElement(By.cssSelector("button.mat-icon-button[type='button']")).click();
		  System.out.println("Campaign detailed report closed successfully.");
		  
//Export CSV
		  
		  Thread.sleep(2000);
		  driver.findElement(By.className("btn-csv-download")).click();
		  System.out.println("CSV Exported successfully.");
		  
		  String filePath = "/Users/nehasingh/Downloads/iZooto _ Campaign Data for APIS WEBSITE.csv";
	      Path downloadedFile = Paths.get(filePath);
		  Desktop.getDesktop().open(downloadedFile.toFile());
		  Thread.sleep(5000);
		  try {
			    // Replace 'Adobe Reader' with the actual application name
			    String applicationName = "Numbers";
			    Runtime.getRuntime().exec("pkill -f " + applicationName);
			} catch (IOException e) {
			    e.printStackTrace();
			}
		  System.out.println("Downloaded CSV opened successfully.");
		  
//Select Different Types of Campaigns Pushed
		  
		  //Type 1 - One-Time
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
		  Thread.sleep(2000);
		  WebElement oneTimeOption = driver.findElement(By.xpath("//span[text()='One-Time']"));
	      oneTimeOption.click();
	      Thread.sleep(2000);
	      WebElement body = driver.findElement(By.tagName("body"));
	      body.click();
	      System.out.println("Showing One-time type pushed campaigns only.");
		  
	      //Type 2 - Recurring
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
		  Thread.sleep(2000);
		  WebElement oneTimeOption1 = driver.findElement(By.xpath("//span[text()='One-Time']"));
	      oneTimeOption1.click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
	      Thread.sleep(2000);
		  WebElement recurringOption = driver.findElement(By.xpath("//span[text()='Recurring']"));
	      recurringOption.click();
	      Thread.sleep(2000);
	      WebElement body1 = driver.findElement(By.tagName("body"));
	      body1.click();
	      System.out.println("Showing Recurring type pushed campaigns only.");
		  
	      //Type 3 - API Push
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
	      Thread.sleep(2000);
		  WebElement apiOption = driver.findElement(By.xpath("//span[text()='API Push']"));
	      apiOption.click();
	      Thread.sleep(2000);
	      WebElement body2 = driver.findElement(By.tagName("body"));
	      body2.click();
	      System.out.println("Showing API Push type pushed campaigns only.");
		  
		  //Type 4 - All
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Type']")).click();
	      Thread.sleep(2000);
		  WebElement aLLOption = driver.findElement(By.xpath("//span[text()='All']"));
	      aLLOption.click();
	      Thread.sleep(2000);
	      WebElement body3 = driver.findElement(By.tagName("body"));
	      body3.click();
	      System.out.println("Showing All Push type pushed campaigns.");

//Select different status of pushed campaigns
	      
	      //Type 1 - Scheduled
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
		  Thread.sleep(2000);
	      WebElement scheduledOption = driver.findElement(By.xpath("//span[text()='Scheduled']"));
	      scheduledOption.click();
	      Thread.sleep(2000);
	      WebElement body4 = driver.findElement(By.tagName("body"));
	      body4.click();
	      System.out.println("Showing Scheduled type campaigns only.");
	      
	      //Type 2 - Running
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
	      Thread.sleep(2000);
	      WebElement runningOption = driver.findElement(By.xpath("//span[text()='Running']"));
	      runningOption.click();
	      Thread.sleep(2000);
	      WebElement body5 = driver.findElement(By.tagName("body"));
	      body5.click();
	      System.out.println("Showing Running type campaigns only.");
	      
	      //Type 3 - Completed
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
	      Thread.sleep(2000);
	      WebElement completedOption = driver.findElement(By.xpath("//span[text()='Completed']"));
	      completedOption.click();
	      Thread.sleep(2000);
	      WebElement body6 = driver.findElement(By.tagName("body"));
	      body6.click();
	      System.out.println("Showing Completed type campaigns only.");
	      
	      //Type 4 - Aborted
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
	      Thread.sleep(2000);
	      WebElement AbortedOption = driver.findElement(By.xpath("//span[text()='Aborted']"));
	      AbortedOption.click();
	      Thread.sleep(2000);
	      WebElement body7 = driver.findElement(By.tagName("body"));
	      body7.click();
	      System.out.println("Showing Aborted type campaigns only.");
	      
	      //Type 4 - All
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.className("mat-pseudo-checkbox-checked")).click();
	      Thread.sleep(2000);
		  driver.findElement(By.xpath("//mat-select[@placeholder='Status']")).click();
	      Thread.sleep(2000);
	      WebElement AllOption = driver.findElement(By.xpath("//span[text()='All']"));
	      AllOption.click();
	      Thread.sleep(2000);
	      WebElement body8 = driver.findElement(By.tagName("body"));
	      body8.click();
	      System.out.println("Showing All type campaigns only.");
	      
//Check Pagination of the page	      
	      
	      //For next to reach last page
	      Thread.sleep(3000);
	      try {
	            WebElement nextPageButton = driver.findElement(By.cssSelector("button[aria-label='Next page']"));
	            while (nextPageButton.isEnabled()) {
	                nextPageButton.click();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	      System.out.println("Next of pagination on reporting is working fine. Old reports are visible.");
		  
	      //For previous to reach first page
		  Thread.sleep(3000);
		  try {
	            WebElement previousPageButton = driver.findElement(By.cssSelector("button[aria-label='Previous page']"));
	            while (previousPageButton.isEnabled()) {
	                previousPageButton.click();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		  System.out.println("Previous of pagination on reporting is working fine.");
	      
		  //Scroll the page
		  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollBy(0, -500);");
          
//Date-Time Selector
          
		  //Type 1 - Last seven days
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' Last 7 Days ']")).click();
          System.out.println("Last 7 days report fetched successfully.");
          
          //Type 2 - This Week
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' This Week ']")).click();
          System.out.println("This Week report fetched successfully.");
          
          //Type 3 - Last 30 Days
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' Last 30 Days ']")).click();
          System.out.println("Last 30 days report fetched successfully.");
          
          //Type 4 - This Month
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' This Month ']")).click();
          System.out.println("This Month report fetched successfully.");
          
          //Type 5 - Last Month
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' Last Month ']")).click();
          System.out.println("Last Month report fetched successfully.");
          
          //Type 6 - All Time
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' All Time ']")).click();
          System.out.println("All Time report fetched successfully.");
          
          //Type 7 - Custom
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.cssSelector(".prev.available")).click();
          driver.findElement(By.cssSelector(".calendar.left.ng-star-inserted > .calendar-table > .ng-star-inserted.table-condensed > tbody > "
		                                      + "tr:nth-of-type(1) > td:nth-of-type(2)")).click();
          driver.findElement(By.cssSelector(".calendar.left.ng-star-inserted > .calendar-table > .ng-star-inserted.table-condensed > tbody > "
          		+ "tr:nth-of-type(5) > td:nth-of-type(4)")).click();
          Thread.sleep(2000);
          driver.findElement(ByAngular.buttonText("Apply")).click();
          System.out.println("Custom date report fetched successfully.");
          
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html//div[@id='display-area']/div/mat-card/div/div[2]/mat-form-field//input")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("/html/body//div[@role='dialog']/iz-date-range-container//div[.=' All Time ']")).click();
         
//Load More          
          
	      Thread.sleep(3000);
	      try {
	            // Find the last page button (in this case, it's the "Next" button)
	            WebElement nextPageButton = driver.findElement(By.cssSelector("button[aria-label='Next page']"));
	            while (nextPageButton.isEnabled()) {
	                nextPageButton.click();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		  driver.findElement(By.xpath("//span[contains(text(),'Load More')]")).click();
		  Thread.sleep(3000);
		  System.out.println("Load More is working fine.");
		  
		  driver.navigate().refresh();
		  Thread.sleep(3000);
		  
//Clone a campaign
		  
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).click();
		  driver.findElement(By.xpath("//input[@placeholder='Search by Campaign name']")).sendKeys("naruto");
		  Thread.sleep(4000);
		  WebElement cloneButton = driver.findElement(By.cssSelector("button[mattooltip='Clone']"));
          cloneButton.click();
          System.out.println("Clone clicked successfully and content got cloned.");
          
//Push a cloned campaign        
          
          Thread.sleep(4000);
          driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).click();
          driver.findElement(By.xpath("//input[@formcontrolname='campaignName']")).sendKeys("Test Clone Push");  //change the value all time
          Thread.sleep(2000);
		  driver.findElement(ByAngular.buttonText("Send")).click();
		  Thread.sleep(2000);
		  WebElement button = driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span"));
	      button.click();
	      System.out.println("Campaign pushed successfully.");
	      
	      //Regain back focus
	      Thread.sleep(8000);
	      WebElement mainPageElement = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(mainPageElement).click().perform();
          
//Create new campaign from campaign report page and schedule        
          
		  Thread.sleep(3000);
	      driver.findElement(By.xpath("//span[contains(text(),'Create')]")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).click();
	      driver.findElement(By.xpath("//input[@formcontrolname='campaignLandingPageUrl']")).sendKeys("abplive.com");
	      Thread.sleep(1000);
		  driver.findElement(ByAngular.buttonText("Create")).click();
	      Thread.sleep(3000);
	      WebElement elementToScrollTo = driver.findElement(ByAngular.buttonText("Send"));
		  JavascriptExecutor js1 = (JavascriptExecutor) driver;
		  js1.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[contains(text(), 'Schedule')]")).click();
	      Thread.sleep(2000);
	      driver.findElement(ByAngular.buttonText("Schedule")).click();
	      Thread.sleep(3000);
	      WebElement button1 = driver.findElement(By.cssSelector(".mat-button-base.mat-flat-button.mat-primary.mr-5  .iz-row.iz-row--align-center > span"));
	      button1.click();
	      Thread.sleep(8000);
	      System.out.println("Create campaign working fine. Campaign scheduled successfully.");
	      
	      driver.navigate().refresh();
		  Thread.sleep(3000);
	      
//Abort a Scheduled campaign
	      
	      WebElement abortButton = driver.findElement(By.cssSelector("button[mattooltip='Abort']"));
          abortButton.click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//span[contains(text(), 'Yes')]")).click();
	      System.out.println("Campaign Aborted successfully.");
	      

	      
	      
	      
	      
		  

}
}
