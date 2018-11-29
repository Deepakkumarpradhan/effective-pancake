package testsAP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectsAP.RepositoryAP;;
public class LoginTC extends TestBase{
	
	@Test
	public void login(){
		String emailId="dpradhank@gmail.com";
		String pw= "12345678";
		RepositoryAP reposit= PageFactory.initElements(driver, RepositoryAP.class);
		reposit.login.click();
		reposit.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		reposit.eMail.sendKeys(emailId);
		reposit.passWord.sendKeys(pw);
		reposit.loginButton.click();
		
		
		
	}

}
