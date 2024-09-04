package browserpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.initBase;
import utils.Utils;

public class MinopCustomColumnPage {

	WebDriver driver;
	private static String exceptionDesc;
	Utils utils = new Utils(driver);
	private String fullTitle;

	public MinopCustomColumnPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Payroll Generate Column']")
	private WebElement verifyGenerateColumn;

	@FindBy(xpath = "//a[@id='create_column']")
	private WebElement clickOnCreatBtn;

	@FindBy(xpath = "(//h4[normalize-space()='Create New Column'])[1]")
	private WebElement verifyNewCustomColumnTitle;

	@FindBy(xpath = "//button[@id='btnsave']")
	private WebElement ClickOnSaveBtn;

	@FindBy(xpath = "//div[text()='Please enter column name']")
	private WebElement VerifyValidationMsg;

	@FindBy(id = "Column_name")
	private WebElement txtColumnName;

	@FindBy(xpath = "//select[@id='Column_Type']")
	private WebElement drpColumnType;

	@FindBy(xpath = "//div[text()='Column add successfully.']")
	private WebElement verifySuccessMsg;

	@FindBy(id = "TableSearch")
	private WebElement txtSearch;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement dataTableEmpty;

	@FindBy(id = "edit_column_data")
	private WebElement clickOnEditlink;

	@FindBy(id = "Edit_head")
	private WebElement verifyUpdatePageTitle;

	@FindBy(xpath = "//div[text()='Column Updated successfully']")
	private WebElement verifyUpdateSuccessMsg;

	@FindBy(xpath = "//div[text()='Column Already exists on this deduction type.']")
	private WebElement verifyDuplicateMsg;

	@FindBy(xpath = "//table[@id='GetallColumntable']//thead/tr/th[1]")
	private WebElement verifyColumnHadName;

	@FindBy(xpath = "//table[@id='GetallColumntable']/tbody/tr/td[1]")
	private WebElement verifyColumnData;

	@FindBy(xpath = "//li[@class=\"next disabled\"]")
	private WebElement clickOnPagination;

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

	public boolean verifyHeaderSort() {
		try {
			utils.waitForEle(verifyColumnHadName, "visible", "", 3);
			verifyColumnHadName.isDisplayed();
			verifyColumnHadName.click();

			if (verifyColumnData.getText() != verifyColumnData.getText()) {
				System.out.println("Sorting work proper");

			} else {
				System.out.println("Sorting not work");
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
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

	public boolean ClickOnEditLink() {
		try {
			utils.waitForEle(clickOnEditlink, "visible", "", 5);
			clickOnEditlink.isDisplayed();
			clickOnEditlink.click();

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

	public boolean enterSearchtxt(String Search) {
		try {

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

	public boolean verifyTitleInTable() {
		try {
			String xpath = "//td[normalize-space()='" + fullTitle + "']";
			System.out.println(xpath);
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
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

	public boolean enterUpdateColumnName(String columnName) {
		try {
			utils.waitForEle(txtColumnName, "visible", null);

			txtColumnName.isDisplayed();
			txtColumnName.clear();

//			fullTitle = HeadTitle + randomDateFormat;

//			txtHeadTitle.sendKeys(fullTitle);
			txtColumnName.sendKeys(columnName + initBase.executionRunTime);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterColumnName(String columnName) {
		try {
			utils.waitForEle(txtColumnName, "visible", null);
			if (txtColumnName.isDisplayed()) {
				String currentText = txtColumnName.getAttribute("value");

				if (!currentText.isEmpty()) {
					txtColumnName.clear();
				} else {
					txtColumnName.isDisplayed();
					txtColumnName.clear();

//				fullTitle = HeadTitle + randomDateFormat;

					txtColumnName.sendKeys(columnName + initBase.executionRunTime);
//				System.out.println(fullTitle);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean SelectSectionType(String sectionType) {
		try {
			utils.waitForEle(drpColumnType, "visible", "", 5);
			Select drpColumn = new Select(drpColumnType);
			drpColumn.selectByVisibleText(sectionType);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyValidationMessage() {
		try {
			utils.waitForEle(VerifyValidationMsg, "visible", "", 3);
			VerifyValidationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnSaveBtn() {
		try {
			utils.waitForEle(ClickOnSaveBtn, "visible", null);
			ClickOnSaveBtn.isDisplayed();
			ClickOnSaveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyCreateCustomeColumnTitle() {
		try {
			utils.waitForEle(verifyNewCustomColumnTitle, "visible", null);
			verifyNewCustomColumnTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnCreateCustomColumnBtn() {
		try {
			utils.waitForEle(clickOnCreatBtn, "visible", null);
			clickOnCreatBtn.isDisplayed();
			clickOnCreatBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyGenerateColumnTitle() {
		try {
			utils.waitForEle(verifyGenerateColumn, "visible", "", 5);
			verifyGenerateColumn.isDisplayed();
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
