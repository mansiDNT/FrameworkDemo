package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.GGLoginVerificationPage;

public class GGLoginIndexPage extends AbstractPage{

	public GGLoginIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(linkText="log yourself in")
	WebElement login_link;
	public GGLoginVerificationPage clickonlogyourselflink()
	{
		Common.clickOn(driver, login_link);
		return new GGLoginVerificationPage(driver);		
	}
	
	@FindBy(name="email_address")
	WebElement emailfield;
	public GGLoginVerificationPage enteremail(String username)
	{
		Common.enterDataIn(driver, emailfield, username);
		return new GGLoginVerificationPage(driver);		
	}
	
	@FindBy(name="password")
	WebElement pwd;
	public GGLoginVerificationPage enterpass(String Password)
	{
		Common.enterDataIn(driver, pwd, Password);
		return new GGLoginVerificationPage(driver);		
	}
	
	@FindBy(id="tdb1")
	WebElement signIN;
	public GGLoginVerificationPage signINbtn()
	{
		Common.clickOn(driver, signIN);
		return new GGLoginVerificationPage(driver);		
	}
	
	@FindBy(linkText="Log Off")
	WebElement logofflink;
	public GGLoginVerificationPage Clickonlogofflink()
	{
		Common.clickOn(driver, logofflink);
		return new GGLoginVerificationPage(driver);		
	}
	
	@FindBy(id="tdb1")
	WebElement continuebtn;
	public GGLoginVerificationPage ClickonconINbtn()
	{
		Common.clickOn(driver, continuebtn);
		return new GGLoginVerificationPage(driver);		
	}
	
	
}
