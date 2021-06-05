package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	WebDriver driver;
	
		
		private By email = By.name("email");
		private By pass = By.id("password");
		private By signin = By.id("submit");
		private By register = By.id("register");
		
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement password() {
		return driver.findElement(pass);
	}
	
	public WebElement signIn() {
		return driver.findElement(signin);
	}
	
	public WebElement register() {
		return driver.findElement(register);
	}
}
