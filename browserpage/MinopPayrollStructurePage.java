package browserpage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.initBase;
import utils.Utils;

public class MinopPayrollStructurePage {

	WebDriver driver;
	private static String exceptionDesc;
	Utils utils = new Utils(driver);
	private String StructurenameTXt;
	private String StructureTypeTxt;
	private String fullTitle1;
//	private String payStructurename;

	public MinopPayrollStructurePage(WebDriver driver) {
		this.driver = driver;
		utils = new Utils(this.driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@class='title'][normalize-space()='Pay Structure']")
	private WebElement verifyPayStructure;

	@FindBy(xpath = "//a[@id='AddEmployee']")
	private WebElement clickonNewPayroll;
	
	
	@FindBy(xpath = "//a[@id='cancel_btn']")
	private WebElement CancelPageBtn;
	
	
	@FindBy(xpath = "//th[normalize-space()='Structure Name']")
	private WebElement VerifyPaystructureName;
	
	
	@FindBy(xpath = "//h2[contains(text(),'Delete Payroll Structure')]")
	private WebElement VerifyDeletePayrollPopup;
	
	
	@FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
	private WebElement ClickonYesBtn;
	
	
	
	@FindBy(xpath = "//span[@title='This structure is incomplate please complate strcture for assign employee']")
	private WebElement VerifyIncompleteTitle;
	
	
	@FindBy(xpath = "//button[@id='btn_view_edit']")
	private WebElement clickupdatehead;

	@FindBy(id = "Structure_Name")
	private WebElement txtStructurenameTitle;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	private WebElement verifyValidationmessage;

	@FindBy(xpath = "//a[@id='nextstep_btn']")
	private WebElement ClickonSaveBtn;
	
	@FindBy(xpath = "(//i[@class='fa fa-close'])[9]")
	private WebElement ClickonCansel;		
			
	@FindBy(id = "Structure_Name")
	private WebElement EnterStructurename;
	
	@FindBy(xpath = "//input[@id='d_search']")
	private WebElement ClickonDeduction;
	
	
	@FindBy(xpath = "//input[@id='add_amount']")
	private WebElement Enteramount;
	
	
	@FindBy(xpath = "//a[@id='view_btn']")
	private WebElement ClickonviewBtn;

	@FindBy(id = "Structure_Type")
	private WebElement EnterStructureType;

	@FindBy(xpath = "//p[contains(text(),'Earning - Deduction- Reimbursement')]")
	private WebElement VerifyEarningDeductionPage;

	@FindBy(id = "e_search")
	private WebElement SearchEarningTextbox;
	
	@FindBy(xpath = "//input[@id='Filter_str']")
	private WebElement SearchEmployeeAssign;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	private WebElement SearchStructurenameSearchbox;

	@FindBy(xpath = "//*[@class=\"checkbox_box\"]")
	private WebElement CheckTheCheckBoxHeadTitle;
	
	
	@FindBy(id = "reimbursement_create_head")
	private WebElement CreateHeadForEarning;

	@FindBy(id = "Create_Head_title")
	private WebElement txtHeadTitle;
	
	@FindBy(xpath = "//a[@title='Add new fields']//i[@class='fa fa-plus']")
	private WebElement clickonplusicon;
	
	@FindBy(xpath = "//select[@id='edit_head_drop1']")
	private WebElement VerifynewCalculationwindow;
	
	
	@FindBy(xpath = "//select[@id='edit_head_drop2']")
	private WebElement Verify2ndCalculationwindow;
	
	@FindBy(xpath = "(//a[@title='Next'])[1]")
	private WebElement clickonPagination;

	@FindBy(xpath = "//div[@id='create_Data']//button[@id='btnsave']")
	private WebElement ClickOnSaveBtn;

	@FindBy(xpath = "//select[@id='Create_HeadType']")
	private WebElement drpHeadType;

	@FindBy(xpath = "//select[@id='edit_head_drop0']")
	private WebElement drpCalculationType;
	
	
	@FindBy(xpath = "//select[@id='edit_head_drop1']")
	private WebElement newCalculationType;
	
	

	@FindBy(xpath = "//input[@id='inpid0']")
	private WebElement txtPercentage;
	
	
	@FindBy(xpath = "//input[@id='inpid1']")
	private WebElement newtxtPercentage;
	
	@FindBy(xpath = "//input[@id='inpid2']")
	private WebElement SecondtxtPercentage;

	@FindBy(id = "btn_head_submit")
	private WebElement ClickoncreateHead;

	@FindBy(xpath = "//div[@class='toast toast-error']")
	private WebElement verifyValidationMsg;

	@FindBy(id = "selected_head_title")
	private WebElement VerifyCreateHeadTitle;

	@FindBy(xpath = "//tbody/tr[13]/td[1]/label[1]/span[1]")
	private WebElement ChecktheCheckbox;

	@FindBy(id = "nextstep_btn1")
	private WebElement NextBtn1;
	
	
	@FindBy(xpath = "(//a[normalize-space()='More Option'])[3]")
	private WebElement ClickonMoreOption;
	
	

	@FindBy(xpath = "//p[normalize-space()='Preview & Edit']")
	private WebElement VerifyEditandPreviewPage;

	@FindBy(id = "nextstep_btn2")
	private WebElement NextBtn2;

	
	@FindBy(xpath = "//p[normalize-space()='View & Save']")
	private WebElement VerifyViewandsavePage;

	@FindBy(id = "save_btn")
	private WebElement Save_Btn;
	
	@FindBy(xpath = "//div[text()='Employee is successfully assigned.']")
	private WebElement SuccessMsgofAssignPay;
	
	@FindBy(xpath = "//div[text()='Successfully updated pay stracture.You can assign Employees']")
	private WebElement VerifySuccessPayrollmessage;
	
	@FindBy(xpath = "//div[text()='Structure Name Already Exists']")
	private WebElement ValidationmsgForSameStructurename;

	@FindBy(id = "assign_emp")
	private WebElement ClickonAssignBtn;
	

	@FindBy(xpath = "(//table[@id=\"Deductiontable\"]/tbody/tr//td[@class='checkbox_box'])[1]")
	private WebElement ClickonPFCheckbox;
	
	@FindBy(xpath = "(//table[@id=\"Deductiontable\"]/tbody/tr//td[@class='checkbox_box'])[3]")
	private WebElement ClickonProfessTaxCheckbox;
	

	@FindBy(xpath = "//tr[@class='odd']//td[@class='ptTaxId']//span")
	private WebElement ClickonNewDeduction;
	

	
	@FindBy(xpath = "//button[@id='taxMasterSave']")
	private WebElement ClickonSavenewDeduction;
	
	

	@FindBy(xpath = "(//button[@title='None selected'])[1]")
	private WebElement CompanyDrp;
	
	@FindBy(xpath = "(//button[@title='None selected'])[1]")
	private WebElement BranchDrp;
	
	@FindBy(xpath = "(//button[@title='None selected'])[1]")
	private WebElement DepartmentDrp;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchCompany;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchBranch;
	
			
			@FindBy(xpath = "(//button[@id='btn_pf_submit'])[1]")
			private WebElement ClickonSaveDduction;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@placeholder='Search']")
	private WebElement SearchDepartment;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectCompanyCheckbox;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectBranchCheckbox;
	
