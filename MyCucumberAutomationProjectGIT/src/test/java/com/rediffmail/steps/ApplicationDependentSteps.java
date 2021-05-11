package com.rediffmail.steps;

import java.util.Map;

import com.webconnector.webdriver.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ApplicationDependentSteps {
	
	WebConnector con;
	
	public ApplicationDependentSteps(WebConnector con) {
		
		this.con=con;
	}

	@Then("^login should be (.*)$")
	public void validateLogin(String expectedResult) {
		
		con.validateLogin(expectedResult);
		
	}
	
	@And("^I login inside application$")
	public void login(Map<String,String> data) {
		con.logInfo(data.get("Username"));
		con.logInfo(data.get("Password"));
		
		con.login(data.get("Username"),data.get("Password"));
		
	}
	
	
	
	
}
