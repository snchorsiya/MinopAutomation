package browserpage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.initBase;
import groovy.time.TimeDuration;
import utils.Utils;

public class MinopAttendanceFinalizationPage {

	static WebDriver driver;
	initBase intiBase = new initBase();
	private static String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopAttendanceFinalizationPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//span[contains(text(),'Attendance Finalization')])[2]")
	private WebElement verifyAttendanceFinalizeTitle;

	@FindBy(xpath = "(//div[@class='toast-message'])[1]")
	private WebElement verifyValidationMessage;

	@FindBy(xpath = "//button[@id='btnSubmit']")
	private WebElement clickSubmitBtn;

	@FindBy(xpath = "//button[@title='Select Company']")
	private WebElement CompanyDrp;

	@FindBy(xpath = "//button[@title='Select Branch']")
	private WebElement BranchDrp;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchTxt;

	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement searchBranchTxt;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement BrnSearchTxt;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectCompanyCheckbox;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectBranchCheckbox;

	@FindBy(xpath = "//span[@class='assign_emp_ctn']")
	private WebElement verifyAttenSummryTitle;

	@FindBy(xpath = "//button[@id='clear_operation']")
	private WebElement clickOnClearbtn;

	@FindBy(xpath = "(//input[@placeholder='Search'])[7]")
	private WebElement enterempNameSearchtxt;

//	@FindBy(xpath = "(//td[@class='p_days'])[1]")
//	private WebElement txtPresentDay;

	@FindBy(xpath = "(//a[@title='Edit'])[1]")
	private WebElement clickEditBtn;

	@FindBy(xpath = "//tr[@class=\"odd\"]//a[@title=\"Active\"]")
	private WebElement clickUpdatebtn;

	@FindBy(xpath = "//div[text()='Employee attendance data is updated successfully.']")
	private WebElement verifyUpdateMsg;

	@FindBy(xpath = "//div[@class='text-center']")
	private WebElement clickChbox;

	@FindBy(xpath = "//table[@id='hrattendancetable']//tbody//tr//td[5]//input")
	private WebElement txtPresentDay;

	@FindBy(xpath = "//table[@id='hrattendancetable']//tbody//tr//td[6]//input")
	private WebElement txtAbsentDay;

	@FindBy(xpath = "//table[@id='hrattendancetable']//tbody//tr//td[7]//input")
	private WebElement txtTakenLe;

	@FindBy(xpath = "//a[@id='Freezed_status']")
	private WebElement freezedBtn;

	@FindBy(xpath = "//a[@id='onhold_status']")
	private WebElement onHoldBtn;

	@FindBy(xpath = "//a[@id='fnf_status']")
	private WebElement fnfBtn;

	@FindBy(xpath = "(//select[@class='form-control input-sm adrp'])[2]")
	static WebElement dropdownElement;

//	@FindBy(xpath = "//div[text()='Employees Attendance Freezed Successfully.']")
//	private WebElement verifyFreezedMsg;

	@FindBy(xpath = "//div[text()='Employees Attendance Freezed Successfully and employees with a CTC of zero or no.pay days is not processed']")
	private WebElement verifyFreezedMsg;

	@FindBy(xpath = "//div[text()='Employees Attendance On Hold Successfully.']")
	private WebElement verifyHoldMsg;

	@FindBy(xpath = "//div[text()='Employees Attendance FNF Successfully.']")
	private WebElement verifyFNFMsg;

	@FindBy(xpath = "(//a[normalize-space()='Save'])[1]")
	private WebElement btnSaveAF;

	@FindBy(xpath = "//div[text()='Attendance records for 2 employess have been saved,and now we can proceed with the salary processing']")
	private WebElement verifyAFSPMsg;

	@FindBy(xpath = "//table[@id='hrattendancetable']/thead/tr[2]//th//select[@id='Search_dropdown']")
	private WebElement attendDrpValue;

	@FindBy(xpath = "(//a[normalize-space()='Save'])[1]")
	private WebElement clickOnSaveBtn;

	@FindBy(xpath = "//div[text()='Attendance records for 1 employess have been saved,and now we can proceed with the salary processing']")
	private WebElement verifySaveMsg;

	@FindBy(xpath = "//td[@class=\"dataTables_empty\"]")
	private WebElement invalidMagdisplay;

	@FindBy(xpath = "//li[@class=\"next disabled\"]")
	private WebElement clickOnPagination;

	@FindBy(xpath = "(//button[@class='dt-button buttons-excel buttons-html5'])[1]")
	private WebElement clickOnExcelBtn;

