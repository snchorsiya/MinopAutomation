package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

public class MinopApproveWebPunchPage extends initBase {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils= new Utils(driver);
	
	public MinopApproveWebPunchPage(WebDriver driver) {
		this.driver = driver;
		utils= new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.mantra.minop:id/txtLable")
	private WebElement verifyWebPunchPage;

	@FindBy(id = "com.mantra.minop:id/selectAllCheckBox")
	private WebElement clickCheckBox;
	
	@FindBy(id = "com.mantra.minop:id/btnApprov")
	private WebElement clickApproveBtn;
	
	@FindBy(xpath = "//android.widget.Toast[@text='All Webpunch Approved Successfully.']")
	private WebElement verifyTostApproveMsg;

	public boolean verifyWebPunchPageName() {
		try {
			utils.waitForEle(verifyWebPunchPage, "visible", "", 5);
			verifyWebPunchPage.isDisplayed();
			System.out.println(verifyWebPunchPage.getText());
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
			utils.waitForEle(verifyTostApproveMsg, "visible", "", 5);
			verifyTostApproveMsg.isDisplayed();
			System.out.println(verifyTostApproveMsg.getText());
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
