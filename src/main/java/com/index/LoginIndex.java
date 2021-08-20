package com.index;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginIndex extends SeleniumInit {
	 
		int stepCount = 1;
		int extentStepCount =1;
		
	@Test
	public void login_negative() throws Exception
	{
		
		testStepsLog("Step "      + (stepCount++) + " : Enter email address.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter username.");
		loginVerificationPage = loginIndexPage.enterEmail(Common.getCellValue("Login",1,0));
		test.log(LogStatus.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Login",1,0));
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");
		loginVerificationPage = loginIndexPage.enterPassword(Common.getCellValue("Login",1,1));
		test.log(LogStatus.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Login",1,1));
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on Let's go button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Let's go button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();
		Thread.sleep(3000);
		
		loginVerificationPage = loginIndexPage.ScrollDown();
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Verify validation message is displayed or not.");
		boolean validationmsg= loginVerificationPage.verifyNegativeLogin();
		Assert.assertTrue(validationmsg,"validation messsage is displayed");
		Thread.sleep(3000);
	}
	
	@Test
	public void login_positive() throws Exception
	{
		testStepsLog("Step " + (stepCount++) + " : Enter email address.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter username.");
		loginVerificationPage = loginIndexPage.enterEmail(Common.getCellValue("Login",1,2));
		test.log(LogStatus.PASS, "Username entered correctly.Entered username is : " +Common.getCellValue("Login",1,2));
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter password.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter password.");
		loginVerificationPage = loginIndexPage.enterPassword(Common.getCellValue("Login",1,3));
		test.log(LogStatus.PASS, "Password entered correctly.Entered username is : " +Common.getCellValue("Login",1,3));
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on Let's go button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Let's go button.");
		loginVerificationPage = loginIndexPage.clickOnLoginButton();
		Thread.sleep(3000);		
		
		testStepsLog("Step " + (stepCount++) + " : Click on three button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on three button.");
		loginVerificationPage = loginIndexPage.ClickonThreeDot();
		Thread.sleep(3000);
		
		testStepsLog("Step " + (stepCount++) + " : Verify 'Login' is successful.");
		boolean signoutText= loginVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(signoutText,"Login is not successful.");
		Thread.sleep(3000);
	}
}