	@FindBy(xpath = "//table[@id='hrattendancetable']//tbody//tr[1]//td[5]")
	private WebElement verifyPresent;

	@FindBy(xpath = "//table[@id='hrattendancetable']//tbody//tr[1]//td[6]")
	private WebElement verifyAbsent;

	@FindBy(xpath = "(//span[normalize-space()='Dashboard'])[1]")
	private WebElement clickOnDasboardlink;

	@FindBy(xpath = "(//span[normalize-space()='Analytics DashBoard'])[1]")
	private WebElement clickOnAnalyticsDashBoardlink;

	@FindBy(xpath = "//div[@class=\"dropdown dropdown-quick-sidebar-toggler\"]//a")
	private WebElement clickonToggleIcon;

	@FindBy(xpath = "//select[@id=\"CompanyIds\"]")
	private WebElement compDrpValue;

	@FindBy(xpath = "//input[@id=\"FromDate\"]")
	private WebElement enterfromDatetxt;

	@FindBy(xpath = "//input[@id=\"Todate\"]")
	private WebElement enterToDatetxt;

	@FindBy(xpath = "(//button[@title='Select Department'])[1]")
	private WebElement DepartmentDrp;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchDepartment;

	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectDepartmentCheckbox;

	@FindBy(xpath = "//input[@class=\"ClsChkAllDept\"]")
	private WebElement clickEmpCheckBox;

	@FindBy(xpath = "//button[@id=\"BtnOk\"]")
	private WebElement clickOnOkbtn;

	@FindBy(xpath = "(//a[@class='local_report_icon report_26'])[1]")
	private WebElement VerifyMonthlyMustReport;

	@FindBy(xpath = "//tr[@id=\"GridView_DXDataRow2\"]//td[@class=\"dxgv dx-ellipsis dx-ac\"][normalize-space()=\"31\"]")
	private WebElement verifyPrecentDay;

	@FindBy(xpath = "(//a[@title='Active'])[1]")
	private WebElement clickOnUpdateBtn;

