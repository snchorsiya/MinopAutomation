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
import browserpage.MinopPayrollStructurePage;

public class MinopPayrollStructureTest {

	WebDriver driver;
	private static String StructurenameTXt;
	private static String StructureTypeTxt;
	private static String fullTitle1;
	LoadDriver loadDriver = new LoadDriver();
	LogResults logResults = new LogResults();
	MinopLoginChromePage minopLoginChromePage = new MinopLoginChromePage(driver);
	MinopHomeChromePage minopHomeChromePage = new MinopHomeChromePage(driver);
	MinopPayrollStructurePage minopPayrollStructurePage = new MinopPayrollStructurePage(driver);

	@Parameters({ "device" })
	@BeforeMethod
	public void launchDriver(int device) { // String param1
		initBase.browser = "chrome";
		driver = loadDriver.getDriver(device);
		minopLoginChromePage = new MinopLoginChromePage(driver);
		minopHomeChromePage = new MinopHomeChromePage(driver);
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
	public void Payroll_structure_1() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults
				.setScenarioName(" Check that when click on payroll Structure then payroll structure window is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC, "user,password");

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "verify Pay Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure  not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
//			if (minopPayrollStructurePage.VerifyPaystructureName()) {
//				logResults.createLogs("Y", "PASS", "verify Pay Structure  display successfully");
//			} else {
//				logResults.createLogs("Y", "FAIL",
//						"Structure  not display: " + minopPayrollStructurePage.getExceptionDesc());
//			}
	}

	@Test(enabled = true, priority = 2)
	public void Payroll_structure_2() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on Create new Payroll button then Create payroll window is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC, "user,password");

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 3)
	public void Payroll_structure_3() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that without filling mandatory fields and when user click on next step then any validation message is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC, "user,password");

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyValidationmsg()) {
			logResults.createLogs("Y", "PASS", "Verify Validation Message");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 4)
	public void Payroll_structure_4() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that  filling mandatory fields and when user click on next Earning and Deduction Page Opens Or Not.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.Structurename(Structurename)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Name Successfully");

			StructurenameTXt = minopPayrollStructurePage.getStructurenameTXt();
			System.out.println("Full Title set in Test Case 4: " + StructurenameTXt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(1000);
		if (minopPayrollStructurePage.StructureType(Structuretype)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Type successfully");

			StructureTypeTxt = minopPayrollStructurePage.getStructureTypeTxt();
			System.out.println("Full Title set in Test Case 4: " + StructureTypeTxt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 5)
	public void Payroll_structure_6() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Seach Functionality Working Successfully.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,SearchStructureName,SearchHeadTitle");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String SearchHeadTitle = data.get(3);
		// String Searchtype = data.get(4);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 6)
	public void Payroll_structure_7() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that when user click on Create Head + button from Earning/Deduction/Reimbursement section then Create head window is open..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Headtype = data.get(5);
		// String HeadTitle = data.get(6);
		// String Percentage = data.get(7);
		// String CalculationTypes =data.get(8);

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
		Thread.sleep(1000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateHead()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 7)
	public void Payroll_structure_8() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Check that with blank entries in all fields data is saved successfully or any validation message is display on create Head window..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String HeadType = data.get(5);
		// String HeadTitle = data.get(6);
		// String Percentage = data.get(7);
		// String CalculationTypes =data.get(8);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateHead()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateheadbtn()) {
			logResults.createLogs("Y", "PASS", "Click on Create Head Button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.CreateHeadValidationmessage()) {
			logResults.createLogs("Y", "PASS", "Verify Validation Message Successfully ");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation Message Not Display: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 8)
	public void Payroll_structure_9() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Check that with valid entries in all mandatory fields data is saved successfully of Create Head Window..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName,HeadType,HeadTitle,CalculationTypes,Percentage");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		String HeadType = data.get(5);
		String HeadTitle = data.get(6);
		String CalculationTypes = data.get(7);
		String Percentage = data.get(8);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateHead()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyCreateHeadTitle()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateheadbtn()) {
			logResults.createLogs("Y", "PASS", "Click on Create Head Button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.enterHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

			fullTitle1 = minopPayrollStructurePage.getfullTitle1();
			System.out.println("Full Title set in Test Case 4: " + fullTitle1);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.SelectHeadType(HeadType)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.SelectCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.enterPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateheadbtn()) {
			logResults.createLogs("Y", "PASS", "Click on Create Head Button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"not Click on Save Button: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 9)
	public void Payroll_structure_10() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that newly added Head data is display in the respected section..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchHeadTitle,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String SearchHeadTitle = data.get(3);
		// String Searchtype = data.get(4);

//	//	if (fullTitle1 == null) {
//			throw new IllegalStateException(
//					"fullTitle is null. Ensure that pay_9_Payroll_Structure_9 runs successfully before this test.");
//		}
//
//		MinopPayrollStructurePage.setfullTitle1(fullTitle1);
//		System.out.println("Full Title used in Test Case 10: " + fullTitle1);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyHeadTitleonEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 10)
	public void Payroll_structure_11() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Preview and Edit then Preview and edit window is open..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchHeadTitle,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		String SearchHeadTitle = data.get(5);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 11)
	public void Payroll_structure_12() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on View and save then View and save window is open..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName,SearchHeadTitle");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		String SearchHeadTitle = data.get(5);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 12)
	public void Payroll_structure_13() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that with valid entries(Filled all Mandatory fields) then Payroll structure is successfully created..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String SearchHeadTitle = data.get(5);

//		String SearchHeadTitle = data.get(4);
		// String Searchtype = data.get(4);

		// if (fullTitle1 == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_9_Payroll_Structure_9 runs successfully
		// before this test.");
		// }

		// MinopPayrollStructurePage.setfullTitle1(fullTitle1);
		// System.out.println("Full Title used in Test Case 10: " + fullTitle1);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(5000);
		if (minopPayrollStructurePage.SelectSalaryHeads()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Select Head Nor Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.VerifyDeduction()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);
		if (minopPayrollStructurePage.ClickonPFCheckbox()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		// CheckPFTemplateCheckbox
		Thread.sleep(5000);
		if (minopPayrollStructurePage.CheckPFTemplateCheckbox()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		// CheckPFTemplateCheckbox
		Thread.sleep(5000);
		if (minopPayrollStructurePage.ClickonSaveDeduction()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(5000);

		if (minopPayrollStructurePage.VerifynewDeduction()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonProfessTaxCheckbox()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonNewDeduction()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSavenewDeduction()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.VerifyLoan()) {
			logResults.createLogs("Y", "PASS", "Enter the Loan text box" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Loan not enter: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);

		if (minopPayrollStructurePage.ClickonLoanCheckbox()) {
			logResults.createLogs("Y", "PASS", "Loan Checkbox check Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Loan Checkbox not checked: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.FinalSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Save Button Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		/*
		 * if (minopPayrollStructurePage.VerifySuccessPayrollmessage()) {
		 * logResults.createLogs("Y", "PASS", "Verify Save Button Display Successfully"
		 * + ""); } else { logResults.createLogs("Y", "FAIL",
		 * "Data Search A sPer Enter in The SearchTextbox: " +
		 * minopPayrollStructurePage.getExceptionDesc()); }
		 */

		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 13)
	public void Payroll_structure_14() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that newly created Payroll Structure is display in the grid..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 14)
	public void Payroll_structure_15() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on Assign from any Payroll Structure record then Assign Employee window is open..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
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
	}

	@Test(enabled = true, priority = 15)
	public void Payroll_structure_16() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that in Company name, Branch Name, Department and Designation data are display as per selection of data..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName,Companyname");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String Companyname = data.get(3);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.AssignBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyAssignBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Branch Page Diplay Successfully" + "");
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
	}

	@Test(enabled = true, priority = 16)
	public void Payroll_structure_17() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Filter are working properly..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName,Companyname");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String Companyname = data.get(3);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.AssignBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyAssignBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Branch Page Diplay Successfully" + "");
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
			logResults.createLogs("Y", "PASS", "Verify Company Selected Successfuly" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Company not Selected Display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 17)
	public void Payroll_structure_18() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that employee is assign successfully to Payroll Structure.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.AssignBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyAssignBranch()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Branch Page Diplay Successfully" + "");
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

//		if (MinopPayrollStructurePage.SearchEmployeeAssign(SearchStructureName)) {
//			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Assign Button Not Display: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
		if (minopPayrollStructurePage.SelectfirstAssignAll()) {
			logResults.createLogs("Y", "PASS", "Verify Assign Button Click Successfully" + "");
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

	@Test(enabled = true, priority = 18)
	public void Payroll_structure_19() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that when user click on Edit button then edit window is open..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);

		// if (StructurenameTXt == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_14_Payroll_Structure_14 runs successfully
		// before this test.");
		// }
//
		// MinopPayrollStructurePage.setfullTitle1(StructurenameTXt);
		// System.out.println("Full Title used in Test Case 13: " + StructurenameTXt);

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
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
//			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
//					+ MinopPayrollStructurePage.getExceptionDesc());
//		}
			Thread.sleep(2000);
			if (minopPayrollStructurePage.ClickonEditDot()) {
				logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
			} else {
				logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
						+ minopPayrollStructurePage.getExceptionDesc());
			}
			if (minopPayrollStructurePage.ClickonEditButton()) {
				logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
			} else {
				logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
						+ minopPayrollStructurePage.getExceptionDesc());
			}
			if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
				logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
			} else {
				logResults.createLogs("Y", "FAIL",
						"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
			}
		}
	}

	@Test(enabled = true, priority = 19)
	public void Payroll_structure_20() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that validation message display if mandatory fields are kept blank in Edit Window.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName,Companyname,Branchname,Departmentname");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		String Companyname = data.get(5);
		String Branchname = data.get(6);
		String Departmentname = data.get(7);
		// String Searchtype = data.get(4);

		// if (StructurenameTXt == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_14_Payroll_Structure_14 runs successfully
		// before this test.");
		// }