	@FindBy(xpath = "//div[@class='btn-group open']//input[@value='multiselect-all']")
	private WebElement SelectDepartmentCheckbox;
	
	
	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement datatblEmpty;
	
	
			@FindBy(xpath = "/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/label[1]/span[1]")
			private WebElement CheckPFTemplate;	
			
	@FindBy(xpath = "//button[@id='assign_emp_payroll_btn']")
	private WebElement ClickonAssignSaveBtn;
	
	
	
	@FindBy(xpath = "//div[@id='assign_emp_modal']//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 text-right']")
	private WebElement ClickonAnotherElement;
	

	
	
			@FindBy(xpath = "(//input[@id='check_all'])[1]")
		private WebElement ClickonfirstEmpall;
	
	@FindBy(xpath = "//body//div[@class='page-wrapper']//div[@class='col-xs-12']//div[@class='col-xs-12']//label[1]")
	private WebElement VerifyCalculationTypes;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement ClickonAssignPermission;
	
	
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[3]/div[2]/div[1]/div[2]/div[2]/div[11]/div[1]/div[1]/div[2]/fieldset[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/button[1]")
	private WebElement VerifyCompanySelected;
	
	
	
	@FindBy(xpath = "//div[@id='action_dot']")
	private WebElement ClickonEditDot;
	
	
	@FindBy(xpath = "//li[@class='blue_font grade_clm'][normalize-space()='Edit']")
	private WebElement ClickonEditbtn;
	
	@FindBy(xpath = "//div[@class='toast toast-error']")
	private WebElement VerifyDuplicateHeadmsg;
	
	@FindBy(xpath = "//div[@class='assign_emp_filter margin-bottom-10']//div[2]//div[1]//label[1]")
	private WebElement  VerifyAssignBranch;
	
//	@FindBy(xpath = "(//input[@id='check_all'])[2]")
	@FindBy(xpath = "//input[@id=\"selectall\"]")
	private WebElement ClickonSecondEmpall;
	
	@FindBy(xpath = "(//table[@id='Deductiontable']/tbody/tr//td[@class='checkbox_box'])[7]")
	private WebElement clickOnLoanChk;
	
	public boolean ClickonLoanCheckbox() {
		try {
			/*
			 * WebElement Element =
			 * driver.findElement(By.xpath("//label[@for='checkbox19']"));
			 * 
			 * // Scrolling down the page till the element is found JavascriptExecutor js =
			 * (JavascriptExecutor) driver;
			 * js.executeScript("arguments[0].scrollIntoView();", Element);
			 */
			utils.waitForEle(clickOnLoanChk, "visible", null);
			clickOnLoanChk.isDisplayed();
			clickOnLoanChk.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	
	public boolean SelectEmpAssignAll() {
		try {
			utils.waitForEle(ClickonSecondEmpall, "visible", null);
			ClickonSecondEmpall.isDisplayed();
			ClickonSecondEmpall.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyPayStructurepagename() {
		try {
			utils.waitForEle(verifyPayStructure, "visible", null);
			verifyPayStructure.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyStructurenameTitle() {
		try {
			utils.waitForEle(txtStructurenameTitle, "visible", null);
			txtStructurenameTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyPaystructureName() {
		try {
			utils.waitForEle(VerifyPaystructureName, "visible", null);
			VerifyPaystructureName.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean VerifySuccessPayrollmessage() {
		try {
			utils.waitForEle(VerifySuccessPayrollmessage, "visible", null);
			VerifySuccessPayrollmessage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean VerifySuccessMessageTxt() {
		try {
			utils.waitForEle(SuccessMsgofAssignPay, "visible", "", 3);
			SuccessMsgofAssignPay.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	public boolean VerifyCalculationTypes() {
		try {
			utils.waitForEle(VerifyCalculationTypes, "visible", "", 3);
			VerifyCalculationTypes.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean VerifyDuplicateHeadMessageTxt() {
		try {
			utils.waitForEle(VerifyDuplicateHeadmsg, "visible", "", 3);
			VerifyDuplicateHeadmsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean VerifyDeletePayrollPopup() {
		try {
			utils.waitForEle(VerifyDeletePayrollPopup, "visible", "", 3);
			VerifyDeletePayrollPopup.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean clickonNewPayrollBtn() {
		try {
			utils.waitForEle(clickonNewPayroll, "visible", null);
			clickonNewPayroll.isDisplayed();
			clickonNewPayroll.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean EnterAmount() {
		try {
			utils.waitForEle(Enteramount, "visible", null);
			Enteramount.isDisplayed();
			Enteramount.clear();
			Enteramount.click();
			Enteramount.sendKeys("15000");
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonSaveDeduction() {
		try {
			utils.waitForEle(ClickonSaveDduction, "visible", null);
			ClickonSaveDduction.isDisplayed();
			ClickonSaveDduction.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClearTxtSearch() {
		try {
			utils.waitForEle(ClickonDeduction, "visible", null);
			ClickonDeduction.isDisplayed();
			ClickonDeduction.click();
			ClickonDeduction.clear();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickonCancelPageBTN() {
		try {
			utils.waitForEle(CancelPageBtn, "visible", null);
			CancelPageBtn.isDisplayed();
			CancelPageBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonSavenewDeduction() {
		try {
			utils.waitForEle(ClickonSavenewDeduction, "visible", null);
			ClickonSavenewDeduction.isDisplayed();
			ClickonSavenewDeduction.click();
			utils.waitForEle(ClickonDeduction, "visible", "", 10);
			ClickonDeduction.clear();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonNewDeduction() {
		try {
			utils.waitForEle(ClickonNewDeduction, "visible", null);
			ClickonNewDeduction.isDisplayed();
			ClickonNewDeduction.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonPFCheckbox() {
		try {
			utils.waitForEle(ClickonPFCheckbox, "visible", null);
			ClickonPFCheckbox.isDisplayed();
			ClickonPFCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickonProfessTaxCheckbox() {
		try {
			utils.waitForEle(ClickonProfessTaxCheckbox, "visible", null);
			ClickonProfessTaxCheckbox.isDisplayed();
			ClickonProfessTaxCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean CheckPFTemplateCheckbox() {
		try {
			utils.waitForEle(CheckPFTemplate, "visible", null);
			CheckPFTemplate.isDisplayed();
			CheckPFTemplate.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonviewBtn() {
		try {
			utils.waitForEle(ClickonviewBtn, "visible", null);
			ClickonviewBtn.isDisplayed();
			ClickonviewBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean VerifyDeduction() {
		try {
			utils.waitForEle(ClickonDeduction, "visible", null);
			ClickonDeduction.isDisplayed();
			ClickonDeduction.click();
			ClickonDeduction.sendKeys("Provident Fund");
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean VerifynewDeduction() {
		try {
			utils.waitForEle(ClickonDeduction, "visible", null);
			ClickonDeduction.isDisplayed();
			ClickonDeduction.click();
			ClickonDeduction.clear();
			ClickonDeduction.sendKeys("Professional Tax");
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean VerifyLoan() {
		try {
			utils.waitForEle(ClickonDeduction, "visible", null);
			ClickonDeduction.isDisplayed();
			ClickonDeduction.click();
			ClickonDeduction.clear();
			ClickonDeduction.sendKeys("Loan");
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean CheckCheckBoxcompany() {
		try {
			utils.waitForEle(SelectCompanyCheckbox, "visible", null);
			SelectCompanyCheckbox.isDisplayed();
			SelectCompanyCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean CheckCheckBoxBranch() {
		try {
			utils.waitForEle(SelectBranchCheckbox, "visible", null);
			SelectBranchCheckbox.isDisplayed();
			SelectBranchCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickoncancelBtn() {
		try {
			utils.waitForEle(ClickonCansel, "visible", null);
			ClickonCansel.isDisplayed();
			ClickonCansel.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean clickonUpdateHeadBtn() {
		try {
			utils.waitForEle(clickupdatehead, "visible", null);
			clickupdatehead.isDisplayed();
			clickupdatehead.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	//ClickonMoreOption
	public boolean ClickonMoreoptionBtn() {
		try {
			utils.waitForEle(ClickonMoreOption, "visible", null);
			ClickonMoreOption.isDisplayed();
			ClickonMoreOption.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean CheckCheckBoxDepartment() {
		try {
			utils.waitForEle(SelectDepartmentCheckbox, "visible", null);
			SelectDepartmentCheckbox.isDisplayed();
			SelectDepartmentCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonEditDot() {
		try {
			utils.waitForEle(SelectDepartmentCheckbox, "visible", null);
			ClickonEditDot.isDisplayed();
			ClickonEditDot.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonEditButton() {
		try {
			utils.waitForEle(ClickonEditbtn, "visible", null);
			ClickonEditbtn.isDisplayed();
			ClickonEditbtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
		public boolean ClickONAnotherElement() {
			try {
				utils.waitForEle(ClickonAnotherElement, "visible", null);
				ClickonAnotherElement.isDisplayed();
				ClickonAnotherElement.click();
			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}		
			public boolean ClickonAssignSaveBtn() {
				try {
					utils.waitForEle(ClickonAssignSaveBtn, "visible", null);
					ClickonAssignSaveBtn.isDisplayed();
					ClickonAssignSaveBtn.click();
				} catch (Exception e) {
					exceptionDesc = e.getMessage().toString();
					return false;
				}
				return true;
			}		
				public boolean SelectfirstAssignAll() {
					try {
						utils.waitForEle(ClickonfirstEmpall, "visible", null);
						ClickonfirstEmpall.isDisplayed();
						ClickonfirstEmpall.click();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
	}
				public boolean ClickonAssignPermission() {
					try {
						utils.waitForEle(ClickonAssignPermission, "visible", null);
						ClickonAssignPermission.isDisplayed();
						ClickonAssignPermission.click();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
				}		

				public boolean Clickonplusbutton() {
					try {
						utils.waitForEle(clickonplusicon, "visible", null);
						clickonplusicon.isDisplayed();
						clickonplusicon.click();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
				}			
			
				public boolean VerifyCompanySelected() {
					try {
						utils.waitForEle(VerifyCompanySelected, "visible", null);
						VerifyCompanySelected.isDisplayed();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
				}
				public boolean VerifynewCalculationWindow() {
					try {
						utils.waitForEle(VerifynewCalculationwindow, "visible", null);
						VerifynewCalculationwindow.isDisplayed();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
				}
				public boolean Verify2ndCalculationWindow() {
					try {
						utils.waitForEle(Verify2ndCalculationwindow, "visible", null);
						Verify2ndCalculationwindow.isDisplayed();
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
						return false;
					}
					return true;
				}
	


	public boolean VerifyValidationmsg() {
		try {
			utils.waitForEle(verifyValidationmessage, "visible", null);
			verifyValidationmessage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	//datatblEmpty
	public boolean VerifyBlankTbl() {
		try {
			utils.waitForEle(datatblEmpty, "visible", null);
			datatblEmpty.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean VerifyIncompleteTitle() {
		try {
			utils.waitForEle(VerifyIncompleteTitle, "visible", null);
			VerifyIncompleteTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean VerifyValidationmsgforSameStructurename() {
		try {
			utils.waitForEle(ValidationmsgForSameStructurename, "visible", null);
			ValidationmsgForSameStructurename.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean ClickonSaveBtn() {
		try {
			utils.waitForEle(ClickonSaveBtn, "visible", null);
			ClickonSaveBtn.isDisplayed();
			ClickonSaveBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean Structurename(String Structurename) {
		try {
			utils.waitForEle(EnterStructurename, "visible", null);
			if (EnterStructurename.isDisplayed()) {
				String currentText = EnterStructurename.getAttribute("value");

				if (!currentText.isEmpty()) {
					EnterStructurename.clear();
				} else {
					EnterStructurename.isDisplayed();
					EnterStructurename.clear();

					EnterStructurename.sendKeys(Structurename + initBase.executionRunTime);
					// String payStructurename = Structurename+executionRunTime;
					// System.out.println(payStructurename);
					// String randomDateFormat = Utils.getRandomDateFormat();
				//	StructurenameTXt = Structurename + executionRunTime;

					// EnterStructurename.sendKeys(StructurenameTXt);
				//	System.out.println(StructurenameTXt);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean updateStructurename(String Structurename) {
		try {
			utils.waitForEle(EnterStructurename, "visible", null);
//			if (EnterStructurename.isDisplayed()) {
//				String currentText = EnterStructurename.getAttribute("value");
//
//				if (!currentText.isEmpty()) {
//					EnterStructurename.clear();
//				} else {
					EnterStructurename.isDisplayed();
					EnterStructurename.clear();

					EnterStructurename.sendKeys(Structurename + initBase.executionRunTime);
					// String payStructurename = Structurename+executionRunTime;
					// System.out.println(payStructurename);
					// String randomDateFormat = Utils.getRandomDateFormat();
					//StructurenameTXt = Structurename + executionRunTime;

					// EnterStructurename.sendKeys(StructurenameTXt);
					//System.out.println(StructurenameTXt);
				
			

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean blankStructurename() {
		try {
			utils.waitForEle(EnterStructurename, "visible", null);
			if (EnterStructurename.isDisplayed()) {
				String currentText = EnterStructurename.getAttribute("value");

				if (!currentText.isEmpty()) {
					EnterStructurename.clear();
				} else {
					EnterStructurename.isDisplayed();
					EnterStructurename.clear();

				//	EnterStructurename.sendKeys(Structurename + executionRunTime);
					// String payStructurename = Structurename+executionRunTime;
					// System.out.println(payStructurename);
					// String randomDateFormat = Utils.getRandomDateFormat();
			//		StructurenameTXt = Structurename + executionRunTime;

					// EnterStructurename.sendKeys(StructurenameTXt);
			//05		System.out.println(StructurenameTXt);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean blankStructuretype() {
		try {
			utils.waitForEle(EnterStructureType, "visible", null);
			if (EnterStructureType.isDisplayed()) {
				String currentText = EnterStructureType.getAttribute("value");

				if (!currentText.isEmpty()) {
					EnterStructureType.clear();
				} else {
					EnterStructureType.isDisplayed();
					EnterStructureType.clear();

				//	EnterStructurename.sendKeys(Structurename + executionRunTime);
					// String payStructurename = Structurename+executionRunTime;
					// System.out.println(payStructurename);
					// String randomDateFormat = Utils.getRandomDateFormat();
			//		StructurenameTXt = Structurename + executionRunTime;

					// EnterStructurename.sendKeys(StructurenameTXt);
			//05		System.out.println(StructurenameTXt);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean StructureType(String Structuretype) {
		try {
			utils.waitForEle(EnterStructureType, "visible", null);
			if (EnterStructureType.isDisplayed()) {
				String currentText = EnterStructureType.getAttribute("Value");

				if (!currentText.isEmpty()) {
					EnterStructureType.clear();
				} else {
					EnterStructureType.isDisplayed();
					EnterStructureType.clear();
					// String randomDateFormat = Utils.getRandomDateFormat();

					EnterStructureType.sendKeys(Structuretype + initBase.executionRunTime);
				//	StructureTypeTxt = Structuretype + executionRunTime;
				//	System.out.println(StructureTypeTxt);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean updateStructureType(String Structuretype) {
		try {
//			utils.waitForEle(EnterStructureType, "visible", null);
//			if (EnterStructureType.isDisplayed()) {
//				String currentText = EnterStructureType.getAttribute("Value");
//
//				if (!currentText.isEmpty()) {
//					EnterStructureType.clear();
//				} else {
					EnterStructureType.isDisplayed();
					EnterStructureType.clear();
					// String randomDateFormat = Utils.getRandomDateFormat();

					EnterStructureType.sendKeys(Structuretype + initBase.executionRunTime);
			//		StructureTypeTxt = Structuretype + executionRunTime;
			//		System.out.println(StructureTypeTxt);
				
			

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyEarningPage() {
		try {
			utils.waitForEle(VerifyEarningDeductionPage, "visible", null);
			VerifyEarningDeductionPage.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterSearchtxt(String SearchHeadTitle) {
		try {
			// if (fullTitle1 == null) {
			// throw new Exception("fullTitle1 is null");
			// }
			utils.waitForEle(SearchEarningTextbox, "visible", "", 3);
			SearchEarningTextbox.isDisplayed();
			SearchEarningTextbox.click();
			SearchEarningTextbox.clear();
			System.out.println("Enter the text:");

			fullTitle1 = SearchHeadTitle + initBase.executionRunTime;
			SearchEarningTextbox.sendKeys(fullTitle1);
			System.out.println("After enter thre text: " + fullTitle1);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	
	
	
	public boolean EnterStructurenameSearchTxt(String SearchStructureName) {
		try {
			// if (StructurenameTXt == null) {
			// throw new Exception("StructurenameTXt is null");
			// }
			utils.waitForEle(SearchStructurenameSearchbox, "visible", "", 3);
			SearchStructurenameSearchbox.isDisplayed();
			SearchStructurenameSearchbox.click();
			SearchStructurenameSearchbox.clear();
			System.out.println("Enter the text:");
		   StructurenameTXt = SearchStructureName + initBase.executionRunTime;
			SearchStructurenameSearchbox.sendKeys(StructurenameTXt);
			/// SearchStructurenameSearchbox.sendKeys(payStructurename);
	//05		System.out.println("After enter thre text: " + StructurenameTXt);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean SearchEmployeeAssign(String SearchStructureName) {
		try {
			// if (StructurenameTXt == null) {
			// throw new Exception("StructurenameTXt is null");
			// }
			utils.waitForEle(SearchEmployeeAssign, "visible", "", 3);
			SearchEmployeeAssign.isDisplayed();
			SearchEmployeeAssign.click();
			SearchEmployeeAssign.clear();
			System.out.println("Enter the text:");
		   StructurenameTXt = SearchStructureName + initBase.executionRunTime;
		   SearchEmployeeAssign.sendKeys(StructurenameTXt);
			/// SearchStructurenameSearchbox.sendKeys(payStructurename);
	//05		System.out.println("After enter thre text: " + StructurenameTXt);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean ClickonCreateHead() {
		try {
			utils.waitForEle(CreateHeadForEarning, "visible", null);
			CreateHeadForEarning.isDisplayed();
			CreateHeadForEarning.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean enterPercentagetxt(String Percentage) {
		try {
			utils.waitForEle(txtPercentage, "visible", null);
			txtPercentage.isDisplayed();
			txtPercentage.clear();

			txtPercentage.sendKeys(Percentage);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean enternewPercentagetxt(String Percentage) {
		try {
			utils.waitForEle(newtxtPercentage, "visible", null);
			newtxtPercentage.isDisplayed();
			newtxtPercentage.clear();

			newtxtPercentage.sendKeys(Percentage);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean enterSecondPercentagetxt(String Percentage) {
		try {
			utils.waitForEle(SecondtxtPercentage, "visible", null);
			SecondtxtPercentage.isDisplayed();
			SecondtxtPercentage.clear();

			SecondtxtPercentage.sendKeys(Percentage);

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean SelectCalculationType(String CalculationTypes) {
		try {
			utils.waitForEle(drpCalculationType, "visible", "", 5);
			Select drpCalculation = new Select(drpCalculationType);
			drpCalculation.selectByVisibleText(CalculationTypes);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean SelectnewCalculationType(String CalculationTypes) {
		try {
			utils.waitForEle(newCalculationType, "visible", "", 5);
			Select newCalculation = new Select(newCalculationType);
			newCalculation.selectByVisibleText(CalculationTypes);
			System.out.println(CalculationTypes);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean Select2ndCalculationType(String CalculationTypes1) {
		try {
			utils.waitForEle(Verify2ndCalculationwindow, "visible", "", 5);
			Select SecondCalculation = new Select(Verify2ndCalculationwindow);
			SecondCalculation.selectByVisibleText(CalculationTypes1);
			System.out.println(CalculationTypes1);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean SelectHeadType(String HeadType) {
		try {
			utils.waitForEle(drpHeadType, "visible", "", 5);
			Select drpHead = new Select(drpHeadType);
			drpHead.selectByVisibleText(HeadType);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	public boolean VerifyClickPagination() {
		try {
//			WebElement nextButton = driver.findElement(By.xpath("a[title='Next']"));

			// Scrolling down the page till the element is found
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", nextButton);
			js.executeScript("javascript:window.scrollBy(250,350)");
			utils.waitForEle(clickonPagination, "visible", "", 5);
			List<WebElement> tableDataBefore = driver
					.findElements(By.xpath("//table[@id='strcturetable']//tbody//tr"));
			List<String> dataBefore = new ArrayList<>();
			for (WebElement row : tableDataBefore) {
				dataBefore.add(row.getText());
			}
			clickonPagination.isDisplayed();
			clickonPagination.click();
			utils.waitForEle(driver.findElement(By.xpath("//table[@id='strcturetable']//tbody//tr[1]")), "visible",
					"", 5);

			// Get the current table data after clicking "Next"
			List<WebElement> tableDataAfter = driver
					.findElements(By.xpath("//table[@id='strcturetable']//tbody//tr"));
			List<String> dataAfter = new ArrayList<>();
			for (WebElement row : tableDataAfter) {
				dataAfter.add(row.getText());
			}

			// Compare the data before and after pagination
			if (!dataBefore.equals(dataAfter)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			exceptionDesc = e.getMessage();
			return false;
		}
	}
	public boolean ClickonDrpCompanyname() {
		try {
//			utils.waitForEle(CompanyDrp, "visible", "", 5);
//			Select drpcompany = new Select(CompanyDrp);
//			drpcompany.selectByVisibleText(Companyname);
			utils.waitForEle(CompanyDrp, "visible", null);
			CompanyDrp.isDisplayed();
			CompanyDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickonDrpBranchname() {
		try {
//			utils.waitForEle(BranchDrp, "visible", "", 5);
//			Select drpBranch = new Select(BranchDrp);
//			drpBranch.selectByVisibleText(Branchname);
			utils.waitForEle(BranchDrp, "visible", null);
			BranchDrp.isDisplayed();
			BranchDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	
	public boolean ClickonDrpDepartmentname() {
		try {
//			utils.waitForEle(DepartmentDrp, "visible", "", 5);
//			Select drpDepartment = new Select(DepartmentDrp);
//			drpDepartment.selectByVisibleText(Departmentname);
			utils.waitForEle(DepartmentDrp, "visible", null);
			DepartmentDrp.isDisplayed();
			DepartmentDrp.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}
	public boolean enterHeadTitle(String HeadTitle) {
		try {
			utils.waitForEle(txtHeadTitle, "visible", null);
			if (txtHeadTitle.isDisplayed()) {
				String currentText = txtHeadTitle.getAttribute("value");

				if (!currentText.isEmpty()) {
					txtHeadTitle.clear();
				} else {
					txtHeadTitle.isDisplayed();
					txtHeadTitle.clear();
					// String randomDateFormat = Utils.getRandomDateFormat();
					// fullTitle1 = HeadTitle + randomDateFormat;

					txtHeadTitle.sendKeys(HeadTitle + initBase.executionRunTime);
					// System.out.println(fullTitle1);
				}
			}

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickonCreateheadbtn() {
		try {
			utils.waitForEle(ClickoncreateHead, "visible", null);
			ClickoncreateHead.isDisplayed();
			ClickoncreateHead.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}
	
	public boolean ClickonYesBtn() {
		try {
			utils.waitForEle(ClickonYesBtn, "visible", null);
			ClickonYesBtn.isDisplayed();
			ClickonYesBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean CreateHeadValidationmessage() {
		try {
			utils.waitForEle(verifyValidationMsg, "visible", "", 3);
			verifyValidationMsg.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyCreateHeadTitle() {
		try {
			utils.waitForEle(VerifyCreateHeadTitle, "visible", "", 3);
			VerifyCreateHeadTitle.isDisplayed();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean CheckTheCheckbox() {
		try {
			utils.waitForEle(ChecktheCheckbox, "visible", null);
			ChecktheCheckbox.isDisplayed();
			ChecktheCheckbox.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickonNextBtn1() {
		try {
			utils.waitForEle(NextBtn1, "visible", null);
			NextBtn1.isDisplayed();
			NextBtn1.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean VerifyPreviewandEditButton() {
		try {
			utils.waitForEle(VerifyEditandPreviewPage, "visible", null);
			VerifyEditandPreviewPage.isDisplayed();
			// NextBtn1.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean VerifyviewandSavePage() {
		try {
			utils.waitForEle(VerifyViewandsavePage, "visible", null);
			VerifyViewandsavePage.isDisplayed();
			// NextBtn1.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean ClickonNextBtn2() {
		try {
			utils.waitForEle(NextBtn2, "visible", null);
			NextBtn2.isDisplayed();
			NextBtn2.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;

	}

	public boolean FinalSaveBtn() {
		try {
			utils.waitForEle(Save_Btn, "visible", null);
			Save_Btn.isDisplayed();
			Save_Btn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean AssignBtn() {
		try {
			 utils.waitForEle(ClickonAssignBtn, "visible", null);
			 ClickonAssignBtn.isDisplayed();
			// ClickonAssignBtn.isEnabled();
			
			 ClickonAssignBtn.click();
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
		return true;
	}

	public boolean verifyStructurenameTitleSearch() {
		try {
			String xpath = "//td[normalize-space()='" + StructurenameTXt + "']";
			//String xpath = "//td[normalize-space()='" + fullTitle + "']";
			//div[contains(text(),'ADER')]
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}
	public boolean VerifyHeadTitleonEarningPage() {
		try {
			String xpath = "//label[normalize-space()='" + fullTitle1 + "']";
			//String xpath = "//td[normalize-space()='" + fullTitle + "']";
			//div[contains(text(),'ADER')]
			WebElement titleElement = driver.findElement(By.xpath(xpath));
			return titleElement.isDisplayed();

		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			return false;
		}
	}
		public boolean VerifyAssignBranch() {
			try {
				 utils.waitForEle(VerifyAssignBranch, "visible", null);
				 VerifyAssignBranch.isDisplayed();
				// ClickonAssignBtn.isEnabled();
				
				// ClickonAssignBtn.click();
			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		public boolean Searchcompanyname(String Companyname) {
			try {
				// if (fullTitle1 == null) {
				// throw new Exception("fullTitle1 is null");
				// }
				utils.waitForEle(SearchCompany, "visible", "", 3);
				SearchCompany.isDisplayed();
				SearchCompany.click();
				SearchCompany.clear();
				System.out.println("Enter the text:");

			//	fullTitle1 = SearchHeadTitle + executionRunTime;
				SearchCompany.sendKeys(Companyname);
				System.out.println("After enter thre text: " + Companyname);

			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		public boolean SearchBranchname(String Branchname) {
			try {
				// if (fullTitle1 == null) {
				// throw new Exception("fullTitle1 is null");
				// }
				utils.waitForEle(SearchBranch, "visible", "", 3);
				SearchBranch.isDisplayed();
				SearchBranch.click();
				SearchBranch.clear();
				System.out.println("Enter the text:");

			//	fullTitle1 = SearchHeadTitle + executionRunTime;
				SearchBranch.sendKeys(Branchname);
				System.out.println("After enter thre text: " + Branchname);

			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		public boolean SearchDepartmentname(String Departmentname) {
			try {
				// if (fullTitle1 == null) {
				// throw new Exception("fullTitle1 is null");
				// }
				utils.waitForEle(SearchDepartment, "visible", "", 3);
				SearchDepartment.isDisplayed();
				SearchDepartment.click();
				SearchDepartment.clear();
				System.out.println("Enter the text:");

			//	fullTitle1 = SearchHeadTitle + executionRunTime;
				SearchDepartment.sendKeys(Departmentname);
				System.out.println("After enter thre text: " + Departmentname);

			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		
	
		 
		public boolean ClickoncompanyCheckbox() {
			try {
				utils.waitForEle(clickonNewPayroll, "visible", null);
				clickonNewPayroll.isDisplayed();
				clickonNewPayroll.click();
			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		
		public boolean ClickonHeadtitleCheckbox() {
			try {
				utils.waitForEle(CheckTheCheckBoxHeadTitle, "visible", null);
				CheckTheCheckBoxHeadTitle.isDisplayed();
				CheckTheCheckBoxHeadTitle.click();
			} catch (Exception e) {
				exceptionDesc = e.getMessage().toString();
				return false;
			}
			return true;
		}
		
		
	    public boolean SelectSalaryHeads() {
	        // Locate the checkboxes within the table
	    	try {
	        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class=\"checkbox_box\"]"));
	        int size = checkboxes.size();
	        System.out.println("The size of list in checkbox"+ size);
	        
	       
        Thread.sleep(3000);
	        // Select the first five checkboxes
	        for (int i = 1; i < 6; i++) {
	            if (i < checkboxes.size()) {
	            	System.out.println(checkboxes);
	                checkboxes.get(i).click();}
	            else {
	            	System.out.println("Check All CheckBox");
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

	public void setStructurenameTXt(String StructurenameTXt) {
		this.StructurenameTXt = StructurenameTXt;
	}

	public String getStructurenameTXt() {
		return StructurenameTXt;
	}

	public void setStructureTypeTxt(String StructureTypeTxt) {
		this.StructureTypeTxt = StructureTypeTxt;
	}

	public String getStructureTypeTxt() {
		return StructureTypeTxt;
	}

	public void setfullTitle1(String fullTitle1) {
		this.fullTitle1 = fullTitle1;
	}

	public String getfullTitle1() {
		return fullTitle1;
	}

}
