package PageObject;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.NRIUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class NRI {
	public Webdriverhelper web;
	public WebDriver driver;
	Logger logs;
	SignUp sign;
	ExtentReports reports;
	ExtentTest test;
	Screenshot scrn;
	Logs log;
	public NRI() {
		driver=StartBrowser.driver;
		web=new Webdriverhelper();
		log=new Logs();
		sign=new SignUp();
		test=StartBrowser.test;
		reports=StartBrowser.report;
	}
	public void nri() throws IOException {
		web.navigatetoWeb("https://www.nobroker.in/");
		logs=log.createlog();
		test=reports.startTest("NRI");
		logs.info("TESTCASE-7");
		web.clickbtn(NRIUi.click);
		logs.info("Successfully clicked on NRI houses");
		test.log(LogStatus.PASS,"Successfully clicked on NRI houses");
		String parent=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(!parent.equals(handle))
				driver.switchTo().window(handle);
		}
		web.sendtext(NRIUi.name,"ritesh");
		web.sendtext(NRIUi.mobile, "9348551411");
		web.sendtext(NRIUi.mail, "ritesh18pradhan@gmail.com");
		web.clickbtn(NRIUi.city);
		web.clickbtn(NRIUi.select);
		web.clickbtn(NRIUi.type);
		web.clickbtn(NRIUi.selecttype);
		sign.getscrshot("NRI");
		logs.info("Successfully enetered all the details for enqiry");
		test.log(LogStatus.PASS, "Successfully enetered all the details for enqiry");
		web.clickbtn(NRIUi.touch);
		reports.endTest(test);
	}
}
