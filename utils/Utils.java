package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import base.initBase;

/**
 * 
 */
public class Utils {
	// MySQL Variables should be here
	public static String dbURL = initBase.mySQLString; 
	//"jdbc:mysql://192.168.6.201:3306/paytimewebmaster?user=saas&password=mantra123&autoReconnect=true&useSSL=false";
	public static String mySQLQry = "";
	public static Connection connection;
	public static Connection con_obj;
	public static Statement st_obj;
	WebDriver driver;
	private String exceptionDesc;
	public static int days;
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	//
	public void cleanReports() {
		try {
			String folderPath = initBase.screenShotFolder; // Specify the folder path
			String jsonfolderPath = "", scrShtFdrPth="";;
			days =  Integer.parseInt(initBase.strDeleteHTML);// Specify the number of days
		//	deleteOldFiles(folderPath, days);
			folderPath = initBase.currDir + "\\reports\\";
			File directory = new File(folderPath);
			File jsondirectory = null;
			File[] files = directory.listFiles();
			
			for (File file : files) {
				// If the file is a directory, delete it recursively
				if (file.isDirectory()) {
					jsonfolderPath = file.getAbsolutePath() + "\\json\\";
					scrShtFdrPth= file.getAbsolutePath() + "\\screenshot\\";
					jsondirectory = new File(jsonfolderPath);
				
					if (jsondirectory.isDirectory()) {
						deleteOldFiles(jsondirectory.getAbsolutePath());
						jsondirectory.delete();
					}
					deleteOldFiles(file.getAbsolutePath());
					//Delete Screenshot folder
					jsondirectory= new File(scrShtFdrPth);
					if (jsondirectory.isDirectory()) {
						deleteOldFiles(jsondirectory.getAbsolutePath());
						jsondirectory.delete();
					}
					deleteOldFiles(file.getAbsolutePath());
				}
				file.delete();
			}
		} catch (Exception e) {
			System.out.println("Error while deleting report directory." + e.getMessage());
		}
	}

