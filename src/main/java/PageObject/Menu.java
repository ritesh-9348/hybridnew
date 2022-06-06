package PageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.MenuUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class Menu {
	public Webdriverhelper web;
	public WebDriver driver;
	Logger logs;
	ExtentReports reports;
	ExtentTest test;
	SignUp sign;
	Screenshot scrn;
	Logs log;
	public Menu() {
		driver=StartBrowser.driver;
		web=new Webdriverhelper();
		log=new Logs();
		sign=new SignUp();
		test=StartBrowser.test;
		reports=StartBrowser.report;
		scrn=new Screenshot();
	}
	public void menu() throws IOException {
		web.navigatetoWeb("https://www.nobroker.in/");
		logs=log.createlog();
		test=reports.startTest("Menu");
		logs.info("TESTCASE-6");
		web.clickbtn(MenuUi.click);
		logs.info("Successfully clciked on main Menu");
		test.log(LogStatus.PASS, "Successfully clciked on main Menu");
		web.clickbtn(MenuUi.refer);
		sign.getscrshot("Menu");
		String text=web.gettext(MenuUi.text);
		test.log(LogStatus.PASS, text);
		logs.info(text);
		reports.endTest(test);
	}
}
