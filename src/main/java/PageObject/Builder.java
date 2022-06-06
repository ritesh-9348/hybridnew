package PageObject;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.BuilderUi;
import Utilities.Logs;
import Utilities.Screenshot;
import Utilities.StartBrowser;

public class Builder {
	public Webdriverhelper web;
	public WebDriver driver;
	Logger logs;
	ExtentReports reports;
	ExtentTest test;
	Screenshot scrn;
	Logs log;
	public Builder() {
		driver=StartBrowser.driver;
		web=new Webdriverhelper();
		log=new Logs();
		test=StartBrowser.test;
		reports=StartBrowser.report;
		scrn=new Screenshot();
	}
	public void build() {
		web.navigatetoWeb("https://www.nobroker.in/");
		logs=log.createlog();
		test=reports.startTest("Builder");
		logs.info("TESTCASE_-4");
		String parent=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(!parent.equals(handle))
				driver.switchTo().window(handle);
		}
		test.log(LogStatus.PASS, "Successfully moved to another page");
		logs.info("Successfully moved to another page");
		web.clickbtn(BuilderUi.city);
		web.sendtext(BuilderUi.name, "ritesh");
		web.sendtext(BuilderUi.email, "ritesh18pradhan@gmail.com");
		web.sendtext(BuilderUi.phone, "9348551411");
		web.clickbtn(BuilderUi.area);
		web.clickbtn(BuilderUi.selectarea);
		web.clickbtn(BuilderUi.budget);
		web.clickbtn(BuilderUi.price);
		test.log(LogStatus.PASS, "Successfully entered all the details");
		logs.info("Successfully entered all the details");
		web.clickbtn(BuilderUi.submit);
		reports.endTest(test);
	}
}
