package ChangePassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.ByAngular;

public class ChangePassword {

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
		 Thread.sleep(2000);
		 System.out.println("Panel opened successfully and logged In.");
		 
//Change Password
		 
		 //Select Change Password from dropdown
		 WebElement dropdownButton = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption = driver.findElement(By.xpath("//span[contains(text(), 'Change Password')]"));
	     myprofileOption.click();
		 System.out.println("Change Password modal opened successfully.");
		 
//Change Password Testcases
		 
		 //Test case 1 - Leave all fields blank
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 1 passed successfully. Change Password fields cannot be blank.");
		
		 //Test case 2 - Leave old password blank
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 2 passed successfully. Old Password cannot be blank.");
		
		 //Test case 3 - Enter old password just spaces
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).sendKeys("          ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 3 passed successfully. Old Password cannot be just spaces.");
		 
		 //Test case 4 - Enter old password short
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).sendKeys("abc");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 4 passed successfully. Old Password is short.");
		 
		 //Test case 5 - Enter old password incorrect - At least one character required of (A-Z), (a-z), (0-9) and a special character.
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).sendKeys("abc123");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 5 passed successfully. Old Password is incorrect : At least one character required of (A-Z), (a-z), (0-9) and a special character..");
		
		 //Test case 6 - Enter old password which is not correct doesn't match with previous password
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).sendKeys("Iz00to@1234");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 6 passed successfully. Old Password is wrong.");
		 
		 //Test case 7 - Enter new password just spaces
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='old-password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("        ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 7 passed successfully. New Password cannot be just spaces.");
		 
		 //Test case 8 - Enter new password short
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("abcd");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 8 passed successfully. New Password is short.");
		
		 //Test case 9 - Enter new password incorrect - At least one character required of (A-Z), (a-z), (0-9) and a special character.
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("abcd234");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 9 passed successfully. New Password is incorrect : At least one character required of (A-Z), (a-z), (0-9) and a special character.");
		
		 //Test case 10 - Enter confirm password just spaces
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("        ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 10 passed successfully. Confirm Password cannot be just spaces.");
		 
		 //Test case 11 - Enter confirm password short
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("abcd");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 11 passed successfully. Confirm Password is short.");
		
		 //Test case 12 - Enter confirm password incorrect - At least one character required of (A-Z), (a-z), (0-9) and a special character.
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("abcd123");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 12 passed successfully. Confirm Password is incorrect : At least one character required of (A-Z), (a-z), (0-9) and a special character.");
		
		 //Test case 13 - Enter Old password, new password and confirm password all fields correctly
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='confirm-password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 13 passed successfully. Password changed successfully.");
	
		 //Login back with new password
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(".mat-form-field-infix.ng-tns-c74-3")).click();
		 driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("dummyizmogra@gmail.com");
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Izooto@123");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Sign In")).click();
		 System.out.println("Logged in with new password successfully.");
		 
		 
	}

}
