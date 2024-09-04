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
import androidpage.MinopHomePage;
import androidpage.MinopLoginPage;
import base.LoadDriver;
import base.LogResults;
import base.initBase;

public class MinopLoginTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginPage minopLoginPage;
	MinopHomePage minopHomePage;
	MinopForgotPasswordPage minopForgotPasswordPage;

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		driver = loadDriver.getDriver(device);
		minopLoginPage = new MinopLoginPage(driver);
		minopHomePage = new MinopHomePage(driver);
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
	public void M_1963_Minop_Login_01() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login with valid Company code, Email Address, and valid password");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

		String user = data.get(0);
		String pass = data.get(1);
		String domain = data.get(2);

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
//			logResults.logResults.createLogs("Y", "PASS", "Handled all popups successfully");
//		} else {
//			logResults.logResults.createLogs("Y", "INFO", "No popups to handle or failed to handle popups: " + minopLoginPage.getExceptionDesc());
//		}

		if (minopHomePage.verifyEmpName()) {
			logResults.createLogs("Y", "PASS", "Employee Name displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee Name is not displayed: " + minopHomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_1964_Minop_Login_02() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login with invalid Email Address/PunchID/EmpCode and valid password and Company code");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

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

		if (minopLoginPage.verifyUserNotExistMessage())
			logResults.createLogs("Y", "PASS", "Message Error ! User Not Exist. is displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Message Error ! User Not Exist. is not displayed :" + minopLoginPage.getExceptionDesc());

	}

	@Test(enabled = true, priority = 3)
	public void M_1965_Minop_Login_03() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login for Employee Account with valid Account Code/Domain Name,Email Address and invalid password");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain,message");

		String user, pass, domain, message;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		message = data.get(3);

		;

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

		if (minopLoginPage.verifyInvalidEmailIDMessage(message))
			logResults.createLogs("Y", "PASS",
					"Message Error ! Invalid Email/PunchID/EmployeeCode/Password. is displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Message Error ! Invalid Email/PunchID/EmployeeCode/Password. is not displayed :"
							+ minopLoginPage.getExceptionDesc());
	}

	@Test(enabled = true, priority = 4)
	public void M_1966_Minop_Login_05() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login with blank Email Address and valid password,Company Code");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);

		;

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

	}

	@Test(enabled = true, priority = 5)
	public void M_1967_Minop_Login_06() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login for Employee Account with valid Email Address,Account Code/Domain name and blank password");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

		String user, pass, domain;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);

		;

		if (minopLoginPage.enterDomin(domain))
			logResults.createLogs("Y", "PASS", "Domin Name Entered in Text Box: " + domain);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering domin name: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.enterUser(user))
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());
		String maskedPassword = initBase.maskPassword(pass);

		if (minopLoginPage.enterPassword(pass))
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		else
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.clickLoginBtn())
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		else
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());

	}

	@Test(enabled = true, priority = 6)
	public void M_1968_Minop_Login_07() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login for Employee Account with blank Email Address and blank password and valid Company Code");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

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

	}

	@Test(enabled = true, priority = 7)
	public void M_1969_Minop_Login_08() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login for Employee Account with blank Company Code valid Email Address and valid password");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

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

		if (minopLoginPage.enterPassword(pass))
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		else
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.clickLoginBtn())
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		else
			logResults.createLogs("Y", "FAIL", "Error while Clicking Sign In: " + minopLoginPage.getExceptionDesc());

	}

	@Test(enabled = true, priority = 8)
	public void M_1970_Minop_Login_09() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Check that user is able to do login for Employee Account with Invalid Company Code valid Email Address and valid password");
		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain,message");

		String user, pass, domain, message;
		user = data.get(0);
		pass = data.get(1);
		domain = data.get(2);
		message = data.get(3);

		if (minopLoginPage.enterDomin(domain))
			logResults.createLogs("Y", "PASS", "Domin Name Entered in Text Box: " + domain);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering domin name: " + minopLoginPage.getExceptionDesc());
		if (minopLoginPage.enterUser(user))
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		else
			logResults.createLogs("Y", "FAIL", "Error while entering user name: " + minopLoginPage.getExceptionDesc());

		// Masking the password before logging
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

		if (minopLoginPage.verifyInvalidAccountCodeMessage(message))
			logResults.createLogs("Y", "PASS", "Message Error ! Invalid Account Code. is displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Message Error ! Invalid Account Code. is not displayed :" + minopLoginPage.getExceptionDesc());
	}

	@Test(enabled = true, priority = 9)
	public void M_2695_Minop_Login_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				"Scenario: Verify that user is redirect to the Reset Password page when new employee/ employee whose email and password are same");
//		ArrayList<String> data = initBase.loadExcelData("Login", currTC, "user,password,domain");

		if (minopLoginPage.clickForgotPassLink())
			logResults.createLogs("Y", "PASS", "Click on Forgot Password link");
		else
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Forgot Password : " + minopLoginPage.getExceptionDesc());

		if (minopForgotPasswordPage.verifyForgotPasswordTitle())
			logResults.createLogs("Y", "PASS", "Forgot Password Page Title displayed successfully");
		else
			logResults.createLogs("Y", "FAIL",
					"Forgot Password Page Title is not displayed. " + minopLoginPage.getExceptionDesc());
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

} // EOF
