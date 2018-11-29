package testsAP;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjectsAP.RepositoryAP;

public class TC1 extends TestBase{
	//Class TC1 get the products list on the front end of desired category
	@Test
	public void init()throws Exception{
		 
		RepositoryAP reposit= PageFactory.initElements(driver, RepositoryAP.class);
		reposit.moveMouse();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		reposit.lacquered.click();
		//reposit.hardBound.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		reposit.pageDown();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		reposit.listValues();
		
	}

}
