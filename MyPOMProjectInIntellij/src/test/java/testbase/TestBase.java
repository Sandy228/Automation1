package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.microsoft.azure.storage.file.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.extentreports.ExtentReportManager;


public class TestBase {

	public WebDriver driver;
	public  Properties prop;
	public ExtentReports report;
	public  ExtentTest  test;
	public SoftAssert softAssert;
	
	
	
		
	
	@BeforeMethod
	public void inIt(ITestResult result) throws IOException {
		
		
				report=ExtentReportManager.getExtentReport();
				
				  test=report.createTest(result.getMethod().getMethodName().toString().toUpperCase());
				  
				  softAssert= new SoftAssert();
				  
				 
				  prop= new Properties();
					FileInputStream fiput= new FileInputStream("D:\\Sandy Data\\Automation-2021Dell\\MyAutomationProjectPOM_Pracice\\src\\test\\resources\\amazon.properties");
							prop.load(fiput); 			
							infoLog("--------------Executing Beforemethode--------------");	  
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
	

  public void takeSceenShot(){ // fileName of the screenshot
	  Date d=new Date();
  String screenshotFile=d.toString().replace(":", "_").replace(" ","_")+".png"; 
  
  // take screenshot
  File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  try { 
	  // get thedynamic folder name
	  FileUtils.copyFile(srcFile, new File(ExtentReportManager.screenshotFolderPath+screenshotFile)); 
	  //put screenshotfile in reports
	  test.log(Status.FAIL,"Screenshot-> "+test.addScreenCaptureFromPath(ExtentReportManager.screenshotFolderPath+ screenshotFile)); }
  catch (IOException e)
  { // TODO Auto-generated catchblock 
	  e.printStackTrace();
  
  }
  
  }
 
	 
	
	
	public void infoLog(String message) {
		
		System.out.println(message);
		
		test.log(Status.INFO, message);
	
		
	}
	
	
	@AfterMethod
	public void quite() throws InterruptedException  {
		
		
		Thread.sleep(10000);
		driver.close();
		report.flush();
	}
	
}
