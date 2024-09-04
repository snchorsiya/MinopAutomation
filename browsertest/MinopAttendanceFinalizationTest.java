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
import browserpage.MinopAttendanceFinalizationPage;
import browserpage.MinopHomeChromePage;
import browserpage.MinopLoginChromePage;

public class MinopAttendanceFinalizationTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopAttendanceFinalizationPage minopAttendanceFinalizationPage = new MinopAttendanceFinalizationPage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		minopAttendanceFinalizationPage = new MinopAttendanceFinalizationPage(driver);
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
	public void pay_91_Attendance_Finalization_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Attendance Finalization then Attendance Finalization page is open.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC, "user,password");

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void pay_92_Attendance_Finalization_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that without selecting any mandatory field dropdown and click on Apply then data is prcessed or any validation message is display");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC, "user,password");

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void pay_93_Attendance_Finalization_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user select Company, branch and month from dropdown then click on Apply button then data is processed or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void pay_94_Attendance_Finalization_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Clear button then all selected data is refresh or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickClearBtn()) {
			logResults.createLogs("Y", "PASS", "Click Clear button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Clear button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.VerifyCompanyname()) {
			logResults.createLogs("Y", "PASS", "Blank Company display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company dropdown not blank: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void pay_95_Attendance_Finalization_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that after data is processed successfuly then processed data is display in the grid.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 11)
	public void pay_96_Attendance_Finalization_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that when user click on edit button from any record then data is editable or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
		String PresentDay = data.get(5);
		String AbsentDay = data.get(6);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterPresentDay(PresentDay)) {
			logResults.createLogs("Y", "PASS", "PresentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PresentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterAbsentDay(AbsentDay)) {
			logResults.createLogs("Y", "PASS", "AbsentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AbsentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 13)
	public void pay_97_Attendance_Finalization_7_pay_117_Attendance_Finalize_21_pay_118_Attendance_Finalize_22()
			throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Check that when user click on edit button from any record then employee attendance data is updated or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay,TakenLeave");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
		String PresentDay = data.get(5);
		String AbsentDay = data.get(6);
		String TakenLeave = data.get(7);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterPresentDay(PresentDay)) {
			logResults.createLogs("Y", "PASS", "PresentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PresentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterAbsentDay(AbsentDay)) {
			logResults.createLogs("Y", "PASS", "AbsentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AbsentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterTakenLeave(TakenLeave)) {
			logResults.createLogs("Y", "PASS", "TakenLeave data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"TakenLeave data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickUpdatebtn()) {
			logResults.createLogs("Y", "PASS", "Update button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyUpdateValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Update validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 14)
	public void pay_98_Attendance_Finalization_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Check that when user tick the all coulmn from the grid then Freeze, On Hold and FNF button display.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickOnCheckBox()) {
			logResults.createLogs("Y", "PASS", "Click on checkbox");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check box not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifythreeButtonDisplay()) {
			logResults.createLogs("Y", "PASS", "Three button display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three button not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 15)
	public void pay_99_Attendance_Finalization_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Verify that when user processed the attendnace data then in attendnace column by default AP status is display.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,AttendanceStatus");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String AttendanceStatus = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (MinopAttendanceFinalizationPage.verifyDropdownValue(AttendanceStatus)) {
			logResults.createLogs("Y", "PASS", "AP status display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AP status not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifythreeButtonDisplay()) {
			logResults.createLogs("Y", "PASS", "Three button display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three button not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 16)
	public void pay_100_Attendance_Finalization_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:" + "Verify that after clickining on Freeze button then status is changed to AF.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay,AttendanceStatus");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
		String PresentDay = data.get(5);
		String AbsentDay = data.get(6);
		String AttendanceStatus = data.get(7);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterPresentDay(PresentDay)) {
			logResults.createLogs("Y", "PASS", "PresentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PresentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterAbsentDay(AbsentDay)) {
			logResults.createLogs("Y", "PASS", "AbsentDay data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AbsentDay data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickOnUpdateBtn()) {
			logResults.createLogs("Y", "PASS", "data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyUpdateValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Update validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.ClickOnCheckBox()) {
			logResults.createLogs("Y", "PASS", "Click on checkbox");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check box not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickOnFreezedBtn()) {
			logResults.createLogs("Y", "PASS", "Freeze button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Freeze button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyFreezedMsg()) {
			logResults.createLogs("Y", "PASS", "Freezed validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Freezed validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(3000);

		if (MinopAttendanceFinalizationPage.verifyDropdownValue(AttendanceStatus)) {
			logResults.createLogs("Y", "PASS", "AF status display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AF status not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 17)
	public void pay_101_Attendance_Finalization_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Check that if employee attendance is on Hold/FNF and click on Save button then employee net amount is calculated or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay,AttendanceStatus");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.ClickOnCheckBox()) {
			logResults.createLogs("Y", "PASS", "Click on checkbox");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check box not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickOnHoldBtn()) {
			logResults.createLogs("Y", "PASS", "On Hold button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"On Hold button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyHoldMsg()) {
			logResults.createLogs("Y", "PASS", "Hold validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Hold validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 18)
	public void pay_102_Attendance_Finalization_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Verify that afterclicking on save button only AF data status is changed to SP and it transfer to Salary proccessed page.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay,AttendanceStatus");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
		String AttendanceStatus = data.get(5);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.SelectAttendanceTypedrp()) {
			logResults.createLogs("Y", "PASS", "Dropdown value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Dropdown value not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(3000);

		if (minopAttendanceFinalizationPage.ClickOnCheckBox()) {
			logResults.createLogs("Y", "PASS", "Click on checkbox");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check box not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifySaveMsg()) {
			logResults.createLogs("Y", "PASS", "Save validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(6000);

		if (minopAttendanceFinalizationPage.SelectSPAttendanceTypedrp()) {
			logResults.createLogs("Y", "PASS", "Sp Dropdown value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Sp Dropdown value not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void pay_104_Attendance_Finalize_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that as per valid keywords entered in Search filters then data is display in the grid or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 7)
	public void pay_105_Attendance_Finalize_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that when user entered invalid keywords in Search filters then data is display in the grid or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.InvalidDataDisplay()) {
			logResults.createLogs("Y", "PASS", "Invalid data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 8)
	public void pay_106_Attendance_Finalize_16() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n" + "Check that Pagination is working properly or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination successfully work");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pagination not work: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 9)
	public void pay_107_Attendance_Finalize_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that When click on download excel from employees attendance then excel file is downloaded or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickOnExcelBtn()) {
			logResults.createLogs("Y", "PASS", "Excel button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Excel button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 10)
	public void pay_116_Attendance_Finalize_20() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that Present, Absent,Week off, Holiday and Leave Taken days total is equal to number of month days or not?");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyDay()) {
			logResults.createLogs("Y", "PASS", "Day data display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Day data not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 12)
	public void pay_117_Attendance_Finalize_21() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Check that if user entered Present, Absent,Week off, Holiday and Leave Taken days are greater than Month days then data is saved or any validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,TakenLeave");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
		String TakenLeave = data.get(5);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterEmpNameSearch(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "enter the emp name in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp name not enter in search field: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEnterTakenLeave(TakenLeave)) {
			logResults.createLogs("Y", "PASS", "TakenLeave data editable successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"TakenLeave data not editable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyclickUpdatebtn()) {
			logResults.createLogs("Y", "PASS", "Update button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		
		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"validation message not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 19)
	public void pay_119_Attendance_Finalize_23() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Check that employees attendance data displayed in the grid is same as Monthly muster report before editing the employee data.");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName,PresentDay,AbsentDay,AttendanceStatus,Departmentname");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);
//		String AttendanceStatus = data.get(5);
		String Departmentname = data.get(5);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.SelectAttendanceTypedrp()) {
			logResults.createLogs("Y", "PASS", "Dropdown value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Dropdown value not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.verifyAbsetTxt()) {
			logResults.createLogs("Y", "PASS", "AbsetData display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"AbsetData not display " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickOnDasboardLink()) {
			logResults.createLogs("Y", "PASS", "Dashboard link click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Dashboard not not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);

		if (minopAttendanceFinalizationPage.clickOnAnalyticsDashBoardlink()) {
			logResults.createLogs("Y", "PASS", "Analytics Dashboard link click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Analytics Dashboard not not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickonToggleIcon()) {
			logResults.createLogs("Y", "PASS", "Toggle icon click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Toggle icon not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.SelectComdrp(Companyname)) {
			logResults.createLogs("Y", "PASS", "Company dropdown value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company dropdown value not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.enterFromDatetxt()) {
			logResults.createLogs("Y", "PASS", "Date enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "date not enter: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.FromDate()) {
			logResults.createLogs("Y", "PASS", "Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Date Not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.enterToDatetxt()) {
			logResults.createLogs("Y", "PASS", "To date enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"To date not enter: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ToDate()) {
			logResults.createLogs("Y", "PASS", "To Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"To Date Not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopAttendanceFinalizationPage.ClickonDrpDepartmentname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Branch Not Clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchDepartmentname(Departmentname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Department  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Search Department not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxDepartment()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check Box not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckclickEmpCheckBox()) {
			logResults.createLogs("Y", "PASS", "Verify Employee Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Check Box not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.VerifyclickOnOkbtn()) {
			logResults.createLogs("Y", "PASS", "Verify click on ok button Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Ok button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.VerifyMonthlyMustReport()) {
			logResults.createLogs("Y", "PASS", "Verify click on MonthlyMustReport Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"MonthlyMustReport not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyPrecentDay()) {
			logResults.createLogs("Y", "PASS", "PrecentDay display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PrecentDay not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 20)
	public void pay_137_Attendance_Finalize_24() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario:"
				+ "Verify that after user click on Save button then edit button is disappear from Employee attendnace record..");

		ArrayList<String> data = initBase.loadExcelData("AttendanceFinalize", currTC,
				"user,password,Companyname,Branchname,EmployeeName");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String EmployeeName = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.ClickOnPayrollLink()) {
			logResults.createLogs("Y", "PASS", "Click Payroll Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnAttenFinalilink()) {
			logResults.createLogs("Y", "PASS", "Click On Attendance Finali Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finali link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopAttendanceFinalizationPage.verifyAttendanceFinalizeTitle()) {
			logResults.createLogs("Y", "PASS", "Attendance Finalize title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Attendance Finalize title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.SearchAttBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopAttendanceFinalizationPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.clickSubmitBtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyAttenSummryTitle()) {
			logResults.createLogs("Y", "PASS", "Atten Summary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Atten Summary title not display: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}
		
		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.SelectSPAttendanceTypedrp()) {
			logResults.createLogs("Y", "PASS", "Dropdown value SP select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Dropdown value SP not select: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopAttendanceFinalizationPage.verifyTitleInTable(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "data display in grid");
		} else {
			logResults.createLogs("Y", "FAIL",
					"data not display in grid: " + minopAttendanceFinalizationPage.getExceptionDesc());
		}

		if (minopAttendanceFinalizationPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "Edit button is not displayed as expected.");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit button is displayed when it should not be: " + minopAttendanceFinalizationPage.getExceptionDesc());
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
