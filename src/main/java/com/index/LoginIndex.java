package com.index;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.init.Common;
import com.init.SeleniumInit;


public class LoginIndex extends SeleniumInit {
	 
		int stepCount = 1;
		int extentStepCount =1;
	@Test
	public void login() throws Exception
	{
		 System.out.println("Username is:" + Common.getCellValue("Sheet1",1,0));
    	 System.out.println("Password is : " + Common.getCellValue("Sheet1",1,1));
   
    	 System.out.println(Common.getCellValue("Sheet1",1,0));
    	 System.out.println(Common.getCellValue("Sheet1",1,1));
		
		//login button disabled
		testStepsLog("Step " + (stepCount++) + " : Enter username.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter username.");
	//	loginVerificationPage = loginIndexPage.enterEmail((Common.getCellValue("Sheet1",1,0)).toString());
		loginVerificationPage = loginIndexPage.enterEmail("qbankadmin");
		extentTest.log(Status.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter password.");
	//	loginVerificationPage = loginIndexPage.enterPassword((Common.getCellValue("Sheet1",1,0)).toString());
	//	loginVerificationPage = loginIndexPage.enterEmail((Common.getCellValue("Sheet1",1,0)).toString());
		loginVerificationPage = loginIndexPage.enterPassword("pass123");
		extentTest.log(Status.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign In button.");
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
		extentTest1.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter username.");
		//loginVerificationPage = loginIndexPage.enterEmail(Common.getCellValue("Sheet1",1,0));
		loginVerificationPage = loginIndexPage.enterEmail("qbankadmin");
		extentTest1.log(Status.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		extentTest1.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter password.");
	//	loginVerificationPage = loginIndexPage.enterPassword(Common.getCellValue("Sheet1",1,0));
		loginVerificationPage = loginIndexPage.enterPassword("pass123");
		extentTest1.log(Status.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Sheet1",1,0));
		
		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		extentTest1.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign In button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();
		
		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean errorMessage= loginVerificationPage.verifyNegativeLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
	}
}
