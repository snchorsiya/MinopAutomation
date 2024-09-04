package androidpage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import utils.Utils;

public class MinopLeaveRequestPage {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);
//	String randomDateXPath = Utils.getRandomDateXPath();

	public MinopLeaveRequestPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/txtLable']")
	private WebElement VerifyLeaveRequestTitle;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvNoleaveReq\"]")
	private WebElement noResutlFoundMsg;
	@FindBy(id = "com.mantra.minop:id/fabLR")
	private WebElement clickAddIcon;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/txtLable']")
	private WebElement addLeaveRquesttitle;
	@FindBy(xpath = "//android.widget.Toast[@text='Please select leave']")
	private WebElement leaveRequestToastMag;
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.mantra.minop:id/frameLayoutLeave']/android.widget.ImageView")
	private WebElement drpLeave;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/tvLeaveType' and @text='CL - Casual Leave']")
	private WebElement clLeave;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.mantra.minop:id/txtFromDateAdd']")
	private WebElement fromDate;
//	@FindBy(xpath = "//android.view.View[@content-desc='29 May 2024']")
//	private WebElement selectFromDate;
	@FindBy(xpath = "//android.view.View[@content-desc=\"31 May 2024\"]")
	private WebElement selectToDate;
	@FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
	private WebElement DateOkbtn;
	@FindBy(id = "com.mantra.minop:id/txtToDateAdd")
	private WebElement toDate;
	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.mantra.minop:id/txtReason\"]")
	private WebElement txtReason;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnSave\"]")
	private WebElement applybtn;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Leave Added Successfully.\"]")
	private WebElement leaveSuccessMsg;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Leave already exists on this day.\"]")
	private WebElement alradyExitMsg;
	@FindBy(xpath = "(//android.widget.LinearLayout[@resource-id=\"com.mantra.minop:id/item_leave_reqapp_main\"])[1]/android.widget.LinearLayout")
	private WebElement leaveRquestView;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvLeaveType\" and @text=\"TL - Travel leave\"]")
	private WebElement tlLeave;
	@FindBy(xpath = "//android.widget.Spinner[@resource-id=\"com.mantra.minop:id/spinnerLeaveType\"]/android.widget.LinearLayout")
	private WebElement leaveTypeVerify;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtStatusDes\"])[1]")
	private WebElement pendingStatus;
	@FindBy(xpath = "(//android.widget.ImageView[@resource-id=\"com.mantra.minop:id/imgchangestatus\"])[1]")
	private WebElement leaveViewIcon;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement viewLeaveTitle;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtDateSearch\"]")
	private WebElement clickOnSearchLeaveByDate;
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.mantra.minop:id/item_leave_reqapp_main\"]/android.widget.LinearLayout")
	private WebElement verifySearchLevaeData;
	@FindBy(id = "com.mantra.minop:id/btnCancel")
	private WebElement verifyLeavecancelbtn;
	@FindBy(id = "com.mantra.minop:id/txtLvBalance")
	private WebElement verifyLeaveBalance;
	@FindBy(id = "com.mantra.minop:id/txtCarryFrwdLv")
	private WebElement verifyCarryFrwdLv;
	@FindBy(id = "com.mantra.minop:id/txtTotalLv")
	private WebElement verifyTotalLv;
	@FindBy(id = "com.mantra.minop:id/choosefilebtn")
	private WebElement verifyChooseFile;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"IMG_20240712_100733.jpg\"]")
	private WebElement chooseImage;
	@FindBy(id = "com.mantra.minop:id/showfilepath1")
	private WebElement showFileDisplay;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvLeaveType\" and @text=\"OD - On Duty Leave\"]")
	private WebElement odLeave;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvLeaveType\" and @text=\"AL - Automation Leave\"]")
	private WebElement alLeave;

	@FindBy(id = "com.mantra.minop:id/checkbox")
	private WebElement isHalf_Leave;
	@FindBy(id = "android:id/prev")
	private WebElement clickPrevicon;
	@FindBy(xpath = "//android.view.View[@content-desc=\"17 May 2024\"]")
	private WebElement clickPrveDate;
	@FindBy(xpath = "//android.widget.Toast[@text=\"Attendance is Locked for the Select Date and Month.\"]")
	private WebElement verifyLockAtt;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtStatusDes\"]")
	private WebElement approvedStatus;
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtStatusDes\" and @text=\"Rejected\"]")
	private WebElement rejectedStatus;
