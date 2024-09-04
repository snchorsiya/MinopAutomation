package androidtest;

import java.sql.SQLException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopApproveAttendancePage;
import androidpage.MinopAttendanceCorrectionPage;
import androidpage.MinopHomePage;
import androidpage.MinopLeaveRequestPage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;
import utils.Utils;

public class MinopLeaveRequestTest_Part2 {
	WebDriver driver;
	Utils utils = new Utils(driver);
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage;
	MinopLeaveRequestPage minopLeaveRequestPage;
	MinopHomePage minopHomePage;
	MinopAttendanceCorrectionPage minopAttendanceCorrectionPage;
	MinopApproveAttendancePage minopApproveAttendancePage;

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
		minopHomePage = new MinopHomePage(driver);
		minopAttendanceCorrectionPage = new MinopAttendanceCorrectionPage(driver);
		minopApproveAttendancePage = new MinopApproveAttendancePage(driver);
		utils = new Utils(driver);
		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device" })
	@BeforeClass
	void runOnce(int device) {
		logResults.createReport();
		logResults.setTestMethodErrorCount(0);
	}

	@BeforeTest
	public void Connection_configuration() {
		utils.Connection_configuration();
	}

	@Test(enabled = true, priority = 1)
	public void M_2639_Minop_Mobile_Leave_Request_28() throws InterruptedException {
		String query = "SET SQL_SAFE_UPDATES=0;";
		String leave = "DELETE FROM MIN8B5E.tblleave WHERE Empid=1;";
//		utils.updateMYSQL(utils.dbURL, query);
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that user is able apply leave with different date formats.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		MinopLeaveRequestPage minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
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
		if (minopHomePage.verifyLeaveRequest()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Leave Request Page Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyleaverequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Click on Add Icon Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Add Icon not clickable: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyAddLeaveRequestPage()) {
			logResults.createLogs("Y", "PASS", "Add Leave Request Page displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Leave Request Page is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyClDrpLeave()) {
			logResults.createLogs("Y", "PASS", "Leave Dropdown Open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave Dropdown not open: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyFromDate(7) && minopLeaveRequestPage.VerifyToDate(7)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.enterLeaveReason()) {
			logResults.createLogs("Y", "PASS", "Leave Reason Entered in Text Box: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering reason name: " + minopLeaveRequestPage.getExceptionDesc());
		}
		if (minopLeaveRequestPage.clickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Apply button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click on Apply button: " + minopLeaveRequestPage.getExceptionDesc());
		}
		if (minopLeaveRequestPage.VerifySuccessMsgAddLeave()) {
			logResults.createLogs("Y", "PASS", "Save message successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save message not successfully: " + minopLeaveRequestPage.getExceptionDesc());
		}
//		String query = "SET SQL_SAFE_UPDATES=0;";
//		String leave = "DELETE FROM MIN8B5E.tblleave WHERE Empid=1;";
		System.out.println("Executing query: " + query);
		System.out.println("Executing query: " + leave);
		try {
			utils.getStatement().execute(query);
			System.out.println("Query executed: " + query);
			utils.getStatement().execute(leave);
			System.out.println("Query executed: " + leave);
		} catch (SQLException e) {
			System.err.println("SQL Exception during query execution");
			e.printStackTrace();
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_2599_Minop_Mobile_Leave_Request_27() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able apply leave for previous month when attendance is locked for that day.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		MinopLeaveRequestPage minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
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
		if (minopHomePage.verifyLeaveRequest()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Leave Request Page Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyleaverequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyClickOnAddIcon()) {
			logResults.createLogs("Y", "PASS", "Click on Add Icon Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Add Icon not clickable: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyAddLeaveRequestPage()) {
			logResults.createLogs("Y", "PASS", "Add Leave Request Page displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Leave Request Page is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyClDrpLeave()) {
			logResults.createLogs("Y", "PASS", "Leave Dropdown Open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave Dropdown not open: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyFromDate(4) && minopLeaveRequestPage.VerifyToDate(4)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		/*
		 * if (minopLeaveRequestPage.verifyFromPrevDateLeave()) {
		 * logResults.createLogs("Y", "PASS",
		 * "Preve month to data select successfully"); } else {
		 * logResults.createLogs("Y", "FAIL", "Preve month to data not select: " +
		 * minopLeaveRequestPage.getExceptionDesc()); }
		 * 
		 * if (minopLeaveRequestPage.clickApplyBtn()) { logResults.createLogs("Y",
		 * "PASS", "Click on Apply button"); } else { logResults.createLogs("Y", "FAIL",
		 * "Not Click on Apply button: " + minopLeaveRequestPage.getExceptionDesc()); }
		 */
		if (minopLeaveRequestPage.verifyLockedAttendanceToast()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
//		String query = "SET SQL_SAFE_UPDATES=0;";
//		String attendance = "update min8b5e.tblsystemsettingmaster set lockAttendanceDay = '';";
//
//		// Execute the SQL query
//		try {
//			st_obj.execute(query);
//			st_obj.execute(attendance);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test(enabled = true, priority = 3)
	public void M_2605_Minop_Mobile_Attendance_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to do attendance correction when attendance is locked for that day..");
		ArrayList<String> data = initBase.loadExcelData("Attendance_Correction", currTC, "user,password,domain");
		MinopLoginPage minopLoginPage = new MinopLoginPage(driver);
		MinopHomePage minopHomePage = new MinopHomePage(driver);
		MinopLeaveRequestPage minopLeaveRequestPage = new MinopLeaveRequestPage(driver);

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
		/*
		 * if (minopLeaveRequestPage.verifyFromPrevDateLeave()) {
		 * logResults.createLogs("Y", "PASS",
		 * "Preve month to data select successfully"); } else {
		 * logResults.createLogs("Y", "FAIL", "Preve month to data not select: " +
		 * minopLeaveRequestPage.getExceptionDesc()); }
		 * 
		 * if (minopLeaveRequestPage.clickApplyBtn()) { logResults.createLogs("Y",
		 * "PASS", "Click on Apply button"); } else { logResults.createLogs("Y", "FAIL",
		 * "Not Click on Apply button: " + minopLeaveRequestPage.getExceptionDesc()); }
		 */
		if (minopLeaveRequestPage.verifyLockedAttendanceToast()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
//		String query = "SET SQL_SAFE_UPDATES=0;";
//		String attendance = "update min8b5e.tblsystemsettingmaster set lockAttendanceDay = '';";
//
//		// Execute the SQL query
//		try {
//			st_obj.execute(query);
//			st_obj.execute(attendance);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test(enabled = true, priority = 4)
	public void M_2642_Minop_Mobile_Attendance_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to do apply attendance correction with different date formats.");
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

		if (minopAttendanceCorrectionPage.selectAddCorrectionDate(6)) {
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
	public void M_2643_Minop_Mobile_Attendance_18() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to do edit attendance correction with different date formats.");
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

		if (minopAttendanceCorrectionPage.verifyOnSearchTxt()) {
			logResults.createLogs("Y", "PASS", "Click on Search box successfully");
		} else {
			logResults.createLogs("Y", "Fail",
					"Not Clickable in Search box: " + minopAttendanceCorrectionPage.getExceptionDesc());
		}
		if (minopAttendanceCorrectionPage.selectAddCorrectionDate(6)) {
			logResults.createLogs("Y", "PASS", "Date Select Successfully.");
		} else {
			logResults.createLogs("Y", "Fail",
					"Date not Select successfully: " + minopAttendanceCorrectionPage.getExceptionDesc());
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

	@AfterTest
	public void Close_DBconnection() {
		utils.closeConnection();
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
