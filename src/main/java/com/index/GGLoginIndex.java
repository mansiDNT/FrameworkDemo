package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.indexPage.GGLoginIndexPage;
import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;
import com.verificationPage.GGLoginVerificationPage;

public class GGLoginIndex extends SeleniumInit{

	int stepCount = 1;
	int extentStepCount = 1;
	
	@Test
	public void login()
	{
		
		testStepsLog("Step " + (stepCount++) + " : Click on log your self link.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on login link.");
		LoginverificationPage = LoginINdexPage.clickonlogyourselflink(); 
		
		testStepsLog("Step " + (stepCount++) + " : Enter email address.");		
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter emailaddress.");			
		LoginverificationPage = LoginINdexPage.enteremail(Common.getCellValue("Sheet1",2,0));
		test.log(LogStatus.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Sheet1",2,0));
				
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");			
		LoginverificationPage = LoginINdexPage.enterpass(Common.getCellValue("Sheet1",2,1));
		test.log(LogStatus.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Sheet1",2,1));
				
		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Sign In button.");
		LoginverificationPage = LoginINdexPage.signINbtn();
		
		testStepsLog("Step " + (stepCount++) + " : Click on logoff link.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on logoff link.");
		LoginverificationPage = LoginINdexPage.Clickonlogofflink();
		
		testStepsLog("Step " + (stepCount++) + " : Click on continue button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on continue button.");
		LoginverificationPage = LoginINdexPage.ClickonconINbtn();
				
		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean sucessmesg = LoginverificationPage.verifyLogin();
		Assert.assertTrue(sucessmesg,"Login is successful.");
				
		}
		
	}

