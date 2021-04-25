package report;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentReports  report;
	
	public static ExtentReports getExtentManager() {
		
		if(report==null) {
			
			report= new ExtentReports();
			
			
			
			Date date= new Date();
			File file= new File(System.getProperty("user.dir")+"//reports//"+date.toString().replaceAll(":", "-")+"//Screenshots");
			file.mkdirs();
			
			ExtentSparkReporter sparkReport= new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+date.toString().replaceAll(":", "-"));
			
			sparkReport.config().setReportName("ProductionReports");

			// Setting the backgrounnd theme color
		 sparkReport.config().setTheme(Theme.DARK);

		 sparkReport.config().setDocumentTitle("Automation Reports");

		 sparkReport.config().setEncoding("utf-8");

			report.attachReporter(sparkReport);
			
		}
		
		
		
		
		
		return report;
		
	}
	
	
	
	
}
