package com.amazon.pageobjects;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import testbase.TestBase;



public class LoginPage extends TestBase{
	
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using = "//input[@id='ap_email']")
	
	WebElement email;
	
	@FindBy(how=How.XPATH,using = "//input[@id='continue']")
	
	WebElement continue_btn;
	
	@FindBy(how=How.XPATH,using = "//input[@id='ap_password']")
	
	WebElement Password;
	
	@FindBy(how=How.XPATH,using = "//input[@id='signInSubmit']")
	
	WebElement submit_btn;
	
	
	
	public void loginToAmazon(String username, String password) throws InterruptedException {
		
		test.log(Status.INFO," message");
	//	infoLog("Entering UserName----"+username);
		email.sendKeys(username);
		
		infoLog("Clicking on Continue button --"+continue_btn);
		continue_btn.click();
		
		//Some time it takes time to appear the element so we use Explicit wait:
				WebDriverWait webWait= new WebDriverWait(driver, Duration.ofSeconds(10));
				webWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ap_password']")));
		
				Thread.sleep(3000);
				
				infoLog("Entering Password----"+password);
				Password.sendKeys(password);
		
		infoLog("Clicking on Login button --"+continue_btn);
		submit_btn.click();
	}
	
	
}
