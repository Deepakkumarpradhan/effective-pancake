package testsAP;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
 
	public WebDriver driver;
	
	@BeforeTest
	public void initialize(){
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	String url= "https://www.anandprakash.com";
	driver.navigate().to(url);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void CleanJob(){
		System.out.println("Current Url: "+driver.getCurrentUrl());
		//driver.quit();
	}

}
