package QueueCodes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObject.LoginPage;
import resources.Base;

public class LoginPageTest extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void initilize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized!");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String uName, String uPass){
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.email().sendKeys(uName);
		log.info("Enter User Name: "+uName);
		lp.password().sendKeys(uPass);
		log.info("Enter Password: "+uPass);
		lp.signIn().click();
		log.info("Test Pass!");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[][] {
			new Object[] {"qu","123"},
			new Object[] {"queuecodes@gmail.com","1235"},
			new Object[] {"queuue@gamil.com","123456"},
			new Object[] {"",""},
			new Object[] {"queuecodes@gmail.com",""},
			new Object[] {"","123456"},
			new Object[] {"queuecodes@gmail.com","123456"}
		};
		return data;
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
