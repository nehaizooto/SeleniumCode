package testNgTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.ByAngular;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgTest {

	WebDriver driver;
	
	
	@Test
	public void sendpage() throws InterruptedException {

		//Chrome Driver Open
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(2000);

		//Open panel
		driver.get("https://panel.izooto.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);

	
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
	
		//Open Send Notification page : 

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


	}


}



