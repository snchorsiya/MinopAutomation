package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

public class MinopLoginPage extends initBase {

	private WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopLoginPage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	// Page factory for Login Page Android
	@FindBy(id = "edtAccountCode")
	private WebElement account_code;

	@FindBy(id = "edtEmail")
	private WebElement email;

	@FindBy(id = "edtPassword")
	private WebElement password;

	@FindBy(id = "btn_signIn")
	private WebElement btn_signin;

	@FindBy(id = "android:id/button1")
	private WebElement Ok_button1;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement permission_allow_button;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement allow_location_button;

	@FindBy(id = "tvRemTime")
	private WebElement tvRemTime;

	@FindBy(xpath = "//android.widget.Toast[@text='Invalid Email/PunchID/EmployeeCode/Password.']")
	private WebElement messageEmailID1;

	@FindBy(id = "com.mantra.minop:id/txtForgotPass")
	private WebElement click_forgotpass_link;

	@FindBy(xpath = "//android.widget.Toast[@text='Invalid Account Code']")
	private WebElement InvalidAccountCodeMsg;

	@FindBy(xpath = "//android.widget.Toast[@text='User Not Exist.']")
	private WebElement UserNotExistMessage;

//	public boolean login(String user, String pass, String domain) {
//		try {
//			account_code.sendKeys(domain);
//			email.sendKeys(user);
//			password.sendKeys(pass);
//			btn_signin.click();
//
////	         Optionally handle popups or alerts here
////	         for example:
////	         if (Ok_button1.isDisplayed())
////	             Ok_button1.click();
////	         if (permission_allow_button.isDisplayed())
////	             permission_allow_button.click();
//
//			return true;
//		} catch (Exception e) {
//			exceptionDesc = e.getMessage().toString();
//			return false;
//		}
//	}

	public boolean enterDomin(String domain) {
		try {
//			if (utils.waitForEle(permission_allow_button, "visible", "", 3)) {
//				permission_allow_button.click();
//			}		
			utils.waitForEle(account_code, "visible", "", 3);
			account_code.sendKeys(domain);
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean enterUser(String user) {
		try {
			if (utils.waitForEle(permission_allow_button, "visible", "", 3)) {
				permission_allow_button.click();
			}
			utils.waitForEle(email, "visible", "", 2);
			email.sendKeys(user);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterPassword(String pass) {
		try {
			utils.waitForEle(password, "visible", "", 2);

//			password.click();
			password.sendKeys(pass);
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickLoginBtn() {

		try {
			utils.waitForEle(btn_signin, "visible", "", 5);
			btn_signin.isDisplayed();
			btn_signin.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickForgotPassLink() {
		try {
			if (utils.waitForEle(permission_allow_button, "visible", "", 3)) {
				permission_allow_button.click();
			}
			click_forgotpass_link.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean handlePopups() {
		try {
			boolean popupHandled = false;

			// Check and handle the OK button popup
			if (Ok_button1.isDisplayed()) {
				System.out.println("OK button");
				Ok_button1.click();
				popupHandled = true;
			}

			// Check and handle the permission allow button popup
			if (permission_allow_button.isDisplayed()) {
				System.out.println("Permission allow");
				permission_allow_button.click();
				popupHandled = true;
			}

			// Check and handle the allow location button popup
			if (allow_location_button.isDisplayed()) {
				System.out.println("Location allow");
				allow_location_button.click();
				popupHandled = true;
			}

			return popupHandled;

		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}

	public boolean verifyInvalidEmailIDMessage(String message) {
		try {
			// Wait for the toast message to appear
//	    	WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30)); // Adjust the timeout as needed
//	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Toast[@text='Invalid Email/PunchID/EmployeeCode/Password.']")));

			String ErroMessage = messageEmailID1.getText();
			if (ErroMessage.contains(message) != true)
				return false;
		} catch (Exception e) {
			// If the wait times out or throws an exception, the toast message didn't appear
			return false;
		}
		return true;
	}

	public boolean verifyInvalidAccountCodeMessage(String message) {
		try {
			if (pageSourceText("Invalid Account Code") != true)
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	public boolean verifyUserNotExistMessage() {
		if (utils.verifyToastMessagesFromSource(UserNotExistMessage)) {
			return true;
		} else {
			btn_signin.click();
			if (utils.verifyToastMessagesFromSource(UserNotExistMessage))
				return true;
			;
		}
		return false;
	}

	public boolean acceptNotify() {
		try {
			if (utils.waitForEle(permission_allow_button, "visible", "", 3)) {
				permission_allow_button.click();
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}

	public boolean pageSourceText(String strSearch) {
		try {
			String temp = "s";
			Thread.sleep(1000);
			for (int i = 0; i < 3; i++) {
				temp = driver.getPageSource();
				btn_signin.click();
				if (temp.contains(strSearch))
					break;
			}
			if (temp.contains(strSearch) != true)
				return false;
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
