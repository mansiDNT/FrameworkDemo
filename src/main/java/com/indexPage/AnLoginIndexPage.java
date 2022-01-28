package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.AnLoginVerificationPage;


public class AnLoginIndexPage extends AbstractPage{

	public AnLoginIndexPage(WebDriver driver) {
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
	
	
	public AnLoginVerificationPage clickOnHellosignin()
	{
		Common.clickOn(driver, gotosignin);
		return new AnLoginVerificationPage(driver);
	}
	
	
	public AnLoginVerificationPage enterMobilenum(String username)
	{
		Common.enterDataIn(driver, mobilenum, username);
		return new AnLoginVerificationPage(driver);
	}
	
	
	public AnLoginVerificationPage clickOncontinue()
	{
		Common.clickOn(driver, contbuttn);
		return new AnLoginVerificationPage(driver);
	}
	
	public AnLoginVerificationPage enterpassword(String username)
	{
		Common.enterDataIn(driver, password, username);
		return new AnLoginVerificationPage(driver);
	}
	
	
	public AnLoginVerificationPage clickOnsignin()
	{
		Common.clickOn(driver, signin);
		return new AnLoginVerificationPage(driver);
	}	

}
