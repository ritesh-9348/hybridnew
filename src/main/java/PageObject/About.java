package PageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.AboutUi;
import Utilities.Logs;
import Utilities.StartBrowser;

public class About {
	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public About() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	public void about() throws IOException {
		log=logs.createlog();
		log.info("TESTCASE-1");
		test=reports.startTest("AboutUs");
		web.navigatetoWeb("https://www.nobroker.in/");
		web.clickbtn(AboutUi.click);
		test.log(LogStatus.PASS, "Successfully clicked on About us");
		log.info("Successfully clicked on About us");
		web.clickbtn(AboutUi.contact);
		sign.getscrshot("AboutUs");
		String text=web.gettext(AboutUi.text);
		log.info(text);
		test.log(LogStatus.PASS, text);
		reports.endTest(test);
	}
}
