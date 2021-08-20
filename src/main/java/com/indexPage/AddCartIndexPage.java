package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.CartVerificationPage;
import org.openqa.selenium.support.FindBy;

public class AddCartIndexPage extends AbstractPage {

	public AddCartIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	WebElement addToCartButton;
	public CartVerificationPage clickOnAddToCart(){
		
		Common.clickOn(driver, addToCartButton);
		return new CartVerificationPage(driver);
	}
	}
