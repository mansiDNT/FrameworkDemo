package com.index;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;

public class SearchProductIndex extends SeleniumInit {
	int stepCount = 1;
	int extentStepCount = 1;

	@Test(priority = 1)
	public void searchProduct() throws Exception {

		testStepsLog("Step " + (stepCount++) + " : Click on Search Product");
		test1.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on Search Product");

		searchProductVerificationPage = searchProductIndexPage.clickOnSearchProduct();
		// Common.getURL(driver,
		// "https://apptest.avasam.com/seeker.html#/productssearchproduct");
		test1.log(LogStatus.PASS, "Click on Search Product");

		Common.pause(2);

		testStepsLog("Step " + (stepCount++) + " : Search Product title");
		test1.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Search Product title");

		searchProductVerificationPage = searchProductIndexPage.clickOnInputSearchProduct();
		test1.log(LogStatus.PASS, "Search Product title");

		// Common.pause(4);
		searchProductVerificationPage = searchProductIndexPage.mouseoverToSource();
		
	//	Common.scrollScreen(driver);

		//Common.pause(4);

		searchProductVerificationPage = searchProductIndexPage.clickOnBtnSearchProduct();
		Common.pause(2);

		boolean errorMessage = searchProductVerificationPage.verifyProductAdded();
		Assert.assertTrue(errorMessage, "Product added successfully.");

	}

	@Test(priority = 2)
	public void verifysourcedProduct() throws Exception {
		searchProductVerificationPage = searchProductIndexPage.clickOnMyproduct();
		Common.pause(2);

	}

}
