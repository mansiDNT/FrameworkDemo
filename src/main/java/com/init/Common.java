package com.init;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Define Common Webdriver
 */
public class Common {

	public static  String userDir = System.getProperty("user.dir");
	 
	protected static Wait<WebDriver> wait;
	public static String alerttext;
	
	public static Instant getCurrentTime()
	{
		return Instant.now();
	}
	
	public static void getURL(WebDriver driver, String url)
	{
		
		driver.get(url);
		
	}
	
	/**
	 * Find web-element for given locator.
	 * 
	 * @param elementName
	 * @return
	 */
	public static WebElement findElement(WebDriver driver, String elementName) {

		String locator;

		locator = elementName;

		int count = 0;
		while (count < 4) {
			try {
				if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
					locator = locator.substring(5); // remove "link=" from
													// locator
					try {
						if (locator.contains(" "))
							return driver.findElement(By.partialLinkText(locator));

						return driver.findElement(By.linkText(locator));
					} catch (Exception e) {
						return null;
					}
				}
				if (locator.startsWith("id=")) {
					locator = locator.substring(3); // remove "id=" from locator
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("//")) {
					try {
						return driver.findElement(By.xpath(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("css=")) {

					locator = locator.substring(4); // remove "css=" from
													// locator
					try {
						return driver.findElement(By.cssSelector(locator));
					} catch (Exception e) {
						return null;
					}
				} else if (locator.startsWith("name=")) {

					locator = locator.substring(5); // remove "name=" from
													// locator
					try {
						return driver.findElement(By.name(locator));
					} catch (Exception e) {
						return null;
					}
				} else {
					try {
						return driver.findElement(By.id(locator));
					} catch (Exception e) {
						return null;
					}

				}
			} catch (StaleElementReferenceException e) {
				e.toString();

				count = count + 1;
				// System.out.println("Trying["+
				// count+"] to recover from a stale element :" +
				// e.getMessage());
			}
			count = count + 4;
		}
		return null;
	}
	
	public static void jsClick(WebDriver driver, WebElement element) {
		highlightElement(driver, element);
		System.out.println("============Apply NOw:::::::::Test::::::"+element.getText());
		((JavascriptExecutor) driver).executeScript(
				"return arguments[0].click();", element);
		// this.waitForAjax("0");
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void scrollToElementTillTrue(WebDriver driver, WebElement element)
	{
		pause(2);
		try {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",element);
		pause(8);
		}catch(Exception e) {
			System.out.println("e");
		}
	}
	
	public static void scrollScreen(WebDriver driver)
	{
		try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		}catch(Exception e) {
			
		}
	}

	public static void scrollToHorizontal(WebDriver driver, WebElement element) {

		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = element;

		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 50;
		for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {
			try {
				// this causes a gradual drag of the scroll bar, 10 units at a
				// time
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
						.moveByOffset(numberOfPixelsToDragTheScrollbarDown, 0).release().perform();
				Thread.sleep(1000L);
			} catch (Exception e1) {

			}
		}
	}

	/**
	 * Perform vertical scrolling
	 * 
	 * @param driver
	 * @param element
	 */
	public static void scrollToVertical(WebDriver driver, WebElement element) {

		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = element;

		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 50;
		for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {

			System.out.println("1");
			try {
				// this causes a gradual drag of the scroll bar, 10 units at a
				// time
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
						.moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release().perform();
				Thread.sleep(1000L);
			} catch (Exception e1) {

			}
		}

	}
	
	public static void scrollToTop(WebDriver driver) {
		
	((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
	}
	
	public static void enterDataIn(WebDriver driver, WebElement element, String search_phrase) {
		element.clear();
		element.sendKeys(search_phrase);
	}
	
	public static void type(WebDriver driver, WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}
	
	public static String getText(WebDriver driver, WebElement element) {
		
		return element.getText();
	}
	
	public static void clickOn(WebDriver driver, WebElement element) {
		highlightElement(driver, element);
		Common.pause(1);
		element.click();
	}

	public static void highlightElement(WebDriver driver, WebElement element) {
		/*
		 * for (int i = 0; i < 2; i++) { JavascriptExecutor js =
		 * (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
		 * element, "color: yellow; border: 2px solid yellow;");
		 * js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
		 * element, ""); }
		 */

		// draw a border around the found element

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '3px solid yellow'", element);

		pause(2);

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border = '0px'", element);
	}

	public static void refreshPage(WebDriver driver)
	{
		Instant start = Common.getCurrentTime();
		driver.navigate().refresh();
		Instant end = Common.getCurrentTime();
		SeleniumInit.timeTakenForStepLog(start, end);
	}
	
	public static void waitForPageLoaded(WebDriver driver) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

	public static boolean visibilityOfElementLocated(WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean waitforElementClickable(WebDriver driver,WebElement element,  int timeoutInSeconds)
	{
		try{
		WebDriverWait wait= new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		highlightElement(driver, element);
		return true;
		}
		catch(TimeoutException | NoSuchElementException e )
		{
			System.out.println(e);
			return false;
		}
	}
	
	public static boolean invisibilityOfElementLocated(WebDriver driver, By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			return true;
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Pauses for given seconds.
	 * 
	 * @param secs
	 */
	public static void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {

		}
	}

	public static void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public static void switchToSecondTab(WebDriver driver) {
		
		Common.pause(5);
		for(String handle: driver.getWindowHandles())
		{
			if(!handle.equals(driver.getWindowHandle()))
			{
				driver.switchTo().window(handle);
			}
		}
	}
	
	public static void SwitchtoTab(WebDriver driver,int tabNumber)
	 {
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(tabNumber));
	 }
	
    public static void switchToFirstTab(WebDriver driver) {
		
		Common.pause(5);
		ArrayList<String> handles = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(handles.get(0));
		
	}

	/**
	 * Gets current time in the following format Month, Date, Hours, Minutes,
	 * Seconds, Millisecond.
	 * 
	 * @return Current date.
	 */
	public static String getCurrentTimeStampString() {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("ddMMYYYY_HH-mm-ss");
		TimeZone timeZone = TimeZone.getDefault();
		Calendar cal = Calendar.getInstance(new SimpleTimeZone(timeZone.getOffset(date.getTime()), "GMT"));
		sd.setCalendar(cal);
		return sd.format(date);
	}

	public static String getTodaysDate()
	{
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("ddMMYYYY");
		return sd.format(date);
	}
	
	public static String getDayBeforeYesterday()
	{
		SimpleDateFormat sd = new SimpleDateFormat("ddMMYYYY");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		return sd.format(cal.getTime());
		
	}
	
	public static void deleteDirectory(File file)
    {
        // store all the paths of files and folders present
        // inside directory
        for (File subfile : file.listFiles()) {
  
            // if it is a subfolder,e.g Rohan and Ritik,
            // recursiley call function to empty subfolder
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
  
            // delete files and empty subfolders
            subfile.delete();
        }
    }
	
	/**
	 * Takes screenshot and adds it to TestNG report.
	 * 
	 * @param driver
	 *            WebDriver instance.
	 */
	public static void makeScreenshot(WebDriver driver, String screenshotName) {
	
		
		// TODO code application logic here
        // File (or directory) to be moved
		// store file path
        String filepath = userDir +"\\test-output\\screenshots";
        
        File file = new File(filepath);
  
        // call deleteDirectory function to delete
        // subdirectory and files
        deleteDirectory(file);
  
        // delete main GFG folder
        file.delete();
		
		WebDriver augmentedDriver = new Augmenter().augment(driver);

		/* Take a screenshot */
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		
		String nameWithExtention = screenshotName + ".png";

		/* Copy screenshot to specific folder */
		try {
			/*
			 * String reportFolder = "target" + File.separator +
			 * "failsafe-reports" + File.separator + "firefox" + File.separator;
			 */
			String reportFolder = "test-output" + File.separator;
			String screenshotsFolder = "screenshots";
			File screenshotFolder = new File(reportFolder + screenshotsFolder);
			if (!screenshotFolder.getAbsoluteFile().exists()) {
				screenshotFolder.mkdir();
			}
			FileUtils.copyFile(screenshot,
					new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
		} catch (IOException e) {
			log("Failed to capture screenshot: " + e.getMessage());
		}
		log("<br><b>Screenshot- </b>" + getScreenshotLink(nameWithExtention, nameWithExtention)); // add
																		// screenshot
																		// link
																		// to
																		// the
																		// report
	}
	
	public static double roundTo2DecimalPlaces(double value)
	{
		return Math.round(value * 100.0)/100.0;
	}
	
	public static String doubleToStringUpto2DecimalPlaces(double value)
	{
		DecimalFormat format = new DecimalFormat("#0.00");
		return format.format(value);
	}

	public  static File getLatestFilefromDir(){
	    File dir = new File(SeleniumInit.downloads_folder_path);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	    
	/**
	 * Log given message to Reporter output.
	 * 
	 * @param msg
	 *            Message/Log to be reported.
	 */
	public static void log(String msg) {

		System.out.println(msg);
		Reporter.log(msg);
	}

	/**
	 * Generates link for TestNG report.
	 * 
	 * @param screenshot_name
	 *            Screenshot name.
	 * @param link_text
	 *            Link text.
	 * @return Formatted link for TestNG report.
	 */
	public static String getScreenshotLink(String screenshot_name, String link_text) {

		return "<a href='../test-output/screenshots/" + screenshot_name + "' target='_new'>" + link_text + "</a>";
	}

	public static void logStatus(String Status) {
		if (Status.equalsIgnoreCase("Pass")) {
			log("<br><Strong><font color=#008000>Pass</font></strong></br>");
		} else if (Status.equalsIgnoreCase("Fail")) {
			log("<br><Strong><font color=#FF0000>Fail</font></strong></br>");

		}
	}

	/**
	 * Get random numeric of given lenth.
	 * 
	 * @param length
	 *            desired length.
	 * @return
	 */
	// will return number between 1 and length (both inclusive)
	public static int randomNumericValueGenerate(int length) {

		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(length);
		return (randomInt + 1);
	}
	
	public static int[] randomNumericValuesGenerate(int length, int count) {

		Random randomGenerator = new Random();

		int[] randomInts = randomGenerator.ints(1, (length + 1)).distinct().limit(count).toArray();
		return randomInts;
	}

	public static String randomStringGenerate() {

		int length = randomNumericValueGenerate(10);
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
	}
	
	public static String getUUID()
	{
		return UUID.randomUUID().toString();		
	}
	/**
	 * Select Random String From Combobox.
	 * 
	 * @param by
	 * @param driver
	 * @return selected random string
	 * @throws InterruptedException
	 */
	public static String selectRandomOptionFromCombo(WebDriver driver, WebElement selectCombo) throws InterruptedException {
		String selectedOption = "";
		Thread.sleep(2);
		List<WebElement> getAllOption = selectCombo.findElements(By.xpath("option"));
		ArrayList<String> arrayOfAllOption = new ArrayList<String>();
		for (WebElement ele : getAllOption) {
			if (!ele.getText().startsWith("All")) {
				arrayOfAllOption.add(ele.getText());
			}

		}
		int index = new Random().nextInt(arrayOfAllOption.size());
		if (Integer.signum(index) == -1) {
			index = -index;
			// index=Math.abs(index);
		}
		selectedOption = arrayOfAllOption.get(index);
		System.out.println("Selected Option Is---->" + selectedOption);
		return selectedOption;
	}

	/**
	 * Select data form dropdown or combobox by visible element
	 * 
	 * @param element
	 * @param value
	 */
	public static void selectFromComboByVisibleElement(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void setScriptProperty(String key, String value)
	{
		
		FileInputStream input = null;
		OutputStream output = null;
		
		try {
			input = new FileInputStream(SeleniumInit.test_data_folder_path + File.separator + "script.properties");
			Properties prop = new Properties();
			prop.load(input);
			input.close();	
			
			output = new FileOutputStream(SeleniumInit.test_data_folder_path + File.separator + "script.properties");
			// set the properties value
			prop.setProperty(key, value);
			// save properties to project root folder
			prop.store(output, null);
			output.close();
			
			
		} catch (IOException io) {
			io.printStackTrace();
		} 
		
		finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	}
	
	public static String getScriptProperty(String key)
	{
		Properties prop = new Properties();
		InputStream input = null;
		String value = "VALUE NOT OBTAINED";
		try {

			input = new FileInputStream(SeleniumInit.test_data_folder_path + File.separator + "script.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			  value = prop.getProperty(key);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return value;

	  }
	
	
	public static String getRandomColorCode()
	{
		Random random = new Random();
        int nextInt = random.nextInt(256*256*256);
        String colorCode = String.format("#%06x", nextInt);
        return colorCode;
	}

	public static int getNumberFromString(String input_string) {
		input_string = input_string.replaceAll("[^0-9]", "");
		return Integer.parseInt(input_string);
	}

	public static long getLongNumberFromString(String input_string)
	{
		input_string = input_string.replaceAll("[^0-9]", "");
		return Long.parseLong(input_string);
	}
	public static double getDoubleFromString(String input_string)
	{
		input_string = input_string.replaceAll("[^0-9.]", "");
		return Double.parseDouble(input_string);
	}
	
	public static void saveScreenshot(WebDriver driver, String testName)
	{
		String test_case_number = Integer.toString(Common.getNumberFromString(testName));
		String screenshotName = "TC" + test_case_number +  "_" + Common.getCurrentTimeStampString();
		Common.makeScreenshot(driver, screenshotName);
	}
	
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}
	
	public static void waitForElement(WebDriver driver,WebElement webelement) {
		  (new WebDriverWait(driver, 35)).until(ExpectedConditions
		    .visibilityOf(webelement));
		 }
	
	public static void clickableElement(WebElement webelement, WebDriver driver) 
	{
		//long starttime=System.currentTimeMillis();
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(webelement));
		//long endtime=System.currentTimeMillis()-starttime;
		/*SeleniumInit.ExplicitWait=SeleniumInit.ExplicitWait+endtime;
		System.out.println(" clickable Element (By element) wait --> "+SeleniumInit.ExplicitWait);*/
	}
	
	public static void PresenceOfElement(By locator, WebDriver driver) 
	{
		//long starttime=System.currentTimeMillis();
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(locator));
		//long endtime=System.currentTimeMillis()-starttime;
		/*SeleniumInit.ExplicitWait=SeleniumInit.ExplicitWait+endtime;
		System.out.println(" Presence of Element wait --> "+SeleniumInit.ExplicitWait);*/
	}
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow Row;
	// Data provider
	@SuppressWarnings("unchecked")
	public static <UnicodeString> UnicodeString getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if (dataType == 3) {
				return (UnicodeString) "";
			} else {
				DataFormatter formatter = new DataFormatter();
				UnicodeString Data = (UnicodeString) formatter.formatCellValue(Cell);
				return Data;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
	public static String getCellValue(String sheet,int i , int j)
	{
		String ser=null;
		try {
			FileInputStream ExcelFile = new FileInputStream(userDir + "\\test_data\\Credentials.xlsx");
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheet);
			ser = getCellData(i, j);
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ser;
	}
}
