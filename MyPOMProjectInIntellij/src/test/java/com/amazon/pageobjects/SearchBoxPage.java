package com.amazon.pageobjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import testbase.TestBase;



public class SearchBoxPage extends TestBase{
	
	WebDriver driver;
	
	
	public SearchBoxPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using = "//input[@id='ap_email']")
	@CacheLookup
	WebElement email;
	
	@FindBy(how=How.XPATH,using = "//input[@id='continue']")
	@CacheLookup
	WebElement continue_btn;
	
	@FindBy(how=How.XPATH,using = "//input[@id='ap_password']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH,using = "//input[@id='signInSubmit']")
	@CacheLookup
	WebElement submit_btn;
	
	
	@FindBy(how=How.XPATH,using = "//input[@id='twotabsearchtextbox']")
	@CacheLookup
	WebElement searchTextField;
	
	@FindBy(how=How.XPATH,using = "//input[@id='nav-search-submit-button']")
	@CacheLookup
	WebElement search_btn;
	
	
	public void enterSearchBoxField(String searchText) {
		
		
		System.out.println("Entering in Search text Field----"+searchText);
		searchTextField.sendKeys(searchText);
		
		System.out.println("Clicking on Search Button----"+search_btn);
		search_btn.click();
		
		
		
	}
	
	
	
	
	
}
