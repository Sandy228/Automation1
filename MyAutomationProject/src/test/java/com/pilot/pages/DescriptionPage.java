/**
 * 
 */
package com.pilot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author Sandeep
 *
 */
public class DescriptionPage {
	
	
	
		
	@FindBy(xpath="//textarea[@id='req_descp']")
	WebElement description;
	
	@FindBy(how=How.XPATH,using="//textarea[@id='req_descp']")
	WebElement description1;
	@CacheLookup
	
	//if want to use link in future
	@FindBy(how=How.LINK_TEXT,using="LinkTestSandeep")
	WebElement linkText;
	
	

	
	
	public void typeDesciption(String descriptiondetail) {
		
		description1.sendKeys(descriptiondetail);
	
	
	
	
	
	}
}
