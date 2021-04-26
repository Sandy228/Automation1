/**
 * 
 */
package com.pilot.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pilot.pages.DescriptionPage;
import com.pilot.pages.MobileFieldPage;
import com.pilot.pages.NameEmailFieldPage;

import mydataproviders.CustomDataProviders;
import testbase.TestBase;


/**
 * @author Sandeep
 *
 */
public class VerifyDescription extends TestBase{

	@Test(dataProviderClass=CustomDataProviders.class,dataProvider="dataTestSuiteA")
	public void verifyDescription(String name, String email,String mobile,String description) {
		
		browsers("chrome");
		driver.get("https://www.sakraworldhospital.com/request-appointment.php");
		
		
		
		
		NameEmailFieldPage nameEmailFieldPage=PageFactory.initElements(driver, NameEmailFieldPage.class);
		MobileFieldPage MobileFieldPage=PageFactory.initElements(driver, MobileFieldPage.class);
		
		nameEmailFieldPage.clickDrName();
		nameEmailFieldPage.typeName(name);
		MobileFieldPage.typemobile(mobile);
		nameEmailFieldPage.typeEmailId(email);
		
		
		DescriptionPage descriptionpage=PageFactory.initElements(driver, DescriptionPage.class);
		descriptionpage.typeDesciption(description);
		
	}
	
	
	
}
