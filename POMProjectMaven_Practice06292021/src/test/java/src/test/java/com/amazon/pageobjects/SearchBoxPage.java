package src.test.java.com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import src.test.java.testbase.TestBase;

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
	
	WebElement searchTextField;
	
	@FindBy(how=How.XPATH,using = "//input[@id='nav-search-submit-button']")
	@CacheLookup
	WebElement search_btn;
	
	
	public void enterTextInSearchBoxField(String searchText) {
		
		
		
		
		searchTextField.sendKeys(searchText);

	}
	
public void cickOnSearchButton() {
		
	
	search_btn.click();

	}
	
	
	
	
}
