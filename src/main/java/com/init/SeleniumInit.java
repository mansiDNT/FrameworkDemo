package com.init;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.indexPage.LoginIndexPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.verificationPage.LoginVerificationPage;

public class SeleniumInit {

	
	public static int note_data = 0;
	public static String suiteName = "";
	public static String testName = "";

	/* Minimum requirement for test configuration */

	public  static String testUrl; // Test url
	protected  static String seleniumHub; // Selenium hub IP
	protected static String seleniumHubPort; // Selenium hub port
	protected static  String targetBrowser; // Target browser
	protected static String test_data_folder_path = null;
	protected static String screenshot_folder_path = null; // Path to screenshot folder
	protected static String downloads_folder_path = null;
	public static String currentWindowHandle = "";// Get Current Window handle
	public static String browserName = "";
	public static String osName = "";
	public static String browserVersion = "";
	public static  String userDir = System.getProperty("user.dir");
	public static String comonTemplateName = "";
	public static String constant_grfpTemplateName = "";
	public static HashMap<String,String> globalMap=new HashMap<String,String>();
	public static ArrayList<String> arrayList=new ArrayList<String>();

	
	public String currentTest; // current running test

	protected static Logger logger = Logger.getLogger("testing");
	public WebDriver driver;

	InputStream input = null;
	public static Properties config_properties = new Properties();
	
	public static ExtentTest extentTest;

	static ExtentReports report;
	
	/* Page's declaration */

//	public  TemplateIndexPage templateIndexPage;
//	public  TemplateVerificationPage templateVerificationPage;
//	
	public  LoginIndexPage loginIndexPage;
	public  LoginVerificationPage loginVerificationPage;
//	
//	public  DashboardIndexPage dashboardIndexPage;
//	public  DashboardVerificationPage dashboardVerificationPage;
//	
//	public  RFPIndexPage rfpIndexPage;
//	public  RFPVerificationPage rfpVerificationPage;

	/**
	 * Fetches suite-configuration from XML suite file.
	 * 
	 * @param testContext
	 */

	
	@BeforeSuite(alwaysRun = true)
	 protected void fetchSuiteConfiguration(ITestContext testContext) {
		

		// Pass the URL to be tested
		testUrl = testContext.getCurrentXmlTest().getParameter("selenium.url");
		// testUrl = TestData.getURL();
		System.out.println("Before suite");
		System.out.println("======" + testUrl + "=========");
		
		report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		//report.config().reportName("Final Report");

	}
	private ExtentTest getNewTest(String testName) {
		return report.startTest(testName);
	}
	
	private ExtentTest getNewTest(String testName, String description) {
		return report.startTest(testName, description);
	}


	/*
	 * @BeforeSuite public void testPrint() { System.out.println("Before suite");
	 * report = new
	 * ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
	 * test = report.startTest("ExtentDemo"); }
	 */
	

