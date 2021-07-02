package src.test.java.com.amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import src.test.java.com.amazon.pageobjects.LoginPage;
import src.test.java.testbase.TestBase;

public class VerifyLogin extends TestBase{

	public WebDriver driver;
	
	
	@Test
	public void checkValidLogin() throws IOException, InterruptedException {
		
		driver=getBrowser(prop.getProperty("browsername"), prop.getProperty("url"));
		
		logInfo("Matiching the text");
		if(!"Text1".equals("Text")) {
			softFailure("Text do not match");
			softassert.assertEquals("Text1", "Text");//This line print log and actual error in last line in Reports.
		}
		
		
	LoginPage loginpageobj=PageFactory.initElements(driver, LoginPage.class);
		
	logInfo("Typing username "+prop.getProperty("username"));
	loginpageobj.enterUserName(prop.getProperty("username"));
	
	
	
	logInfo("Clicking on Continue Button ");
	loginpageobj.clickOnContinue();
	
	logInfo("Typing password "+prop.getProperty("password"));
	loginpageobj.enterPassword(prop.getProperty("password"));
	
	logInfo("Clicking on Login Button ");
	loginpageobj.clickOnLoginButton();
	
	
	softassert.assertAll();
	}
	
}
