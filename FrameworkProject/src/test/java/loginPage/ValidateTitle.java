package loginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ValidateTitle extends BaseTest {
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@Test
	public void navigateURL() throws Exception {
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to URL");
		threadSleep();
		String input = getDateTime();
		getScreenshot(input);
		
		String pageTitle = driver.getTitle();
		log.info("Page title captured and stored in string");
		if(pageTitle.equals("LoginPage")) {
			log.info("Expected Title");
		}
		else {
			System.out.println("Page Title is not displayed as expected");
			log.info("Not an Expected Title");
		}
		
		System.out.println("Test Passed");
	}
}