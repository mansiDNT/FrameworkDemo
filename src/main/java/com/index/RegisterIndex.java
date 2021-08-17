package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterIndex extends SeleniumInit {

	int stepCount = 1;
	int extentStepCount =1;
	
	@Test
	public void EmalilExist() throws Exception
	{
			
		testStepsLog("Step " + (stepCount++) + " : Click on Register now link.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Register now link.");
		registerVerificationPage = RegisterindexPage.Clickonregisternow();
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter email address.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter email address.");
		registerVerificationPage = RegisterindexPage.enteremail(Common.getCellValue("CreateAccount",1,0));
		test.log(LogStatus.PASS, "Entered email correctly.Entered email is : "+Common.getCellValue("CreateAccount",1,0));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Verify 'EmailExist' is successful showing.");
		boolean errorMessage= registerVerificationPage.VerifyEmailExist();
		Assert.assertTrue(errorMessage,"Email already exist. validation message showing");
		test.log(LogStatus.PASS, "Validationn message showing ");		
				
	}
	
	@Test
	public void RegisterAccount() throws Exception
	{
		
		testStepsLog("Step " + (stepCount++) + " : Click on Register now link.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Register now link.");
		registerVerificationPage = RegisterindexPage.Clickonregisternow();
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter new email address.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter new email address.");
		registerVerificationPage = RegisterindexPage.enteremail(Common.getCellValue("CreateAccount",1,8));
		test.log(LogStatus.PASS, "Entered email correctly.Entered email is : "+Common.getCellValue("CreateAccount",1,8));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on get started link.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on get started link.");
		registerVerificationPage = RegisterindexPage.ClickonGetstarted();
		Thread.sleep(4000);
		
		testStepsLog("Step " + (stepCount++) + " : Select pro plan.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on pro plan.");
		registerVerificationPage = RegisterindexPage.Clickonfreeplan();
		Thread.sleep(4000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on save and continue.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on save and continue button.");
		registerVerificationPage = RegisterindexPage.ClickonSaveContinue();
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter name.");
		registerVerificationPage = RegisterindexPage.enterName(Common.getCellValue("CreateAccount",1,1));
		test.log(LogStatus.PASS, "Enter email is : "+Common.getCellValue("CreateAccount",1,1));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter company name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter company name.");
		registerVerificationPage = RegisterindexPage.enterCompanyName(Common.getCellValue("CreateAccount",1,2));
		test.log(LogStatus.PASS, "Entered company name is : "+Common.getCellValue("CreateAccount",1,2));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter job title.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter job title.");
		registerVerificationPage = RegisterindexPage.enterJobTitle(Common.getCellValue("CreateAccount",1,3));
		test.log(LogStatus.PASS, "Entered job title is : "+Common.getCellValue("CreateAccount",1,3));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on timezone.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on timezone.");
		registerVerificationPage = RegisterindexPage.Clickontimezone();
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : select timezone.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Select timezone.");
		registerVerificationPage = RegisterindexPage.selectTimezone();
		Thread.sleep(5000);
		
		RegisterindexPage.scrollBackBtn();
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter mobile number.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
		registerVerificationPage = RegisterindexPage.enterMobileNo(Common.getCellValue("CreateAccount",1,4));
		test.log(LogStatus.PASS, "Entered mobile number is : "+Common.getCellValue("CreateAccount",1,4));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on country field.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on country field.");
		registerVerificationPage = RegisterindexPage.Clickoncountry();
		Thread.sleep(4000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter country name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter country name.");
		registerVerificationPage = RegisterindexPage.searchcountyr(Common.getCellValue("CreateAccount",1,7));
		test.log(LogStatus.PASS, "Entered country name is : "+Common.getCellValue("CreateAccount",1,7));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Select country name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Select country name.");
		registerVerificationPage = RegisterindexPage.clickselectedcountry();
		Thread.sleep(5000);
		
		/*testStepsLog("Step " + (stepCount++) + " : Click on search country name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on selected country.");
		registerVerificationPage = RegisterindexPage.clickselectedcountry();
		Thread.sleep(2000);
		*/
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter country name.");
		registerVerificationPage = RegisterindexPage.enterPassword(Common.getCellValue("CreateAccount",1,5));
		test.log(LogStatus.PASS, "Entered country name is : "+Common.getCellValue("CreateAccount",1,5));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter password confirmation.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password confirmation.");
		registerVerificationPage = RegisterindexPage.enterconfirmpwd(Common.getCellValue("CreateAccount",1,5));
		test.log(LogStatus.PASS, "Entered country name is : "+Common.getCellValue("CreateAccount",1,5));
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on save and continue.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on save and continue button.");
		registerVerificationPage = RegisterindexPage.ClickonSaveContinue();
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on create account button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on create account button.");
		registerVerificationPage = RegisterindexPage.ClickonCreateAccount();
		Thread.sleep(5000);
		
		testStepsLog("Step " + (stepCount++) + " : Verify account created sucessfully or not.");
		boolean sucessmsg= registerVerificationPage.SucessfullyRegister();
		Assert.assertTrue(sucessmsg,"Account Created sucessfully.");
		Thread.sleep(3000);
	}
	
}
