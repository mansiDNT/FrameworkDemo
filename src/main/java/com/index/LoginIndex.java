package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;

public class LoginIndex extends SeleniumInit {

	int stepCount = 1;
	int extentStepCount = 1;

	@Test
	public void login() throws Exception {

		acceptCookie();

		System.out.println("Username is:" + Common.getCellValue("Sheet1", 1, 0));
		System.out.println("Password is : " + Common.getCellValue("Sheet1", 1, 1));

		// login button disabled
		testStepsLog("Step " + (stepCount++) + " : Enter username.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter username.");

		loginVerificationPage = loginIndexPage.enterEmail(Common.getCellValue("Sheet1", 1, 0));
		test.log(LogStatus.PASS,
				"Username entered correctly.Entered username is : " + Common.getCellValue("Sheet1", 1, 0));

		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");

		loginVerificationPage = loginIndexPage.enterPassword(Common.getCellValue("Sheet1", 1, 1));
		test.log(LogStatus.PASS,
				"Password entered correctly.Entered username is : " + Common.getCellValue("Sheet1", 1, 1));

		testStepsLog("Step " + (stepCount++) + " : Click on Signin button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Log In button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();

		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean errorMessage = loginVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage, "Login is  successful.");
		
		

	}

}
