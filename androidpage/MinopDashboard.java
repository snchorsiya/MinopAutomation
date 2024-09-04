package androidpage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.initBase;
import utils.Utils;

public class MinopDashboard extends initBase {

	WebDriver driver;
	private String exceptionDesc;
	Utils utils = new Utils(driver);

	public MinopDashboard(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement VerifyDashboardTitle;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/edtmonth\"]")
	private WebElement VerifyCurrentMonth;

	@FindBy(xpath = "//android.widget.Button[@text=\"6\"]")
	private WebElement VerifyDRPMonth;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement verifyOKBtn;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mantra.minop:id/piechart\"]")
	private WebElement verifyChart;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.mantra.minop:id/fragment_container\"]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.LinearLayout")
	private WebElement verifyAbsentCount;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.mantra.minop:id/fragment_container\"]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout")
	private WebElement verifyPresentCount;

	@FindBy(xpath = "//android.widget.TextView[@text=\"This Week Working Hours\"]")
	private WebElement verifyWeekWorkTitle;

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"com.mantra.minop:id/barchart\"]")
	private WebElement verifyNoChartdata;

	@FindBy(xpath = "//android.widget.RelativeLayout")
	private WebElement verifyAbsentData;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/btnGoDashboard\"]")
	private WebElement verifyGoBtn;

	public boolean verifyDashboardTitle() {
		try {
			utils.waitForEle(VerifyDashboardTitle, "visible", "", 5);
			VerifyDashboardTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifCurrentMonth() {
		try {
			utils.waitForEle(VerifyCurrentMonth, "visible", "", 10);
			if (VerifyCurrentMonth.getText() == VerifyCurrentMonth.getText()) {
				VerifyCurrentMonth.isDisplayed();
			} else {
				System.out.println(VerifyCurrentMonth.getText() + "Not Display");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}

	public boolean verifSelectMonth() {
		try {
			utils.waitForEle(VerifyCurrentMonth, "visible", "", 5);

			VerifyCurrentMonth.isDisplayed();
			VerifyCurrentMonth.click();

			utils.waitForEle(VerifyDRPMonth, "visible", "", 5);
			VerifyDRPMonth.click();
			
			utils.waitForEle(verifyOKBtn, "visible", "", 5);
			verifyOKBtn.click();
			
			utils.waitForEle(verifyGoBtn, "visible", "", 5);
			verifyGoBtn.click();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	public boolean verifyPresent() {
		try {
			utils.waitForEle(verifyPresentCount, "visible", "", 5);
			if (verifyPresentCount.getText() == verifyPresentCount.getText()) {
				verifyPresentCount.isDisplayed();
			} else {
				System.out.println(verifyPresentCount.getText() + "Not Display");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean verifyAbsent() {
		try {
			utils.waitForEle(verifyAbsentCount, "visible", "", 5);
			if (verifyAbsentCount.getText() == verifyAbsentCount.getText()) {
				verifyAbsentCount.isDisplayed();
			} else {
				System.out.println(verifyAbsentCount.getText() + "Not Display");
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean VerifyWeekWork() {
		try {
			utils.waitForEle(verifyWeekWorkTitle, "visible", "", 5);
			verifyWeekWorkTitle.isDisplayed();
			
			utils.waitForEle(verifyNoChartdata, "visible", "", 5);
			verifyNoChartdata.isDisplayed();
			
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}

		return true;

	}
	
	
	public boolean VerifyClickOnStatus() {
		try {
			utils.waitForEle(verifyChart, "visible", "", 5);
			verifyChart.isDisplayed();
			verifyChart.click();
			
			utils.waitForEle(verifyAbsentData, "visible", "", 5);
			verifyAbsentData.isDisplayed();
			
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
