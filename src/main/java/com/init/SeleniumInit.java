package com.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.indexPage.LoginIndexPage;
import com.indexPage.SearchProductIndexPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import com.verificationPage.LoginVerificationPage;
import com.verificationPage.SearchProductVerificationPage;

public class SeleniumInit {

	public static int note_data = 0;
	public static String suiteName = "";
	public static String testName = "";

	/* Minimum requirement for test configuration */

	public static String testUrl; // Test url
	protected static String seleniumHub; // Selenium hub IP
	protected static String seleniumHubPort; // Selenium hub port
	protected static String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null; // Path to screenshot
															// folder
	protected static String downloads_folder_path = null;
	public static String currentWindowHandle = "";// Get Current Window handle
	public static String browserName = "";
	public static String osName = "";
	public static String browserVersion = "";
	public static String userDir = System.getProperty("user.dir");
	public static String comonTemplateName = "";
	public static String constant_grfpTemplateName = "";
	public static HashMap<String, String> globalMap = new HashMap<String, String>();
	public static ArrayList<String> arrayList = new ArrayList<String>();

	public String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");
	public static WebDriver driver;

	InputStream input = null;
	public static Properties config_properties = new Properties();

	public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentReports report;

	public LoginIndexPage loginIndexPage;
	public LoginVerificationPage loginVerificationPage;
	public SearchProductIndexPage searchProductIndexPage;
	public SearchProductVerificationPage searchProductVerificationPage;

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */

	@BeforeSuite(alwaysRun = true)
	protected void fetchSuiteConfiguration(ITestContext testContext) {

		// Pass the URL to be tested
		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");

		System.out.println("======" + testUrl + "=========");

		report = new ExtentReports(System.getProperty("user.dir") + "/Reports/ExtentReportResults.html");
		test = getNewTest("Valid Credential");
		test1 = getNewTest("Search Product");

		// report.config().reportName("Final Report");

	}

	private ExtentTest getNewTest(String testName) {
		return report.startTest(testName);
	}

