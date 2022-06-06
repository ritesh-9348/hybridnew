package PageObject;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.SaleUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class FlatSale {
	public Webdriverhelper web;
	public WebDriver driver;
	Logger logs;
	ExtentReports reports;
	ExtentTest test;
	Screenshot scrn;
	Logs log;
	SignUp sign;
	public FlatSale() {
		driver=StartBrowser.driver;
		web=new Webdriverhelper();
		log=new Logs();
		sign=new SignUp();
		test=StartBrowser.test;
		reports=StartBrowser.report;
		scrn=new Screenshot();
	}
public void sale() throws IOException {
	web.navigatetoWeb("https://www.nobroker.in/");
	logs=log.createlog();
	test=reports.startTest("FlatSale");
	logs.info("TESTCASE-5");
	web.clickbtn(SaleUi.click);
	test.log(LogStatus.PASS, "Successfully clicked on FlatSale in Marathalli");
	logs.info("Successfully clicked on FlatSale in Marathalli");
	String parent=driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	for(String handle:handles) {
		if(!parent.equals(handle))
			driver.switchTo().window(handle);
	}
	sign.getscrshot("FlatSale");
	String text=web.gettext(SaleUi.price);
	test.log(LogStatus.PASS, text);
	logs.info(text);
	reports.endTest(test);
}
}