//
		// MinopPayrollStructurePage.setfullTitle1(StructurenameTXt);
		// System.out.println("Full Title used in Test Case 13: " + StructurenameTXt);

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
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.blankStructurename()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.blankStructuretype()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyValidationmsg()) {
			logResults.createLogs("Y", "PASS", "Verify Validation Message");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 20)
	public void Payroll_structure_21() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data Edited successfully when all Mandatory fields are filled in Edit Window..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String StructureName = data.get(2);
		String StructureType = data.get(3);
		String SearchStructureName = data.get(4);
//		String Companyname = data.get(5);
//		String Branchname = data.get(6);
//		String Departmentname = data.get(7);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.updateStructurename(StructureName)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Name Successfully");

			StructurenameTXt = minopPayrollStructurePage.getStructurenameTXt();
			System.out.println("Full Title set in Test Case 11: " + StructurenameTXt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.updateStructureType(StructureType)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Type successfully");

			StructureTypeTxt = minopPayrollStructurePage.getStructureTypeTxt();
			System.out.println("Full Title set in Test Case 11: " + StructureTypeTxt);

		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.FinalSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Save Button Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 21)
	public void Payroll_structure_22() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Edited data display in the Grid after updating the data..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Searchtype = data.get(4);

//		if (StructurenameTXt == null) {
//				throw new IllegalStateException(
//						"fullTitle is null. Ensure Test.");
//				//Ensure that pay_Payroll_Structure runs successfully before this test
//		}
//
//		MinopPayrollStructurePage.setfullTitle1(StructurenameTXt);
//			System.out.println("Full Title used in Test Case 13: " + StructurenameTXt);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 22)
	public void Payroll_structure_24() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that Pagination works when click Next/Previous button..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC, "user,password");

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyClickPagination()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 23)
	public void Payroll_structure_26() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Check that validation message is display when entered duplicated Head name.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName,HeadType,HeadTitle,CalculationTypes,Percentage");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String HeadType = data.get(3);
		String HeadTitle = data.get(4);
		String CalculationTypes = data.get(5);
		String Percentage = data.get(6);

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
		Thread.sleep(2000);

		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateHead()) {
			logResults.createLogs("Y", "PASS", "Verify Create Head Page Opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head Page not get Open : " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.enterHeadTitle(HeadTitle)) {
			logResults.createLogs("Y", "PASS", "Create Head title display successfully");

			fullTitle1 = minopPayrollStructurePage.getfullTitle1();
			System.out.println("Full Title set in Test Case 4: " + fullTitle1);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Head title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.SelectHeadType(HeadType)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.SelectCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.enterPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonCreateheadbtn()) {
			logResults.createLogs("Y", "PASS", "Click on Create Head Button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"not Click on Save Button: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyDuplicateHeadMessageTxt()) {
			logResults.createLogs("Y", "PASS", "Click on Create Head Button successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"not Click on Save Button: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 24)
	public void Payroll_structure_28() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that validation message is display when entered duplicated Payroll Structure name.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
//		String SearchHeadTitle = data.get(4);
		// String Searchtype = data.get(4);

		// if (fullTitle1 == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_9_Payroll_Structure_9 runs successfully
		// before this test.");
		// }

		// MinopPayrollStructurePage.setfullTitle1(fullTitle1);
		// System.out.println("Full Title used in Test Case 10: " + fullTitle1);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.Structurename(Structurename)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Name Successfully");

			StructurenameTXt = minopPayrollStructurePage.getStructurenameTXt();
			System.out.println("Full Title set in Test Case 4: " + StructurenameTXt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.StructureType(Structuretype)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Type successfully");

			StructureTypeTxt = minopPayrollStructurePage.getStructureTypeTxt();
			System.out.println("Full Title set in Test Case 4: " + StructureTypeTxt);

		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyValidationmsgforSameStructurename()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Validation message not Diplay not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 25)
	public void Payroll_structure_30() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that newly created Payroll Structure is display in the grid..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 26)
	public void Payroll_structure_31() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that data searched when user enter invalid data in the Search Textboxes of the Payroll Structure grid.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(10000);
		if (minopPayrollStructurePage.VerifyBlankTbl()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = false, priority = 27)
	public void Payroll_structure_32() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on More Options then Calculation type window is open.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 28)
	public void Payroll_structure_33() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that when user click on + button then new calculation column is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.Clickonplusbutton()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifynewCalculationWindow()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 29)
	public void Payroll_structure_34() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that new calculation type is added successfully after selection of calculation type and filling all fields.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName,CalculationTypes,Percentage");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		String CalculationTypes = data.get(5);
		String Percentage = data.get(6);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
