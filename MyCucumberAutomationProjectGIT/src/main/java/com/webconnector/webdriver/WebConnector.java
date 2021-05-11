package com.webconnector.webdriver;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.extent.reports.ExtentManager;
//import static org.assertj.core.api.Assertions.assertThat;
public class WebConnector {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports report;
	public ExtentTest scenario;
	
	 
	
	public WebConnector() throws IOException {
		
		if(prop==null) {
			prop=new Properties();
			FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties");
			prop.load(fis);
			
		}
		
	}
	
	
	
	
	public void OpenBrowser(String BrowserName) {


		  if (BrowserName.equalsIgnoreCase("Chrome")) {
		  
		  System.setProperty("webdriver.chrome.driver",
		  "D:\\Sandy Data\\Browser_s EXE\\ChromeDriver\\chromversion_90\\chromedriver.exe"
		  ); driver = new ChromeDriver();
		  
		  
		  } else if (BrowserName.equalsIgnoreCase("Mozilla")) {
		  
		  System.setProperty("webdriver.gecko.driver",
		  "D:\\Sandy Data\\Browser_s EXE\\FireFox GecoDriver\\64bit\\geckodriver.exe");
		  
		  driver = new FirefoxDriver();
		  
		  
		  } else if (BrowserName.equalsIgnoreCase("IE")) {
		  System.setProperty("webdriver.ie.driver",
		  "D:\\Sandy Data\\Browser_s EXE\\InternetExplorer Driver\\IEDriverServer.exe"
		  );
		  
		  driver = new InternetExplorerDriver();
		  
		  }
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  logInfo("Browser Opened");
		 
		  
		
	}


	public void inItReport(String scenarioName) {
		report=ExtentManager.getExtentManager();
		scenario=report.createTest(scenarioName);
		
		scenario.log(Status.INFO,"Starting the scenario"+ scenarioName);
		
	}
	
	
	
	
	public void navigate(String loginUrl) {
		logInfo("Navigating to url - "+loginUrl);
		driver.get(prop.getProperty(loginUrl));
		
	}
	
	public void click(String objectKey) {
		logInfo("Clickng on "+objectKey);
		getObject(objectKey).click();
	}
	
	
	public void type(String objectkey, String data) {
		logInfo("Typing the data "+data);
		getObject(objectkey).sendKeys(data);
	}

	//Central function to extract/get the object
	public WebElement getObject(String objectKey) {
		WebElement e=null;
		try {
			if(objectKey.endsWith("_xpath")) {
		e= driver.findElement(By.xpath(prop.getProperty(objectKey)));
		WebDriverWait webWait= new WebDriverWait(driver, 10);
		webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
		
			}
			else if(objectKey.endsWith("_id")) {
				e= driver.findElement(By.id(prop.getProperty(objectKey)));
				WebDriverWait webWait= new WebDriverWait(driver, 10);
				webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(prop.getProperty(objectKey))));
					}
			else if(objectKey.endsWith("_css")) {
				e= driver.findElement(By.cssSelector(prop.getProperty(objectKey)));
				WebDriverWait webWait= new WebDriverWait(driver, 10);
				webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(prop.getProperty(objectKey))));
					}
			
			else if(objectKey.endsWith("_name")) {
				e= driver.findElement(By.name(prop.getProperty(objectKey)));
				WebDriverWait webWait= new WebDriverWait(driver, 10);
				webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(prop.getProperty(objectKey))));
					}
		}
	catch(Exception ex) {
		//report the failure 
		ex.printStackTrace();
		ex.printStackTrace();
		//reportFailure(ex.getMessage());
		reportFailure("Unable to extract object "+objectKey);
	}
		return e;
	}
	
	
	//True-if element present
	//False-If element not present
	public boolean isElementPresent(String objectKey) {
		
		List<WebElement> e= null;
		if(objectKey.endsWith("_xpath")) {
			e= driver.findElements(By.xpath(prop.getProperty(objectKey)));
			WebDriverWait webWait= new WebDriverWait(driver, 10);
			webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(prop.getProperty(objectKey))));
			
				}
				else if(objectKey.endsWith("_id")) {
					e= driver.findElements(By.id(prop.getProperty(objectKey)));
					WebDriverWait webWait= new WebDriverWait(driver, 10);
					webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(prop.getProperty(objectKey))));
						}
				else if(objectKey.endsWith("_css")) {
					e= driver.findElements(By.cssSelector(prop.getProperty(objectKey)));
					WebDriverWait webWait= new WebDriverWait(driver, 10);
					webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(prop.getProperty(objectKey))));
						}
				
				else if(objectKey.endsWith("_name")) {
					e= driver.findElements(By.name(prop.getProperty(objectKey)));
					WebDriverWait webWait= new WebDriverWait(driver, 10);
					webWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(prop.getProperty(objectKey))));
						}
		if(e.size()==0) {
			return false;
		}else
			return true;
	}
	
	public void validateLogin(String expectedResult) {
		boolean result=isElementPresent("portfoliosection_id");
		
		String actualResult="";
		
		if(result) {
			actualResult="Success";
			logInfo("User successfully logged IN");
			
			
		}
		else
			actualResult="Failure";
		
		if(!expectedResult.equalsIgnoreCase(actualResult))
			logInfo("Scenario Failure  --"+actualResult+"And Expected Result is --"+expectedResult);
		reportFailure("Scenario Failure");
	}


	public void login(String Username,String Password) {
		// TODO Auto-generated method stub
		
		type("userNameLocator_xpath", Username);
		type("password_locator_xpath", Password);
		click("loginSubmit_xpath");
	}
	
	//----------------------Logging--------------------
	
	
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
			scenario.log(Status.FAIL,"Screenshot-> "+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 
	
	
	
	
	
	
	public void logInfo(String msg) {
		scenario.log(Status.INFO, msg);
	}
	
	public void reportFailure(String msg) {
		scenario.log(Status.FAIL, msg);
		takeSceenShot();
		
		
	}
	
	
	
	public void successLog(String msg) {
		scenario.log(Status.PASS, msg);
		
	}
	
	
	public void quit() {
		if(report!=null)
			report.flush();
	}
}



