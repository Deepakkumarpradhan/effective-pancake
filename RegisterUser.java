package testsAP;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectsAP.RepositoryAP;

@Test
public class RegisterUser extends TestBase{
	public void registerNew(){
	
		RepositoryAP reposit= PageFactory.initElements(driver, RepositoryAP.class);
		reposit.login.click();
		reposit.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		reposit.createAccountButton.click();
		reposit.firstName.sendKeys("Deepak");
		reposit.lastName.sendKeys("Kumar");
		reposit.fillEmail.sendKeys("dpradhank@gmail.com");
		reposit.fillPassword.sendKeys("12345678");
		reposit.confirmPW.sendKeys("12345678");
		reposit.pagedownCaptcha();
		reposit.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		reposit.captchFill.sendKeys(captchaVal);
		reposit.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		reposit.registerUserButton.click();
	
	
	}
}
