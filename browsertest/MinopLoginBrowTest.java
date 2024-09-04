package browsertest;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.LoadDriver;
import base.LogResults;
import base.initBase;
import browserpage.MinopHomeChromePage;
import browserpage.MinopLoginChromePage;


public class MinopLoginBrowTest   {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser="chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
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
	public void M_01_Minop_Admin_Login() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Login to chrome");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password");

		String user = data.get(0);
		String pass = data.get(1);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		Thread.sleep(30000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.SelectDrpLockAtt()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Lock Attendance select drop down");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page click on Lock Attendance select not drop down value: "
					+ minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickokBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
		} else {
			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void M_02_Minop_Lock_Attendance_Day() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Attendance Lock");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password");

		String user = data.get(0);
		String pass = data.get(1);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.SelectDrpLockAtt()) {
			logResults.createLogs("Y", "PASS", "Attendanace Lock successfully:");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendanace not Lock successfully: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickokBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
		} else {
			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}
	
	@Test(enabled = true, priority = 2)
	public void M_03_Minop_Change_Date_Format_DD_MMM_YYYY() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format DD-MMM-YYYY");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void M_04_Minop_Change_Date_Format_DD_MM_YYYY() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format DD-MM-YYYY");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void M_05_Minop_Change_Date_Format_MMM_DD_YYYY() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format DD-MMM-YYYY");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void M_06_Minop_Change_Date_Format_MM_DD_YYYY() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format MM_DD_YYYY");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 6)
	public void M_07_Minop_Change_Date_Format_YYYY_MMM_DD() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format YYYY_MMM_DD");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 7)
	public void M_08_Minop_Change_Date_Format_YYYY_MM_DD() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Change the date format YYYY_MM_DD");

		ArrayList<String> data = initBase.loadExcelData("AdminLogin", currTC, "user,password,dateFormat");

		String user = data.get(0);
		String pass = data.get(1);
		String dateFormat = data.get(2);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

		if (minopLoginChromePage.enterUser(user)) {
			logResults.createLogs("Y", "PASS", "User Name Entered in Text Box: " + user);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user name: " + minopLoginChromePage.getExceptionDesc());
		}

		String maskedPassword = initBase.maskPassword(pass);
		if (minopLoginChromePage.enterPassword(pass)) {
			logResults.createLogs("Y", "PASS", "Password Entered in Text Box: " + maskedPassword);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while entering user password: " + minopLoginChromePage.getExceptionDesc());
		}

		if (minopLoginChromePage.clickLoginBtn(user, pass)) {
			logResults.createLogs("Y", "PASS", "Click on Sign In Button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Error while Clicking Sign In: " + minopLoginChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnWized()) {
			logResults.createLogs("Y", "PASS", "Wizard Page open successfully");
			System.out.println("Login Successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Wizard Page is not open: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnNextBtn()) {
			logResults.createLogs("Y", "PASS", "Wizard Page click on Next button");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Wizard Page Next button not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickdateFormatDrp(dateFormat)) {
			logResults.createLogs("Y", "PASS", "Data format dropdown click");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date format dropdown not click: " + minopHomeChromePage.getExceptionDesc());
		}

//		if (minopHomeChromePage.ClickokBtn()) {
//			logResults.createLogs("Y", "PASS", "Wizard Page click on ok button");
//		} else {
//			logResults.createLogs("Y", "FAIL", "ok button not clickable: " + minopHomeChromePage.getExceptionDesc());
//		}

		if (minopHomeChromePage.ClickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Submit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopHomeChromePage.getExceptionDesc());
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
