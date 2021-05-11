package com.rediffmail.steps;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webconnector.webdriver.WebConnector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import static org.assertj.core.api.Assertions.assertThat;
public class GenericSteps {
	
	WebConnector con;
	
	
	public GenericSteps(WebConnector con) {
		
		this.con=con;
	}
	
	@Before()
	public void before(Scenario scenario) {
		System.out.println("=================Before the test step==============="+scenario.getName());
		con.inItReport(scenario.getName());
		
	}
	
	@After
	public void after() {
		System.out.println("=================After the test step===============");
		con.quit();
		
	}
	
	@Given("^I open (.*)$")
	public void openBrowser(String browserName) {
		
		con.logInfo("Openig browser --"+browserName);
		con.OpenBrowser(browserName);
		
}
	
	@And("^I go to (.*)$")
	public void i_Navigate(String loginUrl) {
		
		con.logInfo("Navigating URL-- "+loginUrl);
		con.navigate(loginUrl);
		
		
	}
	
	

	}
	
	
	
	
	