	public void Connection_configuration() {
		try {
			String driver_ClassName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver_ClassName);
			System.out.println("MySQL JDBC Driver Registered!");
			String url = "jdbc:mysql://192.168.6.201:3306/paytimewebmaster";
			String user_name = "saas";
			String user_password = "mantra123";
			con_obj = DriverManager.getConnection(url, user_name, user_password);
			System.out.println("Database connected!");
			st_obj = con_obj.createStatement();
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Connection failed. Check output console");
			e.printStackTrace();
		}
	}

	// Getter for the connection object
	public Connection getConnection() {
		return con_obj;
	}

	// Getter for the statement object
	public Statement getStatement() {
		return st_obj;
	}

	public void closeConnection() {
		try {
			if (con_obj != null) {
				con_obj.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteOldFiles(String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists() || !folder.isDirectory()) {
			System.out.println("Invalid folder path.");
			return;
		}
		FilenameFilter imageFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				String lowerName = name.toLowerCase();
				return lowerName.endsWith(".png") || lowerName.endsWith(".txt") || lowerName.endsWith(".lck")
						|| lowerName.endsWith(".html") || lowerName.endsWith(".json");
			}
		};
		// List image files in the directory
		File[] files = folder.listFiles(imageFilter);
		if (files != null) {
			for (File file : files) {
				if (file.isFile()) {
					try {
						BasicFileAttributes attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
						Instant fileTime = attrs.creationTime().toInstant();
						LocalDateTime fileDateTime = LocalDateTime.ofInstant(fileTime, ZoneId.systemDefault());
						LocalDateTime cutoffDate = LocalDateTime.now().minus(days, ChronoUnit.DAYS);
						if (fileDateTime.isBefore(cutoffDate) || days == 0) {
							if (file.delete()) {
								System.out.println("Deleted: " + file.getAbsolutePath());
							} else {
								System.out.println("Failed to delete: " + file.getAbsolutePath());
							}
						}
					} catch (Exception e) {
						System.err.println("Error processing file: " + file.getAbsolutePath());
					}
				}
			}
		}
	}

	public static String getRandomDateXPath(int dayOffset) {
		LocalDate now = LocalDate.now().plusDays(dayOffset);
		String  day = String.format("%02d", now.getDayOfMonth());
		String monthName = now.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		int year = now.getYear();

		return "//android.view.View[@content-desc='" + day + " " + monthName + " " + year + "']";
	}

	public static String getRandomDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");
		// Format the current date
		String date = formatter.format(new Date());
		// Return the formatted date string
		return date;
	}

	/**
	 * @param dbURL
	 * @param mySQLQry
	 */
	public void updateMYSQL(String dbURL, String mySQLQry) {
		try {
			if (connection == null) {
				connection = DriverManager.getConnection(dbURL);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (PreparedStatement statement = connection.prepareStatement(mySQLQry)) {
			// Execute the insert statement
			int rowsInserted = statement.executeUpdate();
			System.out.println("DB->Total records updated are : " + rowsInserted + " for the query ->" + mySQLQry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function will explicitly wait for the given number of seconds for the
	 * element to be available
	 * 
	 * @param ele
	 * @param expCondition
	 * @return
	 */
	public boolean waitForEle(final WebElement ele, final String expCondition, final String subString) {
		boolean result = false;
		try {
			Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(initBase.explicitWait))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver arg0) {
					try {
						if (expCondition.contains("visible")) {
							if (ele.isDisplayed())
								return true;
						} else if (expCondition.contains("enabled")) {
							if (ele.isEnabled())
								return true;
						} else if (expCondition.contains("selected")) {
							if (ele.isSelected())
								return true;
						} else if (expCondition.contains("innerHTML")) {
							return (ele.getAttribute("innerHTML").contains(subString)
									|| ele.toString().contains(subString));
						} else if (expCondition.contains("notvisible")) {
							if (ele.isDisplayed() != true)
								return true;
						}
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
					}
					return false;
				}
			};
			result = (Boolean) wait.until(function);
			wait.until(function);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			result = false;
		}
		return result;
	}

	/**
	 * @param ele
	 * @param expCondition
	 * @param subString
	 * @param waitForSeconds
	 * @return
	 */
	public boolean waitForEle(final WebElement ele, final String expCondition, final String subString,
			int waitForSeconds) {
		boolean result = false;
		try {
			Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(waitForSeconds))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver arg0) {
					try {
						if (expCondition.contains("visible")) {
							if (ele.isDisplayed())
								return true;
						} else if (expCondition.contains("enabled")) {
							if (ele.isEnabled())
								return true;
						} else if (expCondition.contains("selected")) {
							if (ele.isSelected())
								return true;
						} else if (expCondition.contains("innerHTML")) {
							return (ele.getAttribute("innerHTML").contains(subString)
									|| ele.toString().contains(subString));
						} else if (expCondition.contains("notvisible")) {
							if (ele.isDisplayed() != true)
								return true;
						}
					} catch (Exception e) {
						exceptionDesc = e.getMessage().toString();
					}
					return false;
				}
			};
			result = (Boolean) wait.until(function);
			wait.until(function);
		} catch (Exception e) {
			exceptionDesc = e.getMessage().toString();
			result = false;
		}
		return result;
	}

	public String getExceptionDesc() {
		return this.exceptionDesc;
	}

	public boolean verifyToastMessagesFromSource(WebElement ele) {
		try {
			String srcXML = this.driver.getPageSource();
			String searchTexxt = ele.getText();
			if (srcXML.contains(searchTexxt))
				return true;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String runCommandPrompt(List<String> command, String search) {
		// Create a ProcessBuilder instance
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		String results = "";
		try {
			// Start the process
			Process process = processBuilder.start();
			// Capture the output
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			// Parse the output
			while ((line = reader.readLine()) != null) {
				if (search.isEmpty() != true) {
					if (line.contains(search)) {
						results = results + line;
						break;
					}
				} else {
					results = results + line;
				}
			}
			// Wait for the process to complete
			process.waitFor();
		} catch (Exception e) {
			System.out.println("Error while running ADB command prompt: " + e.getMessage());
		}
		return results;
	}

} // END of Utils class
