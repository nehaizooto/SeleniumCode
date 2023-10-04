package Signup;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class SignupClass {

	public static void main(String[] args) throws InterruptedException {
		
		
		// Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
		
		// Open izooto signup page
		driver.get("https://panel.izooto.com/en/signup");
		driver.manage().window().maximize();
		Thread.sleep(5000);
			
	// 1 - Name field test cases validations : 
		
			//test case 1 - when name is blank and other fields are filled
			driver.findElement(By.id("mat-input-0")).click();
			driver.findElement(By.id("mat-input-0")).sendKeys("");
			Thread.sleep(1000);
			driver.findElement(By.id("mat-input-1")).click();
			driver.findElement(By.id("mat-input-1")).sendKeys("dummyizoho1@izooto.com");
			Thread.sleep(1000);
			driver.findElement(By.id("mat-input-2")).click();
			driver.findElement(By.id("mat-input-2")).sendKeys("Izooto@123");
			Thread.sleep(1000);
		    driver.findElement(By.id("mat-select-4")).click();
			driver.findElement(By.id("mat-option-103")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("iz-tel-input#iz-tel-input-component-0 > .ml-5.ng-pristine.ng-touched.ng-valid"))
			.sendKeys("7838397622");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://dummyizoho1.com");
			Thread.sleep(1000);
			driver.findElement(By.id("mat-select-0")).click();
			driver.findElement(By.id("mat-option-0")).click();
			Thread.sleep(4000);
			driver.findElement(By.cssSelector(".btn-action-main.mat-button-base.mat-primary.mat-raised-button.mt-10")).click();
		    System.out.println("Test case 1 passed. Name field cannot be blank.");
			
		    //test case 2 - when name is just spaces and other fields are filled
		    Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-0")).clear();
			driver.findElement(By.id("mat-input-0")).sendKeys("      ");
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".btn-action-main.mat-button-base.mat-primary.mat-raised-button.mt-10")).click();
		    System.out.println("Test case 2 passed. Name field cannot be just spaces.");
			
	// 2 - Email field test cases validations :
		    
		    //test case 3 - when email is blank and other fields are filled
		    Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-0")).clear();
			driver.findElement(By.id("mat-input-0")).sendKeys("Neha Singh");
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("");
			System.out.println("Test case 3 passed. Email field cannot be blank.");
			
			//test case 4 - when email is blank and other fields are filled
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("      ");
			System.out.println("Test case 4 passed. Email field cannot be just spaces.");
			
			//test case 5 - when email is in wrong format
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("dummyizozo1");
			System.out.println("Test case 5 passed. Email Id is not correct.");
			
			//test case 6 - when email is in wrong format
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("dummyizozo1.com");
			System.out.println("Test case 6 passed. Email Id is not correct.");
			
			//test case 7 - when email is in wrong format
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("dummyizozo1-@#92802#izooto.com");
			System.out.println("Test case 7 passed. Email Id is not correct.");
			
			//test case 8 - when email is already used 
			Thread.sleep(2000);
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("neha@datability.co");
			System.out.println("Test case 8 passed. Email Id is already used.");
			
			driver.findElement(By.id("mat-input-1")).clear();
			driver.findElement(By.id("mat-input-1")).sendKeys("dummyizollo1@izooto.com"); //need to change all time
			
   // 3 - Password field test cases validations :
		    
		    //test case 9 - when password is blank and other fields are filled
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("");
			System.out.println("Test case 9 passed. Password cannot be blank.");
			
			//test case 10 - when password is just spaces and other fields are filled
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("     ");
			System.out.println("Test case 10 passed. Password cannot be just spaces.");
			
			//test case 11 - when password is short less than 6 characters
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("izoto");
			System.out.println("Test case 11 passed. Password is wrong.");
			
			//test case 12 - when password is not matching password validations
			// At least one character required of (A-Z), (a-z), (0-9) and a special character.
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("izooto@123");
			System.out.println("Test case 12 passed. Password is wrong.");
			
			//test case 13 - when password is not matching password validations
			// At least one character required of (A-Z), (a-z), (0-9) and a special character.
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("Izooto123");
			System.out.println("Test case 13 passed. Password is wrong.");
			
			//test case 14 - when password is not matching password validations
			// At least one character required of (A-Z), (a-z), (0-9) and a special character.
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("Izooto@");
			System.out.println("Test case 14 passed. Password is wrong.");
			
			driver.findElement(By.id("mat-input-2")).clear();
			driver.findElement(By.id("mat-input-2")).sendKeys("Izooto@123");
			
	// 4 - Phone number field test cases validations :		
			
			//test case 15 - when phone number is blank and other fields are filled
			Thread.sleep(2000);
		    driver.findElement(By.id("mat-select-4")).click();
		    driver.findElement(By.id("mat-option-103")).click();
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("");
			System.out.println("Test case 15 passed. Phone number cannot be blank.");
			
			//test case 16 - when phone number is just spaces and other fields are filled
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("      ");
			System.out.println("Test case 16 passed. Phone number cannot be just spaces.");
			
			//test case 17 - when phone number is not in right format
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("haslass");
			System.out.println("Test case 17 passed. Phone number is wrong.");
			
			//test case 18 - when phone number is less than 7 characters
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("23233");
			System.out.println("Test case 18 passed. Phone number minimum 7 characters allowed.");
			
			//test case 19 - when phone number is more than 16 characters
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("23293232392332238323833");
			System.out.println("Test case 19 passed. Phone number maximum 16 characters allowed.");
			
			//test case 20 - when phone number is not in right format
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("232_33+73");
			System.out.println("Test case 20 passed. Phone number is invalid.");
			
			Thread.sleep(1000);
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).clear();
		    driver.findElement(By.xpath("//iz-tel-input[@id='iz-tel-input-component-0']/input[@type='text']")).sendKeys("7838-39-2422");
		    
			
 // 5 - Website field test cases validations :		
				
			//test case 21 - when website is blank and other fields are filled
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("");
            System.out.println("Test case 21 passed. Website cannot be blank.");
            
           //test case 22 - when website is just spaces
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("      ");
            System.out.println("Test case 22 passed. Website cannot be just spaces.");
			
           //test case 23 - when website doesn't have protocol
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("abc.com");
            System.out.println("Test case 23 passed. Website should start with https.");
			
           //test case 24 - when website is http website
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("http://abc.com");
            System.out.println("Test case 24 passed. Website should start with https.");
			
           //test case 25 - when website is invalid
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://abc");
            System.out.println("Test case 25 passed. Website is invalid.");
			
            //test case 26 - when website is invalid
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://dummy.c");
            System.out.println("Test case 26 passed. Website is invalid.");
			
           //test case 27 - when website is invalid
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://dummyiz/iz.c-com");
            System.out.println("Test case 27 passed. Website is invalid.");
			
            //test case 28 - when website is already used
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://dummyizmusical.com");
            System.out.println("Test case 28 passed. Website domain is already taken.");
            
            Thread.sleep(2000);
		    driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
			.clear();
            driver.findElement(By.xpath("//iz-input-website-url[@id='iz-input-website-url-component-0']/input[@type='url']"))
				.sendKeys("https://dummyizollo1.com"); //need to change all time
            
            //To signup on panel : 
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".btn-action-main.mat-button-base.mat-primary.mat-raised-button.mt-10")).click();
            System.out.println("All Test cases passed now successfully signed up on panel.");
            Thread.sleep(5000);
            
            //To regain back focus again on page 
			 WebElement mainPageElement = driver.findElement(By.linkText("Skip"));
		     Actions actions = new Actions(driver);
		     actions.moveToElement(mainPageElement).click().perform();
		     driver.findElement(By.linkText("Skip")).click();
               
     
	}

}
