package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.RegisterVerificationPage;

public class RegisterIndexPage extends AbstractPage{

	public RegisterIndexPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[contains(text(),\"Register now!\")]")
	WebElement Registernow;
	public RegisterVerificationPage Clickonregisternow()
	{
		Common.scrollToElement(driver, Registernow);
		Common.clickOn(driver, Registernow);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(id="login-email")
	WebElement register_email;
	public RegisterVerificationPage enteremail(String email)
	{
		//Common.randomNumericValueGenerate(10);
		Common.enterDataIn(driver, register_email, email);
		return new RegisterVerificationPage(driver);		
	}
	
	@FindBy(xpath="//div[text()=\"Email already exist")
	WebElement email_exist;
	public RegisterVerificationPage emailAlreadyExist()
	{
		Common.getText(driver, email_exist);
		return new RegisterVerificationPage(driver);		
	}
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement getstarted_btn;
	public RegisterVerificationPage ClickonGetstarted()
	{
		
		Common.clickOn(driver, getstarted_btn);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//div[contains(text(),\"£30/monthly or £330/annually\")]")
	WebElement freeplan;
	public RegisterVerificationPage Clickonfreeplan()
	{
		
		Common.clickOn(driver, freeplan);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//button[contains(text(),\"Save & Continue\")]")
	WebElement save_continue;
	public RegisterVerificationPage ClickonSaveContinue()
	{
		
		Common.scrollToElement(driver, save_continue);
		Common.clickOn(driver, save_continue);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//button[contains(text(),\"Back\")]")
	WebElement scroll_backbtn;
	public RegisterVerificationPage scrollBackBtn()
	{
		
		Common.scrollToElement(driver, scroll_backbtn);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="name")
	WebElement input_name;
	public RegisterVerificationPage enterName(String name)
	{
		Common.scrollToTop(driver);
		Common.enterDataIn(driver, input_name, name);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="companyName")
	WebElement input_CompanyName;
	public RegisterVerificationPage enterCompanyName(String Companyname)
	{
		
		Common.enterDataIn(driver, input_CompanyName, Companyname);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="jobTitle")
	WebElement input_jobTitle;
	public RegisterVerificationPage enterJobTitle(String JobTitle)
	{
		
		Common.enterDataIn(driver, input_jobTitle, JobTitle);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="timezoneId")
	WebElement timezone;
	public RegisterVerificationPage Clickontimezone()
	{
		
		Common.clickOn(driver, timezone);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="timezoneId")
	WebElement selecttimezone;
	public RegisterVerificationPage selectTimezone()
	{
		
		Common.selectFromComboByVisibleElement(selecttimezone, "India Time Zone (UTC +9)");
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//input[@class=\" form-control\"]")
	WebElement input_MobileNo;
	public RegisterVerificationPage enterMobileNo(String mobilenUmber)
	{
		
		Common.enterDataIn(driver, input_MobileNo, mobilenUmber);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//div[@class=\"rounded flag-dropdown\"]")
	WebElement click_country;
	public RegisterVerificationPage Clickoncountry()
	{
		
		Common.clickOn(driver, click_country);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//input[@class=\"search-box\"]")
	WebElement input_search;
	public RegisterVerificationPage searchcountyr(String country)
	{
		
		Common.enterDataIn(driver, input_search, country);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//div[@class=\"flag in\"]")
	WebElement selectcountry;
	public RegisterVerificationPage selectcountryName()
	{
		
		Common.selectFromComboByVisibleElement(selectcountry, "India");
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//span[contains(text(),\"+91\")]")
	WebElement click_india;
	public RegisterVerificationPage clickselectedcountry()
	{
		
		Common.clickOn(driver, click_india);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="password")
	WebElement input_pass;
	public RegisterVerificationPage enterPassword(String password)
	{
		
		Common.enterDataIn(driver, input_pass, password);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(name="confirmPassword")
	WebElement input_passconf;
	public RegisterVerificationPage enterconfirmpwd(String confirmpwd)
	{
		
		Common.enterDataIn(driver, input_passconf, confirmpwd);
		return new RegisterVerificationPage(driver);
		
	}
	
	@FindBy(xpath="//button[contains(text(),\"Create Account\")]")
	WebElement CreateAccount_btn;
	public RegisterVerificationPage ClickonCreateAccount()
	{
		
		Common.clickOn(driver, CreateAccount_btn);
		return new RegisterVerificationPage(driver);
		
	}
	
	
	
}
