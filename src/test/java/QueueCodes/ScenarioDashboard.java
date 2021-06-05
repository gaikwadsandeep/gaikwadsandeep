package QueueCodes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObject.HomePage;
import jdk.internal.org.jline.utils.Log;
import resources.Base;

public class ScenarioDashboard extends Base{
	private static Logger log = LogManager.getLogger(Base.class.getName());
	WebDriver driver;
	HomePage hp ;
	WebDriverWait wait;
	
	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialize successfully!");
		loginValidation();
	}
	
	@Test
	public void Scenario() {
		hp = new HomePage(driver);
		hp.scenarioDashboard().click();
		Actions a = new Actions(driver);
		WebElement drap = hp.drag();
		WebElement drop = hp.drop();
		Action action = a.dragAndDrop(drap, drop).build();
		action.perform();
		log.info("Drag and Drop perform Successfully");
	}
	
	@Test
	public void clickMe() {
		hp = new HomePage(driver);
		wait = new WebDriverWait(driver,5);
		hp.scenarioDashboard().click();
		hp.clickMe().click();
		boolean display = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Technology']"))).isDisplayed();
		 Assert.assertTrue(display);
		 log.info("Word Found Successfully!");
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
