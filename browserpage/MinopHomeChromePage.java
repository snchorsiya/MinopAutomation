package browserpage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Utils;

public class MinopHomeChromePage {

	WebDriver driver;
	private static String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopHomeChromePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='menu_header_Account_details']//li[1]")
	private WebElement accountCode;

	@FindBy(xpath = "//body/div[@class=\"page-wrapper\"]/div[@class=\"page-container\"]/div[@class=\"page-sidebar-wrapper\"]/div[contains(@class,\"page-sidebar navbar-collapse collapse\")]/div[@class=\"slimScrollDiv\"]/ul[@class=\"page-sidebar-menu page-header-fixed page-sidebar-menu-closed\"]/li[3]/a[1]")
	private WebElement verifyWized;

	@FindBy(xpath = "//span[normalize-space()='System Setting Wizard']")
	private WebElement verifySystemWiz;

	@FindBy(xpath = "//ul[@class='page-breadcrumb']//span[contains(text(),'Wizard')]")
	private WebElement verifyPageName;

	@FindBy(xpath = "//button[normalize-space()=\"Next\"]")
	private WebElement clickOnNextbtn;

	@FindBy(xpath = "//select[@id='lockAttDay']")
	private WebElement verifyLocAtt;

	@FindBy(xpath = "//button[@id=\"btnfin\"]")
	private WebElement verifySubmitBtn;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	private WebElement verifyOkbtn;

	@FindBy(xpath = "(//span[@role='presentation'])[1]")
	private WebElement dateFormatDrp;

	@FindBy(xpath = "//span[normalize-space()=\"Payroll Preparation\"]")
	private WebElement clickPayrollPreperationLink;

	@FindBy(xpath = "//span[normalize-space()=\"Salary Heads\"]")
	private WebElement clickSalaryHeads;

	@FindBy(xpath = "(//a[@href='/PayRoll/PayrollDynamicColumn'])[1]")
	private WebElement clickOnCustomColumn;

	@FindBy(xpath = "(//span[normalize-space()='Employee Salary'])[1]")
	private WebElement clickOnEmployeeSalary;

	@FindBy(xpath = "//span[normalize-space()='Pay Structure']")
	private WebElement clickPayStructure;

	@FindBy(xpath = "//a[@href='/Payroll/NonRecurringIncome']")
	private WebElement clickNonRecurringIncome;

	@FindBy(xpath = "(//span[normalize-space()='Payroll'])[1]")
	private WebElement clickPayrollLink;

	@FindBy(xpath = "//span[@class=\"title\"][normalize-space()=\"Attendance Finalization\"]")
	private WebElement clickOnAttenFinalilink;
	
	@FindBy(xpath = "//a[@href=\"/PayRoll/AccountPayroll\"]")
	private WebElement clickOnSalarylilink;

	public boolean ClickOnAttenFinalilink() {
		try {
			WebElement Element = driver.findElement(By.xpath("(//span[normalize-space()='Payroll'])[1]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnAttenFinalilink, "visible", "", 3);
			System.out.println("Scroll Down");
			clickOnAttenFinalilink.isDisplayed();
			clickOnAttenFinalilink.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickOnSalarylink() {
		try {
			WebElement Element = driver.findElement(By.xpath("(//span[normalize-space()='Payroll'])[1]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnSalarylilink, "visible", "", 3);
			System.out.println("Scroll Down");
			clickOnSalarylilink.isDisplayed();
			clickOnSalarylilink.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickOnPayrollLink() {
		try {
			WebElement Element = driver.findElement(By.xpath("(//span[normalize-space()='Payroll'])[1]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickPayrollLink, "visible", "", 3);
			System.out.println("Scroll Down");
			clickPayrollLink.isDisplayed();
			clickPayrollLink.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean clickNonRecurringIncome() {
		try {
			WebElement Element = driver.findElement(By.xpath("//span[normalize-space()=\"Payroll Preparation\"]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickNonRecurringIncome, "visible", "", 3);
			System.out.println("Scroll Down");
			clickNonRecurringIncome.isDisplayed();
			clickNonRecurringIncome.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickOnPayStructureLink() {
		try {
			WebElement Element = driver.findElement(By.xpath("//span[normalize-space()=\"Payroll Preparation\"]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickPayStructure, "visible", "", 3);
			System.out.println("Scroll Down");
			clickPayStructure.isDisplayed();
			clickPayStructure.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean clickOnEmployeeSalary() {
		try {
			WebElement Element = driver.findElement(By.xpath("//span[normalize-space()=\"Payroll Preparation\"]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnEmployeeSalary, "visible", "", 3);
			System.out.println("Scroll Down");
			clickOnEmployeeSalary.isDisplayed();
			clickOnEmployeeSalary.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickOnCustomColumn() {
		try {
			WebElement Element = driver.findElement(By.xpath("//span[normalize-space()=\"Payroll Preparation\"]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickOnCustomColumn, "visible", "", 5);
			System.out.println("Scroll Down");
			clickOnCustomColumn.isDisplayed();
			clickOnCustomColumn.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickOnPayrollPreperationLink() {
		try {
			WebElement Element = driver.findElement(By.xpath("//span[normalize-space()=\"Payroll Preparation\"]"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Element);
			utils.waitForEle(clickPayrollPreperationLink, "visible", "", 3);
			System.out.println("Scroll Down");
			clickPayrollPreperationLink.isDisplayed();
			clickPayrollPreperationLink.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickOnSalaryHeadsLink() {
		try {
			utils.waitForEle(clickSalaryHeads, "visible", "", 3);
			clickSalaryHeads.isDisplayed();
			clickSalaryHeads.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean verifyAccountCode() {
		try {
			utils.waitForEle(accountCode, "visible", null);
			accountCode.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean clickdateFormatDrp(String dateFormat) {
		try {
			utils.waitForEle(dateFormatDrp, "visible", "", 3);
			dateFormatDrp.isDisplayed();
			dateFormatDrp.click();

//			List<WebElement> options = driver
//					.findElements(By.xpath("(//ul[@id='select2-DatetimeFormat-results'])[1]//li"));
//			for (WebElement ele : options) {
//				String value = ele.getText();
//				System.out.println(value);

			driver.findElement(By.xpath("//input[@role=\"textbox\"]")).sendKeys(dateFormat);
			Thread.sleep(2000);
			Actions act = new Actions(driver);
//				act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			Thread.sleep(2000);
			System.out.println("Dateformat change...");

//				if (value.equalsIgnoreCase(dateFormat)) {
//					ele.click();
//					System.out.println("The test...");
//					System.out.println(ele);
//					break;
//				}

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean SelectDrpLockAtt() {
		try {
			// Assuming waitForEle is a method to wait for an element to be in a specific
			// state
			utils.waitForEle(verifyLocAtt, "visible", "", 5);
			verifyLocAtt.click();

			if (verifyLocAtt != null && verifyLocAtt.isDisplayed()) {
				Select attenDropdown = new Select(verifyLocAtt);
				attenDropdown.selectByIndex(5); // Assuming selecting the first index, modify as needed
				System.out.println(attenDropdown);

			} else {
				throw new Exception("verifyLocAtt is not visible");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean ClickokBtn() {
		try {
//			driver.switchTo().alert().accept();
			utils.waitForEle(verifyOkbtn, "visible", "", 5);
			verifyOkbtn.isDisplayed();
			verifyOkbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickSubmitBtn() {
		try {
			utils.waitForEle(verifySubmitBtn, "visible", "", 5);
			verifySubmitBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnNextBtn() {
		try {
			utils.waitForEle(clickOnNextbtn, "visible", "", 5);
			clickOnNextbtn.isDisplayed();
			clickOnNextbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickOnWized() {
		try {
			utils.waitForEle(verifyWized, "visible", null, 5);
			verifyWized.click();

			utils.waitForEle(verifySystemWiz, "visible", null, 5);
			verifySystemWiz.click();

			utils.waitForEle(verifyPageName, "visible", null, 5);
			verifyPageName.isDisplayed();

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