package QueueCodes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.RegisterPage;
import resources.Base;

public class RegisterUser extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	RegisterPage rp ;
	
	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialize successfully!");
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.register().click();
		rp = new RegisterPage(driver);
	}
	
	@BeforeMethod
	public void cleanData() {
		rp.setName().clear();
		rp.setMobile().clear();
		rp.setEmail().clear();
		rp.setPassword().clear();
	}
	
	@Test(dataProvider="getData")
	public void registerUser(String uName,String uMobile, String uEmail, String uPass){
		
		rp.setName().sendKeys(uName);
		rp.setMobile().sendKeys(uMobile);
		rp.setEmail().sendKeys(uEmail);
		rp.setPassword().sendKeys(uPass);
		rp.submit().click();
		log.info("Test Passed :"+uName+"|"+uMobile+"|"+uEmail+"|"+uPass);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[][] {
			new Object[] {"Sandeep","10203040","sandeep@gmail.com",""},
			new Object[] {"Sandeep","10203040","","11345"},
			new Object[] {"Sandeep","","sandeep@gmail.com","11345"},
			new Object[] {"","10203040","sandeep@gmail.com","11345"},
			new Object[] {"Sandeep","","","11345"},
			new Object[] {"Sandeep","","",""},
			new Object[] {"","10203040","",""},
			new Object[] {"","","sandeep@gmail.com",""},
			new Object[] {"","","sandeep@gmail.com","123456"}
			};
			return data;
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
