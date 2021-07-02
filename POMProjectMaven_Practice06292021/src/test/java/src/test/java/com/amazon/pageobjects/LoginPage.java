package src.test.java.com.amazon.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import src.test.java.testbase.TestBase;

public class LoginPage extends TestBase {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='ap_email']")

	WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@id='continue']")

	WebElement continue_btn;

	@FindBy(how = How.XPATH, using = "//input[@id='ap_password']")

	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='signInSubmit']")

	WebElement submit_btn;

	public void enterUserName(String username) throws InterruptedException {

		email.sendKeys(username);

	}

	public void clickOnContinue() throws InterruptedException {

		continue_btn.click();

	}

	
	public void enterPassword(String password) throws InterruptedException {
		Thread.sleep(5000);
		Password.sendKeys(password);

	}

	public void clickOnLoginButton() throws InterruptedException {

		submit_btn.click();

	}

}
