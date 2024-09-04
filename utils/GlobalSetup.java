package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class GlobalSetup {
	WebDriver driver;
	
	@Parameters({ "projName" })
	@BeforeSuite
	public void globalSetup(String projName) {
		initBase.readSettingsExcel(projName);
		Utils utils = new Utils(driver);
		LoadDriver.lockDevice();
		utils.cleanReports();
	}

	@Parameters({ "sendEmail" })
	@AfterSuite
	public void globalTeardown(String sendEmail) {
		LogResults.mergeReports();
		if (sendEmail.equalsIgnoreCase("Y")) {
			Email email = new Email();
			email.SendEmail();
		}
	}
}
