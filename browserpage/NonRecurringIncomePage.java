package browserpage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.initBase;
import utils.Utils;

public class NonRecurringIncomePage {

	static WebDriver driver;
	initBase intiBase = new initBase();
	private static String exceptionDesc;
	Utils utils = new Utils(driver);

	public NonRecurringIncomePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class=\"page-breadcrumb\"]//span[contains(text(),\"Non Recurring Income\")]")
	private WebElement verifyNonRecurringIncomeTitle;

	@FindBy(xpath = "//a[@id='newloan']")
	private WebElement verifyNonRecuringIncomeBtn;

	@FindBy(xpath = "//h4[normalize-space()='Non Recurring Income']")
	private WebElement verifyAddIncomeTitle;

	@FindBy(xpath = "//button[@title=\"Select Employee\"]")
	private WebElement EmpDropdwon;

	@FindBy(xpath = "(//input[@role='textbox'])[1]")
	private WebElement txtSearchHeadDrp;

	@FindBy(id = "select_head")
	private WebElement HeadNameDrp;

	@FindBy(xpath = "(//button[@id='Btn_Save'])[1]")
	private WebElement clickOnSaveBtn;

	@FindBy(xpath = "//div[@class=\"toast-message\"]")
	private WebElement validationMsg;

	@FindBy(xpath = "//input[@id=\"Amount_id\"]")
	private WebElement enterAmounttxt;

	@FindBy(xpath = "//input[@id=\"month_id\"]")
	private WebElement enterInstallMonthstxt;

	@FindBy(xpath = "//div[text()='1 Employee Non recurring income added successfully']")
	private WebElement successMsg;

	@FindBy(xpath = "//div[text()='Employee Non recurring income updated successfully']")
	private WebElement UpdateMsg;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement txtEmpNameSearch;

	@FindBy(xpath = "//div[@id='action_dot']")
	private WebElement clickThreedot;

	@FindBy(xpath = "//ul[@class='action_btn_data']//li[contains(@class, 'blue_font') and contains(text(),'Edit')]")
	private WebElement clickOnEditlink;

	@FindBy(xpath = "(//a[@title='Next'])[1]")
	private WebElement clickOnPagination;

	@FindBy(xpath = "//table[@id='loan_tbl']//thead/tr[1]/th[1]")
	private WebElement verifyColumnHadName;

	@FindBy(xpath = "//table[@id='loan_tbl']/tbody/tr/td[1]")
	private WebElement verifyColumnData;

	@FindBy(xpath = "//table[@id='loan_tbl']//tbody//tr//td[2]/img")
	private WebElement clickonEmployee;

	@FindBy(xpath = "//h4[normalize-space()='SheetalAutoFirst']")
	private WebElement verifyLoanTitle;

	@FindBy(xpath = "(//button[@class='dt-button buttons-excel buttons-html5'])[2]")
	private WebElement clickOnExcelBtn;

	@FindBy(xpath = "//td[@class=\"dataTables_empty\"]")
	private WebElement emptyData;

	public boolean verifyEmptyTable() {
		try {
			utils.waitForEle(emptyData, "visible", "", 5);
			emptyData.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;
	}

	public boolean verifyclickOnExcelBtn() {
		try {
			utils.waitForEle(clickOnExcelBtn, "visible", "", 5);
			clickOnExcelBtn.isDisplayed();
			clickOnExcelBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyLoanTitle() {
		try {
			utils.waitForEle(verifyLoanTitle, "visible", "", 5);
			verifyLoanTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnEmp() {
		try {
			utils.waitForEle(clickonEmployee, "visible", "", 5);
			clickonEmployee.isDisplayed();
			clickonEmployee.click();
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

	public boolean ClickOnThreeDot() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", clickThreedot);
			utils.waitForEle(clickThreedot, "visible", "", 5);
			clickThreedot.isDisplayed();
			clickThreedot.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterEmpNametxt(String search) {
		try {
			utils.waitForEle(txtEmpNameSearch, "visible", "", 5);
			txtEmpNameSearch.isDisplayed();
			txtEmpNameSearch.click();
			txtEmpNameSearch.sendKeys(search);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyTitleInTable(String search) {
		try {
			String xpath = "//td//p[normalize-space()='" + search + "']";
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean verifySuccessMsg() {
		try {
			utils.waitForEle(successMsg, "visible", "", 2);
			successMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterInstallMonthtxt(String InstallmentMonths) {
		try {
			utils.waitForEle(enterInstallMonthstxt, "visible", "", 5);
			enterInstallMonthstxt.isDisplayed();
			enterInstallMonthstxt.click();
			enterInstallMonthstxt.sendKeys(InstallmentMonths);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean InstallStartDate() {
		try {
			driver.findElement(By.id("start_date")).click();
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Adjust the target date based on the current date
			LocalDate currentDate = LocalDate.now();
			LocalDate targetDate = currentDate.minusMonths(1);
			DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
			String targetMonth = targetDate.format(monthFormatter);
			String targetYear = String.valueOf(targetDate.getYear());
			SelectDate("1", targetMonth, targetYear);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public void SelectDate(String exDay, String exMonth, String exYear) {
		String MonthYear = driver.findElement(By.className("datepicker-switch")).getText();
		while (!(getMonthYear(MonthYear)[0].equalsIgnoreCase(exMonth) && getMonthYear(MonthYear)[1].equals(exYear))) {
			System.out.println("Current MonthYear: " + MonthYear);
			System.out.println("Expected MonthYear: " + exMonth + " " + exYear);

			// Determine whether to navigate to the previous or next month
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']")).click();

			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
					.textToBePresentInElementLocated(By.className("datepicker-switch"), exMonth + " " + exYear));
			MonthYear = driver.findElement(By.className("datepicker-switch")).getText();
		}
		retryClick(By.xpath("//td[@class='day' and normalize-space()='" + exDay + "']"));
	}

	private void retryClick(By locator) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
						.until(ExpectedConditions.visibilityOfElementLocated(locator));
				element.click();
				break;
			} catch (org.openqa.selenium.StaleElementReferenceException e) {
				attempts++;
				if (attempts >= 3) {
					throw e; // Rethrow exception if max attempts reached
				}
			}
		}
	}

	public static String[] getMonthYear(String MonthYear) {
		return MonthYear.split(" ");
	}

	public boolean enterAmounttxt(String amount) {
		try {
			utils.waitForEle(enterAmounttxt, "visible", null);
			if (enterAmounttxt.isDisplayed()) {
				String currentText = enterAmounttxt.getAttribute("value");

				if (!currentText.isEmpty()) {
					enterAmounttxt.clear();
				} else {
					enterAmounttxt.isDisplayed();
					enterAmounttxt.clear();

//					fullTitle = HeadTitle + randomDateFormat;

					enterAmounttxt.sendKeys(amount);
//					System.out.println(fullTitle);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	/*
	 * public boolean enterUpdateAmounttxt(String amount) { try {
	 * utils.waitForEle(enterAmounttxt, "visible", null);
	 * enterAmounttxt.isDisplayed(); enterAmounttxt.click(); enterAmounttxt.clear();
	 * enterAmounttxt.sendKeys(amount);
	 * 
	 * } catch (Exception e) { exceptionDesc = e.getMessage().toString(); return
	 * false; } return true;
	 * 
	 * }
	 */
	
	public boolean enterUpdateInstallMonthtxt(String InstallmentMonths) {
		try {
			utils.waitForEle(enterInstallMonthstxt, "visible", "", 5);
			enterInstallMonthstxt.isDisplayed();
			enterInstallMonthstxt.clear();
			enterInstallMonthstxt.click();
			enterInstallMonthstxt.sendKeys(InstallmentMonths);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean ClickSaveBtn() {
		try {
			utils.waitForEle(clickOnSaveBtn, "visible", "", 5);
			clickOnSaveBtn.isDisplayed();
			clickOnSaveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyValidationMsg() {
		try {
			utils.waitForEle(validationMsg, "visible", "", 5);
			validationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyUpdateMsg() {
		try {
			utils.waitForEle(UpdateMsg, "visible", "", 5);
			UpdateMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyAddNonRecurringIncomeTitle() {
		try {
			utils.waitForEle(verifyAddIncomeTitle, "visible", "", 5);
			verifyAddIncomeTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyNonRecurringIncomeTitle() {
		try {
			utils.waitForEle(verifyNonRecurringIncomeTitle, "visible", "", 5);
			verifyNonRecurringIncomeTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickNonRecurringIncomeBtn() {
		try {
			utils.waitForEle(verifyNonRecuringIncomeBtn, "visible", "", 5);
			verifyNonRecuringIncomeBtn.isDisplayed();
			verifyNonRecuringIncomeBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean SearchHeadName(String EmployeeName) {
		try {
			utils.waitForEle(EmpDropdwon, "visible", "", 3);
			EmpDropdwon.isDisplayed();
			EmpDropdwon.click();
			WebElement searchBox = driver
					.findElement(By.xpath("(//input[@class='form-control multiselect-search'])[1]"));
			searchBox.sendKeys(EmployeeName); // Search for "SheetalAutoFirst"
			WebElement option = driver
					.findElement(By.xpath("//label[contains(text(),'" + EmployeeName + "')]/parent::a"));
			option.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickonDrpHeadName(String HeadName) {
		try {
			utils.waitForEle(HeadNameDrp, "visible", "", 3);
			Select dropdown = new Select(HeadNameDrp);
			dropdown.selectByVisibleText(HeadName);
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
