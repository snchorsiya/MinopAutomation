package androidtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopDashboard;
import androidpage.MinopHomePage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopDashboardTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
	MinopHomePage minopHomePage = new MinopHomePage(driver);
	MinopDashboard minopDashboard = new MinopDashboard(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchAndroidApp(int device) {
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
		minopDashboard = new MinopDashboard(driver);

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
	public void M_1905_Minop_Mobile_Dashboard_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that dashboard page opens when user click on Dashboard from menu");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_1906_Minop_Mobile_Dashboard_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults
				.setScenarioName("Scenario: Verify that Current month display as selected in the Select Month drodown");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifCurrentMonth()) {
			logResults.createLogs("Y", "PASS", "Current Month display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Current Month not display: " + minopDashboard.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void M_1907_Minop_Mobile_Dashboard_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that the data display/changes in the chart according to the month selected from select month dropdown");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifSelectMonth()) {
			logResults.createLogs("Y", "PASS", "Current Month display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Current Month not display: " + minopDashboard.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void M_1908_Minop_Mobile_Dashboard_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that the Present and Absent count display/changes in the Present and Absent box as per month selected");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifSelectMonth()) {
			logResults.createLogs("Y", "PASS", "Current Month display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Current Month not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifyPresent()) {
			logResults.createLogs("Y", "PASS", "Present count display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Present count not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifyAbsent()) {
			logResults.createLogs("Y", "PASS", "Absent count display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Absent count not display: " + minopDashboard.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void M_1909_Minop_Mobile_Dashboard_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that the value display in the This Week Working Hours section as per the weekly punches are done.");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifSelectMonth()) {
			logResults.createLogs("Y", "PASS", "Current Month display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Current Month not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.VerifyWeekWork()) {
			logResults.createLogs("Y", "PASS", "This Week working hours display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"This Week working hours not display: " + minopDashboard.getExceptionDesc());
		}
	}
	
	
	@Test(enabled = true, priority = 6)
	public void M_1910_Minop_Mobile_Dashboard_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that the Status window open as per status which user click from Chart(i.e. Error window open when user click on Error Staus, Same way Week OFF,Absent Window open as per click on the chart)  ");
		ArrayList<String> data = initBase.loadExcelData("Minop_Mobile_Dashboard", currTC, "user,password,domain");
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

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.clickOnDashboard()) {
			logResults.createLogs("Y", "PASS", "Click Dashboard Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Dashboard Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopDashboard.verifyDashboardTitle()) {
			logResults.createLogs("Y", "PASS", "Dashboard title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard title is not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.verifSelectMonth()) {
			logResults.createLogs("Y", "PASS", "Current Month display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Current Month not display: " + minopDashboard.getExceptionDesc());
		}

		if (minopDashboard.VerifyClickOnStatus()) {
			logResults.createLogs("Y", "PASS", "Status display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status not display: " + minopDashboard.getExceptionDesc());
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
