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
import browserpage.MinopCustomColumnPage;
import browserpage.MinopHomeChromePage;
import browserpage.MinopLoginChromePage;

public class MinopCustomColumnTest {

	WebDriver driver;
	private static String fullTitle;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopCustomColumnPage minopCustomColumnPage = new MinopCustomColumnPage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		minopCustomColumnPage = new MinopCustomColumnPage(driver);
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
	public void pay_60_Payroll_Generate_Column_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults
				.setScenarioName(" Scenario: Check that when click on Head then Payroll Generate Column page is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void pay_61_Payroll_Generate_Column_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Create New Column button then Create new Column Window is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.ClickOnCreateCustomColumnBtn()) {
			logResults.createLogs("Y", "PASS", "Create Custom Column button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custom Column button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyCreateCustomeColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Create Custome Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custome Column title not display: " + minopCustomColumnPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void pay_62_Payroll_Generate_Column_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with blank entries in all fields data is saved successfully or any validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnPayrollPreperationLink()) {
			logResults.createLogs("Y", "PASS", "Click PayrollPreperation Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"PayrollPreperation link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.ClickOnCreateCustomColumnBtn()) {
			logResults.createLogs("Y", "PASS", "Create Custom Column button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custom Column button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyCreateCustomeColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Create Custome Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custome Column title not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopCustomColumnPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void pay_63_Payroll_Generate_Column_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with valid entries in all mandatory fields data is saved successfully.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC,
				"user,password,columnName,sectionType");

		String user = data.get(0);
		String pass = data.get(1);
		String columnName = data.get(2);
		String sectionType = data.get(3);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.ClickOnCreateCustomColumnBtn()) {
			logResults.createLogs("Y", "PASS", "Create Custom Column button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custom Column button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyCreateCustomeColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Create Custome Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custome Column title not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterColumnName(columnName)) {
			logResults.createLogs("Y", "PASS", "Column name enter successfully");

		} else {
			logResults.createLogs("Y", "FAIL", "Column name not enter: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.SelectSectionType(sectionType)) {
			logResults.createLogs("Y", "PASS", "Section Type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Section Type dropdwon value not select: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifySuccessMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopCustomColumnPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void pay_64_Payroll_Generate_Column_5_pay_65_Payroll_Generate_Column_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that newly added data is display in the grid or not.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void pay_66_Payroll_Generate_Column_7() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data is searched when invalid keyword entered in the Search Textbox.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the invalid value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyDataTableEmpty()) {
			logResults.createLogs("Y", "PASS", "Invalid Data not display");
		} else {
			logResults.createLogs("Y", "FAIL", "Invalid data is display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void pay_67_Payroll_Generate_Column_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Edit button of any record then Edit window is open with displaying data.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void pay_68_Payroll_Generate_Column_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that validation message display if mandatory fields are kept blank in Edit Column Window.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC,
				"user,password,columnName,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String columnName = data.get(2);
		String Search = data.get(3);


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

		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.enterColumnName(columnName)) {
			logResults.createLogs("Y", "PASS", "Create Column name display successfully");

			fullTitle = minopCustomColumnPage.getFullTitle();
			System.out.println("Full Title set in Test Case 4: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Column name not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.VerifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void pay_69_Payroll_Generate_Column_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data Edited successfully when all Mandatory fields are filled in Edit Window.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC,
				"user,password,columnName,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String columnName = data.get(2);
		String Search = data.get(3);

//		minopPayrollSalaryHeadsPage.setFullTitle(fullTitle);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.enterUpdateColumnName(columnName)) {
			logResults.createLogs("Y", "PASS", "Create Column name display successfully");

			fullTitle = minopCustomColumnPage.getFullTitle();
			System.out.println("Full Title set in Test Case 4: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Column name not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		

		if (minopCustomColumnPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.VerifyUpdateSuccessMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 10)
	public void pay_70_Payroll_Generate_Column_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Edited data display in the Grid after updating the Column.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String Search = data.get(2);

//		if (fullTitle == null) {
//			throw new IllegalStateException(
//					"fullTitle is null. Ensure that pay_10_Payroll_Minop_Head_10 runs successfully before this test.");
//		}

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopCustomColumnPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 11)
	public void pay_71_Payroll_Generate_Column_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with duplicate column name validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC,
				"user,password,columnName,sectionType");

		String user = data.get(0);
		String pass = data.get(1);
		String columnName = data.get(2);
		String sectionType = data.get(3);

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

//		minopPayrollSalaryHeadsPage.setFullTitle(fullTitle);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.ClickOnCreateCustomColumnBtn()) {
			logResults.createLogs("Y", "PASS", "Create Custom Column button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custom Column button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyCreateCustomeColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Create Custome Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Custome Column title not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.enterUpdateColumnName(columnName)) {
			logResults.createLogs("Y", "PASS", "Column name enter successfully");

		} else {
			logResults.createLogs("Y", "FAIL", "Column name not enter: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.SelectSectionType(sectionType)) {
			logResults.createLogs("Y", "PASS", "Section Type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Section Type dropdwon value not select: " + minopCustomColumnPage.getExceptionDesc());
		}

		if (minopCustomColumnPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.VerifyDuplicateMessage()) {
			logResults.createLogs("Y", "PASS", "Duplicate message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Duplicate message not display: " + minopCustomColumnPage.getExceptionDesc());
		}
	}
	
	
	@Test(enabled = true, priority = 12)
	public void pay_73_Payroll_Generate_Column_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data is sorted when click on Column Header.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC,
				"user,password");

		String user = data.get(0);
		String pass = data.get(1);
	

		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

//		minopPayrollSalaryHeadsPage.setFullTitle(fullTitle);

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyHeaderSort()) {
			logResults.createLogs("Y", "PASS", "Data Sort successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not sorted: " + minopCustomColumnPage.getExceptionDesc());
		}
	}
	
	@Test(enabled = true, priority = 13)
	public void pay_74_Payroll_Generate_Column_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Pagination works when click Next/Previous button.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Generate_Column", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnCustomColumn()) {
			logResults.createLogs("Y", "PASS", "Click Custom Column Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Custom Column link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopCustomColumnPage.verifyGenerateColumnTitle()) {
			logResults.createLogs("Y", "PASS", "Generate Column title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "SalaryHeads not display: " + minopCustomColumnPage.getExceptionDesc());
		}
		
		if (minopCustomColumnPage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination successfully work");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pagination not work: " + minopCustomColumnPage.getExceptionDesc());
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
