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
import browserpage.NonRecurringIncomePage;

public class NonRecurringIncomeTest {

	WebDriver driver;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	NonRecurringIncomePage nonRecurringIncomePage = new NonRecurringIncomePage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
		nonRecurringIncomePage = new NonRecurringIncomePage(driver);
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
	public void pay_120_Non_Recurring_Income_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Non Recurring Income then Non Recurring Income Window is open.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password");

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 2)
	public void pay_121_Non_Recurring_Income_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Add Non Recurring Income button then Non Recurring Income form Window is open.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password");

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickNonRecurringIncomeBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Non Recurring Income button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void pay_122_Non_Recurring_Income_3_pay_123_Non_Recurring_Income_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Add Non Recurring Income button then Non Recurring Income form Window is open.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,HeadName");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadName = data.get(2);

//		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
//		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickNonRecurringIncomeBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Non Recurring Income button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickonDrpHeadName(HeadName)) {
			logResults.createLogs("Y", "PASS", "Head Name display");
		} else {
			logResults.createLogs("Y", "FAIL", "Head Name not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 4)
	public void pay_124_Non_Recurring_Income_5() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that any validation message is display when user select save button without filling any mandatory fields.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password");

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickNonRecurringIncomeBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Non Recurring Income button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyValidationMsg()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void pay_125_Non_Recurring_Income_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data is saved successfully when user filled all mandatory fields.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC,
				"user,password,HeadName,EmployeeName,amount,InstallmentMonths");

		String user = data.get(0);
		String pass = data.get(1);
		String HeadName = data.get(2);
		String EmployeeName = data.get(3);
		String amount = data.get(4);
		String InstallmentMonths = data.get(5);

//		MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
//		MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickNonRecurringIncomeBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Non Recurring Income button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickonDrpHeadName(HeadName)) {
			logResults.createLogs("Y", "PASS", "Head Name display");
		} else {
			logResults.createLogs("Y", "FAIL", "Head Name not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.SearchHeadName(EmployeeName)) {
			logResults.createLogs("Y", "PASS", "Employee Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee not select: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterAmounttxt(amount)) {
			logResults.createLogs("Y", "PASS", "Amount enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Amout not enter: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterInstallMonthtxt(InstallmentMonths)) {
			logResults.createLogs("Y", "PASS", "Amount enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Amout not enter: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.InstallStartDate()) {
			logResults.createLogs("Y", "PASS", "Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Date Not select: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifySuccessMsg()) {
			logResults.createLogs("Y", "PASS", "Success Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Success Validation message not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 6)
	public void pay_127_Non_Recurring_Income_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: \r\n"
				+ "Check that when user click on edit button from any record then Non Recurring Income form Window is open or not?");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Three dot not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 7)
	public void pay_128_Non_Recurring_Income_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that any validation message is display when user click on update button without filling any mandatory fields.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search,amount");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);
		String amount = data.get(3);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Three dot not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterAmounttxt(amount)) {
			logResults.createLogs("Y", "PASS", "Amount enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Amout not enter: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyValidationMsg()) {
			logResults.createLogs("Y", "PASS", "Validation message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 8)
	public void pay_129_Non_Recurring_Income_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data is updated successfully when user filled all mandatory fields and click on update button.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search,InstallmentMonths");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);
		String InstallmentMonths = data.get(3);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnThreeDot()) {
			logResults.createLogs("Y", "PASS", "Click on three dot successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Three dot not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnEditLink()) {
			logResults.createLogs("Y", "PASS", "Click on Edit link successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Edit link not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyAddNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Add Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Add Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterUpdateInstallMonthtxt(InstallmentMonths)) {
			logResults.createLogs("Y", "PASS", "Install Month Update successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Install Month not Update: " + nonRecurringIncomePage.getExceptionDesc());
		}
		
		if (nonRecurringIncomePage.InstallStartDate()) {
			logResults.createLogs("Y", "PASS", "Date Select successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Date Not select: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Save button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Save button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyUpdateMsg()) {
			logResults.createLogs("Y", "PASS", "Update message display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Update message not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 9)
	public void pay_130_Non_Recurring_Income_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Next/Previous button then pagination is working properly.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password");

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.VerifyClickOnPagination()) {
			logResults.createLogs("Y", "PASS", "Pagination successfully work");
		} else {
			logResults.createLogs("Y", "FAIL", "Pagination not work: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 10)
	public void pay_131_Non_Recurring_Income_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Column header then sorting is working properly.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password");

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyHeaderSort()) {
			logResults.createLogs("Y", "PASS", "Data Sort successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not sorted: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 11)
	public void pay_133_Non_Recurring_Income_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Employee from employee details column then employee details window is open.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnEmp()) {
			logResults.createLogs("Y", "PASS", "Click on Employee successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyLoanTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income Loan title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income Loan title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 12)
	public void pay_134_Non_Recurring_Income_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on download excel icon from employee details window then excel file is downloaded or not?");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.ClickOnEmp()) {
			logResults.createLogs("Y", "PASS", "Click on Employee successfully");
		} else {
			logResults.createLogs("Y", "FAIL", "Employee not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyLoanTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income Loan title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income Loan title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyclickOnExcelBtn()) {
			logResults.createLogs("Y", "PASS", "Excel button click successfully.");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Excel button not clickable: " + nonRecurringIncomePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 13)
	public void pay_135_Non_Recurring_Income_16() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with entering valid entries in search filters data is searched as per keyword entered.");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyTitleInTable(search)) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 14)
	public void pay_136_Non_Recurring_Income_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with entering invalid entries in search filters data is searched or not?");

		ArrayList<String> data = initBase.loadExcelData("NonRecurringIncome", currTC, "user,password,search");

		String user = data.get(0);
		String pass = data.get(1);
		String search = data.get(2);

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
		if (minopHomeChromePage.clickNonRecurringIncome()) {
			logResults.createLogs("Y", "PASS", "Click Non Recurring Income Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (nonRecurringIncomePage.verifyNonRecurringIncomeTitle()) {
			logResults.createLogs("Y", "PASS", "Non Recurring Income title display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Non Recurring Income title not display: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.enterEmpNametxt(search)) {
			logResults.createLogs("Y", "PASS", "enter the emp code in search field");
		} else {
			logResults.createLogs("Y", "FAIL",
					"emp code not enter in search field: " + nonRecurringIncomePage.getExceptionDesc());
		}

		if (nonRecurringIncomePage.verifyEmptyTable()) {
			logResults.createLogs("Y", "PASS", "As per serach value data is display");
		} else {
			logResults.createLogs("Y", "FAIL",
					"As per search value data is not display: " + nonRecurringIncomePage.getExceptionDesc());
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
