package PageObject;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reusable.Webdriverhelper;
import UiStore.AgreementUi;
import Utilities.Logs;
import Utilities.StartBrowser;

public class Agreement {
WebDriver driver;
Webdriverhelper web;
ExtentTest test;
SignUp sign;
Logs logs;
Logger log;
ExtentReports reports;
public Agreement() {
driver=StartBrowser.driver;
test=StartBrowser.test;
sign=new SignUp();
logs=new Logs();
web=new Webdriverhelper();
reports=StartBrowser.report;
	}
public void rental() throws IOException {
web.navigatetoWeb("https://www.nobroker.in/");
log=logs.createlog();
test=reports.startTest("Agreement");
log.info("TESTCASE_-3");
web.clickbtn(AgreementUi.click);
log.info("Successfully clicked on rentalmagreement");
test.log(LogStatus.PASS, "Successfully clicked on rentalmagreement");
String parent=driver.getWindowHandle();
Set<String> handles=driver.getWindowHandles();
for(String handle:handles) {
	if(!parent.equals(handle))
		driver.switchTo().window(handle);
}
sign.getscrshot("Agreement");
web.clickbtn(AgreementUi.city);
test.log(LogStatus.PASS, "Successfully city is selected");
String text=web.gettext(AgreementUi.text);
System.out.println(text);
log.info(text);
test.log(LogStatus.PASS, text);
reports.endTest(test);
}
}
