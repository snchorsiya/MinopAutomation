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
import browserpage.MinopEmployeeSalaryPage;
import browserpage.MinopHomeChromePage;
import browserpage.MinopLoginChromePage;
import browserpage.MinopPayrollStructurePage;

public class MinopEmployeeSalaryTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopEmployeeSalaryPage minopEmployeeSalaryPage = new MinopEmployeeSalaryPage(driver);
	MinopPayrollStructurePage minopPayrollStructurePage = new MinopPayrollStructurePage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		minopEmployeeSalaryPage = new MinopEmployeeSalaryPage(driver);
		minopPayrollStructurePage = new MinopPayrollStructurePage(driver);
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
	public void pay_77_Employee_CTC_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that when click on Employee CTC then Employee CTC page is open.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void pay_78_Employee_CTC_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Assign Payroll Structure from Employee CTC page then it redirected to Payroll Structure page.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.ClickOnAssignPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Assign Payroll Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Payroll Structure button not clickable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Assign Payroll Structure title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Payroll Structure title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 10)
	public void pay_86_Employee_CTC_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Search filters are working properly or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

//		if (fullTitle == null) {
//			throw new IllegalStateException(
//					"fullTitle is null. Ensure that pay_4_Payroll_Minop_Head_4 runs successfully before this test.");
//		}
//
//		minopPayrollSalaryHeadsPage.setFullTitle(fullTitle);
//		System.out.println("Full Title used in Test Case 5: " + fullTitle);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		Thread.sleep(3000);

		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 11)
	public void pay_87_Employee_CTC_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that when entered invalid keyword then data is searched or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyDataTableEmpty()) {
			logResults.createLogs("Y", "PASS", "Invalid Data not display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid data is display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 12)
	public void pay_88_Employee_CTC_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Pagination is working properly or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopEmployeeSalaryPage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination successfully work");
		} else {
			logResults.createLogs("Y", "FAIL", "Pagination not work: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void pay_79_Employee_CTC_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that Payroll structure is successfully assigned to Employee redirecting from Employee CTC page to Payroll structure.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,SearchStructureName,Companyname,Branchname,Departmentname");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);
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
		if (minopHomeChromePage.verifyAccountCode()) {
			logResults.createLogs("Y", "PASS", "Dashboard displayed successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Dashboard is not displayed: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.ClickOnAssignPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Assign Payroll Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Payroll Structure button not clickable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Assign Payroll Structure title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Payroll Structure title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.AssignBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyAssignBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Branch Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickONAnotherElement()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCompanySelected()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickONAnotherElement()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonDrpDepartmentname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Branch Not Clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.SearchDepartmentname(Departmentname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Department  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Search Department not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.CheckCheckBoxDepartment()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Check Box not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickONAnotherElement()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.SelectEmpAssignAll()) {
			logResults.createLogs("Y", "PASS", "Verify Click on Checkbox employee Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonAssignSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonAssignPermission()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifySuccessMessageTxt()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Button Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 4)
	public void pay_80_Employee_CTC_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that assigned payroll structure to employee is display in Employee CTC page with complete details.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 5)
	public void pay_81_Employee_CTC_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that if assigned Employee has CTC 0 then user click on Enter CTC button then Enter CTC window is open or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.clickOnUpdateCTC()) {
			logResults.createLogs("Y", "PASS", "Update CTC button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyUpdateCTCTitle()) {
			logResults.createLogs("Y", "PASS", "Update CTC title display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void pay_82_Employee_CTC_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that CTC is successfully assigned to the employee or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname,Amount,BankHolderName,BankIFSCCode,BankAccountNumber,BranchName");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);
		String Amount = data.get(5);
		String BankHolderName = data.get(6);
		String BankIFSCCode = data.get(7);
		String BankAccountNumber = data.get(8);
		String BranchName = data.get(9);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.clickOnUpdateCTC()) {
			logResults.createLogs("Y", "PASS", "Update CTC button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyUpdateCTCTitle()) {
			logResults.createLogs("Y", "PASS", "Update CTC title display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.enterCTCtxt(Amount)) {
			logResults.createLogs("Y", "PASS", "Enter the ctc in text field Successfully" + Amount);
		} else {
			logResults.createLogs("Y", "FAIL",
					"CTC amount not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		
		if (minopEmployeeSalaryPage.ClickOnSaveAmountBtn()) {
			logResults.createLogs("Y", "PASS", "Amount Save button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Amount save button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(1000);

		if (minopEmployeeSalaryPage.ClickOnFirstNextBtn()) {
			logResults.createLogs("Y", "PASS", "First Next button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"First Next button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.entertxtBankHolderName(BankHolderName)) {
			logResults.createLogs("Y", "PASS", "Enter the Bank Holder name in text field Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Bank Holder name not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.entertxtBankIFSCCode(BankIFSCCode)) {
			logResults.createLogs("Y", "PASS", "Enter the Bank IFSC code in text field Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Bank IFSC code not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.entertxtBankAccountNumber(BankAccountNumber)) {
			logResults.createLogs("Y", "PASS", "Enter the Bank Account number in text field Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Bank Account number not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.entertxtBankBaranchName(BranchName)) {
			logResults.createLogs("Y", "PASS", "Enter the Bank Baranch name in text field Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Bank Baranch name not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		
		Thread.sleep(2000);

		if (minopEmployeeSalaryPage.VerifyupdateMessage()) {
			logResults.createLogs("Y", "PASS", "Update Message display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Message not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void pay_83_Employee_CTC_7() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Assigned CTC to employee is display in the grid or not?");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verfiyCTCMonth()) {
			logResults.createLogs("Y", "PASS", "Verify CTC display in grid" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"CTC not display in grid: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void pay_84_Employee_CTC_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that if user has not 0 CTC then update CTC button is present instead of displaying Enter CTC button.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verfiyUpdateCTCbtn()) {
			logResults.createLogs("Y", "PASS", "Verify Update CTC button display" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void pay_85_Employee_CTC_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that if user wants to update CTC then CTC is updated or not when click on Update CTC.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Search,Companyname,Branchname");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);
		String Companyname = data.get(3);
		String Branchname = data.get(4);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		
		Thread.sleep(2000);
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verfiyUpdateCTCbtn()) {
			logResults.createLogs("Y", "PASS", "Verify Update CTC button display" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickUpdateCTCbtn()) {
			logResults.createLogs("Y", "PASS", "Click on Update CTC button" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not clickable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyUpdateCTCTitle()) {
			logResults.createLogs("Y", "PASS", "Update CTC title display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 13)
	public void pay_89_Employee_CTC_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName("Scenario: Check that with blank entries data is saved successfully or any validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("Employee_Salary", currTC,
				"user,password,Companyname,Branchname,Search,Amount");

		String user = data.get(0);
		String pass = data.get(1);
		String Companyname = data.get(2);
		String Branchname = data.get(3);
		String Search = data.get(4);
		String Amount = data.get(5);

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.clickOnEmployeeSalary()) {
			logResults.createLogs("Y", "PASS", "Click Employee Salary Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyEmployeeSalaryTitle()) {
			logResults.createLogs("Y", "PASS", "Employee Salary title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Employee Salary not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickonDrpCompanyname()) {
			logResults.createLogs("Y", "PASS", "Verify CompanyDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Drop Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.Searchcompanyname(Companyname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Company  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Serach Company not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxcompany()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company Checkbox not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.ClickonDrpBranchname()) {
			logResults.createLogs("Y", "PASS", "Verify BranchDrp Get Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.SearchBranchname(Branchname)) {
			logResults.createLogs("Y", "PASS", "Verify Search Branch  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopEmployeeSalaryPage.CheckCheckBoxBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Company Checkbox Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Assign Branch Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.ClickOnApplyBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Apply Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Apply Button Not Display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopEmployeeSalaryPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopEmployeeSalaryPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data not Search as per Enter in The SearchTextbox: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.clickOnUpdateCTC()) {
			logResults.createLogs("Y", "PASS", "Update CTC button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.verifyUpdateCTCTitle()) {
			logResults.createLogs("Y", "PASS", "Update CTC title display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update CTC title not display: " + minopEmployeeSalaryPage.getExceptionDesc());
		}

		if (minopEmployeeSalaryPage.enterCTCtxt(Amount)) {
			logResults.createLogs("Y", "PASS", "Enter the ctc in text field Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"CTC amount not enter in text field: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		
		if (minopEmployeeSalaryPage.ClickOnSaveAmountBtn()) {
			logResults.createLogs("Y", "PASS", "Amount Save button click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Amount save button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
		}
		
//		Thread.sleep(2000);
//
//		if (minopEmployeeSalaryPage.ClickOnFirstNextBtn()) {
//			logResults.createLogs("Y", "PASS", "First Next button click Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"First Next button not clikable: " + minopEmployeeSalaryPage.getExceptionDesc());
//		}
//
//		if (minopEmployeeSalaryPage.ClickOnSaveBtn()) {
//			logResults.createLogs("Y", "PASS", "Save button click Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Save button not clickable: " + minopEmployeeSalaryPage.getExceptionDesc());
//		}

		if (minopEmployeeSalaryPage.verifyValidationMsg()) {
			logResults.createLogs("Y", "PASS", "Validation Message display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation Message not display: " + minopEmployeeSalaryPage.getExceptionDesc());
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
