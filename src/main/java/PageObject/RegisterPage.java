package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	WebDriver driver;
	
	private By name = By.id("name");
	private By mobile =By.id("mobile");
	private By email =By.id("email");
	private By pass =By.id("password");
	private By submit =By.cssSelector("[type='submit']");
	private By already =By.className("text-center");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement setName() {
		return driver.findElement(name);
	}
	
	public WebElement setMobile() {
		return driver.findElement(mobile);
	}
	
	public WebElement setEmail() {
		return driver.findElement(email);
	}
	
	public WebElement setPassword() {
		return driver.findElement(pass);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement already() {
		return driver.findElement(already);
	}
}
