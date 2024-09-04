package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

import org.openqa.selenium.support.FindBy;

public class MinopForgotPasswordPage extends initBase {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	private WebElement ForgotPassowordTitle;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.mantra.minop:id/edtForgotPassEmail\"]")
	private WebElement txtEmail;

	@FindBy(xpath = "//android.widget.EditText[@resource-id=\"com.mantra.minop:id/edtDomain\"]")
	private WebElement txtAccountCode;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnSubmit\"]")
	private WebElement btnSubmit;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/tvLogin\"]")
	private WebElement linkLogin;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Email is required\"]")
	private WebElement verifyValidationMsg;

	@FindBy(xpath = "//android.widget.Toast[@text=\"Email Not Registered.\"]")
	private WebElement verifyunregisteredValidationMsg ;
	
	@FindBy(xpath = "//android.widget.Toast[@text=\"Please Enter Valid Email\"]")
	private WebElement verifyInvalidValidationMsg;
	
	public boolean enterEmailtxt(String user) {
		try {
			utils.waitForEle(txtEmail, "visible", "", 2);
			txtEmail.clear();
			txtEmail.sendKeys(user);
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	public boolean enterAccountCodetxt(String domain) {
		try {
			utils.waitForEle(txtAccountCode, "visible", "", 2);
			txtAccountCode.clear();
			txtAccountCode.sendKeys(domain);
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	public boolean clickSubmitBtn() {

		try {
			utils.waitForEle(btnSubmit, "visible", "", 5);
			btnSubmit.isDisplayed();
			btnSubmit.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	public boolean clickBackToLoginLink() {

		try {
			utils.waitForEle(linkLogin, "visible", "", 5);
			linkLogin.isDisplayed();
			linkLogin.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifyForgotPasswordTitle() {
		try {
			ForgotPassowordTitle.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	public boolean verifyInvalidValidationMessage() {
		if (utils.verifyToastMessagesFromSource(verifyInvalidValidationMsg)) {
			return true;
		} else {
			btnSubmit.click();
			if (utils.verifyToastMessagesFromSource(verifyInvalidValidationMsg))
				return true;
			;
		}
		return false;
	}
	
	public boolean verifyUnregisteredValidationMessage() {
		if (utils.verifyToastMessagesFromSource(verifyunregisteredValidationMsg)) {
			return true;
		} else {
			btnSubmit.click();
			if (utils.verifyToastMessagesFromSource(verifyunregisteredValidationMsg))
				return true;
			;
		}
		return false;
	}
	
	
	public boolean verifyValidationMessage() {
		if (utils.verifyToastMessagesFromSource(verifyValidationMsg)) {
			return true;
		} else {
			btnSubmit.click();
			if (utils.verifyToastMessagesFromSource(verifyValidationMsg))
				return true;
			;
		}
		return false;
	}
	
	public String getExceptionDesc() {
		return this.exceptionDesc;
	}


}
