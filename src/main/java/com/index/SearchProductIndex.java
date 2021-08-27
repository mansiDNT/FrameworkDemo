package com.index;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;

public class SearchProductIndex extends SeleniumInit {
	int stepCount = 1;
	int extentStepCount = 1;

	@Test
	public void searchIndex() throws Exception {
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

		driver.get("https://apptest.avasam.com/seeker.html#/productssearchproduct");

		WebElement btnSupplier = driver.findElement(By.xpath("//*[@id='single-button']"));
		btnSupplier.click();

		WebElement checkGB = driver.findElement(By.xpath("//span[contains(text(),'GB1007040')]"));
		Common.clickOn(driver, checkGB);
		
	    Common.pause(2);
	    
	    WebElement search=driver.findElement(By.xpath("//input[@id='text']"));
	    search.sendKeys("20 Fragranced Incense Sticks With Holder - Lavender NLW");
	    search.sendKeys(Keys.chord(Keys.ENTER));
	    
	    Common.pause(2);
	    
	    WebElement firstElement=driver.findElement(By.xpath("//*[@id='scroll-to']/div/div/div/div[4]"));
	    Common.mouseHover(driver, firstElement);
	    
	    Common.pause(4);
	    
	    WebElement btnSourceproduct=driver.findElement(By.xpath("(//button[@type='button'])[8]"));
	    Common.clickOn(driver, btnSourceproduct);
	    
	    Common.pause(2);
	    
	    
	    
	    
	    
	    
	    
	  
	 
	    

	}

}
