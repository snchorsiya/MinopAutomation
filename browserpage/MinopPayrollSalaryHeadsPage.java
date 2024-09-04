package browserpage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.initBase;
import utils.Utils;

public class MinopPayrollSalaryHeadsPage {

	WebDriver driver;
	String randomDateFormat = Utils.getRandomDateFormat();
	private static String exceptionDesc;
	Utils utils = new Utils(driver);
	initBase intiBase = new initBase();
	private String fullTitle;

	public MinopPayrollSalaryHeadsPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='title'][normalize-space()='Salary Heads']")
	private WebElement verifySlaryHeads;

	@FindBy(xpath = "//a[@id='create_payroll']")
	private WebElement clickOnCreateBtn;

	@FindBy(id = "HeadTitle")
	private WebElement txtHeadTitle;

	@FindBy(xpath = "//span[@id='Create_New_Head']")
	private WebElement verifyNewHeadTitle;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	private WebElement verifyValidationMsg;

	@FindBy(xpath = "//div[@id='create_Data']//button[@id='btnsave']")
	private WebElement ClickOnSaveBtn;

	@FindBy(xpath = "//select[@id='HeadType']")
	private WebElement drpHeadType;

	@FindBy(xpath = "(//select[@id='edit_head_drop0'])[1]")
	private WebElement drpCalculationType;

	@FindBy(xpath = "//input[@id='inpid0']")
	private WebElement txtPercentage;

	@FindBy(xpath = "//div[text()='Head add successfully.']")
	private WebElement verifySuccessMsg;

	@FindBy(xpath = "//div[text()='Head Already exists on this deduction type.']")
	private WebElement verifyDuplicateMsg;

	@FindBy(xpath = "//div[text()='Head activated successfully']")
	private WebElement verifyActivatedMsg;

	@FindBy(xpath = "//div[text()='Head inactivated successfully']")
	private WebElement verifyInActivatedMsg;

	@FindBy(xpath = "//div[text()='Head Updated successfully']")
	private WebElement verifyUpdateSuccessMsg;

	@FindBy(id = "head_list_tablesearch")
	private WebElement txtSearch;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement dataTableEmpty;

	@FindBy(xpath = "//div[@id='action_dot']")
	private WebElement clickThreedot;

	@FindBy(xpath = "//ul[@class='action_btn_data']//li[contains(@class, 'blue_font') and contains(text(),'Edit')]")
	private WebElement clickOnEditlink;

	@FindBy(xpath = "//ul[@class='action_btn_data']//li[contains(@class, 'red_font') and contains(text(),'Inactivate')]")
	private WebElement clickOnInactiveLink;

	@FindBy(xpath = "//span[@id='Create_New_Head']")
	private WebElement verifyUpdatePageTitle;

	@FindBy(xpath = "(//a[@title='Next'])[1]")
	private WebElement clickOnPagination;

	@FindBy(xpath = "//td[normalize-space()='Basic']")
	private WebElement tableData1;

	@FindBy(xpath = "//td[normalize-space()='Gratuity']")
	private WebElement tableData2;

	@FindBy(xpath = "//span[normalize-space()='InActive']")
	private WebElement StatusDisplay;

	public boolean VerifyStatusDisplay() {
		try {
			utils.waitForEle(StatusDisplay, "visible", "", 3);
			StatusDisplay.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyActiveMessage() {
		try {
			utils.waitForEle(verifyActivatedMsg, "visible", "", 3);
			verifyActivatedMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyInActiveMessage() {
		try {
			utils.waitForEle(verifyInActivatedMsg, "visible", "", 5);
			verifyInActivatedMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyClickOnPagination() {
		try {
//			WebElement nextButton = driver.findElement(By.xpath("a[title='Next']"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", nextButton);
			js.executeScript("javascript:window.scrollBy(250,350)");
			utils.waitForEle(clickOnPagination, "visible", "", 5);
			List<WebElement> tableDataBefore = driver
					.findElements(By.xpath("//table[@id='head_list_table']//tbody//tr"));
			List<String> dataBefore = new ArrayList<>();
			for (WebElement row : tableDataBefore) {
				dataBefore.add(row.getText());
			}
			clickOnPagination.isDisplayed();
			clickOnPagination.click();
			utils.waitForEle(driver.findElement(By.xpath("//table[@id='head_list_table']//tbody//tr[1]")), "visible",
					"", 5);

			// Get the current table data after clicking "Next"
			List<WebElement> tableDataAfter = driver
					.findElements(By.xpath("//table[@id='head_list_table']//tbody//tr"));
			List<String> dataAfter = new ArrayList<>();
			for (WebElement row : tableDataAfter) {
				dataAfter.add(row.getText());
			}

			// Compare the data before and after pagination
			if (!dataBefore.equals(dataAfter)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean VerifyUpdateSuccessMessage() {
		try {
			utils.waitForEle(verifyUpdateSuccessMsg, "visible", "", 3);
			verifyUpdateSuccessMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnThreeDot() {
		try {
			utils.waitForEle(clickThreedot, "visible", "", 5);
			clickThreedot.isDisplayed();
			clickThreedot.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnEditLink() {
		try {
			WebElement Element = driver.findElement(By.xpath("//div[@id='action_dot']"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnEditlink, "visible", "", 5);
			clickOnEditlink.isDisplayed();
			clickOnEditlink.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnStatusLink() {
		try {
			WebElement Element = driver.findElement(By.xpath("//div[@id='action_dot']"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnInactiveLink, "visible", "", 5);
			clickOnInactiveLink.isDisplayed();
			clickOnInactiveLink.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyUpdatePageTitle() {
		try {
			utils.waitForEle(verifyUpdatePageTitle, "visible", "", 5);
			verifyUpdatePageTitle.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyDataTableEmpty() {
		try {
			utils.waitForEle(dataTableEmpty, "visible", null);
			dataTableEmpty.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterPercentagetxt(String Percentage) {
		try {
			utils.waitForEle(txtPercentage, "visible", null);
			txtPercentage.isDisplayed();
			txtPercentage.clear();

			txtPercentage.sendKeys(Percentage);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean SelectCalculationType(String CalculationTypes) {
		try {
			utils.waitForEle(drpCalculationType, "visible", "", 5);
			Select drpCalculation = new Select(drpCalculationType);
			drpCalculation.selectByVisibleText(CalculationTypes);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean SelectHeadType(String HeadType) {
		try {
			utils.waitForEle(drpHeadType, "visible", "", 5);
			Select drpHead = new Select(drpHeadType);
			drpHead.selectByVisibleText(HeadType);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterHeadTitle(String HeadTitle) {
		try {
			utils.waitForEle(txtHeadTitle, "visible", null);
			if (txtHeadTitle.isDisplayed()) {
				String currentText = txtHeadTitle.getAttribute("value");

				if (!currentText.isEmpty()) {
					txtHeadTitle.clear();
				} else {
					txtHeadTitle.isDisplayed();
					txtHeadTitle.clear();

//					fullTitle = HeadTitle + randomDateFormat;

					txtHeadTitle.sendKeys(HeadTitle + initBase.executionRunTime);
//					System.out.println(fullTitle);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterUpdateHeadTitle(String HeadTitle) {
		try {
			utils.waitForEle(txtHeadTitle, "visible", null);

			txtHeadTitle.isDisplayed();
			txtHeadTitle.clear();

//			fullTitle = HeadTitle + randomDateFormat;

//			txtHeadTitle.sendKeys(fullTitle);
			txtHeadTitle.sendKeys(HeadTitle + initBase.executionRunTime);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterSearchtxt(String Search) {
		try {
//			if (fullTitle == null) {
//				throw new Exception("fullTitle is null");
//			}
			utils.waitForEle(txtSearch, "visible", "", 3);
			txtSearch.isDisplayed();
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

	public boolean enterSearchtxt1() {
		try {

			utils.waitForEle(txtSearch, "visible", "", 3);
			txtSearch.isDisplayed();
			txtSearch.click();
			txtSearch.clear();
			txtSearch.sendKeys("AutomationTitle250624160431");

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterInvalidSearchtxt(String Search) {
		try {

			utils.waitForEle(txtSearch, "visible", "", 3);
			txtSearch.isDisplayed();
			txtSearch.click();
			txtSearch.clear();
			txtSearch.sendKeys(Search);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyTitleInTable() {
		try {
			String xpath = "//td[normalize-space()='" + fullTitle + "']";
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean ClickOnSaveBtn() {
		try {
			utils.waitForEle(ClickOnSaveBtn, "visible", "", 3);
			ClickOnSaveBtn.isDisplayed();
			ClickOnSaveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifySuccessMessage() {
		try {
			utils.waitForEle(verifySuccessMsg, "visible", "", 3);
			verifySuccessMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyDuplicateMessage() {
		try {
			utils.waitForEle(verifyDuplicateMsg, "visible", "", 3);
			verifyDuplicateMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyValidationMessage() {
		try {
			utils.waitForEle(verifyValidationMsg, "visible", "", 3);
			verifyValidationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyCreateHeadTitle() {
		try {
			utils.waitForEle(verifyNewHeadTitle, "visible", null);
			verifyNewHeadTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnCreateHeadBtn() {
		try {
			utils.waitForEle(clickOnCreateBtn, "visible", null);
			clickOnCreateBtn.isDisplayed();
			clickOnCreateBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySalaryHeads() {
		try {
			utils.waitForEle(verifySlaryHeads, "visible", null);
			verifySlaryHeads.isDisplayed();
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

	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getFullTitle() {
		return fullTitle;
	}

}
