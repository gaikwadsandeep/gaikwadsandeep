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
import org.testng.annotations.Test;

import PageObject.HomePage;
import resources.Base;

public class HPTextValidation extends Base{
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
	public void textValidation() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.validateText(), "QueueCodes123");
		log.info("Test validated!: "+hp.validateText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
