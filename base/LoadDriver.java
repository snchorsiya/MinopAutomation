package base;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

public class LoadDriver {
	WebDriver driver, driver1, driver2;
	DesiredCapabilities capabilities = new DesiredCapabilities(), capabilities1 = new DesiredCapabilities();

	public WebDriver getDriver(int device) {
		URI uri = null;
		URL serverUrl;
		try {
			if (initBase.deviceNo == 0) {
				initBase.deviceNo = device;
			}
			int nrow = device - 1;
			System.out.println("Launching Driver...");
			if (device != 3) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
				}
				capabilities.setCapability("newCommandTimeout", 600); // 10 minutes
				capabilities.setCapability("adbExecTimeout", 10000); // 60 seconds
				capabilities.setCapability("platformName", initBase.arrDevices[nrow][0]);
				capabilities.setCapability("deviceName", initBase.arrDevices[nrow][1]);
				capabilities.setCapability("udid", initBase.arrDevices[nrow][1]);
				capabilities.setCapability("appPackage", initBase.arrDevices[nrow][2]);
				capabilities.setCapability("appActivity", initBase.arrDevices[nrow][3]);
				capabilities.setCapability("platformVersion", initBase.arrDevices[nrow][4]);
				capabilities.setCapability("autoGrantPermissions", initBase.arrDevices[nrow][5]);
				capabilities.setCapability("automationName", initBase.arrDevices[nrow][6]);
				try {
					uri = new URI(
							"http://" + initBase.arrDevices[nrow][7] + ":" + initBase.arrDevices[nrow][8] + "/wd/hub");
					serverUrl = uri.toURL();
					UnlockDevice(initBase.arrDevices[nrow][1]);
					driver = new AndroidDriver(serverUrl, capabilities);
					// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				} catch (Exception e) {
					System.out.println("Issue loading driver, waiting for 10 seconds..:" + e.getMessage());
				}
				return driver;
			} else if (device == 3) {
				launchBrowser();
				return driver;
			}
		} catch (Exception e) {
			System.out.println(
					"Issue loading driver, waiting for 10 seconds..:" + e.getMessage().toString() + " ,URL " + uri);
		}
		return null;
	}

	private void UnlockDevice(String deviceid) {
		List<String> command = new ArrayList<>();
        String adbPath = System.getProperty("user.home") + "\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
		command.add(adbPath);
		command.add("-s");
		command.add(deviceid);
		command.add("shell");
		command.add("input");
		command.add("keyevent");
		command.add("224");
		String result = Utils.runCommandPrompt(command, "");
		
	}

	
	public static  void lockDevice() {
		// adb shell input keyevent 26
		String adbPath = System.getProperty("user.home") + "\\AppData\\Local\\Android\\Sdk\\platform-tools\\adb.exe";
		List<String> command = new ArrayList<>();
		command.add(adbPath);
		command.add("-s");
		command.add(initBase.arrDevices[0][1]); //Currently fixed to first as multiple devices can be done later
		command.add("shell");
		command.add("input");
		command.add("keyevent");
		command.add("26");
		String result = Utils.runCommandPrompt(command, "");
	}
	/*
	 * Launch browser based on configuration
	 */
	void launchBrowser() {
		try {
			if (initBase.browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", initBase.userHome + "geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (initBase.browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup(); // May 24 check this out
				System.setProperty("webdriver.chrome.driver", initBase.userHome + "chromedriver.exe");
			    ChromeOptions options = new ChromeOptions();
		        options.addArguments("--disable-save-password-bubble");
		        options.addArguments("--disable-infobars");
		        options.addArguments("disable-translate");
		        options.addArguments("disable-notifications");
				driver = new ChromeDriver(options);
			} else if (initBase.browser.equals("chromever")) {
				System.setProperty("webdriver.chrome.driver", initBase.userHome + "chromedriver.exe");
				// Provide the path to the Chrome executable
				String chromeExecutablePath = "C:\\Users\\admin\\Downloads\\chrome-win32"; // Update this path
				// Set up Chrome options
				ChromeOptions options = new ChromeOptions();
				options.setBinary(chromeExecutablePath);
				// Create an instance of ChromeDriver with the specified options
				driver = new ChromeDriver(options);
			} else {
				System.setProperty("webdriver.ie.driver", initBase.userHome + "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			driver.navigate().to(initBase.URL);
			Thread.sleep(5000);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(initBase.implicitlyWait)));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(initBase.pageLoadTimeout)));
//			//driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(initBase.pageLoadTimeout), TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(Integer.parseInt(initBase.implicitlyWait),
			// TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println("Issue loading driver..:" + e.getMessage());
		}
	}
}// END Loaddriver
