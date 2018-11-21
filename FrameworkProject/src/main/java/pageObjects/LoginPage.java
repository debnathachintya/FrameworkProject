package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	By username = By.xpath("//input[@id='user_name']");
	By password = By.xpath("//input[@id='pass_word']");
	By submit = By.xpath("//input[@id='btn_login']");
	By reset = By.xpath("//input[@name='Reset']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement username() {
		return driver.findElement(username);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public WebElement reset() {
		return driver.findElement(reset);
	}
}