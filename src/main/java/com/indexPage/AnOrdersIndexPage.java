package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.AnLoginVerificationPage;
import com.verificationPage.AnOrdersVerificationPage;

public class AnOrdersIndexPage extends AbstractPage{
	
	public AnOrdersIndexPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement gotosignin;
	
	@FindBy(id="ap_email")
	WebElement mobilenum;
	
	@FindBy(id="continue")
	WebElement contbuttn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	
	@FindBy(id="nav-orders")
	WebElement orders;
	
	public AnOrdersVerificationPage clickOnHellosignin()
	{
		Common.clickOn(driver, gotosignin);
		//gotosignin.click();
		return new AnOrdersVerificationPage(driver);
	}
	
	public AnOrdersVerificationPage enterMobilenum(String username)
	{
		Common.enterDataIn(driver, mobilenum, username);
		return new AnOrdersVerificationPage(driver);
	}
	
	public AnOrdersVerificationPage clickOncontinue()
	{
		Common.clickOn(driver, contbuttn);
		return new AnOrdersVerificationPage(driver);
	}
	
	public AnOrdersVerificationPage enterpassword(String username)
	{
		Common.enterDataIn(driver, password, username);
		return new AnOrdersVerificationPage(driver);
	}
	
	public AnOrdersVerificationPage clickOnsignin()
	{
		Common.clickOn(driver, signin);
		return new AnOrdersVerificationPage(driver);
	}	
	
	public AnOrdersVerificationPage clickOnorders()
	{
		Common.clickOn(driver, orders);
		return new AnOrdersVerificationPage(driver);
	}
}
