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
	public AnLoginVerificationPage clickOngoto()
	{
		Common.clickOn(driver, gotosignin);
		//gotosignin.click();
		return new AnLoginVerificationPage(driver);
	}
	
	@FindBy(id="ap_email")
	WebElement mobilenum;
	public AnLoginVerificationPage enternum(String username)
	{
		Common.enterDataIn(driver, mobilenum, username);
		return new AnLoginVerificationPage(driver);
	}
	
	@FindBy(id="continue")
	WebElement contbuttn;
	public AnLoginVerificationPage clickOncontinue()
	{
		Common.clickOn(driver, contbuttn);
		return new AnLoginVerificationPage(driver);
	}
	@FindBy(id="ap_password")
	WebElement password;
	public AnLoginVerificationPage enterpassword(String username)
	{
		Common.enterDataIn(driver, password, username);
		return new AnLoginVerificationPage(driver);
	}
	
	@FindBy(id="signInSubmit")
	WebElement signin;
	public AnLoginVerificationPage clickOnsignin()
	{
		Common.clickOn(driver, signin);
		return new AnLoginVerificationPage(driver);
	}	

}
