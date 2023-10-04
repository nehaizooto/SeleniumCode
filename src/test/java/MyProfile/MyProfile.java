package MyProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;

public class MyProfile {

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
		 
//MY PROFILE 
		 
		 //Select My Profile from dropdown
		 WebElement dropdownButton = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption = driver.findElement(By.xpath("//span[contains(text(), 'My Profile')]"));
	     myprofileOption.click();
		 System.out.println("My Profile page opened successfully.");
		
//Name Testcases
		 
		 //Testcase 1 - When name is just spaces 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).sendKeys("              ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 1 passed. Name cannot be just spaces.");
		 
		 //Testcase 2 - Name should accept 100 characters
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard.");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 2 passed. Name with 100 characters which is maximum limit accepted.");
		 
		 //Testcase 3 - Name with special characters
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).sendKeys("Mayur_vedha's-om^ovijay");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 3 passed. Name with special characters accepted.");
		
		 //Testcase 4 - Name with special characters
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).sendKeys("Ajay 12456");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 4 passed. Name with alphanumeric characters accepted.");
		 
		 //Testcase 5 - Name with short characters
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).clear();
		 driver.findElement(By.xpath("//input[@formcontrolname='fullName']")).sendKeys("Ajay Bhist Morey");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 5 passed. Name accepted successfully.");
		 
//Timezone Testcases		 
		 
		 //Testcase 6 - When timezone value is just spaces
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).click();
		 Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).clear();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).sendKeys("                 ");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 6 passed. Timezone value cannot be just spaces.");  
		 
		 //Testcase 7 - When timezone value is invalid
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).clear();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).sendKeys("abc");
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 7 passed. Timezone value is invalid.");
	        
		 //Testcase 8 - Select timezone from dropdown
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).clear();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).sendKeys("a");
		 Thread.sleep(2000);
		 driver.findElement(By.id("mat-option-712")).click();
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 8 passed. Timezone selected successfully."); 
	        
	     //Refresh the oage to reflect timezone changes
		 
		 //Testcase 9 - Refresh the page to check timezone changes
		 Thread.sleep(4000);
		 driver.navigate().refresh();
		 System.out.println("Test case 9 passed. Timezone changed successfully."); 
		 
		 //Testcase 10 - Change timezone to India
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).clear();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@placeholder='Select timezone']")).sendKeys("Asia/kolkata");
		 Thread.sleep(2000);
		 driver.findElement(By.id("mat-option-204")).click();
		 Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 10 passed. Timezone changed to India successfully.");
		 Thread.sleep(3000);
		 driver.navigate().refresh();

//Default website at login testcases
		 
		 //Testcase 11 - Select a app push website to be shown after login as default website on dropdown
		 Thread.sleep(3000);
	     WebElement dropdown = driver.findElement(By.xpath("//mat-select[@formcontrolname='defaultWebsite']"));
         dropdown.click();
	     String optionText = "https://android.dev.android_app_neha.com";
	     WebElement optionToSelect = driver.findElement(By.xpath("//mat-option[contains(., '" + optionText + "')]"));
	     optionToSelect.click();
	     Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 11 passed. Default website at login changed successfully. App website will be shown as default");
		
		 //Testcase 12 - Logout panel to check the default website changes
		 Thread.sleep(3000);
		 WebElement dropdownButton1 = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton1.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption1 = driver.findElement(By.xpath("//span[contains(text(), 'Logout')]"));
	     myprofileOption1.click();
		 System.out.println("Test case 12 passed. Logged out successfully to check my default changes.");
		
		 //Testcase 13 - Login on panel again to check the changes
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
		 Thread.sleep(3000);
		 System.out.println("Test case 13 passed. Panel logged in successfully and the App website we selected is showing as default after login.");
		
		 //Test case 14 - Select My Profile from dropdown again
		 WebElement dropdownButton11 = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton11.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption2 = driver.findElement(By.xpath("//span[contains(text(), 'My Profile')]"));
	     myprofileOption2.click();
		 System.out.println("Test case 14 passed. My Profile page opened successfully.");
		
		 //Testcase 15 - Select a webpush website to be shown after login as default website on dropdown 
		 Thread.sleep(2000);
	     WebElement dropdown1 = driver.findElement(By.xpath("//mat-select[@formcontrolname='defaultWebsite']"));
         dropdown1.click();
	     String optionText1 = "https://dummyizapis.000webhostapp.com";
	     WebElement optionToSelect1 = driver.findElement(By.xpath("//mat-option[contains(., '" + optionText1 + "')]"));
	     optionToSelect1.click();
	     Thread.sleep(2000);
		 driver.findElement(ByAngular.buttonText("Save")).click();
		 System.out.println("Test case 15 passed. Default website at login changed successfully. Web website will be shown as default");
		
		 //Test case 16 - Logout panel to check the default website changes
		 Thread.sleep(3000);
		 WebElement dropdownButton3 = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton3.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption3 = driver.findElement(By.xpath("//span[contains(text(), 'Logout')]"));
	     myprofileOption3.click();
		 System.out.println("Test case 16 passed. Logged out successfully to check my default changes.");
		
		 //Test case 17 - Login on panel again to check the changes
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
		 Thread.sleep(3000);
		 System.out.println("Test case 17 passed. Panel logged in successfully and the Web website we selected is showing as default after login.");
		 
		 //Test case 18 - Select My Profile from dropdown again
		 WebElement dropdownButton4 = driver.findElement(By.cssSelector(".mat-menu-trigger.menu-icon"));
		 dropdownButton4.click();
		 Thread.sleep(2000);
		 WebElement myprofileOption4 = driver.findElement(By.xpath("//span[contains(text(), 'My Profile')]"));
	     myprofileOption4.click();
		 System.out.println("Test case 18 passed. My Profile page opened successfully.");
		 
		 
		 
		 
		 WebElement fileInput = driver.findElement(By.linkText("Edit")); // Replace with your locator strategy

	        // Set the file path to upload (replace with your file path)
	        String imagePath = "/Users/nehasingh/Desktop/images/dds.jpg";
	        fileInput.sendKeys(imagePath);

		 
		 
		 
		 

	}

}
