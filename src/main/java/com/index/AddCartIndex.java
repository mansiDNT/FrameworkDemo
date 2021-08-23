package com.index;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCartIndex extends LoginIndex{
	int stepCount = 1;
	int extentStepCount = 1;

	
	@Test
	public void addProductToCart() throws Exception{
		login();
		cartVerificationPage=addCartIndexPage.clickOnAddToCart();
		boolean errormessage=cartVerificationPage.verifyCartCount();
		Assert.assertTrue(errormessage, "Product is added to cart.");
		
	}

}
