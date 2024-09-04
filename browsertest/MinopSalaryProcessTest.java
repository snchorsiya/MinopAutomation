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
import browserpage.MinopSalaryProcessPage;

public class MinopSalaryProcessTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopSalaryProcessPage minopSalaryProcessPage = new MinopSalaryProcessPage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		minopSalaryProcessPage = new MinopSalaryProcessPage(driver);
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
	public void pay_108_Salary_Process_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Salary Process then Salary Process page is open.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 2)
	public void pay_109_Salary_Process_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on save from attendance finalized page then it redirected to Salary Process page with same data which are processed from Attendance finalized page.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 3)
	public void pay_110_Salary_Process_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Verify that Payroll generate column names are displyed in Salary Process page grid.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.VerifyPyrollColumn()) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 4)
	public void pay_111_Salary_Process_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that as per valid keywords entered in Search filters then data is display in the grid or not?");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Search = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySearchTxt(Search)) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Search data display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Search data not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 5)
	public void pay_112_Salary_Process_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user entered invalid keywords in Search filters then data is display in the grid or not?");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Search = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySearchTxt(Search)) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyInvalidData()) {
			logResults.createLogs("Y", "PASS", "Invalid message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid message not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void pay_113_Salary_Process_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Pagination is working properly or not?");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination working successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Pagination not working: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void pay_140_Salary_Process_7() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Verify that Non Recurring Income heads names are displyed in Salary Process page grid.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Search = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySearchTxt(Search)) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyClickTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Click on employee successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"employee data grid not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyNonRecurringIncomeheads()) {
			logResults.createLogs("Y", "PASS", "Non RecurringIncome heads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non RecurringIncome heads not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void pay_141_Salary_Process_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when amount is entered in any custom column then employee total net payout is also change.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopSalaryProcessPage.VerifyPyrollColumn()) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickOnEditIcon()) {
			logResults.createLogs("Y", "PASS", "Edit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.scrollToElement()) {
			logResults.createLogs("Y", "PASS", "Scroll successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Scroll: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifycustomColumnAmount()) {
			logResults.createLogs("Y", "PASS", "Amount enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Amount not enter: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickOnUpdateBtn()) {
			logResults.createLogs("Y", "PASS", "Amount enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Amount not enter: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyUpdateSuccessMsg()) {
			logResults.createLogs("Y", "PASS", "Success message disaply successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Sucess message not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyNetAmount()) {
		    logResults.createLogs("Y", "PASS", "Net Amount not changed:");
		} else {
		    logResults.createLogs("Y", "FAIL", "Net Amount change successfully" + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void pay_142_Salary_Process_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that when click on edit then only custom cloumns are editable.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopSalaryProcessPage.VerifyPyrollColumn()) {
			logResults.createLogs("Y", "PASS", "Pyroll Column display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pyroll Column not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopSalaryProcessPage.verifyclickOnEditIcon()) {
			logResults.createLogs("Y", "PASS", "Edit button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.scrollToElement()) {
			logResults.createLogs("Y", "PASS", "Scroll successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Not Scroll: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifycustomColumnAmount()) {
			logResults.createLogs("Y", "PASS", "Field Editable");
		} else {
			logResults.createLogs("Y", "FAIL", "Field not editable: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 12)
	public void pay_143_Salary_Process_10_pay_144_Salary_Process_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user tick the all coulmn from the grid then Freeze, On Hold and FNF button display.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Status");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Status = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyselectStatusdrp(Status)) {
			logResults.createLogs("Y", "PASS", "Status dropdown value select Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status dropdown value not select: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickCheckbox()) {
			logResults.createLogs("Y", "PASS", "Check box check successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Check box not checked: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickOnFreeBtn()) {
			logResults.createLogs("Y", "PASS", "Freeze button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Freeze button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		/*
		 * if (minopSalaryProcessPage.verifyFreezedSuccessMsg()) {
		 * logResults.createLogs("Y", "PASS", "Freezed SuccessMsg display"); } else {
		 * logResults.createLogs("Y", "FAIL", "Freezed SuccessMsg not display: " +
		 * minopSalaryProcessPage.getExceptionDesc()); }
		 */
		if (minopSalaryProcessPage.verifySFStatus()) {
			logResults.createLogs("Y", "PASS", "SF status display");
		} else {
			logResults.createLogs("Y", "FAIL", "SF status not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 13)
	public void pay_148_Salary_Process_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Verify that after employee salary is freezed then edit button is disappear from the grid.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Status");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Status = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyselectStatusdrp(Status)) {
			logResults.createLogs("Y", "PASS", "Status dropdown value select Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status dropdown value not select: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyEditRecrd()) {
			logResults.createLogs("Y", "PASS", "Edit button not display");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit button display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 10)
	public void pay_149_Salary_Process_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Verify that when click on Hold button then Employee Salar is on Hold and in Payroll status SOH is display in the grid.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC, "user,password,Companyname,Branchname");

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickCheckbox()) {
			logResults.createLogs("Y", "PASS", "Check box check successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Check box not checked: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickOnHoldBtn()) {
			logResults.createLogs("Y", "PASS", "Hold button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Hold button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySOHStatus()) {
			logResults.createLogs("Y", "PASS", "SOH status display");
		} else {
			logResults.createLogs("Y", "FAIL", "SOH status not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 11)
	public void pay_150_Salary_Process_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Verify that When click on download excel from employees attendance then excel file is downloaded.");

		ArrayList<String> data = initBase.loadExcelData("MinopSalary", currTC,
				"user,password,Companyname,Branchname,Status");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Status = data.get(4);

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
		if (minopHomeChromePage.ClickOnSalarylink()) {
			logResults.createLogs("Y", "PASS", "Click On Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopSalaryProcessPage.verifySalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary title not display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopSalaryProcessPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopSalaryProcessPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyselectStatusdrp(Status)) {
			logResults.createLogs("Y", "PASS", "Status dropdown value select Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status dropdown value not select: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifyclickonSubmitbtn()) {
			logResults.createLogs("Y", "PASS", "Click Submit button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Submit button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
		}

		if (minopSalaryProcessPage.verifySPList()) {
			logResults.createLogs("Y", "PASS", "Salary Pending display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Pending not display: " + minopSalaryProcessPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopSalaryProcessPage.verifyclickOnExcelbtn()) {
			logResults.createLogs("Y", "PASS", "Excel button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Excel button not clickable: " + minopSalaryProcessPage.getExceptionDesc());
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
