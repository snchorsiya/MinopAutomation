package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class MinopApproveLeavePage {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils= new Utils(driver);
	
	public MinopApproveLeavePage(WebDriver driver) {
		this.driver = driver;
		utils= new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement leaveRequestApproveTitle;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvNoAppleaveReq\"]")
	private WebElement leaveRequestNoResultmsg;

	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.mantra.minop:id/img_view\"]/android.widget.ImageView")
	private WebElement leaveReuestviewIcon;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnApproved\"]")
	private WebElement ApproveBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnApprov\"]")
	private WebElement frontApproveBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnReject\"]")
	private WebElement frontRejectBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnReject\"]")
	private WebElement RejectBtn;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
	private WebElement verifypopup;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvTitle\"]")
	private WebElement verifypopupTitle;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.mantra.minop:id/edt_dlgReason\"]")
	private WebElement verifypopupApproveorRejectTextArea;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txt_dlg_save\"]")
	private WebElement verifypopupSavebtn;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txt_dlg_cancel\"]")
	private WebElement verifypopupCancelbtn;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Please give Reason\"]")
	private WebElement verifyToastMsgReason;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Leave Approved Successfully.\"]")
	private WebElement verifyLeaveApprovedSuccessMsg;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Leave Rejected Successfully.\"]")
	private WebElement verifyLeaveRejectMsg;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.mantra.minop:id/imgRefresh\"]")
	private WebElement verifyRefresh;
	
	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.mantra.minop:id/item_leave_reqapp_main\"]/android.widget.LinearLayout")
	private WebElement verifyDataInGrid;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.mantra.minop:id/imgView\"]")
	private WebElement verifyGridCheckBox;
	
	@FindBy(xpath = "//android.widget.CheckBox[@resource-id=\"com.mantra.minop:id/selectAllCheckBox\"]")
	private WebElement verifyAllChekBox;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txt_dlg_save\"]")
	private WebElement verifySaveBtn;
	
	
	public boolean clickOnSaveBtn() {
		try {
			utils.waitForEle(verifySaveBtn, "visible", "", 5);
			verifySaveBtn.click();
			
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyAllCheckBox() {
		try {
			utils.waitForEle(verifyAllChekBox, "visible", "", 5);
			verifyAllChekBox.click();
			if (verifyAllChekBox.isSelected()) {
				System.out.println(verifyGridCheckBox.isSelected());
			}
			else {
				System.out.println("Check box not selected");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyFrontApprove() {
		try {
			utils.waitForEle(frontApproveBtn, "visible", "", 5);
			frontApproveBtn.click();
			
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyFrontReject() {
		try {
			utils.waitForEle(frontRejectBtn, "visible", "", 5);
			frontRejectBtn.click();
			
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyDataInGrid() {
		try {
			utils.waitForEle(verifyDataInGrid, "visible", "", 5);
			verifyDataInGrid.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyRefreshIcon() {
		try {
			utils.waitForEle(verifyRefresh, "visible", "", 5);
			verifyRefresh.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	public boolean verifyLeaveRejectSuccessMsg() {
		try {
			utils.waitForEle(verifyLeaveRejectMsg, "visible", "", 5);
			verifyLeaveRejectMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	public boolean verifyLeaveApprovedSuccessMsg() {
		try {
			utils.waitForEle(verifyLeaveApprovedSuccessMsg, "visible", "", 5);
			if (verifyLeaveApprovedSuccessMsg.isDisplayed()) {
				System.out.println(verifyLeaveApprovedSuccessMsg.getText());
			}
			else {
				System.out.println("Message not display");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyLeaveRequestToastMsgReason() {
		try {
			utils.waitForEle(verifyToastMsgReason, "visible", "", 5);
			verifyToastMsgReason.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestPopupCancelBtn() {
		try {
			utils.waitForEle(verifypopupCancelbtn, "visible", "", 5);
			verifypopupCancelbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestPopupSaveBtn() {
		try {
			utils.waitForEle(verifypopupSavebtn, "visible", "", 5);
			verifypopupSavebtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestPopupTextArea() {
		try {
			utils.waitForEle(verifypopupApproveorRejectTextArea, "visible", "", 5);
			verifypopupApproveorRejectTextArea.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestPopupTextAreaReason() {
		try {
			utils.waitForEle(verifypopupApproveorRejectTextArea, "visible", "", 5);
			verifypopupApproveorRejectTextArea.click();
			verifypopupApproveorRejectTextArea.sendKeys("Today not apply the leave");
			driver.navigate().back();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestPopupTitle() {
		try {
			utils.waitForEle(verifypopupTitle, "visible", "", 5);
			verifypopupTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestApprovePopup() {
		try {
			utils.waitForEle(verifypopup, "visible", "", 5);
			verifypopup.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	

	public boolean verifyLeaveRequestApproveBtn() {
		try {
			utils.waitForEle(ApproveBtn, "visible", "", 5);
			ApproveBtn.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestApproveBtnClick() {
		try {
			utils.waitForEle(ApproveBtn, "visible", "", 5);
			ApproveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyLeaveRequestRejectBtnClick() {
		try {
			utils.waitForEle(RejectBtn, "visible", "", 5);
			RejectBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestTitle() {
		try {
			utils.waitForEle(leaveRequestApproveTitle, "visible", "", 5);
			leaveRequestApproveTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestViewIcon() {
		try {
			utils.waitForEle(leaveReuestviewIcon, "visible", "", 5);
			leaveReuestviewIcon.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestViewIconClick() {
		try {
			utils.waitForEle(leaveReuestviewIcon, "visible", "", 5);
			leaveReuestviewIcon.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyLeaveRequestNoDataMsg() {
		try {
			utils.waitForEle(leaveRequestNoResultmsg, "visible", "", 5);
			leaveRequestNoResultmsg.isDisplayed();
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
