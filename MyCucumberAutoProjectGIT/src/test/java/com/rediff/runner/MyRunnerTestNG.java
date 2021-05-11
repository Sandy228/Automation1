package com.rediff.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
		dryRun = false, //dryRun = true then it does not execute any scenario just check every thing is fine or not 
		strict=true,//suppose given string is not matching and trinct is false then no error it will give.
		monochrome=true, //Out put will give in proper format like 2 test pass 3 fail like that.
		features= {"src/test/resources/"}, //means all feature files are under the resources folder.
				//features= {"src/test/resources/featurs/ if we give this location means only holiday feature will run.
		glue ={"com.rediffmail.steps"},//will find all java test cases scenarios under this package.
		plugin= { "pretty",
				"html:target/site/cucumber-html","json:target/cucumber1.json"}
		
		//pretty is good for consol formatting, if remove pretty , rest will generate report in json and html format
		
		//tags= {"@BuyProduct"}//will run particular feature file
		
		
		
		)
//To run with TestNG just extends AbstractTestNGCucumberTests
public class MyRunnerTestNG  extends AbstractTestNGCucumberTests{

}
