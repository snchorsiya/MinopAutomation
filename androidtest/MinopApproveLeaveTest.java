package androidtest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopApproveLeavePage;
import androidpage.MinopHomePage;
import androidpage.MinopLeaveRequestPage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopApproveLeaveTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage;
	MinopHomePage minopHomePage;
	MinopLeaveRequestPage minopLeaveRequestPage;
	MinopApproveLeavePage minopApproveLeavePage;

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
		minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
		minopApproveLeavePage = new MinopApproveLeavePage(driver);
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
	public void M_1926_Minop_Mobile_Approve_Leave_01() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Leave Request page opens when user open the Leave request page");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Approve Leave Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve title is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 2)
	public void M_1927_Minop_Mobile_Approve_Leave_02() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that Pop Up Open when user click on the Approve Button.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Approve Leave Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve title is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIcon()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve View Icon displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve View Icon is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIconClick()) {
			logResults.createLogs("Y", "PASS", "View Icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"View Icon is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApproveBtnClick()) {
			logResults.createLogs("Y", "PASS", "Approve button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Approve button is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApprovePopup()) {
			logResults.createLogs("Y", "PASS", "Popup open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Popup not open: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 3)
	public void M_1928_Minop_Mobile_Approve_Leave_03() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that leave successfully approved after user click on save button.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Approve Leave Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve title is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIcon()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve View Icon displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve View Icon is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIconClick()) {
			logResults.createLogs("Y", "PASS", "View Icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"View Icon is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApproveBtnClick()) {
			logResults.createLogs("Y", "PASS", "Approve button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Approve button is not clickable: " + minopLoginPage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApprovePopup()) {
			logResults.createLogs("Y", "PASS", "Popup open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Popup not open: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestPopupTextAreaReason()) {
			logResults.createLogs("Y", "PASS", "Add Comment for Apply leave in text");
		} else {
			logResults.createLogs("Y", "FAIL", "Comment not add in Leave " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.clickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveApprovedSuccessMsg()) {
			logResults.createLogs("Y", "PASS", "Leave Approve successfully message display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Approve successfully message not display: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 4)
	public void M_1929_Minop_Mobile_Approve_Leave_04() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that leave successfully approved after user click on save button.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC, "user,password,domain");

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

		if (minopHomePage.verifyLeaveRequest()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyApprovedStatus()) {
			logResults.createLogs("Y", "PASS", "Approved Status displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Approve Status is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 5)
	public void M_1930_Minop_Mobile_Approve_Leave_05() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that Pop Up Open when user click on the reject Button.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Approve Leave Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve title is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIcon()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve View Icon displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve View Icon is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIconClick()) {
			logResults.createLogs("Y", "PASS", "View Icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"View Icon is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestRejectBtnClick()) {
			logResults.createLogs("Y", "PASS", "Reject button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Reject button is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApprovePopup()) {
			logResults.createLogs("Y", "PASS", "Popup open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Popup not open: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void M_1931_Minop_Mobile_Approve_Leave_06() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that leave successfully rejected after user click on save button.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Approve Leave Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Not Click Approve Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve title is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIcon()) {
			logResults.createLogs("Y", "PASS", "Leave Request Approve View Icon displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request Approve View Icon is not displayed: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestViewIconClick()) {
			logResults.createLogs("Y", "PASS", "View Icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"View Icon is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestRejectBtnClick()) {
			logResults.createLogs("Y", "PASS", "Reject button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Reject button is not clickable: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestApprovePopup()) {
			logResults.createLogs("Y", "PASS", "Popup open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Popup not open: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRequestPopupTextAreaReason()) {
			logResults.createLogs("Y", "PASS", "Add Comment for Apply leave in text");
		} else {
			logResults.createLogs("Y", "FAIL", "Comment not add in Leave " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.clickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyLeaveRejectSuccessMsg()) {
			logResults.createLogs("Y", "PASS", "Leave Reject successfully message display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Reject successfully message not display: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void M_1932_Minop_Mobile_Approve_Leave_07() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that what Leave status display in Grid after user has reject the leave");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC, "user,password,domain");

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

		if (minopHomePage.verifyLeaveRequest()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyRejectedStatus()) {
			logResults.createLogs("Y", "PASS", "Rejected Status displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Rejected Status is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void M_1956_Mionp_Mobile_Approve_Leave_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that on click on Refresh button all the data display or not");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyRefreshIcon()) {
			logResults.createLogs("Y", "PASS", "Refresh Icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Refresh Icon not click: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyDataInGrid()) {
			logResults.createLogs("Y", "PASS", "Data display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not display: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void M_2602_Minop_Mobile_Approve_Leave_16() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that when user select on Select all checkbox then all pending leave request should be selected.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyAllCheckBox()) {
			logResults.createLogs("Y", "PASS", "All CheckBox Checked");
		} else {
			logResults.createLogs("Y", "FAIL", "CheckBox not Checked: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 10)
	public void M_2603_Minop_Mobile_Approve_Leave_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: \r\n"
				+ "Check that when user select on Select all checkbox then user is able to approve all pending leave request.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyAllCheckBox()) {
			logResults.createLogs("Y", "PASS", "All CheckBox Checked");
		} else {
			logResults.createLogs("Y", "FAIL", "CheckBox not Checked: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyFrontApprove()) {
			logResults.createLogs("Y", "PASS", "Approve button click");
		} else {
			logResults.createLogs("Y", "FAIL", "Approve button not click: " + minopApproveLeavePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 11)
	public void M_2604_Minop_Mobile_Approve_Leave_18() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: \r\n"
				+ "Check that when user select on Select all checkbox then user is able to Reject all pending leave request.");
		ArrayList<String> data = initBase.loadExcelData("Approve_Leave", currTC,
				"user_approve,password_approve,domain");

		String user_approve, password_approve, domain;
		user_approve = data.get(0);
		password_approve = data.get(1);
		domain = data.get(2);

		if (minopLoginPage.enterDomin(domain)) {
			logResults.createLogs("Y", "PASS", "Domain Name Entered in Text Box: " + domain);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering domain name: " + minopLoginPage.getExceptionDesc());
		}
		if (minopLoginPage.enterUser(user_approve)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user_approve);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		}
		String maskedPassword = initBase.maskPassword(password_approve);
		if (minopLoginPage.enterPassword(password_approve)) {
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

		if (minopHomePage.verifyApproveLeave()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyAllCheckBox()) {
			logResults.createLogs("Y", "PASS", "All CheckBox Checked");
		} else {
			logResults.createLogs("Y", "FAIL", "CheckBox not Checked: " + minopApproveLeavePage.getExceptionDesc());
		}

		if (minopApproveLeavePage.verifyFrontReject()) {
			logResults.createLogs("Y", "PASS", "Reject button click");
		} else {
			logResults.createLogs("Y", "FAIL", "Reject button not click: " + minopApproveLeavePage.getExceptionDesc());
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
