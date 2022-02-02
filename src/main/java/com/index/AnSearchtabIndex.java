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
		System.out.println((Common.getCellValue("Sheet1",1,0)));
		
		
		testStepsLog("Step " + (stepCount++) + " : Click on Hello sign in.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Hello sign in.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.clickOnHellosignin();
		
		testStepsLog("Step " + (stepCount++) + " : Enter mobile number.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter mobile number.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.enterMobilenum((Common.getCellValue("Sheet1",1,0)));
		//AnsearchtabVerificationPage = AnsearchtabIndexPage.enterMobilenum("9972024124"); 
		extentTest.log(Status.PASS, "Mobile number entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Continue button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Continue button.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.clickOncontinue();
		
		testStepsLog("Step " + (stepCount++) + " : Enter Password.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Password.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.enterpassword((Common.getCellValue("Sheet1",1,1)));
		//AnsearchtabVerificationPage = AnsearchtabIndexPage.enterpassword("ama@2022");
		extentTest.log(Status.PASS, "Password entered correctly" );
		
		testStepsLog("Step " + (stepCount++) + " : Click on Sign in button.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Sign in button.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.clickOnsignin();
		boolean errorMessage= AnsearchtabVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
		
		testStepsLog("Step " + (stepCount++) + " : Click on Orders.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on Orders.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.clickOnorders();
		boolean errorMessag= AnsearchtabVerificationPage.SuccessfulOrders();
		Assert.assertTrue(errorMessag,"Orders history not working");
		
		testStepsLog("Step " + (stepCount++) + " : Enter Search item.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Enter Search item.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.searchtab((Common.getCellValue("Sheet1",1,2)));
		//AnsearchtabVerificationPage = AnsearchtabIndexPage.searchtab("suit");
		extentTest.log(Status.PASS, "Search item entered correctly" );
		
		
		testStepsLog("Step " + (stepCount++) + " : Click on SearchOrders.");
		extentTest.log(Status.PASS, "Step " + (extentStepCount++) + " : Click on SearchOrders.");
		AnsearchtabVerificationPage = AnsearchtabIndexPage.clickonSearchOrder();
		boolean errorMsg= AnsearchtabVerificationPage.Searchtab();
		Assert.assertTrue(errorMsg,"Search Order button not working.");
	
	}

}
