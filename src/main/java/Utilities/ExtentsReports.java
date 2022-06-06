package Utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentsReports {
	public static ExtentTest test;
	public static ExtentReports report;
	@BeforeTest
	public void before() {
		report=new ExtentReports(System.getProperty("user.dir")+"Reports/report.html", true);
		
		
	}
	@AfterTest
	public void after() {
		report.flush();
	}
}
