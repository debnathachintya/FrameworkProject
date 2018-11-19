package loginPage;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import repository.BaseFile;

public class NavigateURL extends BaseFile {
	public static Logger log = LogManager.getLogger(NavigateURL.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver = maximizeDriver();
		log.info("Driver is maximized");
		driver = implicitWait();
		log.info("ImplicitlyWait Triggered");
	}
	
	@Test
	public void navigateURL() throws Exception {
		driver.get(prop.getProperty("url"));
		log.info("Naviagted to URL");
		threadSleep();
		log.info("Waiting..");
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_login")));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Browser Closed");
		log.info("Test Passed");
		driver = null;
	}
}