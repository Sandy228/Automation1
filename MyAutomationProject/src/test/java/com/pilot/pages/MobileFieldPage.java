/**
 * 
 */
package com.pilot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testbase.TestBase;

/**
 * @author Sandeep
 *
 */
public class MobileFieldPage extends TestBase {

	
	
	@FindBy(how=How.XPATH,using="//input[@id='req_mobile']")
	WebElement mobileField_Locator;
	
	

	
	//By mobileField_Locator=By.xpath("//input[@id='req_mobile']");
	

	
	
	
	public void typemobile(String mobNum) {
		
		mobileField_Locator.sendKeys(mobNum);
		
	}
	
	
	
	
}
