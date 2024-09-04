package androidtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopApproveAttendancePage;
import androidpage.MinopAttendanceCorrectionPage;
import androidpage.MinopHomePage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopAttendanceCorrectionTest  {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
	MinopHomePage minopHomePage = new MinopHomePage(driver);
	MinopAttendanceCorrectionPage minopAttendanceCorrectionPage;
	MinopApproveAttendancePage minopApproveAttendancePage;
	
	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
		minopAttendanceCorrectionPage = new MinopAttendanceCorrectionPage(driver);
		minopApproveAttendancePage = new MinopApproveAttendancePage(driver);
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
	public void M_1942_Mionp_Mobile_Attendance_01() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Attendance Correction page opens when user click on Attendance Correction  link");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 2)
	public void M_1943_Minop_Mobile_Attendance_02() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that Attendance Correction Pop Up window Open when user click on + button.");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction Pop Up window should open");
		} else {
			logResults.createLogs("Y", "Fail", "Attendance Correction Pop up window should not be open");
		}

	}

	@Test(enabled = true, priority = 3)
	public void M_1944_Minop_Mobile_Attendance_03() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Validation message display when user click on Save button without filling Mandatory Fields");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction Pop Up window should open");
		} else {
			logResults.createLogs("Y", "Fail", "Attendance Correction Pop up window should not be open: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Apply button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyBlankValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Validation message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 4)
	public void M_1945_Minop_Mobile_Attendance_04() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to add attendance correction successfully when all correct values are filled in all fields and user click on save button");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC,
				"user,password,domain,inhourtime,outhourtime,minute");

		String user, password, domain, inhourtime, outhourtime, minute;
		user = data.get(0);
		password = data.get(1);
		domain = data.get(2);
		inhourtime = data.get(3);
		outhourtime = data.get(4);
		minute = data.get(5);

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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction Pop Up window should open");
		} else {
			logResults.createLogs("Y", "Fail", "Attendance Correction Pop up window should not be open: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.clickAddCorrectionDate()) {
			logResults.createLogs("Y", "PASS", "Calendar Open Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Calendar not open successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.selectAddCorrectionDate(1)) {
			logResults.createLogs("Y", "PASS", "Date Select Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Date not Select successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterHourTxt(inhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + inhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOutTime()) {
			logResults.createLogs("Y", "PASS", "Click on Out time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on Out time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterOutHourTxt(outhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + outhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		
		if (minopAttendanceCorrectionPage.ClickOnTimeFormat()) {
			logResults.createLogs("Y", "PASS", "Click on Time Format");
		} else {
			logResults.createLogs("Y", "Fail",
					"Time Format not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.SelectPMDrp()) {
			logResults.createLogs("Y", "PASS", "PM value select in dropdown.");
		} else {
			logResults.createLogs("Y", "Fail",
					"PM value not select in dropdown: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterTxtReson()) {
			logResults.createLogs("Y", "PASS", "Reson add successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Reson not display display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Apply button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifySuccessValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Success Message display successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Success Message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 5)
	public void M_1946_Minop_Mobile_Attendance_05() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that Successfully added Attendance request display in the page");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyDataInDisply()) {
			logResults.createLogs("Y", "PASS", "Attendance Data disply successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Attendance Data not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void M_1947_Minop_Mobile_Attendance_06() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Pending Attendance Correction Status display in the Grid after added attendance correction request and not approved by Admin/Reporting person");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyStatusData()) {
			logResults.createLogs("Y", "PASS", "Attendance status disply successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Attendance status not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void M_1950_Minop_Mobile_Attendance_09() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to add attendance correction successfully when all correct values are filled in all fields and user click on save button");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC,
				"user,password,domain,inhourtime,outhourtime,minute");

		String user, password, domain, inhourtime, outhourtime, minute;
		user = data.get(0);
		password = data.get(1);
		domain = data.get(2);
		inhourtime = data.get(3);
		outhourtime = data.get(4);
		minute = data.get(5);

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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction Pop Up window should open");
		} else {
			logResults.createLogs("Y", "Fail", "Attendance Correction Pop up window should not be open: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.clickAddCorrectionDate()) {
			logResults.createLogs("Y", "PASS", "Calendar Open Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Calendar not open successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.selectAddCorrectionDate(2)) {
			logResults.createLogs("Y", "PASS", "Date Select Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Date not Select successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterHourTxt(inhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + inhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOutTime()) {
			logResults.createLogs("Y", "PASS", "Click on Out time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on Out time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterOutHourTxt(outhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + outhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		
		if (minopAttendanceCorrectionPage.ClickOnTimeFormat()) {
			logResults.createLogs("Y", "PASS", "Click on Time Format");
		} else {
			logResults.createLogs("Y", "Fail",
					"Time Format not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.SelectPMDrp()) {
			logResults.createLogs("Y", "PASS", "PM value select in dropdown.");
		} else {
			logResults.createLogs("Y", "Fail",
					"PM value not select in dropdown: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterTxtReson()) {
			logResults.createLogs("Y", "PASS", "Reson add successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Reson not display display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Apply button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyDuplicateDataValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Duplicate Message display successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Duplicate Message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void M_1953_Minop_Mobile_Attendance_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that search is working properly");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyOnSearchTxt()) {
			logResults.createLogs("Y", "PASS", "Click on Search box successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Clickable in Search box: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.selectAddCorrectionDate(1)) {
			logResults.createLogs("Y", "PASS", "Date Select Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Date not Select successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyStatusData()) {
			logResults.createLogs("Y", "PASS", "Attendance status disply successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Attendance status not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}
	
	@Test(enabled = true, priority = 9)
	public void M_1954_Mionp_Mobile_Attendance_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify taht when user open the Attendnace Correction page then if data present than data display or not");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyNoResultMsg()) {
			logResults.createLogs("Y", "PASS", "record or No Reasult found display successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Record or no result found not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 10)
	public void M_1955_Mionp_Mobile_Attendance_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that on click on Refresh button all the data display or not");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");

		String user, password, domain;
		user = data.get(0);
		password = data.get(1);
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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyRefreshIconClick()) {
			logResults.createLogs("Y", "PASS", "Refresh Icon Click successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Refresh not Clickable in refresh icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 11)
	public void M_2607_Minop_Mobile_Attendance_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that user is able to do edit attendance correction.");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC,
				"user,password,domain,inhourtime,outhourtime,minute");

		String user, password, domain, inhourtime, outhourtime, minute;
		user = data.get(0);
		password = data.get(1);
		domain = data.get(2);
		inhourtime = data.get(3);
		outhourtime = data.get(4);
		minute = data.get(5);

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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.clickOnViewIcon()) {
			logResults.createLogs("Y", "PASS", "Click on view icon successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"View icon not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOnEditBtn()) {
			logResults.createLogs("Y", "PASS", "Click on view icon successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"View icon not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterHourTxt(inhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + inhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOutTime()) {
			logResults.createLogs("Y", "PASS", "Click on Out time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on Out time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterOutHourTxt(outhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + outhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		
		if (minopAttendanceCorrectionPage.ClickOnTimeFormat()) {
			logResults.createLogs("Y", "PASS", "Click on Time Format");
		} else {
			logResults.createLogs("Y", "Fail",
					"Time Format not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.SelectPMDrp()) {
			logResults.createLogs("Y", "PASS", "PM value select in dropdown.");
		} else {
			logResults.createLogs("Y", "Fail",
					"PM value not select in dropdown: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Apply button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyUpdateMessage()) {
			logResults.createLogs("Y", "PASS", "Update Message display successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Update Message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 12)
	public void M_1948_Minop_Mobile_Attendance_07() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Approved Attendance Correction Status display in the Grid after user added attendance request and Approved by Admin/Reporting person");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC,
				"user,password,domain,userapprove,passwordapprove");

		String user, password, domain, userapprove, passwordapprove;
		user = data.get(0);
		password = data.get(1);
		domain = data.get(2);
		userapprove = data.get(3);
		passwordapprove = data.get(4);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(userapprove)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + userapprove);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(passwordapprove);
		if (minopLoginPage.enterPassword(passwordapprove)) {
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

		if (minopHomePage.clickOnApproveAttendance()) {
			logResults.createLogs("Y", "PASS", "Click Approve Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveAttendancePage.verifyApproveAttendancePageName()) {
			logResults.createLogs("Y", "PASS", "Attendance Approve Page open successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not open Attendance Approve page: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopApproveAttendancePage.ClickChkBoxApprove()) {
			logResults.createLogs("Y", "PASS", "Click On Checkbox in Approve");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Checkbox not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopApproveAttendancePage.VerifyClickApproveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Approve button");
		} else {
			logResults.createLogs("Y", "Fail",
					"Approve button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopApproveAttendancePage.VerifyApproveSuceesMsg()) {
			logResults.createLogs("Y", "PASS", "Success message display successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Success message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.VerifyLogOutAccount()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		String maskePassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskePassword);
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyDisplayData()) {
			logResults.createLogs("Y", "PASS", "Data displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not displayed: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 13)
	public void M_1949_Minop_Mobile_Attendance_08() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Rejected Attendance Correction Status display in the Grid after user added Attendance Correction request and Rejected by Admin/Reporting person");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC,
				"user,password,domain,inhourtime,outhourtime,minute,userapprove,passwordapprove");

		String user, password, domain, inhourtime, outhourtime, minute, userapprove, passwordapprove;
		user = data.get(0);
		password = data.get(1);
		domain = data.get(2);
		inhourtime = data.get(3);
		outhourtime = data.get(4);
		minute = data.get(5);
		userapprove = data.get(6);
		passwordapprove = data.get(7);

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
		String maskedPassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.verifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction Pop Up window should open");
		} else {
			logResults.createLogs("Y", "Fail", "Attendance Correction Pop up window should not be open: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.clickAddCorrectionDate()) {
			logResults.createLogs("Y", "PASS", "Calendar Open Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Calendar not open successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.selectRejectAddCorrectionDate(3)) {
			logResults.createLogs("Y", "PASS", "Date Select Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Date not Select successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterHourTxt(inhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + inhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOutTime()) {
			logResults.createLogs("Y", "PASS", "Click on Out time field Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on Out time field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickSwitchInTime()) {
			logResults.createLogs("Y", "PASS", "Click on In time field Switch icon.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Click on In time field Switch icon: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterOutHourTxt(outhourtime)) {
			logResults.createLogs("Y", "PASS", "Enter the hour in field." + outhourtime);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the hours field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterMinutTxt(minute)) {
			logResults.createLogs("Y", "PASS", "Enter the Minute in field." + minute);
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Enter the Minute field: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		
		if (minopAttendanceCorrectionPage.ClickOnTimeFormat()) {
			logResults.createLogs("Y", "PASS", "Click on Time Format");
		} else {
			logResults.createLogs("Y", "Fail",
					"Time Format not Clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.SelectPMDrp()) {
			logResults.createLogs("Y", "PASS", "PM value select in dropdown.");
		} else {
			logResults.createLogs("Y", "Fail",
					"PM value not select in dropdown: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickOkBtn()) {
			logResults.createLogs("Y", "PASS", "Click on OK button.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Ok button clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.enterTxtReson()) {
			logResults.createLogs("Y", "PASS", "Reson add successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Reson not display display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyClickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Apply button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifySuccessValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Success Message display successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Success Message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.VerifyLogOutAccount()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(userapprove)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + userapprove);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPasswordtest = initBase.maskPassword(passwordapprove);
		if (minopLoginPage.enterPassword(passwordapprove)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPasswordtest);
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

		if (minopHomePage.clickOnApproveAttendance()) {
			logResults.createLogs("Y", "PASS", "Click Approve Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

//		if (minopApproveAttendancePage.verifyApprovePrevPopupOpen()) {
//			logResults.createLogs("Y", "PASS", "Popu or calander open");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Popu or calander not open: " + minopAttendanceCorrectionPage.getExceptionDesc());
//		}

		if (minopApproveAttendancePage.verifyApproveAttendancePageName()) {
			logResults.createLogs("Y", "PASS", "Attendance Approve Page open successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not open Attendance Approve page: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopApproveAttendancePage.ClickChkBoxApprove()) {
			logResults.createLogs("Y", "PASS", "Click On Checkbox in Approve");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Checkbox not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopApproveAttendancePage.VerifyClickApproveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Approve button");
		} else {
			logResults.createLogs("Y", "Fail",
					"Approve button not clickable: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopApproveAttendancePage.VerifyApproveSuceesMsg()) {
			logResults.createLogs("Y", "PASS", "Success message display successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Success message not display: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Left Menu is not displayed: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopHomePage.VerifyLogOutAccount()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Left Menu is not displayed: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}

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
		String maskePassword = initBase.maskPassword(password);
		if (minopLoginPage.enterPassword(password)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskePassword);
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

		if (minopHomePage.verifyAttendanceCorrection()) {
			logResults.createLogs("Y", "PASS", "Click Attendance Correction Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Attendance Correction Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyAddCorrectionTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Correction title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Attendance Correction title is not displayed: "
					+ minopAttendanceCorrectionPage.getExceptionDesc());
		}

		if (minopAttendanceCorrectionPage.verifyDisplayData()) {
			logResults.createLogs("Y", "PASS", "Data displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not displayed: " + minopAttendanceCorrectionPage.getExceptionDesc());
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