//	@FindBy(className = "android.widget.Toast")
//	private WebElement tostLock;

	public boolean verifyApprovedStatus() {
		try {
			utils.waitForEle(approvedStatus, "visible", "", 5);
			approvedStatus.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyRejectedStatus() {
		try {
			utils.waitForEle(rejectedStatus, "visible", "", 5);
			rejectedStatus.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	
	public boolean verifyLockedAttendanceToast() {
		if (utils.verifyToastMessagesFromSource(verifyLockAtt)) {
			verifyLockAtt.isDisplayed();
			return true;
		} else {
			applybtn.click();
			if (utils.verifyToastMessagesFromSource(verifyLockAtt))
				return true;
			;
		}
		return false;

	}

	public boolean verifyPrevDateLeave() {
		try {
			utils.waitForEle(fromDate, "visible", "", 5);
			fromDate.click();
			utils.waitForEle(clickPrevicon, "visible", "", 5);
			clickPrevicon.click();
			utils.waitForEle(clickPrveDate, "visible", "", 5);
			clickPrveDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyCheckCheckboxHalfDay() {
		try {
			utils.waitForEle(isHalf_Leave, "visible", "", 1); // Increase wait time if needed
			isHalf_Leave.isDisplayed();
			isHalf_Leave.click();
		} catch (Exception e) {
			e.printStackTrace();
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean verifyFromPrevDateLeave() {
		try {
			utils.waitForEle(toDate, "visible", "", 5);
			toDate.click();
			utils.waitForEle(clickPrevicon, "visible", "", 5);
			clickPrevicon.click();
			utils.waitForEle(clickPrveDate, "visible", "", 5);
			clickPrveDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyodLeaveDocu() {
		try {
			utils.waitForEle(drpLeave, "visible", "", 5);
			drpLeave.click();
			utils.waitForEle(odLeave, "visible", "", 5);
			odLeave.click();
			utils.waitForEle(fromDate, "visible", "", 5);
			fromDate.click();
			utils.waitForEle(selectToDate, "visible", "", 5);
			selectToDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
			utils.waitForEle(toDate, "visible", "", 5);
			toDate.click();
			utils.waitForEle(selectToDate, "visible", "", 5);
//			selectFromDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
			utils.waitForEle(isHalf_Leave, "visible", "", 5);
			isHalf_Leave.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyODLeavePaid() {
		try {
			utils.waitForEle(drpLeave, "visible", "", 5);
			drpLeave.click();
			utils.waitForEle(odLeave, "visible", "", 5);
			odLeave.click();
			utils.waitForEle(leaveTypeVerify, "visible", "", 5);
			leaveTypeVerify.isDisplayed();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyodTwoHalfLeaveDocu() {
		try {
			utils.waitForEle(drpLeave, "visible", "", 5);
			drpLeave.click();
			utils.waitForEle(alLeave, "visible", "", 5);
			alLeave.click();
			utils.waitForEle(fromDate, "visible", "", 5);
			fromDate.click();
//			utils.waitForEle(selectFromDate, "visible", "", 5);
//			selectToDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
			utils.waitForEle(toDate, "visible", "", 5);
			toDate.click();
			utils.waitForEle(selectToDate, "visible", "", 5);
//			selectFromDate.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
			utils.waitForEle(isHalf_Leave, "visible", "", 5);
			isHalf_Leave.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyChooseFile() {
		try {
			// Wait until the 'verifyChooseFile' element is visible
			utils.waitForEle(verifyChooseFile, "visible", "", 5);
			// Check if the 'verifyChooseFile' element is displayed
			if (verifyChooseFile.isDisplayed()) {
				verifyChooseFile.click();
				// Wait until the 'chooseImage' element is visible and then click it
				utils.waitForEle(chooseImage, "visible", "", 5);
				chooseImage.click();
			} else {
				// Print a message if 'verifyChooseFile' is not displayed
				System.out.println("Choose File not displayed.");
			}
		} catch (Exception e) {
			// Capture the exception message
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean verifyChooseFileDisplay() {
		try {
			// Wait until the 'verifyChooseFile' element is visible
			utils.waitForEle(verifyChooseFile, "visible", "", 5);
			// Check if the 'verifyChooseFile' element is displayed
			verifyChooseFile.isDisplayed();

		} catch (Exception e) {
			// Capture the exception message
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}
	
	public boolean verifyCheckChooseFileDisplay() {
		try {
			// Wait until the 'verifyChooseFile' element is visible
			utils.waitForEle(verifyChooseFile, "visible", "", 5);
			// Check if the 'verifyChooseFile' element is displayed
			 if (verifyChooseFile.isDisplayed()) {
		            return false; // Return false if the element is displayed
		        }

		} catch (Exception e) {
			// Capture the exception message
			exceptionDesc = e.getMessage();
			return true;
		}
		return true;
	}

	public boolean verifychooseFileDisplay() {
		try {
			utils.waitForEle(showFileDisplay, "visible", "", 5);
			showFileDisplay.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyLeaveBalance() {
		try {
			utils.waitForEle(verifyLeaveBalance, "visible", "", 5);
			if (verifyLeaveBalance.isDisplayed()) {
				utils.waitForEle(verifyCarryFrwdLv, "visible", "", 5);
			} else if (verifyCarryFrwdLv.isDisplayed()) {
				utils.waitForEle(verifyTotalLv, "visible", "", 5);
			} else if (verifyTotalLv.isDisplayed()) {
				System.out.println("Leave Blance proper display...");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
		return true;
	}

	public boolean verifyleavecancelBtn() {
		try {
			// Define the button text
			String buttonText = "Cancel"; // Replace with the actual text of your button

			// Create the UIAutomator selector
			String uiAutomatorSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
					+ buttonText + "\"))";

			// Locate the button using UIAutomator
			WebElement button = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorSelector));

			// Set implicit wait time
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Click the button
			button.click();
			System.out.println(buttonText + " button clicked successfully.");

			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}

	}

	public boolean verifyleaveSearch(int dayOffset) {
		try {
			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);
			utils.waitForEle(clickOnSearchLeaveByDate, "visible", "", 10); // Increased timeout
			clickOnSearchLeaveByDate.click();

			System.out.println("Generated XPath: " + randomDateXPath);

			// Adding a retry mechanism
			boolean dateSelected = false;
			for (int i = 0; i < 3; i++) {
				try {
					WebElement dateElement = driver.findElement(By.xpath(randomDateXPath));
					utils.waitForEle(dateElement, "visible", "", 5);
					dateElement.click();
					dateSelected = true;
					break;
				} catch (Exception e) {
					System.out.println("Retrying to select the date... Attempt: " + (i + 1));
				}
			}

			if (!dateSelected) {
				throw new Exception("Failed to select the date after multiple attempts.");
			}

			utils.waitForEle(DateOkbtn, "visible", "", 10); // Increased timeout
			DateOkbtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			System.out.println("Exception in verifyleaveSearch: " + exceptionDesc);
			return false;
		}

		return true;
	}

	public boolean verifyleaveSearchData() {
		try {
			utils.waitForEle(verifySearchLevaeData, "visible", "", 5);
			verifySearchLevaeData.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyleaveViewIcon() {
		try {
			utils.waitForEle(leaveViewIcon, "visible", "", 5);
			leaveViewIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyleaveViewTitle() {
		try {
			utils.waitForEle(viewLeaveTitle, "visible", "", 5);
			viewLeaveTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyleaverequestTitle() {
		try {
			utils.waitForEle(VerifyLeaveRequestTitle, "visible", "", 3);
			VerifyLeaveRequestTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyNoResultFoundMsg() {
		try {
			// Wait for the element for a specified time and check if it's visible
			utils.waitForEle(noResutlFoundMsg, "visible", "", 3);
		} catch (Exception e) {
			// If an exception occurs (e.g., element not found), it means the message is not
			// displayed
			System.out.println("The Message is not displayed (exception caught)");
			return false;
		}
		return true;
	}

	public boolean VerifyAddLeaveRequestPage() {
		try {
			utils.waitForEle(addLeaveRquesttitle, "visible", "", 3);
			addLeaveRquesttitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyALDrpLeave() {
		try {

			utils.waitForEle(drpLeave, "visible", "", 5);

			drpLeave.click();

			utils.waitForEle(alLeave, "visible", "", 5);
			alLeave.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyODDrpLeave() {
		try {

			utils.waitForEle(drpLeave, "visible", "", 5);

			drpLeave.click();

			utils.waitForEle(odLeave, "visible", "", 5);
			odLeave.click();

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyClickOnAddIcon() {
		try {
			utils.waitForEle(clickAddIcon, "visible", "", 3);
			clickAddIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyToastMsgAddLeave() {
		if (utils.verifyToastMessagesFromSource(leaveRequestToastMag)) {
			return true;
		} else {
			applybtn.click();
			if (utils.verifyToastMessagesFromSource(leaveRequestToastMag))
				return true;
			;
		}
		return false;
		// Use a shorter timeout within the loop
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
//			WebElement toastElement = wait.until(ExpectedConditions.visibilityOf(leaveRequestToastMag));
//			if (utils.waitForEle(leaveRequestToastMag, "visible", "", 5)) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (Exception e) {
//			exceptionDesc = e.getMessage();
//			return false;
//		}
	}

	public boolean VerifyPendingStatus() {
		try {
			utils.waitForEle(pendingStatus, "visible", "", 5);
			pendingStatus.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyClDrpLeave() {
		try {
			System.out.println("Drp");
			utils.waitForEle(drpLeave, "visible", "", 5);
			drpLeave.click();
			utils.waitForEle(clLeave, "visible", "", 5);
			clLeave.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

//	public boolean VerifyFromDate(int dayOffset) {
//		try {
//
//			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);
//
//			utils.waitForEle(fromDate, "visible", "", 10);
//			fromDate.click();
//
//			System.out.println("Generated XPath for From Date: " + randomDateXPath);
//			Thread.sleep(2000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//			System.out.println("Click FromDate");
//			WebElement dateElement = wait
//					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDateXPath)));
//			System.out.println("Date Element is displayed: " + dateElement.isDisplayed());
//			System.out.println("Date Element is enabled: " + dateElement.isEnabled());
//			System.out.println("The date element: " + dateElement);
//
//			// Wait for the date element to be fully visible and click it
//			utils.waitForEle(dateElement, "visible", "", 10);
//			dateElement.click();
//
//			// Wait for the 'DateOkbtn' element to be visible and click it
//			utils.waitForEle(DateOkbtn, "visible", "", 10);
//			DateOkbtn.click();
//			return true;
//		} catch (Exception e) {
//			System.out.println("Exception occurred while selecting From Date: " + e.getMessage());
//			exceptionDesc = e.getMessage();
//			return false;
//		}
//	}

	public boolean VerifyFromDate(int dayOffset) {
		try {

			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);

			utils.waitForEle(fromDate, "visible", "", 5);
			fromDate.click();

			System.out.println("Generated XPath for From Date: " + randomDateXPath);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement dateElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDateXPath)));
			System.out.println("Click the date");
			dateElement.click();

			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();

			return true;
		} catch (Exception e) {
			System.out.println("Exception occurred while selecting From Date: " + e.getMessage());
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean VerifyOkBtn() {
		try {
			System.out.println("The click on Ok Button");
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.isDisplayed();
			DateOkbtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyToDate(int dayOffset) {
		try {
			// Calculate the target date
			LocalDate today = LocalDate.now();
			LocalDate targetDate = today.plusDays(dayOffset);
			int targetDay = targetDate.getDayOfMonth();
			String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			int targetYear = targetDate.getYear();

			// Determine if we need to navigate to the next month
			LocalDate currentDate = LocalDate.now();
			String currentMonth = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			int currentYear = currentDate.getYear();

			// Generate the correct XPath for the target date
			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);

			utils.waitForEle(toDate, "visible", "", 10);
			toDate.click();

			// Navigate to the next month if the target date is not in the current month
			if (!targetMonth.equals(currentMonth) || targetYear != currentYear) {
				// Assume nextMonthButton is the locator for the next month button in the
				// calendar
				WebElement nextMonthButton = driver.findElement(By.id("android:id/next")); // Replace with actual
																							// locator
				utils.waitForEle(nextMonthButton, "visible", "", 10);
				nextMonthButton.click();
			}

			System.out.println("Generated XPath for To Date: " + randomDateXPath);
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement dateElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(randomDateXPath)));
			System.out.println("Date Element is displayed: " + dateElement.isDisplayed());
			System.out.println("Date Element is enabled: " + dateElement.isEnabled());
			System.out.println("The date element: " + dateElement);

			// Wait for the date element to be fully visible and click it
			utils.waitForEle(dateElement, "visible", "", 10);
			dateElement.click();

			// Wait for the 'DateOkbtn' element to be visible and click it
			utils.waitForEle(DateOkbtn, "visible", "", 10);
			DateOkbtn.click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception occurred while selecting To Date: " + e.getMessage());
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean VerifyToDateDocumant(int dayOffset) {
		try {
			String randomDateXPath = Utils.getRandomDateXPath(dayOffset);
			utils.waitForEle(toDate, "visible", "", 5);
			toDate.click();
			System.out.println("Generated XPath: " + randomDateXPath);

			By selectFromDate = By.xpath(randomDateXPath);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(selectFromDate));
			wait.until(ExpectedConditions.elementToBeClickable(dateElement));
			dateElement.click();
			utils.waitForEle(DateOkbtn, "visible", "", 5);
			DateOkbtn.click();
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean enterLeaveReason() {
		try {
//			if (utils.waitForEle(permission_allow_button, "visible", "", 3)) {
//				permission_allow_button.click();
//			}
			utils.waitForEle(txtReason, "visible", "", 5);
			txtReason.click();
			txtReason.sendKeys("Today Holiday");
			driver.navigate().back();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean clickApplyBtn() {
		try {
			// Define the button text
			String buttonText = "Apply"; // Replace with the actual text of your button

			// Create the UIAutomator selector
			String uiAutomatorSelector = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
					+ buttonText + "\"))";

			// Locate the button using UIAutomator
			WebElement button = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorSelector));

			// Set implicit wait time
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

			// Click the button
			button.click();
			System.out.println(buttonText + " button clicked successfully.");

			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			return false;
		}
	}

	public boolean VerifySuccessMsgAddLeave() {
		try {
			String expectedMsg = "Leave Added Successfully.";

			// Increase the wait time if the element takes longer to appear
			utils.waitForEle(leaveSuccessMsg, "visible", null, 10); // Adjust timeout as needed

			if (leaveSuccessMsg.isDisplayed()) {
				String actualMsg = leaveSuccessMsg.getText();
				if (actualMsg.equals(expectedMsg)) {
					System.out.println("Test Case passed: Success message is displayed.");
					return true;
				} else {
					System.out.println("Test Case passed but success message did not match.");
					System.out.println("Expected: " + expectedMsg);
					System.out.println("Actual: " + actualMsg);
					return false;
				}
			} else {
				System.out.println("Test Case failed: Success message is not displayed.");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
			exceptionDesc = e.getMessage();
			return false;
		}
	}

//	public boolean VerifyAlradyExitMsgAddLeave() {
//		try {
//
//			utils.waitForEle(alradyExitMsg, "visible", "", 1); // Increase wait time if needed
//			if (utils.verifyToastMessagesFromSource(alradyExitMsg)) {
//				alradyExitMsg.isDisplayed();
//
//			} else {
//				applybtn.click();
//				return false; // Success message is not displayed
//			}
//		} catch (Exception e) {
//			exceptionDesc = e.getMessage().toString();
//			return false;
//		}
//
//		return true;
//	}alradyExitMsg

	public boolean VerifyAlreadyExitMsgAddLeave() {
		if (utils.verifyToastMessagesFromSource(alradyExitMsg)) {
			alradyExitMsg.isDisplayed();
			return true;
		} else {
			applybtn.click();
			if (utils.verifyToastMessagesFromSource(alradyExitMsg))
				return true;
			;
		}
		return false;

	}

	public boolean VerifyLeavedisplay() {
		try {
			utils.waitForEle(leaveRquestView, "visible", "", 5);
			leaveRquestView.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyLeavTypeUnpaid() {
		try {
			utils.waitForEle(leaveTypeVerify, "visible", "", 5);
			leaveTypeVerify.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifytlDrpLeave() {
		try {
			utils.waitForEle(drpLeave, "visible", "", 5);
			drpLeave.click();
			utils.waitForEle(tlLeave, "visible", "", 5);
			tlLeave.click();
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
