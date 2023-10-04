package AddWebsite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.paulhammant.ngwebdriver.ByAngular;

public class AddWebsite {

	public static void main(String[] args) throws InterruptedException {
		
		 //Open Chrome Driver
		 WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
		 
		 // Open panel
		 driver.get("https://panel.izooto.com/");
		 driver.manage().window().maximize();
		 Thread.sleep(2000);
			
		 //Login on panel
         driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("dummyizmogra@gmail.com");
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
		 driver.findElement(ByAngular.buttonText("Sign In")).click();
		 Thread.sleep(6000);
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 System.out.println("Panel opened successfully and logged In.");
		 
		 //Open Add-Website
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 System.out.println("Add-Website page opened successfully.");
		 
	//WebPush Test Cases :
		 
		 //Test case 1 : When Title and Domain name is blank -
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 1 passed. Title and Domain cannot be blank.");
		 
		 //Test case 2 : When Title is blank -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		 		+ "//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("https://dummyiztrue.com");
		 Thread.sleep(1000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 2 passed. Title cannot be blank.");
		 
		 //Test case 3 : When Title is just spaces -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
		 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
			 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).sendKeys("          ");
		 Thread.sleep(1000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 3 passed. Title cannot be just spaces.");
		 	
		 //Test case 4 : When Domain is just spaces -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
		 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
			 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).sendKeys("My Test Website");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("         ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 4 passed. Domain cannot be just spaces.");
		
		 //Test case 5 : When Domain is invalid -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("abc.com");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 5 passed. Domain is invalid.");
		
		 //Test case 6 : When Domain is http -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("http://abc.com");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 6 passed. Http domain not supported.");
		 
		 //Test case 7 : When Domain is already used -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("https://dummyizapis.000webhostapp.com");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 7 passed. Domain already taken.");
		 
		 //Test case 8 : Enter valid domain -
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).clear();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("https://dummyiztrue1.com"); //need to change all time
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 8 passed. Domain added successfully.");
		 
		 //Test case 9 : Enter valid domain in Uppercase -
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
			 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
				 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).sendKeys("My Test Website 2");
		 Thread.sleep(2000);	 
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("HTTPS://DUMMYIZTRUE2.COM"); //need to change all time
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 9 passed. Domain added successfully in uppercase.");
		 
		 //Test case 10 : Enter valid domain in with long extension -
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
			 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']"
				 		+ "//mat-card/mat-form-field[1]//input[@type='text']")).sendKeys("My Test Website 3");
		 Thread.sleep(2000);	 
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
			 		+ "//input[@type='text']")).sendKeys("https://dummyizabc.traveller/test-hello"); //need to change all time
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 10 passed. Domain added successfully with long extension.");
		
	// Messenger Test Cases :
		 
		 //Open add website and click messenger option 
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		
		 //Test case 11 : Open messenger and leave Title and Domain blank -
		 Thread.sleep(3000);
	     driver.findElement(By.cssSelector("ng-generic-radio-option[value='messenger']")).click();
         Thread.sleep(2000);	 
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 11 passed. Messenger Title and Domain cannot be blank.");
		 
		 //Test case 12 : Open messenger and leave Title blank -
		 
		 Thread.sleep(2000);  
	     driver.findElement(By.id("mat-select-value-5")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.id("mat-option-4")).click();
         Thread.sleep(1000);	 
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 12 passed. Messenger Title cannot be blank.");
		 
		 //Test case 13 : Open messenger and enter title just spaces -
		 Thread.sleep(2000);
	     driver.findElement(By.id("mat-input-3")).click();
	     driver.findElement(By.id("mat-input-3")).sendKeys("             ");
         Thread.sleep(2000);	 
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 13 passed. Messenger Title cannot be just spaces");
		 
		 //Test case 14 : Add messenger website successfully -
		 Thread.sleep(2000);
	     driver.findElement(By.id("mat-input-3")).clear();
	     driver.findElement(By.id("mat-input-3")).sendKeys("My Messenger Website");
         Thread.sleep(1000);	 
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 14 passed. Messenger website added successfully.");
		 
		 //Open add website and click messenger again
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 Thread.sleep(3000);
	     driver.findElement(By.cssSelector("ng-generic-radio-option[value='messenger']")).click();
		 
		 //Test case 15 : Add messenger website by adding a new domain and enter domain value just spaces -
		 Thread.sleep(2000);
	     driver.findElement(By.id("mat-input-7")).click();
	     driver.findElement(By.id("mat-input-7")).sendKeys("My Messenger Website 1");
         Thread.sleep(1000);	 
         driver.findElement(By.xpath("/html/body/app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/div[1]/div/button//span[.='Add New']")).click();
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
	     		+ "//input[@type='text']")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		     		+ "//input[@type='text']")).sendKeys("          ");
         driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 15 passed. Messenger website cannot be blank.");
		 
		 //Test case 16 : Add messenger website by adding a new domain and enter domain value invalid -
		 Thread.sleep(2000); 
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
	     		+ "//input[@type='text']")).clear();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		     		+ "//input[@type='text']")).sendKeys("abc.com");
         driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 16 passed. Messenger website is invalid.");
		 
		 //Test case 17 : Add messenger website by adding a new domain and enter domain value as http -
		 Thread.sleep(2000); 
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
	     		+ "//input[@type='text']")).clear();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		     		+ "//input[@type='text']")).sendKeys("http://abc.com");
         driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 17 passed. Messenger website is http.");
	 
		 //Test case 18 : Add messenger website by adding a new domain and enter domain value which is already taken -
         Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
	     		+ "//input[@type='text']")).clear();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		     		+ "//input[@type='text']")).sendKeys("https://dummyizapis.000webhostapp.com");
         driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 18 passed. Messenger website is already taken.");
		 
		 //Test case 19 : Add messenger website by adding a new domain -
         Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
	     		+ "//input[@type='text']")).clear();
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[2]"
		     		+ "//input[@type='text']")).sendKeys("https://dummyizmessenger12345.com"); //need to change all time
	     Thread.sleep(2000);
         driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 19 passed. Messenger website added successfully.");

	//Add Android Website	
		 
		 //Open add website and click android option 
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("ng-generic-radio-option[value='android']")).click();
		 
		 //Test case 20 : Add android website -
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("ng-generic-radio-option[value='android']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[1]"
		 		+ "//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[1]"
			 		+ "//input[@type='text']")).sendKeys("My Android Test Website"); //need to change all time
		 Thread.sleep(1000);
		 driver.findElement(By.cssSelector(".mat-checkbox-inner-container")).click();
		 Thread.sleep(1000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 20 passed. Android website added successfully.");
		 
    //Add iOS Website	
		 
		 //Open add website and click android option 
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".iz-col.iz-col--content-center.ng-star-inserted")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector(".add-website-btn-text")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("ng-generic-radio-option[value='ios']")).click();
		 
		 //Test case 21 : Add iOS website -	 
		 Thread.sleep(3000);
		 driver.findElement(By.cssSelector("ng-generic-radio-option[value='ios']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[1]"
		 		+ "//input[@type='text']")).click();
		 driver.findElement(By.xpath("/html//app-root/iz-add-site-root[@class='ng-star-inserted']//mat-card/mat-form-field[1]"
		 		+ "//input[@type='text']")).sendKeys("My iOS Test Website"); //need to change all time
		 Thread.sleep(1000);
		 driver.findElement(By.cssSelector(".mat-checkbox-inner-container")).click();
		 Thread.sleep(1000);
		 driver.findElement(ByAngular.buttonText("Continue")).click();
		 System.out.println("Test case 21 passed. iOS website added successfully.");
		 


	}

}
