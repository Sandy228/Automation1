package com.pilot.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pilot.pages.NameEmailFieldPage;

import mydataproviders.CustomDataProviders;
import testbase.TestBase;

public class VerifyPilotNameEmail extends TestBase{

	WebDriver driver;
	
	@Test(dataProviderClass=CustomDataProviders.class,dataProvider="dataTestSuiteA")
	public void verifyPiloNameEmail(String name, String email,String mobile,String description) {
		
		
		
		log("Opening Browser");
		driver=browsers("Chrome");
		
		
		
		log("Opening url");
		driver.get("https://www.sakraworldhospital.com/request-appointment.php");
		
		
		NameEmailFieldPage nameEmailFieldPage=PageFactory.initElements(driver, NameEmailFieldPage.class);
		
		log("Clicking on Doctor's name");
		isElementPresent("/html/body/section[3]/div/div[1]/div[2]/a[1]",driver);
		nameEmailFieldPage.clickDrName();
		
		
		log("Typing in name field");
		
		if(!isElementPresent("//input[@id='req_name1']",driver)) {
			
			softFailure("Xpath do not match");
			softassert.assertEquals("//input[@id='req_name1']", "//input[@id='req_name']");//This line print log and actual error in last line in Reports.
			
			
		}
		
		
		
		/*isElementPresent("//input[@id='req_name']",driver);
		nameEmailFieldPage.typeName(name);*/
		
		
		
		log("Typing in name Email's field");
		isElementPresent("//input[@id='req_email']",driver);
		nameEmailFieldPage.typeEmailId(email);
		
		log("Closing driver");
		//driver.quit();
		
	}
	
	
	
}
