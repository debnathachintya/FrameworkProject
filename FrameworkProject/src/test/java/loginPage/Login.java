package loginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class Login extends BaseTest {
	public static Logger log = LogManager.getLogger(Login.class.getName());
	
	@Test
	public void validateLogin() throws Exception{
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the given URL");
		threadSleep();
		log.info("Waiting Time Added");
		LoginPage lp = new LoginPage(driver);
		lp.username().sendKeys(prop.getProperty("username"));
		log.info("Username entered");
		lp.password().sendKeys(prop.getProperty("password"));
		log.info("Password entered");
		threadSleep();
		log.info("Waiting Time Added");
		String input = getDateTime();
		getScreenshot(input);
		
		System.out.println("Test Passed");
	}
}