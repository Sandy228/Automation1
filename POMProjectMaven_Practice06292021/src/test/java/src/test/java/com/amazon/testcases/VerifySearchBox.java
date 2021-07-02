package src.test.java.com.amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import src.test.java.com.amazon.pageobjects.LoginPage;
import src.test.java.com.amazon.pageobjects.SearchBoxPage;
import src.test.java.testbase.TestBase;

public class VerifySearchBox extends TestBase {

	
	@Test
	public void checkSearchBoxField() throws IOException, InterruptedException {
		
		driver=getBrowser(prop.getProperty("browsername"), prop.getProperty("url"));
		
		LoginPage loginpageobj=PageFactory.initElements(driver, LoginPage.class);
		SearchBoxPage serchBoxobj=PageFactory.initElements(driver, SearchBoxPage.class);
			
		logInfo("Typing username "+prop.getProperty("username"));
		loginpageobj.enterUserName(prop.getProperty("username"));
		
		
		logInfo("Clicking on Continue Button ");
		loginpageobj.clickOnContinue();
		
		logInfo("Typing password "+prop.getProperty("password"));
		loginpageobj.enterPassword(prop.getProperty("password"));
		
		logInfo("Clicking on Login Button ");
		loginpageobj.clickOnLoginButton();
		
		
		
		logInfo("Typing text in Search box page");
		serchBoxobj.enterTextInSearchBoxField("Aircondition");
		
		
		logInfo("Clicking on Search button");
		serchBoxobj.cickOnSearchButton();
	}
}
