package QueueCodes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;

import resources.Base;

public class HPTitleValidaton extends Base {
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	WebDriver driver;
	
	@BeforeClass
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver Initialized!");
		loginValidation();
		log.info("Login successfully Done!");
	}
	
	@Test
	public void titleValidation() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.validateTitle(),"Queue Codes | Dashboard");	
		log.info("Title Validated: "+hp.validateTitle());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
