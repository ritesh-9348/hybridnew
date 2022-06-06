package PageObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.SignUpUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class SignUp {
public Webdriverhelper web;
public WebDriver driver;
Logger logs;
ExtentReports reports;
ExtentTest test;
Screenshot scrn;
Logs log;
public SignUp() {
	driver=StartBrowser.driver;
	reports=StartBrowser.report;
	test=StartBrowser.test;
	web=new Webdriverhelper();
	log=new Logs();
	scrn=new Screenshot();
}
public void Login() throws IOException {
	web.navigatetoWeb("https://www.nobroker.in/");
	logs=log.createlog();
	test=reports.startTest("Sign Up");
	logs.info("TESTCASE-1");
	web.clickbtn(SignUpUi.signUp);
	web.sendtext(SignUpUi.mobile,"9348551411");
	test.log(LogStatus.PASS,"Successfully entered mobile number");
	logs.info("Successfully entered mobile number");
	web.sendtext(SignUpUi.name, "ritesha");
	web.sendtext(SignUpUi.email, "ritesh18pradhan@gmail.com");
	test.log(LogStatus.PASS,"Successfully entered email and name");
	logs.info("Successfully entered email and name");
	this.getscrshot("SignUp");
	web.clickbtn(SignUpUi.contin);
	
}
public void getscrshot(String name) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
	File dest=new File(path);
	FileUtils.copyFile(src, dest);
}
}
