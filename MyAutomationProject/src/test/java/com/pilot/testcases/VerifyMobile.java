/**
 * 
 */
package com.pilot.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pilot.pages.MobileFieldPage;
import com.pilot.pages.NameEmailFieldPage;

import mydataproviders.CustomDataProviders;
import testbase.TestBase;

/**
 * @author Sandeep
 *
 */
public class VerifyMobile extends TestBase{

	@Test(dataProviderClass=CustomDataProviders.class,dataProvider="dataTestSuiteA")
	public void verifyPilomobile(String name, String email,String mobile,String description)  {
		
	
		browsers("chrome");
		driver.get("https://www.sakraworldhospital.com/request-appointment.php");
		
		
		NameEmailFieldPage nameEmailFieldPage=PageFactory.initElements(driver, NameEmailFieldPage.class);
		MobileFieldPage MobileFieldPage=PageFactory.initElements(driver, MobileFieldPage.class);
		
	
		
		
		//working on nameEmailField test
		nameEmailFieldPage.clickDrName();
		nameEmailFieldPage.typeName(name);
		nameEmailFieldPage.typeEmailId(email);
		//working on mobile test
		MobileFieldPage.typemobile(mobile);
		
		
		
		//driver.quit();
		
	}
	
	
}
