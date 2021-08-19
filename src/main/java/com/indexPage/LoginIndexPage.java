package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.LoginVerificationPage;

public class LoginIndexPage extends AbstractPage {
	
	public LoginIndexPage(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	} 

	@FindBy(id="login-email")
	WebElement email_field;
	public LoginVerificationPage enterEmail(String username)
	{
		Common.enterDataIn(driver, email_field, username);
		return new LoginVerificationPage(driver);
	}
	
	@FindBy(id="login-password")
	WebElement password_field;
	public LoginVerificationPage enterPassword(String password)
	{
		Common.enterDataIn(driver, password_field, password);
		//Common.pause(2);
		return new LoginVerificationPage(driver);
	}
	
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement login_button;
	public LoginVerificationPage clickOnLoginButton()
	{
		//login_button.click();
		//driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Common.clickOn(driver, login_button);
		return new LoginVerificationPage(driver);
	}
	
	@FindBy(xpath="//div[contains(text(),\"Invalid email id provided.\")]")
	WebElement Error_msg;
	public LoginVerificationPage validationmsg()
	{
		//login_button.click();
		//driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Common.clickOn(driver, Error_msg);
		return new LoginVerificationPage(driver);
	}

	@FindBy(xpath="//a[contains(text(),\"Subscription Plans\")]")
	WebElement scroll_down;
	public LoginVerificationPage ScrollDown()
	{
		//login_button.click();
		//driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Common.scrollToVertical(driver, scroll_down);
		return new LoginVerificationPage(driver);
	}
	
	@FindBy(id="dropdownMenuButton")
	WebElement threeDot;
	public LoginVerificationPage ClickonThreeDot()
	{
		//login_button.click();
		//driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		Common.clickOn(driver, threeDot);
		return new LoginVerificationPage(driver);
	}

	
}