//		if (MinopPayrollStructurePage.Clickonplusbutton()) {
//			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Data Search A sPer Enter in The SearchTextbox: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
//		if (MinopPayrollStructurePage.VerifynewCalculationWindow()) {
//			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Data Search A sPer Enter in The SearchTextbox: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
		Thread.sleep(3000);
		if (minopPayrollStructurePage.SelectCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(3000);
		if (minopPayrollStructurePage.enterPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonUpdateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 30)
	public void Payroll_structure_35() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(" Scenario: Check that up to 3 calculations types user can add in 1 Head type..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName,CalculationTypes,Percentage,CalculationTypes1");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		String CalculationTypes = data.get(3);
		String Percentage = data.get(4);
		String CalculationTypes1 = data.get(5);
		// String Searchtype = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.Clickonplusbutton()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifynewCalculationWindow()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.SelectnewCalculationType(CalculationTypes)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.enternewPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.Clickonplusbutton()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.Select2ndCalculationType(CalculationTypes1)) {
			logResults.createLogs("Y", "PASS", "Head type dropdwon value select successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Head type dropdwon value not select: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.enterSecondPercentagetxt(Percentage)) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonUpdateHeadBtn()) {
			logResults.createLogs("Y", "PASS", "Percentage enter successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Percentage not enter successfully: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 31)
	public void Payroll_structure_36() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when user click on cancel button from calculation type window then calculation type column is removed.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickoncancelBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 32)
	public void Payroll_structure_37() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that when click on cancel from selected head type then head is remove from the step-3 grid..");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonMoreoptionBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyCalculationTypes()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickoncancelBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 33)
	public void Payroll_structure_38() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario: Check that on step 4( View & Save) page by default salary calaculation breakdown structure is display.");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);
		// String SearchHeadTitle = data.get(5);

//		String SearchHeadTitle = data.get(4);
		// String Searchtype = data.get(4);

		// if (fullTitle1 == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_9_Payroll_Structure_9 runs successfully
		// before this test.");
		// }

		// MinopPayrollStructurePage.setfullTitle1(fullTitle1);
		// System.out.println("Full Title used in Test Case 10: " + fullTitle1);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
//		if (MinopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
//			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Data Search A sPer Enter in The SearchTextbox: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
//		Thread.sleep(5000);
//		if (MinopPayrollStructurePage.SelectSalaryHeads()) {
//			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Create Structure title not display: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
//		

		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 34)
	public void Payroll_structure_39() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that on step 4(View & Save) page when user enter desired amount in textbox then salary calculation correctly is display in salary breakdown structure. ");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		// String SearchHeadTitle = data.get(5);

//		String SearchHeadTitle = data.get(4);
		// String Searchtype = data.get(4);

		// if (fullTitle1 == null) {
		// throw new IllegalStateException(
		// "fullTitle is null. Ensure that pay_9_Payroll_Structure_9 runs successfully
		// before this test.");
		// }

		// MinopPayrollStructurePage.setfullTitle1(fullTitle1);
		// System.out.println("Full Title used in Test Case 10: " + fullTitle1);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
//		if (MinopPayrollStructurePage.enterSearchtxt(SearchHeadTitle)) {
//			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Data Search A sPer Enter in The SearchTextbox: " + MinopPayrollStructurePage.getExceptionDesc());
//		}
//		Thread.sleep(5000);
//		if (MinopPayrollStructurePage.SelectSalaryHeads()) {
//			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Create Structure title not display: " + MinopPayrollStructurePage.getExceptionDesc());
//		}

		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterAmount()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonviewBtn()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
	}

	@Test(enabled = true, priority = 35)
	public void Payroll_structure_40() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that when user click on save button from last step then payroll structure is created successfully. ");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String SearchStructureName = data.get(2);
		// String SearchHeadTitle = data.get(5);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonEditDot()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

