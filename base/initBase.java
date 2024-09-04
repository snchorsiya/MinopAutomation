package base;

import java.io.File;
import java.io.FileInputStream;

//ctrl shift numpad divide to collapse all /
//-ctrl + 9 = exand all.

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

//Excel
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class initBase {
	// ExcelSettings variables
	public static String browser;
	static String sleep;
	public static String screenShot;
	public static String screenShotFolder = System.getProperty("user.dir") + "//screenshots//";;
//	public static String screenShotFolder = "reports//screenshots//";;
	public static int SkipCount;
	public static String mySQLString;
	public static String strDeleteHTML;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	// Excel as DB Variables
	public static Recordset recordset = null;
	public static Fillo fillo = new Fillo();
	public static Connection connection;
	public static String currDir = System.getProperty("user.dir") + "\\"; // Current directory where the FW is
																			// launched
	public static String userHome = System.getProperty("user.home") + "\\.m2\\repository\\"; // This will hold the
																								// repository path
	public static String pageLoadTimeout = "30";
	public static String implicitlyWait = "15";	
	public static int explicitWait = 20;
	public static String runDir = System.getProperty("user.dir");
	public static String urlID, URL, wkDay, results, modeDebug = "";
	boolean headLess = false;
	// ExcelSettings variables
	public static String testenv;
	public static String reportName;
	public static String[][] arrDevices = new String[2][10]; // Store mobile device related info.
	//
	public static LinkedHashMap<String, String> mapAllValues = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> mapAllValuesLowerCase = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> hashUnique = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> hashDict = new LinkedHashMap<String, String>();
	public static List<WebElement> allLinks = new ArrayList<WebElement>();
	public static LinkedHashMap<String, String> mapALLURL = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> mapParentURL = new LinkedHashMap<String, String>();
	public static LinkedHashMap<String, String> mapChildURL = new LinkedHashMap<String, String>();
	// log File Name
	public static String logFileName = "log.txt", logFileName1 = "log1.txt";
	public static File logFile = new File(currDir + "\\data\\", logFileName),
			logFile1 = new File(currDir + "\\data\\", logFileName1);
	public static int deviceNo = 0;
	// Hashmap
	public static HashMap<String, Integer> hashMapTestCaseData = new HashMap<String, Integer>();
	public static String allSheetNames = "";
	public static String executionRunTime = new SimpleDateFormat("ddMMyyHHmmss").format(new Date()); // Unique
	// Total Pass/Fail/TC Count
	public static Integer totalPass = 0;
	public static Integer totalFail = 0;

	/**
	 * @param infoMessage
	 * @param titleBar
	 */
	public static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Loads all the settings required for the driver
	 */
	public static void readSettingsExcel(String projName) {
		try {
			if (Objects.isNull(fis) != true) {
				return;
			}
			if (verifyInputfile(currDir + "reports", "") == false) {
				System.out.println("Report Directory not found, Can't continue...");
				infoBox("Report Directory not found, Can't continue...", "Error.");
				System.exit(0);
			}
			if (verifyInputfile(currDir + "data\\Project.xlsx") == false) {
				System.out.println("Configuration file not found, Can't continue...");
				infoBox("Configuration file not found, Can't continue...", "Error.");
				System.exit(0);
			}
			if (verifyInputfile(currDir + "data\\" + projName + "TestData.xlsx") == false) {
				System.out.println("Project test data file not found, Can't continue...");
				infoBox("Project file not found, Can't continue...", "Error.");
				System.exit(0);
			}
			if (verifyInputfile(userHome + "\\Chromedriver.exe") == false) {
				System.out.println("ChromeDriver.exe not found in the user home directory, kindly add first->: " + userHome);
				System.exit(0);
			}
			
			fis = new FileInputStream(currDir + "data\\" + projName + "TestData.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(workbook.getSheetIndex("settings"));
			int i = 1, j = 1;
			browser = sheet.getRow(i++).getCell(j).getStringCellValue();
			URL = sheet.getRow(i++).getCell(j).getStringCellValue();
			sleep = sheet.getRow(i++).getCell(j).getStringCellValue();
			testenv = sheet.getRow(i++).getCell(j).getStringCellValue();
			pageLoadTimeout = sheet.getRow(i++).getCell(j).getStringCellValue();
			implicitlyWait = sheet.getRow(i++).getCell(j).getStringCellValue();
			// drivers = userHome; // sheet.getRow(i++).getCell(j).getStringCellValue();
			reportName = sheet.getRow(i++).getCell(j).getStringCellValue();
			screenShot = sheet.getRow(i++).getCell(j).getStringCellValue();
			SkipCount = Integer.parseInt(sheet.getRow(i++).getCell(j).getStringCellValue());
			explicitWait = Integer.parseInt(sheet.getRow(i++).getCell(j).getStringCellValue());
			mySQLString = sheet.getRow(i++).getCell(j).getStringCellValue();
			strDeleteHTML= sheet.getRow(i++).getCell(j).getStringCellValue();
			// platformType = sheet.getRow(i++).getCell(j).getStringCellValue();
			sheet = workbook.getSheetAt(workbook.getSheetIndex("device"));
			try {
				List<String> command = new ArrayList<>();
		        String adbPath = System.getProperty("user.home") + "\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
				command.add(adbPath);
				command.add("devices");
				String results = ""; //Utils.runCommandPrompt(command, "emulator-");
				
				String[] arrEmu = { "emulator-5554", "emulator-5556" };
				for (int nrow = 0; nrow < 2; nrow++) {
					row = sheet.getRow(nrow + 1);
					String temp = sheet.getRow(nrow + 1).getCell(0).getStringCellValue();
					if (temp.isEmpty())
						break;
					for (int jcol = 0; jcol < 10; jcol++) {
						cell = row.getCell(jcol);
						arrDevices[nrow][jcol] = getCellValueAsString(cell);
					}
					if (results.contains("emulator-")) {
						arrDevices[nrow][1] = arrEmu[nrow];
					}
				}
			} catch (Exception e) {
				System.out.println("Error while loading devices info ");
			}
			if (arrDevices.length < 1) {
				throw new Exception("Devices information missing");
			}
		} catch (Exception e) {
			System.out.println("Fatal Error while reading Excel Settings: " + e.getMessage());
			System.exit(1);
		}
	}

	private static String getCellValueAsString(XSSFCell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				int intValue = (int) Math.floor(cell.getNumericCellValue());
				return String.valueOf(intValue);
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "Unknown Cell Type";
		}
	}

	/**
	 * Java hashmap for storing all the test cases value as key and values pair
	 */
	public static ArrayList<String> loadExcelData(String sheetName, String tcName, String fieldNames) {
		ArrayList<String> cellValues = new ArrayList<String>();
		try {
			sheet = workbook.getSheetAt(workbook.getSheetIndex(sheetName));
			int i = 1, j = 1, k;
			if (allSheetNames.contains(sheetName) == false) {
				// Retrieve all the test case names into HashMap.
				allSheetNames = allSheetNames + sheetName + ",";
				j = sheet.getLastRowNum();
				String excelTCName = "";
				for (i = 1; i <= j; i++) {
					try {
						excelTCName = sheet.getRow(i).getCell(0).getStringCellValue();
						if (excelTCName.length() < 2)
							continue;
						hashMapTestCaseData.put(excelTCName, i);
					} catch (Exception e) {
						System.out.println("Error while storing TCNames: " + e.getMessage());
					} // Add Scenario name in future if required.
				}
			}
			// Retrieve all the values based on the required columns
			i = hashMapTestCaseData.get(tcName);
			int noOfColumns = sheet.getRow(0).getLastCellNum();
			Boolean found = false;
			String columnName;
			String[] temp = fieldNames.split(",");
			for (k = 0; k < temp.length; k++) {
				found = false;
				String col = testenv + "_" + temp[k]; // Take the current Environment and club with the passed column
														// name from @Test Method
				for (j = 1; j <= noOfColumns; j++) {
					try {
						columnName = sheet.getRow(0).getCell(j).getStringCellValue();
						if (col.equals(columnName)) {
							String rowvalue = "";
							try {
								rowvalue = sheet.getRow(i).getCell(j).getStringCellValue();
							} catch (Exception e) {
							}
							cellValues.add(rowvalue);
							found = true;
							break;
						}
					} catch (Exception e) {
						System.out.println("Error while reading excel : " + e.getMessage());
					}
				}
				if (found != true) {
					cellValues.add("");
					System.out.println("No values found in Excel Data for column : " + col);
				}
			}
		} catch (Exception e) {
			System.out.println("Error while reading excel : " + e.getMessage());
		}
		return cellValues;
	}

	/**
	 * This function verifies file exist on the given path
	 * 
	 */
	public static boolean verifyInputfile(String filename) {
		try {
			File file = new File(filename);
			if (file.exists()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("File does not exist: " + filename);
		}
		return false;
	}

	/**
	 * This function verifies dir exist on the given path
	 * 
	 */
	public static boolean verifyInputfile(String filename, String directory) {
		try {
			File file = new File(filename);
			if (file.isDirectory() != true) {
				file.mkdir();
			}
			return true;
		} catch (Exception e) {
			System.out.println("Unable to create Directory/Path : " + e.getMessage());
		}
		return false;
	}

	/**
	 * This function will be called once the execution is completed.
	 * 
	 */
//	public static void cleanUP() {
//		sheet = null;
//		workbook = null;
//		try {
//			recordset.close();
//			connection.close();
//		} catch (Exception e) {
//			// Not capturing error here and above as not required as of now.
//		}
//		// extentReports.flush();
//	}
	/**
	 * 
	 */
//	public static void closeDriverExe() {
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
//		} catch (Exception e) {
//		}
//	}
//	/**
//	 * @param currTC
//	 */
//	public static void createExtentReport(String currTC) {
//		try {
//			if (deviceNo == 1 || deviceNo == 3)
//				extentTest = extentReports.createTest(currTC);
//			else
//				extentTest1 = extentReports1.createTest(currTC);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public static String maskPassword(String password) {
		return password.replaceAll(".", "*");
	}
//	protected void SetScenarioName(String strScNam) {
//		if (deviceNo == 1 || deviceNo == 3) {
//			scenarioName = strScNam;
//		} else {
//			scenarioName1 = strScNam;
//		}
//	}
//
//	protected void setTestMethodErrorCount() {
//		if (deviceNo == 1 || deviceNo == 3) {
//			testMethodErrorCount = 0;
//		} else {
//			testMethodErrorCount1 = 0;
//		}
//	}
//	/**
//	 * Launch browser based on configuration
//	 */
//	public static void launchBrowser() {
//		try {
//			if (browser.equals("firefox")) {
//				System.setProperty("webdriver.gecko.driver", userHome + "geckodriver.exe");
//				driver = new FirefoxDriver();
//			} else if (browser.equals("chrome")) {
//				System.setProperty("webdriver.chrome.driver", userHome + "chromedriver.exe");
//				driver = new ChromeDriver();
//			} else if (browser.equals("chromever")) {
//				System.setProperty("webdriver.chrome.driver", userHome + "chromedriver.exe");
//				// Provide the path to the Chrome executable
//				String chromeExecutablePath = "C:\\Users\\admin\\Downloads\\chrome-win32"; // Update this path
//
//				// Set up Chrome options
//				ChromeOptions options = new ChromeOptions();
//				options.setBinary(chromeExecutablePath);
//
//				// Create an instance of ChromeDriver with the specified options
//				driver = new ChromeDriver(options);
//
//			} else {
//				System.setProperty("webdriver.ie.driver", userHome + "IEDriverServer.exe");
//				driver = new InternetExplorerDriver();
//			}
//			driver.navigate().to(URL);
//			Thread.sleep(5000);
//			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(pageLoadTimeout), TimeUnit.SECONDS);
//			driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitlyWait), TimeUnit.SECONDS);
//			driver.manage().window().maximize();
//		} catch (Exception e) {
//			createLogs("Y", "FAIL", "error while launching URL" + e.getMessage());
//		}
//	}
//
//	public static void logMessage(String msg) {
//		if (msg.contains("stale element")) {
//			System.out.println("Stale Ele");
//		}
//		if (modeDebug.contains("ON"))
//			System.out.println("Error : " + msg);
//		;
//	}
//
//	
//	public static void logout() {
//		try {
//			if (deviceNo == 1) {
//				if (driver != null)
//					driver.quit();
//			}
//			if (deviceNo == 2) {
//				if (driver1 != null)
//					driver1.quit();
//				if (driver2 != null)
//					driver2.quit();
//			}
//			Thread.sleep(5);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	public void switchBrowserTab() {
//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(tabs2.get(1));
//	}
//
//	public void writeToLog(String textAdd) {
//		try {
//			FileUtils.writeStringToFile(logFile, textAdd, true);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public static WebDriver getDriver(String platform, String devName, String appPackage,
//			String appActivity, String appiumServer, int appiumPort, int bootstrapPort,
//			String platformversion, boolean autograntpermissions) {
//	public static WebDriver getDriver(int device) {
//		if (deviceNo == 0) {
//			deviceNo = device;
//		}
//		int nrow = device - 1;
//		System.out.println("Launching Driver...");
//		if (device == 1) {
//			capabilities.setCapability("platformName", arrDevices[nrow][0]);
//			capabilities.setCapability("deviceName", arrDevices[nrow][1]);
//			capabilities.setCapability("udid", arrDevices[nrow][1]);
//			capabilities.setCapability("appPackage", arrDevices[nrow][2]);
//			capabilities.setCapability("appActivity", arrDevices[nrow][3]);
//			capabilities.setCapability("platformVersion", arrDevices[nrow][4]);
//			capabilities.setCapability("autoGrantPermissions", arrDevices[nrow][5]);
//			capabilities.setCapability("automationName", arrDevices[nrow][6]);
//			// capabilities.setCapability("bp", arrDevices[nrow][9]);
//			try {
//				URL serverUrl = new URL("http://" + arrDevices[nrow][7] + ":" + arrDevices[nrow][8] + "/wd/hub");
//				driver = new AndroidDriver(serverUrl, capabilities);
//				// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			} catch (Exception e) {
//				System.out.println("Issue loading driver, waiting for 10 seconds..:" + e.getMessage());
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e1) {
//				}
//			}
//			return driver;
//		} else if (device == 2) {
//			try {
//				Thread.sleep(10000);
//			} catch (Exception e) {
//			}
//			capabilities1.setCapability("platformName", arrDevices[nrow][0]);
//			capabilities.setCapability("deviceName", arrDevices[nrow][1]);
//			capabilities.setCapability("udid", arrDevices[nrow][1]);
//			capabilities1.setCapability("appPackage", arrDevices[nrow][2]);
//			capabilities1.setCapability("appActivity", arrDevices[nrow][3]);
//			capabilities.setCapability("platformVersion", arrDevices[nrow][4]);
//			capabilities1.setCapability("autoGrantPermissions", arrDevices[nrow][5]);
//			capabilities1.setCapability("automationName", arrDevices[nrow][6]);
//			// capabilities1.setCapability("bp", arrDevices[nrow][9]);
//			try {
//				URL serverUrl1 = new URL("http://" + arrDevices[nrow][7] + ":" + arrDevices[nrow][8] + "/wd/hub");
//				driver1 = new AndroidDriver(serverUrl1, capabilities1);
//				// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			} catch (Exception e) {
//				System.out.println("Issue loading driver, waiting for 10 seconds..:" + e.getMessage());
//				try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e1) {
//				}
//			}
//			return driver1;
//		} else if (device == 3) {
//			launchBrowser();
//			return driver;
//		}
//		return null;
//	}
//	private static int getIndexArray(String[][] arrDevices, String Param1) {
//		for (int j = 0; j < arrDevices.length; j++) {
//			if (arrDevices[j][1].equalsIgnoreCase(Param1)) {
//				return j;
//			}
//		}
//		return -1;
//	}
	/**
	 * 
	 * //
	 */
//	public static void closeBrowser() {
//		try {
//			driver.close();
//			Thread.sleep(5000);
//			driver.quit();
//		} catch (Exception e) {
//			createLogs("N", "FAIL", "Close browser error: " + e.getMessage());
//		}
//	}
	/**
	 * This function will create the reports using extent for the end user The
	 * reports contains rich look and complete execution status
	 */
//	public void createReport(int device) {
//		try {
//			String[] arrep = this.getClass().getName().toString().split("\\.");
//			String rep = arrep[arrep.length - 1];
//			if (device == 1) {
//				extentReports = new ExtentReports();
//				extentHtmlReporter = new ExtentSparkReporter(
//						".\\reports\\" + browser + rep + executionRunTime + ".html");
//				extentReports.attachReporter(extentHtmlReporter);
//				extentReports.setSystemInfo("Environment", testenv);
//				extentHtmlReporter.config().setDocumentTitle(reportName);
//				extentHtmlReporter.config().setReportName(reportName + "-" + browser + "-" + testenv);
//				extentHtmlReporter.config().setTheme(Theme.STANDARD);
//				handler = new FileHandler(currDir + "reports\\" + browser + rep + executionRunTime + "-Logs.txt", true);
//				handler.setFormatter(formatter);
//				logger = Logger.getLogger(initBase.class.getName());
//				logger.addHandler(handler);
//				logger.setLevel(Level.INFO);
//				extentReports.flush();
//			} else if (device == 2) {
//				extentReports1 = new ExtentReports();
//				extentHtmlReporter1 = new ExtentSparkReporter(
//						".\\reports\\" + browser + rep + executionRunTime + ".html");
//				extentReports1.attachReporter(extentHtmlReporter);
//				extentReports1.setSystemInfo("Environment", testenv);
//				extentHtmlReporter1.config().setDocumentTitle(reportName);
//				extentHtmlReporter1.config().setReportName(reportName + "-" + browser + "-" + testenv);
//				extentHtmlReporter1.config().setTheme(Theme.STANDARD);
//				handler1 = new FileHandler(currDir + "reports\\" + browser + rep + executionRunTime + "-Logs.txt",
//						true);
//				handler1.setFormatter(formatter);
//				logger1 = Logger.getLogger(initBase.class.getName());
//				logger1.addHandler(handler1);
//				logger1.setLevel(Level.INFO);
//				extentReports1.flush();
//			} else if (device == 3) {
//				extentReports = new ExtentReports();
//				extentHtmlReporter = new ExtentSparkReporter(
//						".\\reports\\" + browser + rep + executionRunTime + ".html");
//				extentReports.attachReporter(extentHtmlReporter);
//				extentReports.setSystemInfo("Environment", testenv);
//				extentHtmlReporter.config().setDocumentTitle(reportName);
//				extentHtmlReporter.config().setReportName(reportName + "-" + browser + "-" + testenv);
//				extentHtmlReporter.config().setTheme(Theme.STANDARD);
//				handler = new FileHandler(currDir + "reports\\" + browser + rep + executionRunTime + "-Logs.txt", true);
//				handler.setFormatter(formatter);
//				logger = Logger.getLogger(initBase.class.getName());
//				logger.addHandler(handler);
//				logger.setLevel(Level.INFO);
//				extentReports.flush();
//			}
//			// }
//		} catch (Exception e) {
//			System.out.println("Error while creating Report/Logs: " + e.getMessage());
//			onlyLog();
//			logout();
//			System.exit(1);
//		}
//	}
	/**
	 * @param passFail -
	 * @param message  This function will log status in the Execution report and
	 *                 also log into the log files simultaneously for analyze
	 */
//	public static void createLogs(String lgMessage, String passFail, String message) {
//		if (deviceNo == 1 || deviceNo == 3) {
//			testMethodErrorCount2 = testMethodErrorCount;
//			logger2 = logger;
//			extentTest2 = extentTest;
//			driver2 = driver;
//		} else {
//			testMethodErrorCount2 = testMethodErrorCount1;
//			logger2 = logger;
//			extentTest2 = extentTest1;
//			driver2 = driver1;
//		}
//		String newMessage;
//		try {
//			newMessage = message;
//			if (newMessage.length() > 160)
//				newMessage = newMessage.substring(0, 160);
//
//			Status st;
//			if (passFail.contains("PASS")) {
//				st = Status.PASS;
//			} else if (passFail.contains("FAIL")) {
//				st = Status.FAIL;
//			} else {
//				st = Status.SKIP;
//			}
//			if (lgMessage.equals("Y")) {
//				takeScreenShot(st, newMessage);
//			}
//			logger2.info(passFail + " - " + message);
//			if (passFail.contains("SKIP")) {
//				logger2.info("SKIPING rest seps");
//				createLogs("Y", "FAIL", "Skipping rest steps: Waiting for 10 seconds... " + testMethodErrorCount2);
//				try {
//					driver2.quit();
//				} catch (Exception e) {
//				}
//				Thread.sleep(10000);
//				throw new SkipException("Skip Steps");
//			}
//			if (passFail.contains("FAIL")) {
//				testMethodErrorCount2++;
//				if (testMethodErrorCount2 >= SkipCount) { // Skip remaining steps if the error counts in the test method
//					createLogs("Y", "FAIL",
//							"Skipping rest steps as error count reached configured value, Waiting for 10 seconds... : "
//									+ testMethodErrorCount2);
//					try {
//						driver2.quit();
//					} catch (Exception e) {
//					}
//					Thread.sleep(10000);
//					logger2.info("FAIL - Skipping rest steps as error count reached configured value : "
//							+ testMethodErrorCount2);
//					throw new SkipException("Skip Steps"); // reaches the global configured count
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("Error occured while writing logs: " + e.getMessage());
//		}
//		if (deviceNo == 1 || deviceNo == 3) {
//			testMethodErrorCount = testMethodErrorCount2;
//		} else {
//			testMethodErrorCount1 = testMethodErrorCount2;
//		}
//	}
	/**
	 * This function will only write logs e.g. when @Test method gets executed
	 */
//	public static void onlyLog() {
//		if (deviceNo == 1 || deviceNo == 3) {
//			logger2 = logger;
//			scenarioName2 = scenarioName;
//			testMethodErrorCount2 = testMethodErrorCount;
//		} else {
//			logger2 = logger;
//			scenarioName2 = scenarioName1;
//			testMethodErrorCount2 = testMethodErrorCount1;
//		}
//		if (scenarioName.isEmpty())
//			return;
//		Status st;
//		String passFail = "Passed";
//
//		if (testMethodErrorCount2 > 0) // IF any step fails this counter will be more than 0
//		{
//			totalFail++;
//			passFail = "Failed";
//		} else {
//			totalPass++;
//		}
//		if (passFail.equalsIgnoreCase("Passed"))
//			st = Status.PASS;
//		else
//			st = Status.FAIL;
//		logger2.info(passFail + " - " + scenarioName2);
//		Integer runcnt = totalPass + totalFail;
//		logger2.info("Total Pass : " + totalPass + " Total Fail : " + totalFail + "  Run: " + runcnt + " Total TC : "
//				+ totalTC);
//		System.out.println("Total Pass : " + totalPass + " Total Fail : " + totalFail + "  Run: " + runcnt
//				+ " Total TC : " + totalTC);
//		if (deviceNo == 1 || deviceNo == 3) {
//			extentTest.log(st, scenarioName2 + " :- " + passFail);
//			extentReports.flush();
//		} else {
//			extentTest1.log(st, scenarioName2 + " :- " + passFail);
//			extentReports1.flush();
//		}
//	}
	/**
	 * This function will take the screen shot of the screen
	 */
//	public static void takeScreenShot(Status st, String message) {
//		String fileName = new SimpleDateFormat("dd-MM-yyyy-hhmmss").format(new Date());
//		try {
//			if (screenShot.equalsIgnoreCase("Y") && (!Objects.isNull(driver2))) {
//				if (st.toString().toUpperCase().equals("FAIL") || screenShot.equals("Y")) {
//					String app = ((StartsActivity) driver).getCurrentPackage();
//					String app1 = ((StartsActivity) driver).currentActivity();
//					 System.out.println  (app1.toString() + " " + app.toString());
//					ApplicationState appState = ((InteractsWithApps) driver).queryAppState(app);
//					if (appState.toString().equalsIgnoreCase("RUNNING_IN_FOREGROUND")) {
//						File srcFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
//						FileUtils.copyFile(srcFile, new File(screenShotFolder + "-" + fileName + ".png"));
//						message = message + ".  <a href='file:///" + screenShotFolder + "-" + fileName
//								+ ".png'>ScreenShot</a>";
//					}
//				}
//			}
//			extentTest2.log(st, message);
//		} catch (Exception e) {
//			createLogs("N", "FAIL", "Screenshot not captured: " + e.getMessage());
//		}
//	}
	// Tips
	// 1. When 500 error comes run below
//	adb uninstall io.appium.uiautomator2.server
//	adb uninstall io.appium.uiautomator2.server.test S+alt+J HEAD
//	
//	1. Install Java Development Kit (JDK)
//	2. Install Android Studio and SDK
//	3. Install Appium Desktop applicaiton
//	4. Install Eclipse IDE
//	5. Install TestNG Plugin for Eclipse
//	6. Install Appium inspector (setup with appropriate appium port and URL)
//	client.. not worked had  to install appium in npm only.
//	nodejs
//	npm install -g appium
//	npm install -g adb
//https://developer.android.com/tools/releases/platform-tools for installing ADB
	//npm install -g appium-uiautomator2-driver

}// END
