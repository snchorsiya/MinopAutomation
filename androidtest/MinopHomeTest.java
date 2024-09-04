package androidtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopHomePage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopHomeTest {
	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
	MinopHomePage minopHomePage = new MinopHomePage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchAndroidApp(int device) {
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
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
	public void M_1896_Minop_Mobile_Home_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that user is redirected to the HOme page after user do login");
		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginPage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.clickLoginBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
		}
//		if (minopLoginPage.handlePopups()) {
//			logResults.createLogs("Y", "PASS", "Handled all popups successfully");
//		} else {
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
//		}
		if (minopHomePage.verifyEmpName()) {
			logResults.createLogs("Y", "PASS", "Employee Name displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee Name is not displayed: " + minopHomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_1897_Minop_Mobile_Home_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that Check In button display when user do login ");
		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginPage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.clickLoginBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
		}
		if (minopHomePage.verifyCheckInBtn()) {
			logResults.createLogs("Y", "PASS", "Check In button displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Check In button is not displayed. " + minopHomePage.getExceptionDesc());
		}
		if (minopLoginPage.handlePopups()) {
			logResults.createLogs("Y", "PASS", "Handled all popups successfully");
		} else {
			logResults.createLogs("Y", "INFO",
					"No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void M_1898_Minop_Mobile_Home_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Check Out button display when user click on Check IN button and do punch ");
		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginPage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.clickLoginBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
		}
		
		if (minopHomePage.verifyCheckOutBtn()) {
			logResults.createLogs("Y", "PASS", "Check Out button displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check Out button is not displayed. " + minopHomePage.getExceptionDesc());
		}
		
		try {
			if (minopLoginPage.handlePopups()) {
				logResults.createLogs("Y", "PASS", "Handled all popups successfully");
			} else {
				logResults.createLogs("Y", "INFO",
						"No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
			}
		} catch (Exception e) {
		}

	}

	@Test(enabled = true, priority = 4)
	public void M_1899_Minop_Mobile_Home_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Check IN button display when user click on Check Out button and do punch");
		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		if (minopLoginPage.enterDomin(domain))
			logResults.createLogs("Y", "PASS", "Domin Name Entered in Text Box: " + domain);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering domin name: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.enterUser(user))
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		String maskedPassword = initBase.maskPassword(pass);
//	    logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		if (minopLoginPage.enterPassword(pass))
//	        logResults.createLogs("Y", "PASS", "Password Entered in Text Box: "+ pass); 
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		else
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.clickLoginBtn())
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		else
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
//		if (minopLoginPage.handlePopups()) {
//			logResults.createLogs("Y", "PASS", "Handled all popups successfully");
//		} else {
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
//		}
		if (minopHomePage.verifyCheckOutBtnDisplay())
			logResults.createLogs("Y", "PASS", "Check Out button displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Check Out button is not displayed. " + minopHomePage.getExceptionDesc());
		if (minopHomePage.AfterClickCheckOutBtn())
			logResults.createLogs("Y", "PASS",
					"After Click on CheckOut button, the check in button display successfully");
		else
			logResults.createLogs("Y", "FAIL", "After Click on CheckOut button, the check in button is display. "
					+ minopHomePage.getExceptionDesc());
	}

	@Test(enabled = true, priority = 5)
	public void M_1900_Minop_Mobile_Home_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults
				.setScenarioName("Scenario: Verify that In Time not display until user has not approved the webpunch");
		ArrayList<String> data = initBase.loadExcelData("Home", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		if (minopLoginPage.enterDomin(domain))
			logResults.createLogs("Y", "PASS", "Domin Name Entered in Text Box: " + domain);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering domin name: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.enterUser(user))
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		String maskedPassword = initBase.maskPassword(pass);
//	    logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		if (minopLoginPage.enterPassword(pass))
//	        logResults.createLogs("Y", "PASS", "Password Entered in Text Box: "+ pass); 
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		else
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.clickLoginBtn())
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		else
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
//		if (minopLoginPage.handlePopups()) {
//			logResults.createLogs("Y", "PASS", "Handled all popups successfully");
//		} else {
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
//		}
		if (minopHomePage.verifyCheckOutBtn())
			logResults.createLogs("Y", "PASS", "Check Out button displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Check Out button is not displayed. " + minopHomePage.getExceptionDesc());
		if (minopHomePage.verifyDisplayedTime()) {
			logResults.createLogs("Y", "PASS", "Displayed time is correct");
		} else {
			logResults.createLogs("Y", "FAIL", "Displayed time is incorrect: " + minopHomePage.getExceptionDesc());
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
