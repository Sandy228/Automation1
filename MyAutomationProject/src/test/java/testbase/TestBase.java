package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import report.ExtentManager;

public class TestBase {

	public WebDriver driver=null;
	public ExtentReports report;
	public ExtentTest test;
	public SoftAssert softassert;
	
	
	@BeforeMethod
	public void inIt(ITestResult result) {
		
		report=ExtentManager.getExtentManager();
		test  =	report.createTest(result.getMethod().getMethodName().toString().toUpperCase());
		result.setAttribute("SendingtestObj", test);
		
		 softassert= new SoftAssert();
	}
	
	@AfterMethod
	public void quite() {
		
		report.flush();
		
		
	}
	
	
	public void log(String message) {
	
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void logFailure(String message) {//only fail in extent report
		
		System.out.println(message);
		test.log(Status.FAIL, message);
	}
	
	
	public void softFailure(String message) {// fail in extent report, test ng and continue the test
		logFailure(message); // fail in extent reports
		softassert.fail(message); // fail in test ng
	}
	
	public void hardFailure(String message) {// fail in extent report, test ng and stop the test
		
		logFailure(message); // fail in extent reports
		softassert.fail(message); // fail in test ng
		softassert.assertAll();
	}
	
	
	public WebDriver browsers(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\Sandy Data\\Browser_s EXE\\ChromeDriver\\chromversion_90\\chromedriver.exe");
			driver = new ChromeDriver();
			

		} else if (browser.equalsIgnoreCase("Mozilla")) {

			System.setProperty("webdriver.gecko.driver",
					"D:\\Sandy Data\\Browser_s EXE\\FireFox GecoDriver\\64bit\\geckodriver.exe");

			driver = new FirefoxDriver();
			

		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\Sandy Data\\Browser_s EXE\\InternetExplorer Driver\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	
	
	
	
	@SuppressWarnings("resource")
	public HashMap<String, String> ReadExcelFile(String filePath, String fileName, String sheetName, int set)
			throws IOException {
		File excelFile = new File(filePath + "\\" + fileName);
		FileInputStream excelInputStream = new FileInputStream(excelFile);
		Workbook excelWorkbook = null;
		// Assuming XLSX here. If XLS use HSSFWorkbook
		excelWorkbook = new XSSFWorkbook(excelInputStream);
		// Read the sheet inside the excel workbook
		Sheet excelSheet = excelWorkbook.getSheet(sheetName);
		Row excelRow = excelSheet.getRow(0);
		Row excelSet = excelSheet.getRow(set);
		HashMap<String, String> test = new HashMap<String, String>();
		// Now we need to read all the cell (column) values in each row
		for (int j = 0; j < excelRow.getLastCellNum(); j++) {
			// Output value to the console for now
			String key = excelRow.getCell(j).getStringCellValue();
			String value = excelSet.getCell(j).getStringCellValue();
			test.put(key, value);
		}
		excelInputStream.close();
		return test;
	}

	
	
	
	public boolean isElementPresent(String elemetXpath, WebDriver driver ) {
		//Limitation of this is if first element invisible then it wont check another one 
		int size=driver.findElements(By.xpath(elemetXpath)).size();//findElements we are using cause only size work for it.,
		
		if(size==0) {
			log("Size is 0 so element not present");
			return false;
		}
		
		if(driver.findElement(By.xpath(elemetXpath)).isDisplayed()&&driver.findElement(By.xpath(elemetXpath)).isEnabled()) {
			log("Element is visible and enabled");
			return true;
		}
		else {
			log("Element is not visible and enabled");
		return false;
		}
	}
	
	
	
	
	
	
	
	
}
