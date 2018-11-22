package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestFile {
	public static WebDriver driver;
	
	
	public static void main(String[] args) throws IOException {
		TestFile tf = new TestFile();
		//String input = tf.newDate();
		tf.ExcelUtils();
	}
	
	public String newDate() throws IOException {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return df.format(d);	
	}
	
	public void getScreenshot(String newFile) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:/Selenium/hello.png"));
	}
	
	public void takesScreenshot(String newFile) throws IOException {
		System.out.println(newFile);
	}
	
	public void ExcelUtils() throws IOException {
		FileInputStream fs = new FileInputStream("./data/DataInputFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(1);
		System.out.println(cell.getStringCellValue());
	}
}