package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.init.SeleniumInit;

public class AnOrdersIndex extends SeleniumInit{
	
	int stepCount = 1;
	int extentStepCount =1;
	
	@Test
	public void Orders() throws Exception
	{
		testStepsLog("Step " + (stepCount++) + " : Click on Hello sign in.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Hello sign in.");
		AnordersVerificationPage = AnordersIndexPage.clickOnHellosignin();
		
		testStepsLog("Step " + (stepCount++) + " : Enter mobile number.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
		AnordersVerificationPage = AnordersIndexPage.enterMobilenum("9972024124"); 
		extentTest.log(Status.PASS, "Mobile number entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Continue button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Continue button.");
		AnordersVerificationPage = AnordersIndexPage.clickOncontinue();
		
		testStepsLog("Step " + (stepCount++) + " : Enter Password.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Password.");
		AnordersVerificationPage = AnordersIndexPage.enterpassword("ama@2022");
		extentTest.log(Status.PASS, "Password entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Sign in button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign in button.");
		AnordersVerificationPage = AnordersIndexPage.clickOnsignin();
		boolean errorMessage= AnordersVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
		
		testStepsLog("Step " + (stepCount++) + " : Click on Orders.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Orders.");
		AnordersVerificationPage = AnordersIndexPage.clickOnorders();
		boolean errorMessag= AnordersVerificationPage.SuccessfulOrders();
		Assert.assertTrue(errorMessag,"Orders history not working");
	
	}

}