	@AfterSuite(alwaysRun = true)
	public void testResults() {

		report.endTest(test);
		report.endTest(test1);
		report.flush();

	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@BeforeSuite
	public void one(ITestContext testContext) {
		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
	}

	@SuppressWarnings("deprecation")
	@BeforeTest(alwaysRun = true)
	public void setUp(ITestContext testContext) throws IOException, InterruptedException {

		targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		currentTest = testContext.getCurrentXmlTest().getName(); // get Name of
																	// current
																	// test.

		log("current test- " + currentTest);

		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";
		String DOWNLOADS_FOLDER_NAME = "downloads";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		downloads_folder_path = new File(DOWNLOADS_FOLDER_NAME).getAbsolutePath();

		// load the properties file from test_data folder
		FileReader reader;
		try {
			reader = new FileReader(test_data_folder_path + File.separator + "config.properties");
			config_properties.load(reader);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find the config properties file");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was a problem in loading the config properties file");
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		suiteName = testContext.getSuite().getName();
		Common.log("Current Xml Suite is:---->" + suiteName);

		DesiredCapabilities capability = null;
		System.out.println(targetBrowser);

		try {
			// URL remote_grid = new URL("http://" + seleniumHub + ":" +
			// seleniumHubPort + "/wd/hub");

			if (targetBrowser == null || targetBrowser.contains("firefox")) {

				File file = new File(userDir + "//lib//geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList", 2);
				profile.setPreference("browser.download.manager.showWhenStarting", false);
				profile.setPreference("browser.download.dir", downloads_folder_path);
				profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/octet-stream");
				profile.setPreference("browser.helperApps.neverAsk.openFile",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/octet-stream");
				capability = DesiredCapabilities.firefox();
				capability.setCapability("marionette", true);
				capability.setJavascriptEnabled(true);

				capability.setCapability(FirefoxDriver.PROFILE, profile);

				browserName = capability.getBrowserName();
				osName = System.getProperty("os.name");
				browserVersion = capability.getVersion().toString();

				// driver = new RemoteWebDriver(remote_grid, capability);
				SeleniumInit.driver = new FirefoxDriver(capability);

				System.out.println("=========" + " Mozilla Firefox Browser " + "==========");

			} else if (targetBrowser.contains("chrome")) {

				capability = DesiredCapabilities.chrome();

				File file = new File(userDir + "//lib//chromedriver.exe");

				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory", downloads_folder_path);

				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-infobars");
				options.setExperimentalOption("prefs", chromePrefs);

				capability.setJavascriptEnabled(true);
				capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				capability.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capability);

				browserName = capability.getBrowserName();
				osName = capability.getPlatform().name();
				browserVersion = capability.getVersion();

				SeleniumInit.driver = new ChromeDriver(capability);

				System.out.println("=========" + " Google Chrome Browser " + "==========");

			} else if (targetBrowser.contains("ie")) {

				File file = new File(userDir + "//lib//IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

				capability = DesiredCapabilities.internetExplorer();

				capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capability.setCapability("ie.ensureCleanSession", true);
				capability.setJavascriptEnabled(true);

				browserName = capability.getBrowserName();
				osName = capability.getPlatform().name();
				browserVersion = capability.getVersion();

				log(browserVersion);

				SeleniumInit.driver = new InternetExplorerDriver(capability);

				System.out.println("=========" + " Internet Explorer Browser " + "==========");

			} else if (targetBrowser.contains("safari")) {

				capability = DesiredCapabilities.safari();

				capability.setJavascriptEnabled(true);
				capability.setBrowserName("safari");

				browserName = capability.getBrowserName();
				osName = capability.getPlatform().name();
				browserVersion = capability.getVersion();

				SeleniumInit.driver = new SafariDriver(capability);

				System.out.println("=========" + " Safari Browser " + "==========");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(testUrl);

		driver.manage().window().maximize();

		Common.waitForPageLoaded(driver);

		currentWindowHandle = driver.getWindowHandle();

		System.out.println("Current Window Handle ID:--->" + currentWindowHandle);

	}

	@BeforeMethod(alwaysRun = true)
	public void initV() {
		loginIndexPage = new LoginIndexPage(driver);
		loginVerificationPage = new LoginVerificationPage(driver);

		searchProductIndexPage = new SearchProductIndexPage(driver);
		searchProductVerificationPage = new SearchProductVerificationPage(driver);

	}

	public void acceptCookie() throws Exception {
		WebElement cookiee = driver.findElement(By.id("hs-eu-confirmation-button"));

		if (cookiee.isDisplayed()) {
			cookiee.click();
		}

	}

	/**
	 * Log For Failure Test Exception.
	 * 
	 * @param tests
	 */
	private void getShortException(IResultMap tests) {

		for (ITestResult result : tests.getAllResults()) {

			Throwable exception = result.getThrowable();
			List<String> msgs = Reporter.getOutput(result);
			boolean hasReporterOutput = msgs.size() > 0;
			boolean hasThrowable = exception != null;
			if (hasThrowable) {
				boolean wantsMinimalOutput = result.getStatus() == ITestResult.SUCCESS;
				if (hasReporterOutput) {
					log("<b><i>" + (wantsMinimalOutput ? "Expected Exception" : "Failure Reason:") + "</b></i>");
				}

				// Getting first line of the stack trace
				String str = ExceptionUtils.getStackTrace(exception);
				// tackTrace(exception, true)[0];

				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(str);
				String firstLine = scanner.nextLine();
				log("<Strong><font color=#ff0000>" + firstLine + "</font></strong>");
			}
		}
	}

	/**
	 * After Test
	 * 
	 * @param testResult
	 */
	public static int passed_count = 0;
	public static int failed_count = 0;
	public static int skipped_count = 0;

	@AfterTest(alwaysRun = true)

	public void tearDown() throws NullPointerException {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();

		ITestResult testResult = null;
		// System.out.println("entered into tearDown");

		ITestContext ex = testResult.getTestContext();

		if (testResult.getStatus() == ITestResult.SUCCESS) {
			passed_count++;
		}

		else if (testResult.getStatus() == ITestResult.FAILURE) {
			failed_count++;

		}

		else if (testResult.getStatus() == ITestResult.SKIP) {
			skipped_count++;

		}
		try {
			testName = testResult.getName();
			if (!testResult.isSuccess()) {

				// Common.saveScreenshot(driver, currentTest);
				// Print test result to Jenkins Console
				System.out.println();
				System.out.println("TEST FAILED - " + testName);
				System.out.println();
				System.out.println("ERROR MESSAGE: " + testResult.getThrowable());
				System.out.println("\n");
				Reporter.setCurrentTestResult(testResult);

				Reporter.log("<br></br><Strong><font color=#ff0000>Fail                  </font></strong><img src='"
						+ userDir + "\\report-imgs\\fail.png' alt='fail' height='15' width='15'/>");
				getShortException(ex.getFailedTests());
				Common.saveScreenshot(driver, currentTest);
			} else {

				// Print test result to Jenkins console
				System.out.println("TEST PASSED - " + testName + "\n");
			}
			System.out.println("--------------- Test status : " + testResult.getStatus() + " ---------------");

			// driver.manage().deleteAllCookies();
			// driver.close();
			// driver.quit();

		} catch (Exception throwable) {
			System.out.println("message from tear down" + throwable);
		} finally {

			if (browserName.contains("internet explorer")) {
				killIEServer();
				Common.pause(5);
			}
		}

	}

	public void analyzeLog() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}

	/**
	 * This method is killing the IE instance once test is completed. After
	 * killing IE instance it's also clear and kill the IE Server driver.
	 * 
	 */
	public void killIEServer() {
		try {

			Common.pause(5);

			String[] cmd = new String[3];
			cmd[0] = "cmd.exe";
			cmd[1] = "/C";
			cmd[2] = "taskkill /F /IM iexplore.exe";

			Process process = Runtime.getRuntime().exec(cmd);

			Process process1 = Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			System.err.println(process + "" + process1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */

	public void log(String msg) {

		System.out.println("======" + msg + "======");
		Reporter.log("<br>" + msg);
	}

	public void failedLog(String msg) {
		System.out.println("<strong>======" + msg + "======</strong>");
		Reporter.log("<font color=#FF0000>--Failed- </font>" + "<strong>======" + msg + "======</strong>");
	}

	public void testCaselog(String msg) {
		System.out.println("<strong>======" + msg + "======</strong>");
		Reporter.log("<br></br>" + "<strong>======" + msg + "======</strong>");
	}

	public void testInfoLog(String msg1, String msg2) {

		log("<strong>" + msg1 + " : </strong><font color=#9400D3>" + msg2 + "</font>&nbsp; <img src='" + userDir
				+ "\\report-imgs\\info.png' alt='info' height='15' width='15'/>");
	}

	public void testStepsLog(String msg) {
		System.out.println(msg);
		log(msg + "<br>");
	}

	public void testVerifyLog(String msg) {

		log("<font color=#000080>" + msg + "</font>");

	}

	public void testValidationLog(String msg) {

		log("Validation Message : <Strong><font color=#ff0000>" + msg + "</strong></font>");

	}

	public void testConfirmationLog(String msg) {

		log("Confirmation Message : <Strong><font color=#008000>" + msg + "</strong></font>");

	}

	public void testWarningLog(String msg) {

		log("Warning Message : <Strong><font color=#FF2070>" + msg + "</strong></font>&nbsp; <img src='" + userDir
				+ "\\report-imgs\\warning.png' alt='info' height='15' width='15'/>");

	}

	public static void timeTakenForStepLog(Instant start, Instant end) {
		String duration = Duration.between(start, end).toString();
		duration = duration.replaceAll("PT", "");
		System.out.println("<b>Time taken for step- </b>" + duration);
		Reporter.log("<br><b>Time taken for step- </b>" + duration);
	}

}
