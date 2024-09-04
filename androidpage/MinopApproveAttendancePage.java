package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

public class MinopApproveAttendancePage extends initBase {

	WebDriver driver;
	Utils utils = new Utils(driver);
	private static java.lang.String exceptionDesc;

	public MinopApproveAttendancePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mantra.minop:id/txtLable")
	private WebElement verifyApproveAttendancePage;

	@FindBy(id = "com.mantra.minop:id/selectAllCheckBox")
	private WebElement clickCheckBox;

	@FindBy(id = "com.mantra.minop:id/btnApprov")
	private WebElement clickApproveBtn;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Attendance Correction Approved Successfully.\"]")
	private WebElement verifyTostApproveAttendanceMsg;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout")
	private WebElement approvePrevAtt;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txt_ok\"]")
	private WebElement clickOnOkbtnPrev;

	@FindBy(id = "com.mantra.minop:id/edtFromDate")
	private WebElement clickonFromDate;

	@FindBy(id = "android:id/prev")
	private WebElement clickOnPrevicon;

	@FindBy(xpath = "//android.view.View[@content-desc=\"21 May 2024\"]")
	private WebElement selectFromDate;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement clickOnOkbtn;

	public boolean verifyApprovePrevPopupOpen() {
		try {
			utils.waitForEle(approvePrevAtt, "visible", "", 5);

			if (approvePrevAtt.isDisplayed()) {
				utils.waitForEle(clickOnOkbtnPrev, "visible", "", 5);
				clickOnOkbtnPrev.click();
				utils.waitForEle(clickonFromDate, "visible", "", 5);
				clickonFromDate.click();
				utils.waitForEle(clickOnPrevicon, "visible", "", 5);
				clickOnPrevicon.click();
				utils.waitForEle(selectFromDate, "visible", "", 5);
				selectFromDate.click();
				utils.waitForEle(clickOnOkbtn, "visible", "", 5);
				clickOnOkbtn.click();

			} else {
				utils.waitForEle(clickonFromDate, "visible", "", 5);
				clickonFromDate.click();
				utils.waitForEle(clickOnPrevicon, "visible", "", 5);
				clickOnPrevicon.click();
				utils.waitForEle(selectFromDate, "visible", "", 5);
				selectFromDate.click();
				utils.waitForEle(clickOnOkbtn, "visible", "", 5);
				clickOnOkbtn.click();

			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyApproveAttendancePageName() {
		try {
			utils.waitForEle(verifyApproveAttendancePage, "visible", "", 5);
			verifyApproveAttendancePage.isDisplayed();
			System.out.println(verifyApproveAttendancePage.getText());
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean ClickChkBoxApprove() {
		try {
			utils.waitForEle(clickCheckBox, "visible", "", 5);
			clickCheckBox.click();
			System.out.println(clickCheckBox.isSelected());
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean VerifyClickApproveBtn() {
		try {
			utils.waitForEle(clickApproveBtn, "visible", "", 5);
			clickApproveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean VerifyApproveSuceesMsg() {
		try {
			utils.waitForEle(verifyTostApproveAttendanceMsg, "visible", "", 5);
			verifyTostApproveAttendanceMsg.isDisplayed();
			System.out.println(verifyTostApproveAttendanceMsg.getText());
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

}
