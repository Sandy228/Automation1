package src.test.java.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import report.ExtentManager;

//import report.ExtentManager;

public class TestBase {

	public WebDriver driver=null;
	public ExtentReports report;
	public ExtentTest test;
	public SoftAssert softassert;
	public Properties prop;
	
	
	@BeforeMethod
	public void inIt(ITestResult result) throws IOException {
		
		report=ExtentManager.getExtentManager();
		test  =	report.createTest(result.getMethod().getMethodName().toString().toUpperCase());
		result.setAttribute("SendingtestObj", test);
		
		 softassert= new SoftAssert();
		 
		 prop= new Properties();
			FileInputStream fiput= new FileInputStream("D:\\Sandy Data\\Automation-2021Dell\\MyAutomationProjectPOM_Pracice\\src\\test\\resources\\amazon.properties");
					prop.load(fiput); 	
	}
	
	@AfterMethod
	public void quite() {
		
		report.flush();
		driver.quit();
		
		
	}
	
	
	public void logInfo(String message) {
	
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void logInfoFailure(String message) {//only fail in extent report
		
		
		logInfo(message);
		test.log(Status.FAIL, message);
	}
	
	
	public void softFailure(String message) {// fail in extent report, test ng and continue the test
		logInfo(message);
		logInfoFailure(message); // fail in extent reports
		takeSceenShot();
		softassert.fail(message); // fail in test ng
	}
	
	public void hardFailure(String message) {// fail in extent report, test ng and stop the test
		logInfo(message);
		logInfoFailure(message); // fail in extent reports
		softassert.fail(message); // fail in test ng
		takeSceenShot();
		softassert.assertAll();
	}
	
	
public  WebDriver getBrowser(String browser, String url) throws IOException {
		
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
		
		System.out.println("Openng URL"+url);
		driver.get(url);
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

	
	
	
	public boolean isElementPresent1(String elemetXpath, WebDriver driver ) {
		//Limitation of this is if first element invisible then it wont check another one 
		int size=driver.findElements(By.xpath(elemetXpath)).size();//findElements we are using cause only size work for it.,
		
		if(size==0) {
			logInfo("Size is 0 so element not present");
			return false;
		}
		
		if(driver.findElement(By.xpath(elemetXpath)).isDisplayed()&&driver.findElement(By.xpath(elemetXpath)).isEnabled()) {
			logInfo("Element is visible and enabled");
			return true;
		}
		else {
			logInfo("Element is not visible and enabled");
		return false;
		}
	}
	
	
	
public void getCalendar(String dateTobe,String locator_Prv, String locator_Next,String displayingDateLocator,String daytoBeLocator,String calendarFieldclk_locator) throws ParseException {
		
		//As we have in calendar date mentiond like February 2021 so 
		//tobedate which should be in same format 
		
	
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MMMM-yyyy");
		
		Date Obj_Of_dateToBe=sdf.parse(dateTobe);
		
		
		String dayToBe =new SimpleDateFormat("dd").format(Obj_Of_dateToBe);
		
		
		String MonthToBe =new SimpleDateFormat("MMMM").format(Obj_Of_dateToBe);
		String yearToBe =new SimpleDateFormat("yyyy").format(Obj_Of_dateToBe);
		
		String MonthAndYearTobe=MonthToBe+" "+yearToBe;
		
		System.out.println("MonthAndYearTobe=========="+MonthAndYearTobe);
		
		
		
		
		//Displaying Calendar title Locator 
		driver.findElement(By.xpath(calendarFieldclk_locator)).click();
		
		String displayingDate=driver.findElement(By.xpath(displayingDateLocator)).getText();
		System.out.println("displayingDate==="+displayingDate);
		
			Date currentdate= new Date();
		
		while(!displayingDate.equals(MonthAndYearTobe)) {
			
			
			if(currentdate.compareTo(Obj_Of_dateToBe)==1) {
				
				driver.findElement(By.xpath(locator_Prv)).click();
			}
			else{
				driver.findElement(By.xpath(locator_Next)).click();
				
				
			}
			displayingDate=driver.findElement(By.xpath(displayingDateLocator)).getText();
			String SelectingDate= driver.findElement(By.xpath(displayingDateLocator)).getText();
			System.out.println("SelectingDate===="+SelectingDate);
			
			
			
		}
		
		driver.findElement(By.xpath("//a[text()='12']")).click();
		
		
		
		
	}
	
	
public boolean isElementPresent(String elementXpath) {// only for xpath 
	
	WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
	}catch(Exception e) {
		return false;
	}
	
	return true;
}
	

public void takeSceenShot(){
	// fileName of the screenshot
	Date d=new Date();
	String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	// take screenshot
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		// get the dynamic folder name
		FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
		//put screenshot file in reports
		test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



}
