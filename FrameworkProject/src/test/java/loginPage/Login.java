package loginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import repository.BaseFile;
import pageObjects.LoginPage;

public class Login extends BaseFile {
	public static Logger log = LogManager.getLogger(Login.class.getName());
	
	@BeforeTest
	public void initialize() throws Exception {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver = maximizeDriver();
		log.info("Browser is maximized");
		driver = implicitWait();
		log.info("ImplicitlyWait Triggered");
	}
	
	@Test
	public void validateLogin() throws Exception{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the given URL");
		threadSleep();
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys(prop.getProperty("username"));
		log.info("Username entered");
		lp.password().sendKeys(prop.getProperty("password"));
		log.info("Password entered");
		threadSleep();
	}
	@AfterTest
	public void teardown() throws Exception {
		driver.close();
		log.info("Browser closed");
		driver = null;
		log.info("Driver object refreshed");
	}
}