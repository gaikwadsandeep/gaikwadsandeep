package QueueCodes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.HomePage;
import resources.Base;

public class Users extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	
	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver initialize successfully!");
		loginValidation();
	}
	
	@Test
	public void usersInHome() {
		HomePage hp= new HomePage(driver);
		hp.userDashboard().click();
		hp.userDeleteFirst().click();
		driver.switchTo().alert().accept();
		hp.userDeleteThird().click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		log.info("User delete Successfully");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
