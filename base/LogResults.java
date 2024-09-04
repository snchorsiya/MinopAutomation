package base;

import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogResults {
	// HTML Reports
	private ExtentSparkReporter extentHtmlReporter;
	private ExtentReports extentReports;
	private ExtentTest extentTest;
	//
	// Java Logger
	private FileHandler handler;
	private Logger logger;
	private SimpleFormatter formatter = new SimpleFormatter();
	// Pass fail related variables
	private Integer testMethodErrorCount;
	private String scenarioName;
	// Webdriver
	private WebDriver driver;

	/**
	 * @param currTC
	 */
	public void createExtentReport(String currTC) {
		try {
			extentTest = extentReports.createTest(currTC);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function will create the reports using extent for the end user The
	 * reports contains rich look and complete execution status
	 */
	public void createReport() {
		StackTraceElement[] ar = Thread.currentThread().getStackTrace();
		StackTraceElement parentElement = ar[2];
		String strT1 = parentElement.toString();
		strT1 = strT1.replace("(", "-");
		String arrT2 = strT1.split("-")[1];
		arrT2 = arrT2.replace(".", "-");
		arrT2 = arrT2.split("-")[0];
		try {
			// String[] arrep = this.getClass().getName().toString().split("\\.");
			String rep = arrT2; // arrep[arrep.length - 1];
			String strjsonFdr = "reports\\HTML-" + initBase.executionRunTime + "\\JSON\\" + initBase.browser + rep
					+ ".json";
			String strhtmlFdr = "reports\\HTML-" + initBase.executionRunTime + "\\" + initBase.browser + rep + ".html";
			File reportDir = new File("reports\\HTML-" + initBase.executionRunTime);
			initBase.screenShotFolder = "reports\\HTML-" + initBase.executionRunTime + "\\screenshot";
			if (reportDir.exists() != true) {
				reportDir.mkdirs();
				reportDir = new File("reports\\HTML-" + initBase.executionRunTime + "\\json");
				reportDir.mkdirs();
				File screeshtFdr = new File(initBase.screenShotFolder);
				screeshtFdr.mkdirs();
			}
			extentReports = new ExtentReports();
			extentReports.createDomainFromJsonArchive(strjsonFdr);
			extentHtmlReporter = new ExtentSparkReporter(strhtmlFdr);
			JsonFormatter json = new JsonFormatter(strjsonFdr);
			extentReports.attachReporter(json, extentHtmlReporter);
			extentReports.setSystemInfo("Environment", initBase.testenv);
			extentHtmlReporter.config().setDocumentTitle(initBase.reportName);
			extentHtmlReporter.config()
					.setReportName(initBase.reportName + "-" + initBase.browser + "-" + initBase.testenv);
			extentHtmlReporter.config().setTheme(Theme.STANDARD);
			// July24 Modal Functionality
//			extentHtmlReporter.config().setCss(
//					"<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>");
//			extentHtmlReporter.config().setJs("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js'></script>"
//					+ "<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js'></script>"
//					+ "<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js'></script>");
//			extentHtmlReporter.config().setJs("document.addEventListener('DOMContentLoaded', function() {"
//					+ "    var body = document.querySelector('body');"
//					+ "    var modalHtml = '<div class=\"modal fade\" id=\"screenshotModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">' +"
//					+ "        '<div class=\"modal-dialog\" role=\"document\">' +"
//					+ "            '<div class=\"modal-content\">' +"
//					+ "                '<div class=\"modal-header\">' +"
//					+ "                    '<h5 class=\"modal-title\" id=\"exampleModalLabel\">Screenshot</h5>' +"
//					+ "                    '<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">' +"
//					+ "                        '<span aria-hidden=\"true\">&times;</span>' +"
//					+ "                    '</button>' +" + "                '</div>' +"
//					+ "                '<div class=\"modal-body\">' +"
//					+ "                    '<img id=\"screenshotImg\" src=\"\"  style=\"width:100px;\">' +"
//					+ "                '</div>' +" + "                '<div class=\"modal-footer\">' +"
//					+ "                    '<button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>' +"
//					+ "                '</div>' +" + "            '</div>' +" + "        '</div>' +" + "    '</div>';"
//					+ "    body.insertAdjacentHTML('beforeend', modalHtml);" + "});" + "function openModal(imgSrc) {"
//					+ "    $('#screenshotModal').modal('show');"
//					+ "    document.getElementById('screenshotImg').src = imgSrc;" + "}");
			//
			handler = new FileHandler(
					"reports\\HTML-" + initBase.executionRunTime + "\\" + initBase.browser + rep + "-Logs.txt", true);
			handler.setFormatter(formatter);
			logger = Logger.getLogger(initBase.class.getName());
			logger.addHandler(handler);
			logger.setLevel(Level.INFO);
			extentReports.flush();
		} catch (Exception e) {
			System.out.println("Error while creating Report/Logs: " + e.getMessage());
			onlyLog();
			System.exit(1);
		}
	}

	/**
	 * @param passFail -
	 * @param message  This function will log status in the Execution report and
	 *                 also log into the log files simultaneously for analyze
	 */
	public void createLogs(String lgMessage, String passFail, String message) throws SkipException {
		String newMessage;
		try {
			newMessage = message;
			if (newMessage.length() > 160)
				newMessage = newMessage.substring(0, 160);
			Status st = null;
			;
			if (passFail.contains("PASS")) {
				st = Status.PASS;
			} else if (passFail.contains("FAIL")) {
				st = Status.FAIL;
			} else {
				st = Status.INFO;
			}
			if (lgMessage.equals("Y")) {
				takeScreenShot(st, newMessage);
			}
			logger.info(passFail + " - " + message);
//			if (passFail.contains("SKIP")) {
//				logger.info("SKIPING rest seps");
//				throw new SkipException("Skip Steps");
//			}
			if (passFail.contains("FAIL")) {
				testMethodErrorCount++;
				if (testMethodErrorCount >= initBase.SkipCount) { // Skip remaining steps if the error counts in the
					logger.info("FAIL - Skipping rest steps as error count reached configured value : "
							+ testMethodErrorCount);
					if (initBase.SkipCount > 1) {
						extentTest.info("Skipping rest steps as error count reached configured value : "
								+ testMethodErrorCount);
					}
					throw new SkipException("Skip Steps"); // reaches the global configured count
				}
			}
		} catch (Exception e) {
			throw new SkipException("Skip Steps");
		}
	}

	/**
	 * This function will take the screen shot of the screen
	 */
	public void takeScreenShot(Status st, String message) {
		String fileName = new SimpleDateFormat("dd-MM-yyyy-hhmmss").format(new Date());
		try {
			if (initBase.screenShot.equalsIgnoreCase("Y") && (!Objects.isNull(driver))) {
				if (st.toString().toUpperCase().equals("FAIL") || initBase.screenShot.equals("Y")) {
					File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(srcFile,
							new File(initBase.currDir + initBase.screenShotFolder + "\\" + fileName + ".png"));
					// Working message = message + ". <a href='screenshot/" + fileName + ".png" +
					// "'>ScreenShot</a>";
//					//Working message = "Screenshot example: <a href='" + "screenshot/" + fileName + ".png" + "' target='_blank'>"
//							+ "<img src='" + "screenshot/" + fileName + ".png"
//							+ "' style='width:100px;height:100px;'></a>";
					message = message + "<a href='" + "screenshot/" + fileName + ".png" + "' target='_blank'>"
							+ "'>ScreenShot</a>";
//					message = message + ".  <a href='file:///" + initBase.screenShotFolder + "-" + fileName
//							+ ".png'>ScreenShot</a>";
//					message = message + ". <a href='javascript:void(0);' onclick='openModal  (\"" + "screenshot\\"
//							+ fileName + ".png" + "\")'>" + "<img src='" + "screenshot\\" + fileName + ".png"
//							+ "' style='width:100px;height:100px;'></a>";	
				}
			}
			// July 24
			if (st.toLower().equalsIgnoreCase("pass")) {
				extentTest.pass(message);
			} else if (st.toLower().equalsIgnoreCase("info")) {
				extentTest.info(message);
			} else {
				extentTest.fail(message);
			}
			//
			// extentTest.log(st, message);july 24
		} catch (Exception e) {
			System.out.println("Screenshot not captured : " + e.getMessage().toString());
		}
	}

	/*
	 * 
	 * This function will only write logs e.g.when @Test method gets executed
	 */
	public void onlyLog() {
		extentReports.flush();
		if (getScenarioName() == null)
			return;
		Status st;
		String passFail = "Passed";
		if (getTestMethodErrorCount() > 0) // IF any step fails this counter will be more than 0
		{
			initBase.totalFail++;
			passFail = "Failed";
		} else {
			initBase.totalPass++;
		}
		if (passFail.equalsIgnoreCase("Passed"))
			st = Status.PASS;
		else
			st = Status.FAIL;
		logger.info(passFail + " - " + getScenarioName());
		Integer runcnt = initBase.totalPass + initBase.totalFail;
		System.out.println("---------------------------------------------------------------");
		logger.info("Total Pass : " + initBase.totalPass + " Total Fail : " + initBase.totalFail + "  Total TC : "
				+ runcnt);
		System.out.println("---------------------------------------------------------------");
		extentTest.log(st, getScenarioName() + " :- " + passFail);
		setTestMethodErrorCount(0);
		scenarioName = "";
		extentReports.flush();
	}

	public String getScenarioName() {
		return scenarioName;
	}

	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	public Integer getTestMethodErrorCount() {
		return this.testMethodErrorCount;
	}

	public void setTestMethodErrorCount(Integer testMethodErrorCount) {
		this.testMethodErrorCount = testMethodErrorCount;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public static void mergeReports() {
		try {
			String strjsonFdr = ".\\reports\\HTML-" + initBase.executionRunTime + "\\json\\";
			String strHTMLfdr = ".\\reports\\HTML-" + initBase.executionRunTime + "\\";
			File jsonOPDirectory = new File(strjsonFdr);
			if (jsonOPDirectory.exists()) {
				ExtentSparkReporter mergedSpark = new ExtentSparkReporter(strHTMLfdr + "AllReports.html");
				ExtentReports extentMerged = new ExtentReports();
				FilenameFilter jsonFilter = new FilenameFilter() {
					public boolean accept(File dir, String name) {
						String lowerName = name.toLowerCase();
						return lowerName.endsWith(".json");
					}
				};
				File[] files = jsonOPDirectory.listFiles(jsonFilter);
				if (files != null) {
					for (File file : files) {
						if (file.isFile()) {
							try {
								extentMerged.createDomainFromJsonArchive(file.getPath());
								file.delete();
							} catch (Exception e) {
								System.err.println("Error processing file: " + file.getAbsolutePath());
							}
						}
					}
				}
				jsonOPDirectory.delete();
				extentMerged.attachReporter(mergedSpark);
				extentMerged.flush();
			}
		} catch (Exception e) {
			System.out.println("Error while merging reports : " + e.getMessage().toString());
		}
	}
} // End of LogResults
