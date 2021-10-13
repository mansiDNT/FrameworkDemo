package com.index;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;


public class LoginIndex extends SeleniumInit {
	 
		int stepCount = 1;
		int extentStepCount =1;
	@Test
	public void login() throws Exception
	{
		 System.out.println("Username is  :" + Common.getCellValue("Sheet1",1,0));
    	 System.out.println("Password is : " + Common.getCellValue("Sheet1",1,1));
   
    	 System.out.println(Common.getCellValue("Sheet1",1,0));
    	 System.out.println(Common.getCellValue("Sheet1",1,1));
		
		//login button disabled
		testStepsLog("Step " + (stepCount++) + " : Enter username.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter username.");
	//	loginVerificationPage = loginIndexPage.enterEmail((Common.getCellValue("Sheet1",1,0)).toString());
		loginVerificationPage = loginIndexPage.enterEmail("qbankadmin");
		extentTest.log(LogStatus.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step" + (stepCount++) + " : Enter password.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");
	//	loginVerificationPage = loginIndexPage.enterPassword((Common.getCellValue("Sheet1",1,0)).toString());
	//	loginVerificationPage = loginIndexPage.enterEmail((Common.getCellValue("Sheet1",1,0)).toString());
		loginVerificationPage = loginIndexPage.enterPassword("pass123");
		extentTest.log(LogStatus.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Sign In button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();
		
		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean errorMessage= loginVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
		
	}
	
	@Test
	public void login_negative() throws Exception
	{
		 System.out.println("Username is: " + Common.getCellValue("Sheet1",1,0));
    	 System.out.println("Password is: " + Common.getCellValue("Sheet1",1,1));
    	 
		
		//login button disabled
		testStepsLog("Step " + (stepCount++) + " : Enter username.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter username.");
		//loginVerificationPage = loginIndexPage.enterEmail(Common.getCellValue("Sheet1",1,0));
		loginVerificationPage = loginIndexPage.enterEmail("qbankadmin");
		extentTest.log(LogStatus.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");
	//	loginVerificationPage = loginIndexPage.enterPassword(Common.getCellValue("Sheet1",1,0));
		loginVerificationPage = loginIndexPage.enterPassword("pass123");
		extentTest.log(LogStatus.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		extentTest.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Sign In button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();
		
		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean errorMessage= loginVerificationPage.verifyNegativeLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
	}
}
