package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.init.Common;
import com.init.SeleniumInit;


public class AnLoginIndex extends SeleniumInit{
	
	int stepCount = 1;
	int extentStepCount =1;
	
@Test
public void login() throws Exception
{
	
	testStepsLog("Step " + (stepCount++) + " : Click on Hello sign in.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Hello sign in.");
	AnloginVerificationPage = AnloginIndexPage.clickOnHellosignin();
	
	testStepsLog("Step " + (stepCount++) + " : Enter mobile number.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
	AnloginVerificationPage = AnloginIndexPage.enterMobilenum("9972024124"); 
	extentTest.log(Status.PASS, "Mobile number entered correctly" );
	
	testStepsLog("Step " + (stepCount++) + " : Click on Continue button.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Continue button.");
	AnloginVerificationPage = AnloginIndexPage.clickOncontinue();
	
	testStepsLog("Step " + (stepCount++) + " : Enter Password.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Password.");
	AnloginVerificationPage = AnloginIndexPage.enterpassword("ama@2022");
	extentTest.log(Status.PASS, "Password entered correctly" );
	
	testStepsLog("Step " + (stepCount++) + " : Click on Sign in button.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign in button.");
	AnloginVerificationPage = AnloginIndexPage.clickOnsignin();
	boolean errorMessage= AnloginVerificationPage.verifySuccessfulLogin();
	Assert.assertTrue(errorMessage,"Login is not successful.");

}

@Test
public void login_negative() throws Exception
{
	testStepsLog("Step " + (stepCount++) + " : Click on Hello sign in.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Hello sign in.");
	AnloginVerificationPage = AnloginIndexPage.clickOnHellosignin();
	
	testStepsLog("Step " + (stepCount++
			) + " : Enter mobile number.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
	AnloginVerificationPage = AnloginIndexPage.enterMobilenum("9972024124"); 
	extentTest.log(Status.PASS, "Mobile number entered correctly" );
	
	testStepsLog("Step " + (stepCount++) + " : Click on Continue button.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Continue button.");
	AnloginVerificationPage = AnloginIndexPage.clickOncontinue();
	
	testStepsLog("Step " + (stepCount++) + " : Enter Password.");
	extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Password.");
	AnloginVerificationPage = AnloginIndexPage.enterpassword("ama@2022");
	extentTest.log(Status.PASS, "Password entered correctly" );
	
	testStepsLog("Step " + (stepCount++) + " : Click on Sign in button.");
	extentTest1.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign in button.");
	AnloginVerificationPage = AnloginIndexPage.clickOnsignin();
	boolean errorMessage= AnloginVerificationPage.verifyNegativeLogin();
	Assert.assertTrue(errorMessage,"Login is not successful.");

}
}
