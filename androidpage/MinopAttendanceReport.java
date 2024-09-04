package androidpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;

public class MinopAttendanceReport {
	
	private WebDriver driver;
	private String exceptionDesc;
	Utils utils= new Utils(driver);
	
	public MinopAttendanceReport(WebDriver driver) {
		this.driver = driver;
		utils= new Utils(this.driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.mantra.minop:id/txtLable\"]")
	private WebElement verifyAttendanceReportTitle;
	
	
	public boolean verifyAttendanceReportPageTitle() {
		try {
			utils.waitForEle(verifyAttendanceReportTitle, "visible", "", 5);
			verifyAttendanceReportTitle.isDisplayed();
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
