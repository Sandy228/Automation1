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
 *This class will store all locators and methods.
 *
 *
 *
 */
public class NameEmailFieldPage extends TestBase{

	
		
	@FindBy(how=How.XPATH,using="/html/body/section[3]/div/div[1]/div[2]/a[1]")
	WebElement DrName_locator;

	@FindBy(how=How.XPATH,using="//input[@id='req_name']")
	WebElement name_locator;
	
	@FindBy(how=How.XPATH,using="//input[@id='req_email']")
	WebElement emailId_locator;
	
	
	
	
	
	public void clickDrName() {
		
		
		DrName_locator.click();
		
	}
	
	public void typeName(String name) {
		
		
		name_locator.sendKeys(name);
		
		
	}
	
	
	public void typeEmailId(String emailId) {
		
		
		emailId_locator.sendKeys(emailId);
		
		
	}
	
	
}
