package androidpage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

public class MinopHomePage extends initBase {

	WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopHomePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtEmpName\"]")
	private WebElement verifyName;

	@FindBy(id = "btncheckIn")
	private WebElement verifyCheckInBtn;

	@FindBy(id = "btn_webpunch")
	private WebElement webPunchBtn;

	@FindBy(id = "edtEmpInTime")
	private WebElement displayedTime;

	@FindBy(id = "com.mantra.minop:id/btnEmpSearch")
	private WebElement FacePunchBtn;

	@FindBy(id = "com.mantra.minop:id/faceOverlay")
	private WebElement VerifyCamera;

	@FindBy(id = "com.mantra.minop:id/img_left_menu")
	private WebElement clickLeaftMenu;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/txtMenu' and @text='Approve WebPunch']")
	private WebElement clickWebPunchApproveLink;

	@FindBy(id = "com.mantra.minop:id/txtLable")
	private WebElement verifyWebPunchPage;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/txtMenu' and @text='Home']")
	private WebElement clickOnHomePage;

	@FindBy(xpath = "//android.widget.TextView[@text='Leave Request']")
	private WebElement leaveReuestPage;

	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.mantra.minop:id/img_user']")
	private WebElement verifyImage;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtMenu\" and @text=\"Approve Leave\"]")
	private WebElement approveLeavePage;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtMenu\" and @text=\"Attendance Correction\"]")
	private WebElement attendanceCorrectionPage;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtMenu\" and @text=\"Approve Attendance\"]")
	private WebElement approveAttendancePage;

	@FindBy(id = "com.mantra.minop:id/btn_logout")
	private WebElement accountLogout;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtMenu\" and @text=\"Dashboard\"]")
	private WebElement VerifyDashboardPage;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtMenu\" and @text=\"Attendance Report\"]")
	private WebElement verifyAttendanceReport;
	
	public boolean clickOnAttendanceReport() {
		try {
			utils.waitForEle(verifyAttendanceReport, "visible", "", 5);
			verifyAttendanceReport.isDisplayed();
			verifyAttendanceReport.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickOnDashboard() {
		try {
			utils.waitForEle(VerifyDashboardPage, "visible", "", 5);
			VerifyDashboardPage.isDisplayed();
			VerifyDashboardPage.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickOnApproveAttendance() {
		try {
			utils.waitForEle(approveAttendancePage, "visible", "", 5);
			approveAttendancePage.isDisplayed();
			approveAttendancePage.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyEmpName() {
		try {
			utils.waitForEle(verifyName, "visible", "", 10);
			if (verifyName.isDisplayed()) {
				return true;
			} else {
				exceptionDesc = "Element is not displayed even though it was found.";
				return false;
			}
		} catch (NoSuchElementException e) {
			exceptionDesc = "No such element: " + e.getMessage();
			return false;
		} catch (TimeoutException e) {
			exceptionDesc = "Timeout while waiting for element: " + e.getMessage();
			return false;
		} catch (Exception e) {
			exceptionDesc = "An unexpected error occurred: " + e.getMessage();
			return false;
		}
	}

	public boolean verifyApproveLeave() {
		try {
			utils.waitForEle(approveLeavePage, "visible", "", 5);
			approveLeavePage.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyProfileImg() {
		try {
			utils.waitForEle(verifyImage, "visible", "", 5);
			verifyImage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean VerifyCameraOpen() {
		try {
			utils.waitForEle(VerifyCamera, "visible", "", 5);
			VerifyCamera.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyCheckInBtn() {
		try {
			utils.waitForEle(verifyCheckInBtn, "visible", "", 5);
			verifyCheckInBtn.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyCheckOutBtnDisplay() {
		try {
			utils.waitForEle(verifyCheckInBtn, "visible", "", 5);
			verifyCheckInBtn.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyCheckOutBtn() {
		try {
			utils.waitForEle(verifyCheckInBtn, "visible", "", 5);
			verifyCheckInBtn.isDisplayed();
			verifyCheckInBtn.click();
			System.out.println("Check IN Button Click");
			utils.waitForEle(webPunchBtn, "visible", "", 5);
			webPunchBtn.click();
			System.out.println("Punch Successfully");
			utils.waitForEle(verifyCheckInBtn, "visible", "", 5);
			verifyCheckInBtn.isDisplayed();

		} catch (Exception e) {
			// Handle exceptions and log the error message
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean verifyclickFacePunch() {
		try {
			verifyCheckInBtn.click();
			System.out.println("Check IN Button Click");
			utils.waitForEle(FacePunchBtn, "visible", "", 5);
			FacePunchBtn.click();
			System.out.println("Open Face Punch");

		} catch (Exception e) {
			// Handle exceptions and log the error message
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean AfterClickCheckOutBtn() {
		try {
			// Check if the verifyCheckInBtn is displayed
			if (verifyCheckInBtn.isDisplayed()) {
				utils.waitForEle(verifyCheckInBtn, "visible", "", 5);
				System.out.println("CheckIn button is displayed");

				// Check if the verifyCheckInBtn is enabled
				if (verifyCheckInBtn.isEnabled()) {
					System.out.println("CheckIn button is enabled");
				}
			}

		} catch (Exception e) {
			// Handle exceptions and log the error message
			exceptionDesc = e.getMessage();
			System.out.println("Exception caught: " + exceptionDesc);
			return false;
		}
		return true;
	}

	public boolean verifyDisplayedTime() {

		try {

			String displayedTimeText = displayedTime.getText();
			String currentTime = new SimpleDateFormat("HH:mm").format(new Date());

			if (displayedTimeText.equals(currentTime)) {
				System.out.println("Current time displayed correctly: " + displayedTimeText);
				return true;
			} else if (displayedTimeText.equals("00:00")) {
				System.out.println("Default time displayed: " + displayedTimeText);
				return true;
			} else {
				System.out.println("Unexpected time displayed: " + displayedTimeText);
				return false;
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean verifyLeftMenu() {
		try {
			utils.waitForEle(clickLeaftMenu, "visible", "", 5);
			clickLeaftMenu.isDisplayed();
			clickLeaftMenu.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyWebPunch() {
		try {
			utils.waitForEle(clickWebPunchApproveLink, "visible", "", 5);
			clickWebPunchApproveLink.isDisplayed();
			clickWebPunchApproveLink.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean GotoHomePage() {
		try {
			utils.waitForEle(clickOnHomePage, "visible", "", 5);
			clickOnHomePage.isDisplayed();
			clickOnHomePage.click();
			utils.waitForEle(verifyName, "visible", "", 5);
			verifyName.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyLogOutAccount() {
		try {
			utils.waitForEle(accountLogout, "visible", "", 5);
			accountLogout.isDisplayed();
			accountLogout.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyLeaveRequest() {
		try {
			utils.waitForEle(leaveReuestPage, "visible", "", 5);
			leaveReuestPage.isDisplayed();
			leaveReuestPage.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyAttendanceCorrection() {
		try {
			utils.waitForEle(attendanceCorrectionPage, "visible", "", 5);
			attendanceCorrectionPage.isDisplayed();
			attendanceCorrectionPage.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public String getExceptionDesc() {
		return this.exceptionDesc;
	}
}