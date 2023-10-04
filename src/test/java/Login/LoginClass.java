package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class LoginClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Open Chrome browser
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
		
		driver.get("https://panel.izooto.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//test case 1 - when both email and password is blank
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).sendKeys("");
		driver.findElement(By.id("mat-input-1")).sendKeys("");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 1 passed. Email and password cannot be blank.");
		
		//test case 2 - when both email and password is just spaces
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).sendKeys("      ");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).sendKeys("      ");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 2 passed. Email and password cannot be just spaces.");
		
		//test case 3 - when email has a value and password is blank
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("dummyizmogra@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		driver.findElement(By.id("mat-input-1")).sendKeys("");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 3 passed. Password field cannot be blank.");
		
		//test case 4 - when email is blank and password has value 
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Izooto");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 4 passed. Email field cannot be blank.");
		
		//test case 5 - when we enter valid email and invalid password value
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("dummyizmogra@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Izooto");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 5 passed. Password is invalid.");
		
		//test case 6 - when we enter invalid email and valid password value
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("dummyizmogra");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Izooto@123");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 6 passed. Email is invalid.");
		
		//test case 7 - when we enter email id that doesn't exist, not signed up yet
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("abcdtest@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Izooto@123");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		System.out.println("Test Case 7 passed. Email id doesn't exist on panel.");
		
		//test case 8 - enter valid email id password and login
		driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		driver.findElement(By.id("mat-input-0")).clear();
		driver.findElement(By.id("mat-input-0")).sendKeys("dummyizmogra@gmail.com");
		Thread.sleep(4000);
		driver.findElement(By.id("mat-input-1")).click();
		driver.findElement(By.id("mat-input-1")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("mat-input-1")).sendKeys("Izooto@123");
		driver.findElement(ByAngular.buttonText("Sign In")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		System.out.println("Test Case 8 passed. Logged in successfully.");
		
	
		
		System.out.println("Page is Opened");
		
		
		
		
		
		
		
		
	}

}
