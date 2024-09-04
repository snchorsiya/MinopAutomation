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
import browserpage.MinopPayrollSalaryHeadsPage;

public class MinopPayrollSalaryHeadsTest {

	WebDriver driver;
	private static String fullTitle;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopPayrollSalaryHeadsPage minopPayrollSalaryHeadsPage = new MinopPayrollSalaryHeadsPage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		minopPayrollSalaryHeadsPage = new MinopPayrollSalaryHeadsPage(driver);
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
	public void pay_1_Payroll_Minop_Head_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that when click on Head then Head page is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void pay_2_Payroll_Minop_Head_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Create New Payroll button then Create new Payroll Window is open or not.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.ClickOnCreateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Create Head button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void pay_3_Payroll_Minop_Head_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with blank entries in all fields data is saved successfully or any validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.ClickOnCreateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Create Head button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void pay_4_Payroll_Minop_Head_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with valid entries in all mandatory fields data is saved successfully.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC,
				"user,password,HeadType,HeadTitle,CalculationTypes,Percentage");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadType = data.get(2);
		String HeadTitle = data.get(3);
		String CalculationTypes = data.get(4);
		String Percentage = data.get(5);

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.ClickOnCreateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Create Head button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.enterHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

//			fullTitle = minopPayrollSalaryHeadsPage.getFullTitle();
//			System.out.println("Full Title set in Test Case 4: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.SelectHeadType(HeadType)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.SelectCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.enterPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifySuccessMessage()) {
			logResults.createLogs("Y", "PASS", "Success message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Success message not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void pay_5_Payroll_Minop_Head_5_pay_6_Payroll_Minop_Head_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that newly added data is display in the grid or not.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,Search");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 6)
	public void pay_7_Payroll_Minop_Head_7() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data is searched when invalid keyword entered in the Search Textbox.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,Search");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterInvalidSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the Invalid value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyDataTableEmpty()) {
			logResults.createLogs("Y", "PASS", "Invalid Data not display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Invalid data is display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 7)
	public void pay_8_Payroll_Minop_Head_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Edit button of any record then Edit window is open with displaying data.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,Search");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three dot not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit link not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

	}
	
	
	@Test(enabled = true, priority = 8)
	public void pay_9_Payroll_Minop_Head_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that validation message display if mandatory fields are kept blank in Edit Payroll Head Window.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,HeadTitle,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadTitle = data.get(2);
		String Search = data.get(3);

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three dot not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit link not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.enterHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

			fullTitle = minopPayrollSalaryHeadsPage.getFullTitle();
			System.out.println("Full Title set in Test Case 4: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyValidationMessage()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

	}
	
	
	@Test(enabled = true, priority = 9)
	public void pay_10_Payroll_Minop_Head_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data Edited successfully when all Mandatory fields are filled in Edit Window.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,HeadTitle,Search");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadTitle = data.get(2);
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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three dot not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Edit link not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyUpdatePageTitle()) {
			logResults.createLogs("Y", "PASS", "Update Page title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update Page title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.enterUpdateHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

			  fullTitle = minopPayrollSalaryHeadsPage.getFullTitle();
		        System.out.println("Full Title set in Test Case 15: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		/*
		 * if (minopPayrollSalaryHeadsPage.VerifyUpdateSuccessMessage()) {
		 * logResults.createLogs("Y", "PASS",
		 * "Update Validation message display successfully"); } else {
		 * logResults.createLogs("Y", "FAIL", "Update Validation message not display: "
		 * + minopPayrollSalaryHeadsPage.getExceptionDesc()); }
		 */

	}
	
	@Test(enabled = true, priority = 10)
	public void pay_11_Payroll_Minop_Head_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Edited data display in the Grid after updating the Payroll Head.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,Search");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

	}


	@Test(enabled = true, priority = 11)
	public void pay_13_Payroll_Minop_Head_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Pagination works when click Next/Previous button.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination successfully work");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Pagination not work: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}
	
	
	@Test(enabled = true, priority = 12)
	public void pay_15_Payroll_Minop_Head_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that validation message is display when entered duplicated Head name.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC,
				"user,password,HeadType,HeadTitle,CalculationTypes,Percentage");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadType = data.get(2);
		String HeadTitle = data.get(3);
		String CalculationTypes = data.get(4);
		String Percentage = data.get(5);

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.ClickOnCreateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Create Head button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.enterUpdateHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

//			fullTitle = minopPayrollSalaryHeadsPage.getFullTitle();
//			System.out.println("Full Title set in Test Case 4: " + fullTitle);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.SelectHeadType(HeadType)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.SelectCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.enterPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.ClickOnSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.VerifyDuplicateMessage()) {
			logResults.createLogs("Y", "PASS", "Duplicate message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Duplicate message not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
	}
	
	@Test(enabled = true, priority = 13)
	public void pay_17_Payroll_Minop_Head_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Edited data display in the Grid after updating the Payroll Head.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_Minop_Head", currTC, "user,password,Search");

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
		if (minopHomeChromePage.ClickOnSalaryHeadsLink()) {
			logResults.createLogs("Y", "PASS", "Click Salary Heads Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Salary Heads link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.verifySalaryHeads()) {
			logResults.createLogs("Y", "PASS", "SalaryHeads display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"SalaryHeads not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}

		if (minopPayrollSalaryHeadsPage.verifyTitleInTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Three dot not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.ClickOnStatusLink()) {
			logResults.createLogs("Y", "PASS", "Click on Status link Inactive successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status link not clickable: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyInActiveMessage()) {
			logResults.createLogs("Y", "PASS", "InActive message successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"InActive message not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		Thread.sleep(3000);
		
		if (minopPayrollSalaryHeadsPage.enterSearchtxt(Search)) {
			logResults.createLogs("Y", "PASS", "Enter the value in search box");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Value not enter in search box: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
		}
		
		if (minopPayrollSalaryHeadsPage.VerifyStatusDisplay()) {
			logResults.createLogs("Y", "PASS", "Status display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Status not display: " + minopPayrollSalaryHeadsPage.getExceptionDesc());
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
