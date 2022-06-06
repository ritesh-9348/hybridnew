package PageObject;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.PackerMoverUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class PackerMover {
	public Webdriverhelper web;
	public WebDriver driver;
	Logger logs;
	SignUp sign;
	ExtentReports reports;
	ExtentTest test;
	Screenshot scrn;
	Logs log;
	public PackerMover() {
		driver=StartBrowser.driver;
		web=new Webdriverhelper();
		log=new Logs();
		sign=new SignUp();
		test=StartBrowser.test;
		reports=StartBrowser.report;
	}
	public void book() throws IOException {
		web.navigatetoWeb("https://www.nobroker.in/");
		logs=log.createlog();
		test=reports.startTest("Packers");
		logs.info("TESTCASE-8");
		web.clickbtn(PackerMoverUi.click);
		test.log(LogStatus.PASS, "Successfully clicked on Packers movers");
		logs.info("Successfully clicked on Packers movers");
		String parent=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(!parent.equals(handle))
				driver.switchTo().window(handle);
		}
		sign.getscrshot("Packers");
		String text=web.gettext(PackerMoverUi.text);
		test.log(LogStatus.PASS, text);
		logs.info(text);
		reports.endTest(test);
	}
}
