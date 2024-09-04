package browserpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.initBase;
import utils.Utils;

public class MinopEmployeeSalaryPage {

	WebDriver driver;
	initBase intiBase = new initBase();
	private static String exceptionDesc;
	Utils utils = new Utils(driver);
	private String fullTitle;

	public MinopEmployeeSalaryPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class=\"page-breadcrumb\"]//span[contains(text(),\"Employee Salary\")]")
	private WebElement verifyEmployeeSalaryTitle;

	@FindBy(xpath = "//a[@id='Assign_payroll_str']")
	private WebElement clickOnAssignPayrollBtn;

	@FindBy(id = "ajax_loader")
	private WebElement ajaxVerify;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement dataTableEmpty;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement txtSearch;

	@FindBy(xpath = "(//a[@title='Next'])[1]")
	private WebElement clickOnPagination;

	@FindBy(xpath = "//tr[@class=\"odd\"]//div[@class=\"dayswise_action blue_font\"][normalize-space()=\"Update CTC\"]")
	private WebElement verifyUpdateCtcBtn;

	@FindBy(xpath = "//div[@id=\"Strcture_name\"]")
	private WebElement verifyUpdateCTCTitle;

	@FindBy(xpath = "//input[@id=\"Ctc_input\"]")
	private WebElement verifyTxtCTC;
	
	@FindBy(xpath = "//button[@id='FirstNext']")
	private WebElement verifyFirstNextBtn;
	
	@FindBy(id = "Bank_holder_name")
	private WebElement txtBankHolderName;
	
	@FindBy(id = "Bank_IFSC_Code")
	private WebElement txtBankIFSCCode;
	
	@FindBy(id = "Bank_account_number")
	private WebElement txtBankAccountNumber;
	
	@FindBy(id = "Bank_branch_name")
	private WebElement txtBankBaranchName;
	
	@FindBy(id = "save_btn")
	private WebElement btnSave;
	
	@FindBy(xpath = "//div[text()='Bank detils saved successfully']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//div[text()='Updated successfully']")
	private WebElement updateMessage;
	
	@FindBy(xpath = "//div[@class=\"enc_ctc ctc\"]")
	private WebElement verifyCTC;
	
	@FindBy(xpath = "//div[@class=\"dayswise_action blue_font\"]")
	private WebElement verifyUpdateCTCbtn;
	
	@FindBy(xpath = "//div[@class=\"toast toast-error\"]")
	private WebElement verifyValidationMsg;
	
	@FindBy(xpath = "(//button[@title='Select Company'])[1]")
	private WebElement CompanyDrp;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchCompany;
	
	@FindBy(xpath = "(//button[@title='Select Branch'])[1]")
	private WebElement BranchDrp;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectCompanyCheckbox;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchBranch;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectBranchCheckbox;
	
	@FindBy(xpath = "//button[@id=\"btnSubmit\"]")
	private WebElement VerifyOnApplybtn;
	
	@FindBy(xpath = "(//button[@id='FirstSave'])[1]")
	private WebElement verifySaveAmountBtn;
	
	public boolean VerifyupdateMessage() {
		try {
			utils.waitForEle(updateMessage, "visible", null);
			updateMessage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickOnSaveAmountBtn() {
		try {
			utils.waitForEle(verifySaveAmountBtn, "visible", null);
			verifySaveAmountBtn.isDisplayed();
			verifySaveAmountBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickOnApplyBtn() {
		try {
			utils.waitForEle(VerifyOnApplybtn, "visible", null);
			VerifyOnApplybtn.isDisplayed();
			VerifyOnApplybtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean CheckCheckBoxBranch() {
		try {
			utils.waitForEle(SelectBranchCheckbox, "visible", null);
			SelectBranchCheckbox.isDisplayed();
			SelectBranchCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickonDrpBranchname() {
		try {
//			utils.waitForEle(BranchDrp, "visible", "", 5);
//			Select drpBranch = new Select(BranchDrp);
//			drpBranch.selectByVisibleText(Branchname);
			utils.waitForEle(BranchDrp, "visible", null);
			BranchDrp.isDisplayed();
			BranchDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean SearchBranchname(String Branchname) {
		try {
			// if (fullTitle1 == null) {
			// throw new Exception("fullTitle1 is null");
			// }
			utils.waitForEle(SearchBranch, "visible", "", 3);
			SearchBranch.isDisplayed();
			SearchBranch.click();
			SearchBranch.clear();
			System.out.println("Enter the text:");

		//	fullTitle1 = SearchHeadTitle + executionRunTime;
			SearchBranch.sendKeys(Branchname);
			System.out.println("After enter thre text: " + Branchname);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	
	public boolean ClickonDrpCompanyname() {
		try {
//			utils.waitForEle(CompanyDrp, "visible", "", 5);
//			Select drpcompany = new Select(CompanyDrp);
//			drpcompany.selectByVisibleText(Companyname);
			utils.waitForEle(CompanyDrp, "visible", null);
			CompanyDrp.isDisplayed();
			CompanyDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean Searchcompanyname(String Companyname) {
		try {
			
			utils.waitForEle(SearchCompany, "visible", "", 3);
			SearchCompany.isDisplayed();
			SearchCompany.click();
			SearchCompany.clear();
			System.out.println("Enter the text:");

		//	fullTitle1 = SearchHeadTitle + executionRunTime;
			SearchCompany.sendKeys(Companyname);
			System.out.println("After enter thre text: " + Companyname);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean CheckCheckBoxcompany() {
		try {
			utils.waitForEle(SelectCompanyCheckbox, "visible", null);
			SelectCompanyCheckbox.isDisplayed();
			SelectCompanyCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	
	public boolean verifyValidationMsg() {
		try {
			utils.waitForEle(verifyValidationMsg, "visible", "", 5);
			verifyValidationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	
	
	public boolean verfiyUpdateCTCbtn() {
		try {
			utils.waitForEle(verifyUpdateCTCbtn, "visible", "", 5);
			verifyUpdateCTCbtn.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	public boolean ClickUpdateCTCbtn() {
		try {
			utils.waitForEle(verifyUpdateCTCbtn, "visible", "", 5);
			verifyUpdateCTCbtn.isDisplayed();
			verifyUpdateCTCbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	
	public boolean verfiyCTCMonth() {
		try {
			utils.waitForEle(verifyCTC, "visible", "", 5);
			verifyCTC.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	
	public boolean verifySuccessMsg() {
		try {
			utils.waitForEle(successMessage, "visible", "", 10);
			successMessage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	
	
	public boolean entertxtBankBaranchName(String BranchName) {
		try {

			utils.waitForEle(txtBankBaranchName, "visible", "", 5);
			txtBankBaranchName.click();
			txtBankBaranchName.clear();

			txtBankBaranchName.sendKeys(BranchName);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	
	public boolean entertxtBankAccountNumber(String BankAccountNumber) {
		try {

			utils.waitForEle(txtBankAccountNumber, "visible", "", 5);
			txtBankAccountNumber.click();
			txtBankAccountNumber.clear();

			txtBankAccountNumber.sendKeys(BankAccountNumber);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	public boolean entertxtBankIFSCCode(String BankIFSCCode) {
		try {

			utils.waitForEle(txtBankIFSCCode, "visible", "", 5);
			txtBankIFSCCode.click();
			txtBankIFSCCode.clear();

			txtBankIFSCCode.sendKeys(BankIFSCCode);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	public boolean entertxtBankHolderName(String BankHolderName) {
		try {

			utils.waitForEle(txtBankHolderName, "visible", "", 5);
			txtBankHolderName.click();
			txtBankHolderName.clear();

			txtBankHolderName.sendKeys(BankHolderName);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	
	public boolean ClickOnSaveBtn() {
		try {
			utils.waitForEle(btnSave, "visible", "", 5);
			btnSave.isDisplayed();
			btnSave.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	
	public boolean ClickOnFirstNextBtn() {
		try {
			utils.waitForEle(verifyFirstNextBtn, "visible", "", 5);
			verifyFirstNextBtn.isDisplayed();
			verifyFirstNextBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterCTCtxt(String Amount) {
		try {

			utils.waitForEle(verifyTxtCTC, "visible", "", 5);
			verifyTxtCTC.click();
			verifyTxtCTC.clear();

			verifyTxtCTC.sendKeys(Amount);
			Thread.sleep(1000);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyClickOnPagination() {
	    try {
	        // Wait for the pagination button to be visible and interactable
	        utils.waitForEle(clickOnPagination, "visible", "", 5);

	        // Check if the pagination button is enabled and interactable
	        if (isEnable(clickOnPagination) && clickOnPagination.isDisplayed() && clickOnPagination.getSize().getWidth() > 0 && clickOnPagination.getSize().getHeight() > 0) {
	            clickOnPagination.click();
	            System.out.println("Next button clicked.");
	        } else {
	            System.out.println("Next button is disabled or not interactable. Test case passed.");
	        }
	    } catch (Exception e) {
	        exceptionDesc = e.getMessage();
	        return false;
	    }
	    return true;
	}
	
	public static boolean isEnable(WebElement button) {
		// Check if the button's parent <li> has the class "disabled"
		WebElement parentLi = button.findElement(By.xpath("./parent::*"));
		return !parentLi.getAttribute("class").contains("disabled");
	}

	
	public boolean verifyUpdateCTCTitle() {
		try {
			utils.waitForEle(verifyUpdateCTCTitle, "visible", "", 5);
			verifyUpdateCTCTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyEmployeeSalaryTitle() {
		try {
			utils.waitForEle(verifyEmployeeSalaryTitle, "visible", "", 5);
			verifyEmployeeSalaryTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickOnUpdateCTC() {
		try {
			utils.waitForEle(verifyUpdateCtcBtn, "visible", "", 5);
			verifyUpdateCtcBtn.isDisplayed();
			verifyUpdateCtcBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterSearchtxt(String Search) {
		try {

			utils.waitForEle(txtSearch, "visible", "", 5);
			txtSearch.click();
			txtSearch.clear();
			System.out.println("Enter the text:");
			fullTitle = Search + initBase.executionRunTime;
			txtSearch.sendKeys(fullTitle);
//			System.out.println("After enter thre text: " + fullTitle);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyTitleInTable() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_loader")));
			String xpath = "//td[normalize-space()='" + fullTitle + "']";
			System.out.println(xpath);
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean verifyDataTableEmpty() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_loader")));
			utils.waitForEle(dataTableEmpty, "visible", null);
			dataTableEmpty.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnAssignPayrollBtn() {
		try {
			// Wait for the blocking element to disappear
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax_loader")));

			// Wait for the button to be visible and enabled
			wait.until(ExpectedConditions.visibilityOf(clickOnAssignPayrollBtn));
			wait.until(ExpectedConditions.elementToBeClickable(clickOnAssignPayrollBtn));

			// Click the button
			clickOnAssignPayrollBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public String getExceptionDesc() {
		return this.exceptionDesc;
	}

	public void setExceptionDesc(String exceptionDesc) {
		exceptionDesc = exceptionDesc;
	}

}
