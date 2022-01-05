package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.init.SeleniumInit;

public class AnOrdersIndex extends SeleniumInit{
	
	@Test
	public void Orders() throws Exception
	{
		loginVerificationPage = loginIndexPage.clickOnHellosignin();
		loginVerificationPage = loginIndexPage.enterMobilenum("9972024124"); 
		loginVerificationPage = loginIndexPage.clickOncontinue();
		loginVerificationPage = loginIndexPage.enterpassword("ama@2022");
		loginVerificationPage = loginIndexPage.clickOnsignin();
		boolean errorMessage= loginVerificationPage.verifySuccessfulLogin();
		Assert.assertTrue(errorMessage,"Login is not successful.");
		
		loginVerificationPage = loginIndexPage.clickOnorders();
		//loginVerificationPage = loginIndexPage.checkcancelled();
		boolean errorMessag= loginVerificationPage.SuccessfulOrders();
		Assert.assertTrue(errorMessag,"Orders history not working");
	
	}

}
