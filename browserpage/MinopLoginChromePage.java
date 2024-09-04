package browserpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import androidpage.MinopLoginPage;
import base.initBase;
import utils.Utils;

public class MinopLoginChromePage {

	private static WebDriver driver;
	private static String exceptionDesc;
	static Utils utils= new Utils(driver);

	public MinopLoginChromePage(WebDriver driver) {
		this.driver = driver;
		utils= new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	// Page factory for Login Page Android
	// ']

	@FindBy(id = "UserEmail")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(xpath = "(//button[contains(text(),'Login​')])[1]")
	private WebElement btn_signin;

	@FindBy(xpath = "//*[@id='adminLogin']/div")
	private static WebElement errorMsg;
	
	
	public static boolean errorMessage() {
		try {
			utils.waitForEle(errorMsg, "visible", null);
			errorMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterUser(String user) {
		try {
			utils.waitForEle(email, "visible", user);
			email.sendKeys(user);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterPassword(String pass) {
		try {
			utils.waitForEle(password, "visible", pass);
			password.sendKeys(pass);

		} catch (Exception e) {
			// TODO: handle exception
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean clickLoginBtn(String user, String pass) {

		try {
			utils.waitForEle(btn_signin, "visible", null, 5);
			System.out.println(btn_signin.isDisplayed());
			try {
				btn_signin.click();
			} catch (Exception e) {
			}
			// Retry logic for failed case of Login in Minop
			// WebElement accCode =
			// driver.findElement(By.xpath("//li[@class='account_code'])[1]"));
			for (int i = 0; i < 3; i++) {
				System.out.println("Iteration" + i);
				try {
					WebElement ele = driver.findElement(By.xpath("//div[@class='menu_header_Account_details']//li[1]"));
					break;
				} catch (Exception e) {
					System.out.println(e.getMessage().toString());
					email.sendKeys(user);
					password.sendKeys(pass);
					btn_signin.click();
				}
			}

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