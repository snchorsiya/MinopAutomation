package androidpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.HidesKeyboard;
import utils.Utils;

public class MinopAttendanceCorrectionPage {

	WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopAttendanceCorrectionPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement verifyAttendancePageTitle;

	@FindBy(id = "com.mantra.minop:id/txtNoReq")
	private WebElement veifyNoResultFoundMsg;

	@FindBy(id = "com.mantra.minop:id/imgRefresh")
	private WebElement verifyRefreshIcon;

	@FindBy(id = "com.mantra.minop:id/fabCorrection")
	private WebElement verifyAddIcon;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement verifyAddCorrectionPageTitle;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtDate\"]")
	private WebElement verifyDate;

	@FindBy(xpath = "//android.view.View[@content-desc=\"21 May 2024\"]")
	private WebElement verifySelectDate;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")
	private WebElement verifyCancelBtn;

	@FindBy(id = "android:id/prev")
	private WebElement clickPrevBtn;

	@FindBy(xpath = "//android.widget.Spinner[@resource-id=\"android:id/am_pm_spinner\"]")
	private WebElement clickTimeFormat;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement verifyOkBtn;

	@FindBy(id = "android:id/button1")
	private WebElement clickCalOk;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtTimeIn\"]")
	private WebElement verifyInTime;

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Switch to text input mode for the time input.\"]")
	private WebElement verifySwitchInTime;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/input_hour\"]")
	private WebElement verifyHourTxt;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"android:id/input_minute\"]")
	private WebElement verifyMinuTxt;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtTimeOut\"]")
	private WebElement verifyOutTime;

	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"PM\"]")
	private WebElement verifyPm;

	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"am\"]")
	private WebElement verifyAm;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.mantra.minop:id/txtReason\"]")
	private WebElement verifyResonTxt;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Please Enter Attendance Date\"]")
	private WebElement verifyValidationMsg;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Please Enter Attendance Date\"]")
	private WebElement verifyValidationSameDate;

	@FindBy(xpath = "//android.widget.Toast[@text=\" Attendance Correction Added Successfully.\"]")
	private WebElement verifySuccessMsg;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnApply\"]")
	private WebElement clickOnApplybtn;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Attendance Correction Updated Successfully.\"]")
	private WebElement updateMsgDisplay;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mantra.minop:id/attendance_correction_rec\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.ImageView[2]")
	private WebElement verifyViewIcon;

	@FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.mantra.minop:id/attendance_correction_rec\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout")
	private WebElement veriyfData;

	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLeaveType\"])[1]")
	private WebElement verifyPadingStatus;

	@FindBy(id = "com.mantra.minop:id/edtDateSearch")
	private WebElement clickOnSearchTxt;

	@FindBy(id = "com.mantra.minop:id/btnRejectAC")
	private WebElement clickOnEditbtn;

	@FindBy(xpath = "//android.view.View[@content-desc=\"25 May 2024\"]")
	private WebElement verifySelectDateReject;

	public boolean selectRejectAddCorrectionDate(int dayOffset) {
		try {
//			utils.waitForEle(clickPrevBtn, "visible", "", 5);
//			clickPrevBtn.click();
//			
//			utils.waitForEle(verifySelectDateReject, "visible", "", 5);
//			verifySelectDateReject.click();

			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);

			System.out.println("Generated XPath for From Date: " + randomDateXPath);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement dateElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDateXPath)));

			dateElement.click();

			utils.waitForEle(clickCalOk, "visible", "", 5);
			clickCalOk.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickOnEditBtn() {
		try {
			utils.waitForEle(clickOnEditbtn, "visible", "", 5);
			clickOnEditbtn.isDisplayed();
			clickOnEditbtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyOnSearchTxt() {
		try {
			utils.waitForEle(clickOnSearchTxt, "visible", "", 5);
			clickOnSearchTxt.isDisplayed();
			clickOnSearchTxt.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyStatusData() {
		try {
			utils.waitForEle(verifyPadingStatus, "visible", "", 5);
			verifyPadingStatus.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyDisplayData() {
		try {
			utils.waitForEle(verifyPadingStatus, "visible", "", 5);
			if (verifyPadingStatus.isDisplayed()) {
				System.out.println("The Data is Display");
			} else {
				utils.waitForEle(veifyNoResultFoundMsg, "visible", "", 5);
				veifyNoResultFoundMsg.isDisplayed();
				System.out.println("The No Data Found Message is Display.");
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyDataInDisply() {
		try {
			utils.waitForEle(veriyfData, "visible", "", 5);
			veriyfData.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyAttendanceTitle() {
		try {
			utils.waitForEle(verifyAttendancePageTitle, "visible", "", 5);
			verifyAttendancePageTitle.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickInTime() {
		try {
			utils.waitForEle(verifyInTime, "visible", "", 5);
			verifyInTime.isDisplayed();
			verifyInTime.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickSwitchInTime() {
		try {
			utils.waitForEle(verifySwitchInTime, "visible", "", 5);
			verifySwitchInTime.isDisplayed();
			verifySwitchInTime.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean enterHourTxt(String inhourtime) {
		try {
			utils.waitForEle(verifyHourTxt, "visible", "", 5);
			verifyHourTxt.isDisplayed();
			verifyHourTxt.click();
			verifyHourTxt.clear();
			verifyHourTxt.sendKeys(inhourtime);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean enterOutHourTxt(String outhourtime) {
		try {
			utils.waitForEle(verifyHourTxt, "visible", "", 5);
			verifyHourTxt.isDisplayed();
			verifyHourTxt.click();
			verifyHourTxt.clear();
			verifyHourTxt.sendKeys(outhourtime);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean enterMinutTxt(String minute) {
		try {
			utils.waitForEle(verifyMinuTxt, "visible", "", 5);
			verifyMinuTxt.isDisplayed();
			verifyMinuTxt.click();
			verifyMinuTxt.clear();
			verifyMinuTxt.sendKeys("06:30");
			driver.navigate().back();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean SelectAMDrp() {
		try {
			utils.waitForEle(clickTimeFormat, "visible", "", 5);
			clickTimeFormat.isDisplayed();
			clickTimeFormat.click();

			utils.waitForEle(verifyAm, "visible", "", 5);
			verifyAm.isDisplayed();
			verifyAm.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickOutTime() {
		try {
			utils.waitForEle(verifyOutTime, "visible", "", 5);
			verifyOutTime.isDisplayed();
			verifyOutTime.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean ClickOnTimeFormat() {
		try {
			utils.waitForEle(clickTimeFormat, "visible", "", 5);
			clickTimeFormat.isDisplayed();
			clickTimeFormat.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean SelectPMDrp() {
		try {
			utils.waitForEle(verifyPm, "visible", "", 5);
			verifyPm.isDisplayed();
			verifyPm.click();
//			driver.navigate().back();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyDuplicateDataValidationMessage() {
		try {
			utils.waitForEle(verifyValidationSameDate, "visible", "", 2);
			verifyValidationSameDate.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyUpdateMessage() {
		try {
			utils.waitForEle(updateMsgDisplay, "visible", "", 2);
			updateMsgDisplay.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyBlankValidationMessage() {
		try {
			utils.waitForEle(verifyValidationMsg, "visible", "", 2);
			verifyValidationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickOnViewIcon() {
		try {
			utils.waitForEle(verifyViewIcon, "visible", "", 2);
			verifyViewIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifySuccessValidationMessage() {
		try {
			utils.waitForEle(verifySuccessMsg, "visible", "", 2);
			verifySuccessMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean enterTxtReson() {
		try {
			utils.waitForEle(verifyResonTxt, "visible", "", 5);
			verifyResonTxt.isDisplayed();
			verifyResonTxt.click();
			verifyResonTxt.sendKeys("Punch not come");
			((HidesKeyboard) driver).hideKeyboard();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyAddCorrectionTitle() {
		try {
			utils.waitForEle(verifyAddCorrectionPageTitle, "visible", "", 5);
			verifyAddCorrectionPageTitle.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickCancelBtn() {
		try {
			utils.waitForEle(verifyCancelBtn, "visible", "", 5);
			verifyCancelBtn.isDisplayed();
			verifyCancelBtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickOkBtn() {
		try {
			utils.waitForEle(verifyOkBtn, "visible", "", 5);
			verifyOkBtn.isDisplayed();
			verifyOkBtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickApplyBtn() {
		try {
			utils.waitForEle(clickOnApplybtn, "visible", "", 5);
			clickOnApplybtn.isDisplayed();
			clickOnApplybtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickAddCorrectionDate() {
		try {
			utils.waitForEle(verifyDate, "visible", "", 5);
			verifyDate.isDisplayed();
			verifyDate.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean selectAddCorrectionDate(int dayOffset) {
		try {
//			utils.waitForEle(clickPrevBtn, "visible", "", 5);
//			clickPrevBtn.click();

			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);

			System.out.println("Generated XPath for From Date: " + randomDateXPath);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement dateElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDateXPath)));

			dateElement.click();

//			utils.waitForEle(verifySelectDate, "visible", "", 5);
//			verifySelectDate.click();

			utils.waitForEle(clickCalOk, "visible", "", 5);
			clickCalOk.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyNoResultMsg() {
		try {
			utils.waitForEle(veifyNoResultFoundMsg, "visible", "", 5);
			veifyNoResultFoundMsg.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyRefreshIconClick() {
		try {
			utils.waitForEle(verifyRefreshIcon, "visible", "", 5);
			verifyRefreshIcon.isDisplayed();
			verifyRefreshIcon.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyClickOnAddIcon() {
		try {
			utils.waitForEle(verifyAddIcon, "visible", "", 5);
			verifyAddIcon.isDisplayed();
			verifyAddIcon.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyPrevDateLeave() {
		try {
			utils.waitForEle(verifyDate, "visible", "", 5);
			verifyDate.click();

			utils.waitForEle(clickPrevBtn, "visible", "", 5);
			clickPrevBtn.click();

			utils.waitForEle(verifySelectDate, "visible", "", 5);
			verifySelectDate.click();

			utils.waitForEle(clickCalOk, "visible", "", 5);
			clickCalOk.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public String getExceptionDesc() {
		return this.exceptionDesc;
	}

}
