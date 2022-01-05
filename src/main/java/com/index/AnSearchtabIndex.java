package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.init.Common;
import com.init.SeleniumInit;


public class AnSearchtabIndex extends SeleniumInit{
	
	int stepCount = 1;
	int extentStepCount =1;
	
	@Test
	public void Searchtab() throws Exception
	{
		
		testStepsLog("Step " + (stepCount++) + " : Click on Hello sign in.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Hello sign in.");
		loginVerificationPage = loginIndexPage.clickOnHellosignin();
		
		testStepsLog("Step " + (stepCount++
				) + " : Enter mobile number.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
		loginVerificationPage = loginIndexPage.enterMobilenum("9972024124"); 
		extentTest.log(Status.PASS, "Mobile number entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Continue button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Continue button.");
		loginVerificationPage = loginIndexPage.clickOncontinue();
		
		testStepsLog("Step " + (stepCount++) + " : Enter Password.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Password.");
		loginVerificationPage = loginIndexPage.enterpassword("ama@2022");
		extentTest.log(Status.PASS, "Password entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Sign in button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign in button.");
		loginVerificationPage = loginIndexPage.clickOnsignin();
		boolean errorMessage= loginVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
		
		testStepsLog("Step " + (stepCount++) + " : Click on Orders.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Orders.");
		loginVerificationPage = loginIndexPage.clickOnorders();
		boolean errorMessag= loginVerificationPage.SuccessfulOrders();
		Assert.assertTrue(errorMessag,"Orders history not working");
		
		testStepsLog("Step " + (stepCount++) + " : Enter Search item.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Search item.");
		loginVerificationPage = loginIndexPage.searchtab("suit");
		extentTest.log(Status.PASS, "Search item entered correctly" );
		
		
		testStepsLog("Step " + (stepCount++) + " : Click on Orders.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Orders.");
		loginVerificationPage = loginIndexPage.clickonSearchOrder();
		boolean errorMsg= loginVerificationPage.Searchtab();
		Assert.assertTrue(errorMsg,"Search Order button not working.");
	
	}

}
