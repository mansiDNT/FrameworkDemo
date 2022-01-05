package com.indexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.AnSearchtabVerificationPage;

public class AnSearchtabIndexPage extends AbstractPage{
	
	public AnSearchtabIndexPage(WebDriver driver) {
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
	
	@FindBy(id="searchOrdersInput")
	WebElement search;
	
	@FindBy(className="a-button-input")
	WebElement searchorder;
	
	public AnSearchtabVerificationPage clickOnHellosignin()
	{
		try {
		Common.waitForPageLoaded(driver);
		Common.visibilityOfElementLocated(driver, By.id("nav-link-accountList-nav-line-1"), DRIVER_WAIT);
		gotosignin.click();
		//Common.clickOn(driver, gotosignin);
		}catch(Exception e) {
		extentTest.log(Status.FAIL, "Failure Message:- Hello sign in is not working.");
		Assert.fail(Common.getExceptionMessage(e));	
		}
		
		return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage enterMobilenum(String username)
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("ap_email"), DRIVER_WAIT);
			Common.enterDataIn(driver, mobilenum, username);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Username is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		
		    return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage clickOncontinue()
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("continue"), DRIVER_WAIT);
			Common.clickOn(driver, contbuttn);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Continue button is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		    return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage enterpassword(String username)
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("ap_password"), DRIVER_WAIT);
			Common.enterDataIn(driver, password, username);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Password is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage clickOnsignin()
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("signInSubmit"), DRIVER_WAIT);
			Common.clickOn(driver, signin);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Sign in button is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		
		return new AnSearchtabVerificationPage(driver);
	}	

	
	
	public AnSearchtabVerificationPage clickOnorders()
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("nav-orders"), DRIVER_WAIT);
			Common.clickOn(driver, orders);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Orders button is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		
		return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage searchtab(String username)
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("searchOrdersInput"), DRIVER_WAIT);
			Common.enterDataIn(driver, search, username);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Search order tab is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		
		return new AnSearchtabVerificationPage(driver);
	}
	
	
	public AnSearchtabVerificationPage clickonSearchOrder()
	{
		try {
			Common.waitForPageLoaded(driver);
			Common.visibilityOfElementLocated(driver, By.id("a-button-input"), DRIVER_WAIT);
			Common.clickOn(driver, searchorder);
			}catch(Exception e) {
			extentTest.log(Status.FAIL, "Failure Message:- Search order button is not working.");
			Assert.fail(Common.getExceptionMessage(e));	
			}
		
		return new AnSearchtabVerificationPage(driver);
	}

}
