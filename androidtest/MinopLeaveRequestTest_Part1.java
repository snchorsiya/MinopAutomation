package androidtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import androidpage.MinopHomePage;
import androidpage.MinopLeaveRequestPage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopLeaveRequestTest_Part1 {

	private Connection con_obj;
	private Statement st_obj;

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage;
	MinopHomePage minopHomePage;
	MinopLeaveRequestPage minopLeaveRequestPage;

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
		minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
		logResults.setDriver(driver);
		logResults.setScenarioName("");
	}

	@Parameters({ "device" })
	@BeforeClass
	void runOnce(int device) {
		logResults.createReport();
		logResults.setTestMethodErrorCount(0);
	}

	/*
	 * @BeforeTest public void Connection_configuration() { try { String
	 * driver_ClassName = "com.mysql.cj.jdbc.Driver";
	 * Class.forName(driver_ClassName);
	 * 
	 * String url = "jdbc:mysql://192.168.5.62:3306/paytimewebmaster"; String
	 * user_name = "saas"; String user_password = "mantra123";
	 * 
	 * con_obj = DriverManager.getConnection(url, user_name, user_password);
	 * 
	 * st_obj = con_obj.createStatement();
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); } }
	 */

	@Test(enabled = true, priority = 1)
	public void M_1911_Minop_Mobile_Leave_Request_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Leave Request page opens when user open the Leave request page");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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
			logResults.createLogs("Y", "PASS", "Leave Request title displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request title is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 2)
	public void M_1912_Minop_Mobile_Leave_Request_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that No result found text display in Leave Request page when user open the Leave request page there is no any record present");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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
		new WebDriverWait(driver, Duration.ofSeconds(10));

		if (minopLeaveRequestPage.verifyleaverequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyNoResultFoundMsg()) {
			logResults.createLogs("Y", "PASS", "No Result Found message displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"No Result Found message is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 3)
	public void M_1913_Minop_Mobile_Leave_Request_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that Add Leave Request page opens when user click on + button in Leave Request page");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

	}

	@Test(enabled = true, priority = 4)
	public void M_1914_Minop_Mobile_Leave_Request_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that validation message display when user click on apply button without filling mendatory fields");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain,message");

		MinopLeaveRequestPage minopLeaveRequestPage = new MinopLeaveRequestPage(driver);

		String user, pass, domain, message;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		message = data.get(3);

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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
		new WebDriverWait(driver, Duration.ofSeconds(10));
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
		Thread.sleep(2000);

		if (minopLeaveRequestPage.clickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL", "Apply button not click " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyToastMsgAddLeave()) {
			logResults.createLogs("Y", "PASS", "Toast Message displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Toast Message is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 5)
	public void M_1915_Minop_Mobile_Leave_Request_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that leave is added successfully when user enter valid data in all fields and then click on Apply button");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyFromDate(0) && minopLeaveRequestPage.VerifyToDate(0)) {
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
			logResults.createLogs("Y", "PASS", "Apply button click successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL", "Apply button not click " + minopLeaveRequestPage.getExceptionDesc());
		}

//		if (minopLeaveRequestPage.VerifySuccessMsgAddLeave()) {
//			logResults.createLogs("Y", "PASS", "Save message successfully display: ");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Save message not successfully display: " + minopLeaveRequestPage.getExceptionDesc());
//		}
		
		if (minopLeaveRequestPage.VerifyLeavedisplay()) {
			logResults.createLogs("Y", "PASS", "Leave displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void M_1916_Minop_Mobile_Leave_Request_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Verify that successfully added leave display in the Leave request page");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyLeavedisplay()) {
			logResults.createLogs("Y", "PASS", "Leave displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void M_1918_Minop_Mobile_Leave_Request_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that User is able to add leave when Leave Balance is 0 and leave type selected as UnPaid");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifytlDrpLeave()) {
			logResults.createLogs("Y", "PASS", "Leave Dropdown Open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave Dropdown not open: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyFromDate(0) && minopLeaveRequestPage.VerifyToDate(0)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyLeavTypeUnpaid()) {
			logResults.createLogs("Y", "PASS", "Unpaid Leave type display: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Unpaid Leave type not display: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void M_1919_Minop_Mobile_Leave_Request_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that validation message display when user enter either same From date or To date on which date leave is already added ");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		Thread.sleep(2000);

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

		if (minopLeaveRequestPage.VerifyFromDate(0) && minopLeaveRequestPage.VerifyToDate(0)) {
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
			logResults.createLogs("Y", "PASS", "Apply button click successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL", "Apply button not click " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyAlreadyExitMsgAddLeave()) {
			logResults.createLogs("Y", "PASS", "Already  exist message successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Already exist message not display: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void M_1921_Minop_Mobile_Leave_Request_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults
				.setScenarioName("Scenario: Verify that pending status is display after user successfully added leave");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyPendingStatus()) {
			logResults.createLogs("Y", "PASS", "Pending displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Pending is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 10)
	public void M_1922_Minop_Mobile_Leave_Request_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to view Leave Request when user click on View button");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.verifyleaveViewIcon()) {
			logResults.createLogs("Y", "PASS", "Leave Request View Icon displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request View Icon is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyleaveViewTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request View Page displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request View Page is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 11)
	public void M_1923_Minop_Mobile_Leave_Request_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is able to search Leave Request as per date selected from the calendar");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
			return; // Early return if domain entry fails
		}
		if (minopLoginPage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
			return; // Early return if user entry fails
		}
		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginPage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
			return; // Early return if password entry fails
		}
		if (minopLoginPage.clickLoginBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());
			return; // Early return if login button click fails
		}
		if (minopHomePage.verifyEmpName()) {
			logResults.createLogs("Y", "PASS", "Employee Name displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee Name is not displayed: " + minopHomePage.getExceptionDesc());
			return; // Early return if employee name verification fails
		}
		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
			return; // Early return if left menu verification fails
		}
		if (minopHomePage.verifyLeaveRequest()) {
			logResults.createLogs("Y", "PASS", "Click Leave Request Page successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Click Leave Request Page: " + minopHomePage.getExceptionDesc());
			return; // Early return if leave request page click fails
		}
		if (minopLeaveRequestPage.verifyleaverequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
			return; // Early return if leave request title verification fails
		}

		Thread.sleep(1000);
		if (minopLeaveRequestPage.verifyleaveSearch(0)) {
			logResults.createLogs("Y", "PASS", "Calendar displayed in Searchbox successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Calendar not displayed in searchbox: " + minopLeaveRequestPage.getExceptionDesc());
			return; // Early return if calendar in searchbox fails
		}
		if (minopLeaveRequestPage.verifyleaveSearchData()) {
			logResults.createLogs("Y", "PASS", "Leave displayed successfully as per search");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave is not displayed as per search: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 12)
	public void M_1924_Minop_Mobile_Leave_Request_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that on click on cancel button Add Leave request page is closed and Leave request page is display");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.verifyleavecancelBtn()) {
			logResults.createLogs("Y", "PASS", "Cancel button click proper");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Cancel button not clickable: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyleaverequestTitle()) {
			logResults.createLogs("Y", "PASS", "Leave Request displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Request is not displayed: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 13)
	public void M_1925_Minop_Mobile_Leave_Request_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that correct leave Balance and carry forward leave and Total Leaves count display in Add Leave Request page");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyFromDate(0) && minopLeaveRequestPage.VerifyToDate(0)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyLeaveBalance()) {
			logResults.createLogs("Y", "PASS", "Leave Balance display successfully ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Leave Balance not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 14)
	public void M_2588_Minop_Mobile_Leave_Request_16() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that when user apply leave for 1 day but select document required for 2 days selected leave in leave type from web and then upload document field is display.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyFromDate(3) && minopLeaveRequestPage.VerifyToDate(4)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyChooseFileDisplay()) {
			logResults.createLogs("Y", "PASS", "Upload Document Display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Upload Document not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 15)
	public void M_2589_Minop_Mobile_Leave_Request_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that when user apply leave for 2 day and select document required for 2 days selected leave in leave type from web and then upload document field is display.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyFromDate(3) && minopLeaveRequestPage.VerifyToDate(4)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyChooseFile()) {
			logResults.createLogs("Y", "PASS", "Upload Document Display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Upload Document not display: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifychooseFileDisplay()) {
			logResults.createLogs("Y", "PASS", "Choose File Display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Choose file not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 16)
	public void M_2590_Minop_Mobile_Leave_Request_18_M_2592_Minop_Mobile_Leave_Request_20()
			throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that leave is successfully applied when user upload document rather then jpg, png, image, pdf file format.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyFromDate(7) && minopLeaveRequestPage.VerifyToDate(10)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyChooseFile()) {
			logResults.createLogs("Y", "PASS", "Upload Document Display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Upload Document not display: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifychooseFileDisplay()) {
			logResults.createLogs("Y", "PASS", "Choose File Display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Choose file not display: " + minopLeaveRequestPage.getExceptionDesc());
		}
		if (minopLeaveRequestPage.enterLeaveReason()) {
			logResults.createLogs("Y", "PASS", "Leave Reason Entered in Text Box: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering reason name: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.clickApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Apply button click successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL", "Apply button not click " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifySuccessMsgAddLeave()) {
			logResults.createLogs("Y", "PASS", "Save message successfully: ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save message not successfully: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 17)
	public void M_2593_Minop_Mobile_Leave_Request_21() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that if document required for 1 day leave and user apply 1 half day leave then upload document field is display or not.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyALDrpLeave()) {
			logResults.createLogs("Y", "PASS", "Leave Dropdown Open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave Dropdown not open: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.VerifyFromDate(0) && minopLeaveRequestPage.VerifyToDate(0)) {
			logResults.createLogs("Y", "PASS", "From Date and To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"From Date or To Date not select: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyCheckCheckboxHalfDay()) {
			logResults.createLogs("Y", "PASS", "Check box check successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Check box not Checked: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyCheckChooseFileDisplay()) {
			logResults.createLogs("Y", "PASS", "Upload file not display");
		} else {
			logResults.createLogs("Y", "FAIL", "Upload file display: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 18)
	public void M_2594_Minop_Mobile_Leave_Request_22_M_2595_Minop_Mobile_Leave_Request_23()
			throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that if document required for 1 day leave and user apply 2 half day leave then upload document field is display or not.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyodTwoHalfLeaveDocu()) {
			logResults.createLogs("Y", "PASS", "Leave Dropdown Open successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Leave Dropdown not open: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopLeaveRequestPage.verifyCheckChooseFileDisplay()) {
			logResults.createLogs("Y", "PASS", "Upload file not display");
		} else {
			logResults.createLogs("Y", "FAIL", "Upload file display: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 19)
	public void M_2598_Minop_Mobile_Leave_Request_26() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that when user select OD leave then in leave type by default Paid leave type is display.");
		ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC, "user,password,domain");

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
//			logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + exceptionDesc);
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

		if (minopLeaveRequestPage.VerifyODLeavePaid()) {
			logResults.createLogs("Y", "PASS", "Paid Leave type value display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Paid Leave type value not display: " + minopLeaveRequestPage.getExceptionDesc());
		}

		if (minopHomePage.verifyLeftMenu()) {
			logResults.createLogs("Y", "PASS", "Left Menu displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " + minopHomePage.getExceptionDesc());
		}

		if (minopHomePage.VerifyLogOutAccount()) {
			logResults.createLogs("Y", "PASS", "Logout successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "User not logout: " + minopLeaveRequestPage.getExceptionDesc());
		}

	}

	/*
	 * @Test(enabled = true, priority = 20) public void
	 * M_2599_Minop_Mobile_Leave_Request_27() throws InterruptedException { String
	 * currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
	 * logResults.createExtentReport(currTC); logResults.
	 * setScenarioName("Scenario: Check that user is able apply leave for previous month when attendance is locked for that day."
	 * ); ArrayList<String> data = initBase.loadExcelData("Leave_Request", currTC,
	 * "user,password,domain");
	 * 
	 * MinopLoginPage minopLoginPage = new MinopLoginPage(driver); MinopHomePage
	 * minopHomePage = new MinopHomePage(driver); MinopLeaveRequestPage
	 * minopLeaveRequestPage = new MinopLeaveRequestPage(driver);
	 * 
	 * String user, pass, domain; user = data.get(0); pass = data.get(1); domain =
	 * data.get(2);
	 * 
	 * try { String query = "SET SQL_SAFE_UPDATES=0;"; String attendance =
	 * "update min8b5e.tblsystemsettingmaster set lockAttendanceDay = '06';";
	 * 
	 * // Execute the SQL query st_obj.execute(query); st_obj.execute(attendance); }
	 * catch (Exception e) { e.printStackTrace(); }
	 * 
	 * if (minopLoginPage.enterDomin(domain)) { logResults.createLogs("Y", "PASS",
	 * "Domain Name Entered in Text Box: " + domain); } else {
	 * logResults.createLogs("Y", "FAIL", "Error while entering domain name: " +
	 * minopLoginPage.getExceptionDesc()); } if (minopLoginPage.enterUser(user)) {
	 * logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
	 * } else { logResults.createLogs("Y", "FAIL",
	 * "Error while entering user name: " + minopLoginPage.getExceptionDesc()); }
	 * String maskedPassword = initBase.maskPassword(pass); if
	 * (minopLoginPage.enterPassword(pass)) { logResults.createLogs("Y", "PASS",
	 * "Password Entered in Text Box: " + maskedPassword); } else {
	 * logResults.createLogs("Y", "FAIL", "Error while entering user password: " +
	 * exceptionDesc); } if (minopLoginPage.clickLoginBtn()) {
	 * logResults.createLogs("Y", "PASS", "Click on Sign In Button"); } else {
	 * logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " +
	 * minopLoginPage.getExceptionDesc()); } // if (minopLoginPage.handlePopups()) {
	 * // logResults.createLogs("Y", "PASS", "Handled all popups successfully"); //
	 * } else { // logResults.createLogs("Y", "INFO",
	 * "No popups to handle or failed to handle popups: " + exceptionDesc); // } if
	 * (minopHomePage.verifyEmpName()) { logResults.createLogs("Y", "PASS",
	 * "Employee Name displayed successfully"); } else { logResults.createLogs("Y",
	 * "FAIL", "Employee Name is not displayed: " +
	 * minopHomePage.getExceptionDesc()); } if (minopHomePage.verifyLeftMenu()) {
	 * logResults.createLogs("Y", "PASS", "Left Menu displayed successfully"); }
	 * else { logResults.createLogs("Y", "FAIL", "Left Menu is not displayed: " +
	 * minopHomePage.getExceptionDesc()); }
	 * 
	 * if (minopHomePage.verifyLeaveRequest()) { logResults.createLogs("Y", "PASS",
	 * "Click Leave Request Page successfully"); } else { logResults.createLogs("Y",
	 * "FAIL", "Not Click Leave Request Page Page: " +
	 * minopHomePage.getExceptionDesc()); }
	 * 
	 * if (minopLeaveRequestPage.verifyleaverequestTitle()) {
	 * logResults.createLogs("Y", "PASS", "Leave Request displayed successfully"); }
	 * else { logResults.createLogs("Y", "FAIL", "Leave Request is not displayed: "
	 * + minopLeaveRequestPage.getExceptionDesc()); }
	 * 
	 * if (minopLeaveRequestPage.VerifyAddLeaveRequestPage()) {
	 * logResults.createLogs("Y", "PASS",
	 * "Add Leave Request Page displayed successfully"); } else {
	 * logResults.createLogs("Y", "FAIL",
	 * "Add Leave Request Page is not displayed: " + exceptionDesc); }
	 * 
	 * if (minopLeaveRequestPage.VerifyClDrpLeave()) { logResults.createLogs("Y",
	 * "PASS", "Leave Select successfully"); } else { logResults.createLogs("Y",
	 * "FAIL", "Leave not Select: " + exceptionDesc); }
	 * 
	 * if (minopLeaveRequestPage.verifyPrevDateLeave()) { logResults.createLogs("Y",
	 * "PASS", "Preve month data select successfully"); } else {
	 * logResults.createLogs("Y", "FAIL", "Preve month data not select: " +
	 * exceptionDesc); }
	 * 
	 * if (minopLeaveRequestPage.verifyLockedAttendanceToast()) {
	 * logResults.createLogs("Y", "PASS",
	 * "Validation message display successfully"); } else {
	 * logResults.createLogs("Y", "FAIL", "Validation message not display: " +
	 * exceptionDesc); }
	 * 
	 * String query = "SET SQL_SAFE_UPDATES=0;"; String attendance =
	 * "update min8b5e.tblsystemsettingmaster set lockAttendanceDay = '';";
	 * 
	 * // Execute the SQL query try { st_obj.execute(query);
	 * st_obj.execute(attendance); } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	@AfterTest
	public void Close_DBconnection() {
		try {
			if (con_obj != null) {
				con_obj.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
