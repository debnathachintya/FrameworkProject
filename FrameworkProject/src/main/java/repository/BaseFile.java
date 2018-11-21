package repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseFile {
	public static WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(BaseFile.class.getName());

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fs = new FileInputStream("./data/data.properties");
		prop.load(fs);

		log.info("Properties File Loaded");

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			log.info("Chrome Browser Initialized");
		} else {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckoDriverPath"));
			driver = new FirefoxDriver();
			log.info("Firefox Browser Initialized");
		}

		return driver;
	}

	public WebDriver maximizeDriver() {
		driver.manage().window().maximize();
		log.info("Browser Window Maximized");
		return driver;
	}

	public WebDriver implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Waiting Time Added");
		return driver;
	}

	public void threadSleep() throws InterruptedException {
		Thread.sleep(3000);
		log.info("Sleep Time Added");
	}

	public void getScreenshot(String timeStamp) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./screenshots/"+timeStamp+".png"));
		log.info("Screenshot Taken");
	}

	public String getDateTime() throws IOException {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
		log.info("Current Date/Time Captured");

		return df.format(d);
	}
}