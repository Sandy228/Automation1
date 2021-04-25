package listners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyCustomListners implements ITestListener {

	public void onTestSuccess(ITestResult result) {

		System.out.println("=====Test Passed===from onTestSuccess===");
		
		
		ExtentTest test=(ExtentTest) result.getAttribute("SendingtestObj");
		test.log(Status.PASS, result.getName());
		
	}

	public void onTestFailure(ITestResult result) {

		System.out.println("=====Test failed===from onTestFailure===");
		System.out.println("Failed test name ="+result.getTestName());
		System.out.println(result.getThrowable().getMessage());//get error message

		ExtentTest test=(ExtentTest) result.getAttribute("SendingtestObj");
		test.log(Status.FAIL, result.getThrowable().getMessage());// This line also printing at the end of report
	}

	
}
