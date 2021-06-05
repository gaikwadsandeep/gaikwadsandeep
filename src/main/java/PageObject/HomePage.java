package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;

	private By title = By.cssSelector("span.logo-lg");
	private By user = By.cssSelector("[href*='users.html']");
	private By dlt = By.cssSelector(".label.label-danger");
	private By dlt1 = By.cssSelector("label.label-danger.ss");
	private By dlt2 = By.xpath("//tr[5]/td[8]/a");
	private By scenario = By.cssSelector("[href*='scenario.html']");
	private By drag = By.cssSelector("#drag1");
	private By drop = By.cssSelector("#div1");
	private By clickMe = By.cssSelector(".btn.btn-primary.btn-block.btn-flat");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String validateTitle() {
		return driver.getTitle();
	}

	public String validateText() {
		return driver.findElement(title).getText();
	}

	public WebElement userDashboard() {
		return driver.findElement(user);
	}
	
	public WebElement userDeleteFirst() {
		return driver.findElement(dlt);
	}
	
	public WebElement userDeleteSecond() {
		return driver.findElement(dlt1);
	}
	
	public WebElement userDeleteThird() {
		return driver.findElement(dlt2);
	}
	
	public WebElement scenarioDashboard() {
		return driver.findElement(scenario);
	}
	
	public WebElement drag() {
		return driver.findElement(drag);
	}
	
	public WebElement drop() {
		return driver.findElement(drop);
	}
	
	public WebElement clickMe() {
		return driver.findElement(clickMe);
	}
}
