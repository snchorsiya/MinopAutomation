package browserpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.initBase;
import utils.Utils;

public class MinopSalaryProcessPage {

	static WebDriver driver;
	initBase intiBase = new initBase();
	private static String exceptionDesc;
	Utils utils = new Utils(driver);
	private String SearchTxt;
	private String netSalary;

	public MinopSalaryProcessPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains(text(),'Salary Process')])[2]")
	private WebElement SalayTitle;

	@FindBy(xpath = "//button[@id=\"btnSubmit\"]")
	private WebElement clickonSubmitbtn;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectBranchCheckbox;

	@FindBy(xpath = "//button[@title='Select Company']")
	private WebElement CompanyDrp;

	@FindBy(xpath = "(//button[@title='Select Branch'])[1]")
	private WebElement BranchDrp;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement searchTxt;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement BrnSearchTxt;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectCompanyCheckbox;

	@FindBy(xpath = "(//div[@class='final_summary_list'])[2]")
	private WebElement verifySPList;

	@FindBy(xpath = "//table[@id='Generate_TDS_table']//thead//tr[1]//th[7]")
	private WebElement VerifyPyrollColumn;

	@FindBy(xpath = "//table[@id='Generate_TDS_table']//thead//tr[2]//th[3]//input[@placeholder='Search']")
	private WebElement verifySearchTxt;

	@FindBy(xpath = "//td[@class=\"dataTables_empty\"]")
	private WebElement verifyInvalidData;

	@FindBy(xpath = "//li[@class=\"next disabled\"]")
	private WebElement clickOnPagination;

	@FindBy(xpath = "//table[@id='Deduction_table']//tbody/tr[4]//div[@class='d-flex justify-content-between']")
	private WebElement verifyNonRecurringIncomeheads;

	@FindBy(xpath = "//table[@id='Generate_TDS_table']//tbody//td[10]//a[@title='Edit']")
	private WebElement clickOnEditIcon;

	@FindBy(xpath = "(//td[@class='fixed-column-1'])[1]")
	private WebElement verifynetPaySalary;

	@FindBy(xpath = "(//input[contains(@class, 'form-control') and contains(@class, 'input-sm') and contains(@class, 'Pay_days')])[2]")
	private WebElement customColumnAmount;

	@FindBy(xpath = "//table[@id='Generate_TDS_table']//tbody//td[10]//a[@title='Update']")
	private WebElement clickOnUpdateBtn;

	@FindBy(xpath = "//div[text()='Data updated successfully.']")
	private WebElement verifyUpdateSuccessMsg;

	@FindBy(xpath = "//table[@id='Generate_TDS_table']//tbody//tr//td[1]")
	private WebElement clickCheckbox;

	@FindBy(xpath = "//a[@id='Freezed_status']")
	private WebElement clickOnFreeBtn;

	@FindBy(xpath = "//div[text()='Eployee Salary successfully Freezed']")
	private WebElement verifyFreezedSuccessMsg;

	@FindBy(xpath = "(//div[@class='final_summary_list green_font'])[2]")
	private WebElement verifySFStatus;

	@FindBy(xpath = "(//select[@id='Status_filter'])[1]")
	private WebElement selectStatusdrp;

	@FindBy(xpath = "(//a[normalize-space()='On hold'])[1]")
	private WebElement clickOnHoldBtn;

	@FindBy(xpath = "(//div[@class='final_summary_list red_font'])[2]")
	private WebElement verifySOHStatus;

	@FindBy(xpath = "(//button[@class='dt-button buttons-excel buttons-html5'])[1]")
	private WebElement clickOnExcelbtn;

	public boolean verifyclickOnExcelbtn() {
		try {
			utils.waitForEle(clickOnExcelbtn, "visible", "", 5);
			clickOnExcelbtn.isDisplayed();
			clickOnExcelbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySOHStatus() {
		try {
			utils.waitForEle(verifySOHStatus, "visible", "", 5);
			verifySOHStatus.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnHoldBtn() {
		try {
			utils.waitForEle(clickOnHoldBtn, "visible", "", 5);
			clickOnHoldBtn.isDisplayed();
			clickOnHoldBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyselectStatusdrp(String Status) {
		try {
			utils.waitForEle(selectStatusdrp, "visible", "", 5);
			verifySFStatus.isDisplayed();
			Select ststDrp = new Select(selectStatusdrp);
			ststDrp.selectByVisibleText(Status);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySFStatus() {
		try {
			utils.waitForEle(verifySFStatus, "visible", "", 5);
			verifySFStatus.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyFreezedSuccessMsg() {
		try {
			utils.waitForEle(verifyUpdateSuccessMsg, "visible", "", 5);
			verifyFreezedSuccessMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnFreeBtn() {
		try {
			utils.waitForEle(clickOnFreeBtn, "visible", "", 5);
			clickOnFreeBtn.isDisplayed();
			clickOnFreeBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickCheckbox() {
		try {
			utils.waitForEle(clickCheckbox, "visible", "", 5);
			clickCheckbox.isDisplayed();
			clickCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyUpdateSuccessMsg() {
		try {
			utils.waitForEle(verifyUpdateSuccessMsg, "visible", "", 5);
			verifyUpdateSuccessMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnUpdateBtn() {
		try {
			utils.waitForEle(clickOnUpdateBtn, "visible", "", 5);
			clickOnUpdateBtn.isDisplayed();
			clickOnUpdateBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	/*
	 * public boolean verifyNetAmount() { try { utils.waitForEle(verifynetPaySalary,
	 * "visible", "", 5); if (netSalary.equals(verifynetPaySalary.getText())) {
	 * System.out.println("Net Salary equal"); return true; } else {
	 * System.out.println("Net Salary not equal"); return false; }
	 * 
	 * } catch (Exception e) { exceptionDesc = e.getMessage().toString(); return
	 * false; }
	 * 
	 * }
	 */

	public boolean verifyNetAmount() {
	    try {
	        utils.waitForEle(verifynetPaySalary, "visible", "", 5);

	        // Normalize both the expected and actual values for comparison
	        String expectedSalary = netSalary.trim().replaceAll("[^\\d.]", ""); // Remove non-numeric characters
	        String actualSalary = verifynetPaySalary.getText().trim().replaceAll("[^\\d.]", "");

	        System.out.println("Expected Salary (normalized): " + expectedSalary);
	        System.out.println("Actual Salary (normalized): " + actualSalary);

	        // Compare the normalized values
	        if (expectedSalary.equals(actualSalary)) {
	            System.out.println("Net Salary equal");
	            return true;
	        } else {
	            // Log the difference for debugging
	            System.out.println("Net Salary not equal. Expected: " + expectedSalary + ", Actual: " + actualSalary);
	            return false;
	        }

	    } catch (Exception e) {
	        exceptionDesc = "Error in verifyNetAmount: " + e.getMessage();
	        System.out.println("Exception occurred: " + exceptionDesc);
	        e.printStackTrace(); // Log the stack trace for debugging
	        return false;
	    }
	}

	public boolean scrollToElement() {

		utils.waitForEle(verifynetPaySalary, "visible", "", 5);
		verifynetPaySalary.isDisplayed();
		netSalary = verifynetPaySalary.getText();
		System.out.println("The net salary is: " + netSalary);

		WebElement columVeri = driver.findElement(By.xpath("//table[@id='Generate_TDS_table']/.."));

		int offset = 320;

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollLeft + arguments[1];", columVeri, offset);
		columVeri.isDisplayed();
		System.out.println("-----------------" + columVeri.isDisplayed());

		return true;
	}

	public boolean verifycustomColumnAmount() {
		try {
			utils.waitForEle(customColumnAmount, "visible", null);

			// Perform your action on the element, e.g., click
			customColumnAmount.click();
			System.out.println(customColumnAmount.isEnabled());
			customColumnAmount.clear(); // Clear any existing value before entering a new one
			customColumnAmount.sendKeys("1000");
			System.out.println("The net salary is: " + netSalary);

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			System.out.println("An error occurred: " + exceptionDesc);
			return false;
		}
		return true;
	}

	public boolean verifyclickOnEditIcon() {
		try {
			utils.waitForEle(clickOnEditIcon, "visible", "", 5);
			clickOnEditIcon.isDisplayed();
			clickOnEditIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyEditRecrd() {
		try {
			// Wait for the element to be visible
			utils.waitForEle(clickOnEditIcon, "visible", "", 5);

			// Check if the element is displayed
			if (clickOnEditIcon.isDisplayed()) {
				clickOnEditIcon.click();
				System.out.println("Edit button is displayed.");
				return false; // Return false to indicate the test should fail
			} else {
				System.out.println("Edit button is not displayed.");
				return true; // Return true to indicate the test should pass
			}
		} catch (NoSuchElementException e) {
			// If element is not found, consider it as not displayed and pass the test
			System.out.println("Edit button not found: " + e.getMessage());
			return true; // Return true to pass the test
		} catch (Exception e) {
			// Handle any other exceptions
			exceptionDesc = e.getMessage();
			System.out.println("An unexpected error occurred: " + e.getMessage());
			return false; // Return false for any other exceptions
		}
	}

	public boolean VerifyClickOnPagination() {
		try {
			// Wait for the pagination button to be visible and interactable
			utils.waitForEle(clickOnPagination, "visible", "", 5);

			// Check if the pagination button is enabled and interactable
			if (isEnable(clickOnPagination) && clickOnPagination.isDisplayed()
					&& clickOnPagination.getSize().getWidth() > 0 && clickOnPagination.getSize().getHeight() > 0) {
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

	public boolean verifyInvalidData() {
		try {
			utils.waitForEle(verifyInvalidData, "visible", "", 5);
			verifyInvalidData.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifySearchTxt(String Search) {
		try {
			utils.waitForEle(verifySearchTxt, "visible", "", 5);
			verifySearchTxt.isDisplayed();
			verifySearchTxt.click();
			SearchTxt = Search;
			verifySearchTxt.sendKeys(SearchTxt);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyTitleInTable() {
		try {
			String xpath = "//p[normalize-space()='" + SearchTxt + "']";

			System.out.println(xpath);
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean verifyClickTitleInTable() {
		try {
			String xpath = "//p[normalize-space()='" + SearchTxt + "']";

			System.out.println(xpath);
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			titleElement.isDisplayed();
			titleElement.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;
	}

	public boolean VerifyPyrollColumn() {
		try {
			utils.waitForEle(VerifyPyrollColumn, "visible", null);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", VerifyPyrollColumn);
//			js.executeScript("javascript:window.scrollBy(250,350)");
			VerifyPyrollColumn.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyNonRecurringIncomeheads() {
		try {
			utils.waitForEle(verifyNonRecurringIncomeheads, "visible", "", 5);
			verifyNonRecurringIncomeheads.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySPList() {
		try {
			utils.waitForEle(verifySPList, "visible", "", 5);
			verifySPList.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickonSubmitbtn() {
		try {
			utils.waitForEle(clickonSubmitbtn, "visible", "", 5);
			clickonSubmitbtn.isDisplayed();
			clickonSubmitbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySalaryTitle() {
		try {
			utils.waitForEle(SalayTitle, "visible", "", 5);
			SalayTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickonDrpCompanyname() {
		try {
			utils.waitForEle(CompanyDrp, "visible", null);
			CompanyDrp.isDisplayed();
			CompanyDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickonDrpBranchname() {
		try {

			utils.waitForEle(BranchDrp, "visible", null);
			BranchDrp.isDisplayed();
			BranchDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean Searchcompanyname(String Companyname) {
		try {
			utils.waitForEle(searchTxt, "visible", "", 3);
			searchTxt.isDisplayed();
			searchTxt.click();
			searchTxt.clear();
			System.out.println("Enter the text:");

			// fullTitle1 = SearchHeadTitle + executionRunTime;
			searchTxt.sendKeys(Companyname);
			System.out.println("After enter thre text: " + Companyname);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean SearchBranchname(String Branchname) {
		try {

			utils.waitForEle(BrnSearchTxt, "visible", "", 3);
			BrnSearchTxt.isDisplayed();
			BrnSearchTxt.click();
			BrnSearchTxt.clear();
			System.out.println("Enter the text:");
			BrnSearchTxt.sendKeys(Branchname);
			System.out.println("After enter thre text: " + Branchname);

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

	public String getExceptionDesc() {
		return exceptionDesc != null ? exceptionDesc : "No exception captured.";
	}

	public void setExceptionDesc(String exceptionDesc) {
		exceptionDesc = exceptionDesc;
	}

}
