package loginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class NavigateURL extends BaseTest {
	public static Logger log = LogManager.getLogger(NavigateURL.class.getName());
	
	@Test
	public void navigateURL() throws Exception {
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to URL");
		threadSleep();
		log.info("Waiting Time Added");
		String input = getDateTime();
		getScreenshot(input);
		log.info("Screenshot Captured");
		
		System.out.println("Test Passed");
	}
}