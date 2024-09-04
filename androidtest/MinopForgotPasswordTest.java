package androidtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopForgotPasswordPage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopForgotPasswordTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage;
	MinopForgotPasswordPage minopForgotPasswordPage;

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopForgotPasswordPage = new MinopForgotPasswordPage(driver);
		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device" })
	@BeforeClass
	void runOnce(int device) {
		logResults.createReport();
		logResults.setTestMethodErrorCount(0);
	}

	@Test(enabled = true, priority = 1)
	public void M_1975_Minop_Forgot_Password_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that when click on Forget Password link it is redirected to the Forget Password page");
		ArrayList<String> data = initBase.loadExcelData("Minop_ForgotPassword", currTC, "");

		if (minopLoginPage.clickForgotPassLink()) {
			logResults.createLogs("Y", "PASS", "Click on Forgot Password link");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Forgot Password : " + minopLoginPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.verifyForgotPasswordTitle()) {
			logResults.createLogs("Y", "PASS", "Forgot Password Page Title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Forgot Password Page Title is not displayed. " + minopLoginPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_1980_Minop_Forgot_Password_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that validation message display when user click on Submit button with both field value kept as blank");
		ArrayList<String> data = initBase.loadExcelData("Minop_ForgotPassword", currTC, "user, domain");

		String user = data.get(0);
		String domain = data.get(1);
		
	
		if (minopLoginPage.clickForgotPassLink()) {
			logResults.createLogs("Y", "PASS", "Click on Forgot Password link");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Forgot Password : " + minopLoginPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.verifyForgotPasswordTitle()) {
			logResults.createLogs("Y", "PASS", "Forgot Password Page Title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Forgot Password Page Title is not displayed. " + minopLoginPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.enterEmailtxt(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopForgotPasswordPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.enterAccountCodetxt(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering Domain name: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.verifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation Message displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not displayed :" + minopForgotPasswordPage.getExceptionDesc());
		}


	}
	
	@Test(enabled = true, priority = 3)
	public void M_1981_Minop_Forgot_Password_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that validation message display when user enter invalid email address");
		ArrayList<String> data = initBase.loadExcelData("Minop_ForgotPassword", currTC, "user, domain");

		String user = data.get(0);
		String domain = data.get(1);
		
	
		if (minopLoginPage.clickForgotPassLink()) {
			logResults.createLogs("Y", "PASS", "Click on Forgot Password link");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Forgot Password : " + minopLoginPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.verifyForgotPasswordTitle()) {
			logResults.createLogs("Y", "PASS", "Forgot Password Page Title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Forgot Password Page Title is not displayed. " + minopLoginPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.enterEmailtxt(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopForgotPasswordPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.enterAccountCodetxt(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering Domain name: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.verifyInvalidValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Invalid Validation Message displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid Validation message not displayed :" + minopForgotPasswordPage.getExceptionDesc());
		}


	}
	
	
	@Test(enabled = true, priority = 4)
	public void M_1982_Minop_Forgot_Password_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that validation message display when user enter unregistered email address");
		ArrayList<String> data = initBase.loadExcelData("Minop_ForgotPassword", currTC, "user, domain");

		String user = data.get(0);
		String domain = data.get(1);
		
	
		if (minopLoginPage.clickForgotPassLink()) {
			logResults.createLogs("Y", "PASS", "Click on Forgot Password link");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Forgot Password : " + minopLoginPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.verifyForgotPasswordTitle()) {
			logResults.createLogs("Y", "PASS", "Forgot Password Page Title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Forgot Password Page Title is not displayed. " + minopLoginPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.enterEmailtxt(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopForgotPasswordPage.getExceptionDesc());
		}

		if (minopForgotPasswordPage.enterAccountCodetxt(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering Domain name: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopForgotPasswordPage.getExceptionDesc());
		}
		
		if (minopForgotPasswordPage.verifyUnregisteredValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Unregistered Validation Message displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Unregistered Validation message not displayed :" + minopForgotPasswordPage.getExceptionDesc());
		}


	}

	@AfterMethod
	void Aftermethod() {
		logResults.onlyLog();
		if (driver != null)
			driver.quit();
	}

	@AfterTest
	void cleanUp() {
		if (driver != null)
			driver.quit();
	}
}