	@AfterSuite
	public void testResults() {

		// System.out.println("The passed tests - " + passed_count);
		// System.out.println("The failed tests - " + failed_count);
		// System.out.println("The skipped tests - " + skipped_count);
		try {
			Common.ExcelWBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		report.flush();

	}
	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@BeforeTest
	public void one(ITestContext testContext)
	{
		seleniumHub = testContext.getCurrentXmlTest().getParameter("selenium.host");
		seleniumHubPort = testContext.getCurrentXmlTest().getParameter("selenium.port");
	}
	
		@BeforeMethod(alwaysRun = true)
		public void setUp(Method method, ITestContext testContext) throws IOException, InterruptedException {
			
	    targetBrowser = testContext.getCurrentXmlTest().getParameter("selenium.browser");
		currentTest = testContext.getCurrentXmlTest().getName(); // get Name of current test.
		
		log("current test- " +currentTest);
		extentTest = getNewTest(currentTest);
		
		String SCREENSHOT_FOLDER_NAME = "screenshots";
		String TESTDATA_FOLDER_NAME = "test_data";
		String DOWNLOADS_FOLDER_NAME = "downloads";

		test_data_folder_path = new File(TESTDATA_FOLDER_NAME).getAbsolutePath();
		screenshot_folder_path = new File(SCREENSHOT_FOLDER_NAME).getAbsolutePath();
		downloads_folder_path = new File(DOWNLOADS_FOLDER_NAME).getAbsolutePath();
		
		//load the properties file from test_data folder
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
			URL remote_grid;
			try {
				remote_grid = new URL("http://" + seleniumHub + ":" + seleniumHubPort + "/wd/hub");
			
			if (targetBrowser == null || targetBrowser.contains("firefox")) {

				File file = new File(userDir + "//lib//geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());

				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("browser.download.folderList",2);
				profile.setPreference("browser.download.manager.showWhenStarting",false);
				profile.setPreference("browser.download.dir",downloads_folder_path);
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
				

				//driver = new RemoteWebDriver(remote_grid, capability);
				 this.driver = new FirefoxDriver(capability);

				System.out.println("=========" + " Mozilla Firefox Browser " + "==========");

			} else if (targetBrowser.contains("chrome")) {

				capability = DesiredCapabilities.chrome();
				/*LoggingPreferences loggingprefs = new LoggingPreferences();
		        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);
		        capability.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);*/
				//File file = new File(userDir + "//lib//chromedriver.exe");
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
				
			//	driver = new RemoteWebDriver(remote_grid, options);
				this.driver = new ChromeDriver(capability);

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
				//driver = new RemoteWebDriver(remote_grid, capability);
				this.driver = new InternetExplorerDriver(capability);

				System.out.println("=========" + " Internet Explorer Browser " + "==========");

			} else if (targetBrowser.contains("safari")) {

				capability = DesiredCapabilities.safari();

				capability.setJavascriptEnabled(true);
				capability.setBrowserName("safari");

				browserName = capability.getBrowserName();
				osName = capability.getPlatform().name();
				browserVersion = capability.getVersion();

				this.driver = new SafariDriver(capability);
				
				/*
			    final String AUTOMATE_USERNAME = "mansidelhiwala_KNRX4S";

                final String AUTOMATE_ACCESS_KEY = "rmnN3SCypjmPsKykq4Kc";

                final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

             

                  DesiredCapabilities caps = new DesiredCapabilities();

                  caps.setCapability("os_version", "Big Sur");

                  caps.setCapability("resolution", "1920x1080");

                  caps.setCapability("browser", "Safari");

                  caps.setCapability("browser_version", "14.1");

                  caps.setCapability("os", "OS X");

                  caps.setCapability("name", "BStack-[Java] Sample Test"); // test name

                  caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
                  
                  caps.setCapability("browserstack.video", "true");
                  caps.setCapability("browserstack.debug", "true");
                  caps.setCapability("browserstack.console", "info");

                   this.driver = new RemoteWebDriver(new URL(URL), caps);*/

				System.out.println("=========" + " Safari Browser " + "==========");

			} 
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.get(testUrl);

			driver.manage().window().maximize();

			Common.waitForPageLoaded(driver);
			// Common.setConfigDate(driver);

			currentWindowHandle = driver.getWindowHandle();

			System.out.println("Current Window Handle ID:--->" + currentWindowHandle);

			// Page Object Initialization According To Its Test Suite.
//			templateIndexPage = new TemplateIndexPage(driver);
//			templateVerificationPage = new TemplateVerificationPage(driver);
//			
			loginIndexPage = new LoginIndexPage(driver);
			loginVerificationPage = new LoginVerificationPage(driver);
//			
//			dashboardIndexPage = new DashboardIndexPage(driver);
//			dashboardVerificationPage = new DashboardVerificationPage(driver);
//			
//			rfpIndexPage = new RFPIndexPage(driver);
//			rfpVerificationPage = new RFPVerificationPage(driver);
			
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
						//tackTrace(exception, true)[0];
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(str);
				String firstLine = scanner.nextLine();
				log("<Strong><font color=#ff0000>" + firstLine + "</font></strong>");
			}
		}
	}

	/*
	 * @AfterMethod public void takeScreenShotOnFailure(ITestResult testResult)
	 * throws IOException { if (testResult.getStatus() == ITestResult.FAILURE) {
	 * File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * File screenshotName = new
	 * File("errorScreenshots\\" + testResult.getName() +  ".jpg");
	 * FileUtils.copyFile(scrFile, screenshotName);
	 * 
	 * // Reporter.log("<br><img src='"
	 * +screenshotName+"' height='300' width='300'/><br>"); } }
	 */
	
	/**
	 * After Method
	 * 
	 * @param testResult
	 */
	 public static int passed_count = 0;
	    public static int failed_count = 0;
		public static int skipped_count = 0;
 
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws Exception {
		
		
		ITestContext ex = testResult.getTestContext();

		if(testResult.getStatus() == ITestResult.SUCCESS)
	    {
			passed_count++;
	       
	    }

	    else if(testResult.getStatus() == ITestResult.FAILURE)
	    {
	    	failed_count++;  
	    	extentTest.log(LogStatus.FAIL, this.getClass().getSimpleName() + testResult.getThrowable());
            String screenshotPath = Common.getScreenhot(driver, testResult.getName());
            //To add it in the extent report 
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));


	    }

	     else if(testResult.getStatus() == ITestResult.SKIP )
	     {	 
	    	 skipped_count++;

	     }
		try {
			testName = testResult.getName();
			if (!testResult.isSuccess()) {

				//Common.saveScreenshot(driver, currentTest);
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

			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();

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
	 * This method is killing the IE instance once test is completed. After killing
	 * IE instance it's also clear and kill the IE Server driver.
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

	public void failedLog(String msg)
	{
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

	public static void timeTakenForStepLog(Instant start, Instant end)
	{
		String duration = Duration.between(start, end).toString();
		duration = duration.replaceAll("PT", "");
		System.out.println("<b>Time taken for step- </b>" + duration);
		Reporter.log("<br><b>Time taken for step- </b>" + duration);
	}
	
	/**
	 * Log success message to Reporter output.
	 * 
	 */

	/*public static void success() {

		System.out.println("<Strong><font color=#008000>Pass</font></strong>");
		Reporter.log("<br></br><Strong><font color=#008000>Pass                  </font></strong><img src='" + userDir
				+ "\\report-imgs\\pass.png' alt='pass' height='15' width='15'/>");
	}

	*//**
	 * Log failure message to Reporter output.
	 * 
	 *//*

	public static void failure() {

		System.out.println("<Strong><font color=#ff0000>Fail</font></strong>");
		Reporter.log("<br></br><Strong><font color=#ff0000>Fail                  </font></strong><img src='" + userDir
				+ "\\report-imgs\\fail.png' alt='fail' height='15' width='15'/>");
	}*/

	
}