//		Thread.sleep(5000);
//		if (MinopPayrollStructurePage.SelectSalaryHeads()) {
//			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Create Structure title not display: " + MinopPayrollStructurePage.getExceptionDesc());
//		}

		if (minopPayrollStructurePage.ClickonNextBtn1()) {
			logResults.createLogs("Y", "PASS", "Verify Nect Button is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonNextBtn2()) {
			logResults.createLogs("Y", "PASS", "Verify Next Button Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyPreviewandEditButton()) {
			logResults.createLogs("Y", "PASS", "Verify Preview and Edit Page Open Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyviewandSavePage()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.EnterAmount()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.ClickonviewBtn()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.FinalSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Verify view and Save Page opens Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		/*
		 * if (minopPayrollStructurePage.VerifySuccessPayrollmessage()) {
		 * logResults.createLogs("Y", "PASS", "Verify Save Button Display Successfully"
		 * + ""); } else { logResults.createLogs("Y", "FAIL",
		 * "Data Search A sPer Enter in The SearchTextbox: " +
		 * minopPayrollStructurePage.getExceptionDesc()); }
		 */

		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Data Search A sPer Enter in The SearchTextbox: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.verifyStructurenameTitleSearch()) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 36)
	public void Payroll_structure_41() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that when user click on cancel button from any step then delete payroll pop up window is open. ");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.Structurename(Structurename)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Name Successfully");

			StructurenameTXt = minopPayrollStructurePage.getStructurenameTXt();
			System.out.println("Full Title set in Test Case 4: " + StructurenameTXt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(1000);
		if (minopPayrollStructurePage.StructureType(Structuretype)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Type successfully");

			StructureTypeTxt = minopPayrollStructurePage.getStructureTypeTxt();
			System.out.println("Full Title set in Test Case 4: " + StructureTypeTxt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonCancelPageBTN()) {
			logResults.createLogs("Y", "PASS", "Verify Click Cancel Btn Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyDeletePayrollPopup()) {
			logResults.createLogs("Y", "PASS", "Verify Delete PayrollPopup  Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Delete Payroll Popup not display: " + minopPayrollStructurePage.getExceptionDesc());
		}

	}

	@Test(enabled = true, priority = 37)
	public void Payroll_structure_42() throws InterruptedException {
		String currTC = Thread.currentThread().getStackTrace()[1].getMethodName();
		logResults.createExtentReport(currTC);
		logResults.setScenarioName(
				" Scenario:Check that when user click on cancel button from any step and then click on yes button from delete payroll pop up then payroll structure is deleted successfully. ");

		ArrayList<String> data = initBase.loadExcelData("Payroll_structure", currTC,
				"user,password,StructureName,StructureType,SearchStructureName");

		String user = data.get(0);
		String pass = data.get(1);
		String Structurename = data.get(2);
		String Structuretype = data.get(3);
		String SearchStructureName = data.get(4);

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
		Thread.sleep(2000);
		if (minopHomeChromePage.ClickOnPayStructureLink()) {
			logResults.createLogs("Y", "PASS", "Click Pay Structure Link successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Payroll Structure link is not clickable: " + minopHomeChromePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.verifyPayStructurepagename()) {
			logResults.createLogs("Y", "PASS", "Structure  display successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Structure not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.clickonNewPayrollBtn()) {
			logResults.createLogs("Y", "PASS", "Create Structure button click successfully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure button not clickable: " + minopPayrollStructurePage.getExceptionDesc());
		}
//		if (minopPayrollStructurePage.VerifyStructurenameTitle()) {
//			logResults.createLogs("Y", "PASS", "Create payroll Structure display successfully");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
//		}
		if (minopPayrollStructurePage.Structurename(Structurename)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Name Successfully");

			StructurenameTXt = minopPayrollStructurePage.getStructurenameTXt();
			System.out.println("Full Title set in Test Case 4: " + StructurenameTXt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(1000);
		if (minopPayrollStructurePage.StructureType(Structuretype)) {
			logResults.createLogs("Y", "PASS", "Enter Structure Type successfully");

			StructureTypeTxt = minopPayrollStructurePage.getStructureTypeTxt();
			System.out.println("Full Title set in Test Case 4: " + StructureTypeTxt);
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.ClickonSaveBtn()) {
			logResults.createLogs("Y", "PASS", "Click on Save Button SuccessFully");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		if (minopPayrollStructurePage.VerifyEarningPage()) {
			logResults.createLogs("Y", "PASS", "Verify Earning Page Display Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonCancelPageBTN()) {
			logResults.createLogs("Y", "PASS", "Verify Click Cancel Btn Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Create Structure title not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
//		if (minopPayrollStructurePage.VerifyDeletePayrollPopup()) {
//			logResults.createLogs("Y", "PASS", "Verify Delete PayrollPopup  Display Successfully" + "");
//		} else {
//			logResults.createLogs("Y", "FAIL",
//					"Delete Payroll Popup not display: " + minopPayrollStructurePage.getExceptionDesc());
//		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.ClickonYesBtn()) {
			logResults.createLogs("Y", "PASS", "Verify Yes Button Click Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL",
					"Delete Payroll Popup not display: " + minopPayrollStructurePage.getExceptionDesc());
		}
		Thread.sleep(2000);
		if (minopPayrollStructurePage.EnterStructurenameSearchTxt(SearchStructureName)) {
			logResults.createLogs("Y", "PASS", "Verify Search Functionality is Working Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
		}

		if (minopPayrollStructurePage.VerifyIncompleteTitle()) {
			logResults.createLogs("Y", "PASS", "Verify Incomplete title Display  Successfully" + "");
		} else {
			logResults.createLogs("Y", "FAIL", "Data not Search as per Enter in The SearchTextbox: "
					+ minopPayrollStructurePage.getExceptionDesc());
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