	public boolean verifyPrecentDay() {
		try {
			utils.waitForEle(verifyPrecentDay, "visible", null);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", verifyPrecentDay);
//			js.executeScript("javascript:window.scrollBy(250,350)");
			verifyPrecentDay.isDisplayed();
//			VerifyMonthlyMustReport.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyMonthlyMustReport() {
		try {
			utils.waitForEle(VerifyMonthlyMustReport, "visible", null);
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", nextButton);
			js.executeScript("javascript:window.scrollBy(250,350)");
			VerifyMonthlyMustReport.isDisplayed();
			VerifyMonthlyMustReport.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyclickOnOkbtn() {
		try {
			utils.waitForEle(clickOnOkbtn, "visible", null);
			clickOnOkbtn.isDisplayed();
			clickOnOkbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean CheckclickEmpCheckBox() {
		try {
			utils.waitForEle(clickEmpCheckBox, "visible", null);
			clickEmpCheckBox.isDisplayed();
			clickEmpCheckBox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean CheckCheckBoxDepartment() {
		try {
			utils.waitForEle(SelectDepartmentCheckbox, "visible", null);
			SelectDepartmentCheckbox.isDisplayed();
			SelectDepartmentCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean SearchDepartmentname(String Departmentname) {
		try {
			// if (fullTitle1 == null) {
			// throw new Exception("fullTitle1 is null");
			// }
			utils.waitForEle(SearchDepartment, "visible", "", 3);
			SearchDepartment.isDisplayed();
			SearchDepartment.click();
			SearchDepartment.clear();
			System.out.println("Enter the text:");

			// fullTitle1 = SearchHeadTitle + executionRunTime;
			SearchDepartment.sendKeys(Departmentname);
			System.out.println("After enter thre text: " + Departmentname);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickonDrpDepartmentname() {
		try {
//			utils.waitForEle(DepartmentDrp, "visible", "", 5);
//			Select drpDepartment = new Select(DepartmentDrp);
//			drpDepartment.selectByVisibleText(Departmentname);
			utils.waitForEle(DepartmentDrp, "visible", null);
			DepartmentDrp.isDisplayed();
			DepartmentDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean enterFromDatetxt() {
		try {
			utils.waitForEle(enterfromDatetxt, "visible", "", 5);
			enterfromDatetxt.isDisplayed();
			enterfromDatetxt.click();
//			enterfromDatetxt.sendKeys(FromDate);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean enterToDatetxt() {
		try {
			utils.waitForEle(enterToDatetxt, "visible", "", 5);
			enterToDatetxt.isDisplayed();
			enterToDatetxt.click();
//			enterfromDatetxt.sendKeys(ToDate);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean FromDate() {
		try {
			driver.findElement(By.id("FromDate")).click();
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Adjust the target date based on the current date
			LocalDate currentDate = LocalDate.now();
			LocalDate targetDate = currentDate.minusMonths(1);
			DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
			String targetMonth = targetDate.format(monthFormatter);
			String targetYear = String.valueOf(targetDate.getYear());
			SelectFromDate("1", targetMonth, targetYear);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean ToDate() {
		try {
			driver.findElement(By.id("Todate")).click();
			new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-days")));

			// Adjust the target date based on the current date
			LocalDate currentDate = LocalDate.now();
			LocalDate targetDate = currentDate.minusMonths(1);
			DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
			String targetMonth = targetDate.format(monthFormatter);
			String targetYear = String.valueOf(targetDate.getYear());
			SelectToDate("31", targetMonth, targetYear);
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public void SelectFromDate(String exDay, String exMonth, String exYear) {
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

	public void SelectToDate(String exDay, String exMonth, String exYear) {
		String MonthYear = driver.findElement(By.className("datepicker-switch")).getText();
		while (!(getMonthYear(MonthYear)[0].equalsIgnoreCase(exMonth) && getMonthYear(MonthYear)[1].equals(exYear))) {
			System.out.println("Current MonthYear: " + MonthYear);
			System.out.println("Expected MonthYear: " + exMonth + " " + exYear);

			// Determine whether to navigate to the previous or next month
//			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']")).click();

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

	public boolean SelectComdrp(String Companyname) {
		try {
			utils.waitForEle(compDrpValue, "visible", "", 5);
			compDrpValue.isDisplayed();
			compDrpValue.click();
			Select compdrp = new Select(compDrpValue);
			compdrp.selectByVisibleText(Companyname);
			System.out.println(compdrp.getFirstSelectedOption());
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickonToggleIcon() {
		try {
			utils.waitForEle(clickonToggleIcon, "visible", "", 5);
			clickonToggleIcon.isDisplayed();
			clickonToggleIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickOnAnalyticsDashBoardlink() {
		try {
			utils.waitForEle(clickOnAnalyticsDashBoardlink, "visible", "", 5);
			clickOnAnalyticsDashBoardlink.isDisplayed();
			clickOnAnalyticsDashBoardlink.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickOnDasboardLink() {
		try {
			utils.waitForEle(clickOnDasboardlink, "visible", "", 5);
			clickOnDasboardlink.isDisplayed();
			clickOnDasboardlink.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyAbsetTxt() {
		try {
			utils.waitForEle(verifyAbsent, "visible", "", 5);
			verifyAbsent.isDisplayed();
			String AbsentTxt = verifyAbsent.getText();
			System.out.println("Absent text is: " + AbsentTxt);
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

	public boolean InvalidDataDisplay() {
		try {
			utils.waitForEle(invalidMagdisplay, "visible", "", 5);
			invalidMagdisplay.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifySaveMsg() {
		try {
			utils.waitForEle(verifySaveMsg, "visible", "", 5);
			verifySaveMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnSaveBtn() {
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

	public boolean verifyAFSPMsg() {
		try {
			utils.waitForEle(verifyAFSPMsg, "visible", "", 5);
			verifyAFSPMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	/*
	 * public boolean SelectAttendanceTypedrp() { try {
	 * utils.waitForEle(attendDrpValue, "visible", "", 5); attendDrpValue.click();
	 * attendDrpValue.isDisplayed(); Select optiondrp = new Select(attendDrpValue);
	 * optiondrp.selectByVisibleText("SP");
	 * System.out.println(optiondrp.getFirstSelectedOption()); } catch (Exception e)
	 * { exceptionDesc = e.getMessage().toString(); return false; } return true;
	 * 
	 * }
	 */

	public boolean SelectAttendanceTypedrp() {
		int attempts = 0;
		while (attempts < 3) {
			try {
				// Wait for the dropdown to be visible
				utils.waitForEle(attendDrpValue, "visible", "", 5);

				// Click on the dropdown
				attendDrpValue.click();

				// Re-locate the element after clicking to avoid stale element issues
				Select optiondrp = new Select(attendDrpValue);

				// Select the desired value
				optiondrp.selectByVisibleText("AF");
				System.out.println(optiondrp.getFirstSelectedOption().getText());

				return true; // Return true to indicate the dropdown value was selected successfully
			} catch (StaleElementReferenceException e) {
				// Handle the stale element exception by retrying
				System.out.println("StaleElementReferenceException caught. Retrying... Attempt: " + (attempts + 1));
				attempts++;
			} catch (Exception e) {
				// Capture any other exceptions
				exceptionDesc = e.getMessage();
				return false;
			}
		}
		return false; // Return false if the element remains stale after retries
	}

	/*
	 * public boolean SelectSPAttendanceTypedrp() {
	 * 
	 * try { utils.waitForEle(attendDrpValue, "visible", "", 5);
	 * attendDrpValue.isDisplayed(); attendDrpValue.click(); Select optiondrp = new
	 * Select(attendDrpValue); optiondrp.selectByVisibleText("SP");
	 * System.out.println(optiondrp.getFirstSelectedOption()); } catch (Exception e)
	 * { exceptionDesc = e.getMessage().toString(); return false; } return true;
	 * 
	 * }
	 * 
	 * 
	 * try { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * WebElement attendDrpValue =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	 * "//table[@id='hrattendancetable']/thead/tr[2]//th//select[@id='Search_dropdown']"
	 * )));
	 * 
	 * // Re-fetch the element to avoid StaleElementReferenceException
	 * attendDrpValue =
	 * wait.until(ExpectedConditions.elementToBeClickable(attendDrpValue));
	 * attendDrpValue.click();
	 * 
	 * Select optiondrp = new Select(attendDrpValue);
	 * optiondrp.selectByVisibleText("SP");
	 * System.out.println(optiondrp.getFirstSelectedOption().getText()); } catch
	 * (Exception e) { exceptionDesc = e.getMessage(); return false; } return true;
	 * }
	 */

	public boolean SelectSPAttendanceTypedrp() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		int attempts = 0;
		final int maxAttempts = 3;

		while (attempts < maxAttempts) {
			try {
				WebElement attendDrpValue = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//table[@id='hrattendancetable']/thead/tr[2]//th//select[@id='Search_dropdown']")));
				attendDrpValue = wait.until(ExpectedConditions.elementToBeClickable(attendDrpValue));
				attendDrpValue.click();

				Select optiondrp = new Select(attendDrpValue);
				optiondrp.selectByVisibleText("SP");
				System.out.println(optiondrp.getFirstSelectedOption().getText());
				return true; // If successful, exit method

			} catch (TimeoutException te) {
				// Handle the case where the element was not found or not clickable in time
				System.out.println("Timeout while waiting for element: " + te.getMessage());
			} catch (StaleElementReferenceException sere) {
				// Handle stale element exception and retry
				System.out.println("Stale element reference: " + sere.getMessage());
			} catch (Exception e) {
				// Handle other exceptions
				exceptionDesc = e.getMessage();
				return false;
			}

			attempts++;
			// Optional: wait before retrying
			try {
				Thread.sleep(1000); // Wait for 1 second before retrying
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}
		return false; // If max attempts reached and still failing
	}

	public boolean verifyClickbtnSaveAF() {
		try {
			utils.waitForEle(btnSaveAF, "visible", "", 5);
			btnSaveAF.isDisplayed();
			btnSaveAF.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyHoldMsg() {
		try {
			utils.waitForEle(verifyHoldMsg, "visible", "", 5);
			verifyHoldMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyFNFMsg() {
		try {
			utils.waitForEle(verifyFNFMsg, "visible", "", 5);
			verifyFNFMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyFreezedMsg() {
		try {
			utils.waitForEle(verifyFreezedMsg, "visible", "", 5);
			verifyFreezedMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public static boolean verifyDropdownValue(String AttendanceStatus) {
		// Create a Select object
		Select dropdown = new Select(dropdownElement);

		// Get the currently selected option
		String selectedValue = dropdown.getFirstSelectedOption().getText();
		System.out.println(selectedValue);

		// Return true if the expected value matches the selected value
		return selectedValue.equals(AttendanceStatus);
	}

	public boolean verifythreeButtonDisplay() {
		try {
			utils.waitForEle(freezedBtn, "visible", "", 5);
			freezedBtn.isDisplayed();

			utils.waitForEle(onHoldBtn, "visible", "", 5);
			onHoldBtn.isDisplayed();

			utils.waitForEle(fnfBtn, "visible", "", 5);
			fnfBtn.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnFreezedBtn() {
		try {
			utils.waitForEle(freezedBtn, "visible", "", 5);
			freezedBtn.isDisplayed();
			freezedBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnHoldBtn() {
		try {
			utils.waitForEle(onHoldBtn, "visible", "", 5);
			onHoldBtn.isDisplayed();
			onHoldBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyclickOnFNFBtn() {
		try {
			utils.waitForEle(fnfBtn, "visible", "", 5);
			fnfBtn.isDisplayed();
			fnfBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnCheckBox() {
		try {
			utils.waitForEle(clickChbox, "visible", "", 5);
			clickChbox.isDisplayed();
			clickChbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyUpdateValidationMessage() {
		try {
			utils.waitForEle(verifyUpdateMsg, "visible", null);
			verifyUpdateMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyEditRecrd() {
		try {
			// Wait for the element to be visible
			utils.waitForEle(clickEditBtn, "visible", "", 5);

			// Check if the element is displayed
			if (clickEditBtn.isDisplayed()) {
				clickEditBtn.click();
				System.out.println("Edit button is displayed.");
				return true; // Return false to indicate the test should fail
			} else {
				System.out.println("Edit button is not displayed.");
				return false; // Return true to indicate the test should pass
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

	public boolean clickOnUpdateBtn() {
		try {

			utils.waitForEle(clickOnUpdateBtn, "visible", "", 5);
			clickOnUpdateBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyEnterTakenLeave(String TakenLeave) {
		try {
			utils.waitForEle(txtTakenLe, "visible", "", 5);
			txtTakenLe.click();
			txtTakenLe.clear();
			txtTakenLe.sendKeys(TakenLeave);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyclickUpdatebtn() {
		try {

			utils.waitForEle(clickUpdatebtn, "visible", "", 5);
			clickUpdatebtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyEnterPresentDay(String PresentDay) {
		try {
			utils.waitForEle(txtPresentDay, "visible", "", 5);
			txtPresentDay.click();
			txtPresentDay.clear();
			txtPresentDay.sendKeys(PresentDay);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyDay() {
		try {
			utils.waitForEle(verifyPresent, "visible", "", 5);
			verifyPresent.isDisplayed();
			utils.waitForEle(verifyAbsent, "visible", "", 5);
			verifyAbsent.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyEnterAbsentDay(String AbsentDay) {
		try {
			utils.waitForEle(txtAbsentDay, "visible", "", 5);
			txtAbsentDay.click();
			Thread.sleep(5000);
			txtAbsentDay.clear();
			txtAbsentDay.sendKeys(AbsentDay);
			Thread.sleep(5000);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyTitleInTable(String EmployeeName) {
		try {
			String xpath = "//td//p[normalize-space()='" + EmployeeName + "']";
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean enterEmpNameSearch(String EmployeeName) {
		try {
			utils.waitForEle(enterempNameSearchtxt, "visible", null);
			enterempNameSearchtxt.isDisplayed();
			enterempNameSearchtxt.click();
			enterempNameSearchtxt.sendKeys(EmployeeName);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean clickClearBtn() {
		try {
			utils.waitForEle(clickOnClearbtn, "visible", "", 5);
			clickOnClearbtn.isDisplayed();
			clickOnClearbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyCompanyname() {
		try {
			utils.waitForEle(CompanyDrp, "visible", null);
			CompanyDrp.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyAttenSummryTitle() {
		try {
			utils.waitForEle(verifyAttenSummryTitle, "visible", null);
			verifyAttenSummryTitle.isDisplayed();
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

	public boolean SearchAttBranchname(String Branchname) {
		try {

			utils.waitForEle(searchBranchTxt, "visible", "", 3);
			searchBranchTxt.isDisplayed();
			searchBranchTxt.click();
			searchBranchTxt.clear();
			System.out.println("Enter the text:");
			searchBranchTxt.sendKeys(Branchname);
			System.out.println("After enter thre text: " + Branchname);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyAttendanceFinalizeTitle() {
		try {
			utils.waitForEle(verifyAttendanceFinalizeTitle, "visible", "", 5);
			verifyAttendanceFinalizeTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickSubmitBtn() {
		try {
			utils.waitForEle(clickSubmitBtn, "visible", "", 5);
			clickSubmitBtn.isDisplayed();
			clickSubmitBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyValidationMessage() {
		try {
			utils.waitForEle(verifyValidationMessage, "visible", "", 5);
			verifyValidationMessage.isDisplayed();
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
