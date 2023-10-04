package loginiframe;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.logging.log4j.Logger;



import com.paulhammant.ngwebdriver.ByAngular;

public class LoginIframeClass {

	public static void main(String[] args) throws InterruptedException {
		
		
		final Logger log = LogManager.getLogger("LoginIframeClass");
		log.info("file: {}",LoginIframeClass.class.getTypeName());
		
		
//		final Logger log = LogManager.getLogger(LoginIframeClass.class)
//		Logger log = LoggerFactory.getLogger(LoginIframeClass.class);
       

		WebDriver driver = new ChromeDriver();
		 System.setProperty("webdriver.chrome.driver",
					"/Users/nehasingh/Documents/chromedriver-mac-x64/chromedriver");
			
			
			//Open panel
			 driver.get("https://panel.izooto.com/");
			 driver.manage().window().maximize();
			 Thread.sleep(2000);
				
			 log.info("maximize");
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
			 
			 log.debug("for debug");
			 log.error("for error ");
			log.info("hello");
			 System.out.println("Panel opened successfully and logged In.");
		
	//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
		
	}

}
