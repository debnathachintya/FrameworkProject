package loginPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import repository.BaseFile;

public class BaseTest extends BaseFile {
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver = maximizeDriver();
		log.info("Driver is maximized");
		driver = implicitWait();
		log.info("ImplicitlyWait Triggered");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser Closed");
		log.info("Test Passed");
		driver = null;
	}
}
