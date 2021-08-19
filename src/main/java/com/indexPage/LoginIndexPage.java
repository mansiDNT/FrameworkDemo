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

	@FindBy(id = "user-name")
	WebElement email_field;

	public LoginVerificationPage enterEmail(String username) {
		Common.enterDataIn(driver, email_field, username);
		return new LoginVerificationPage(driver);
	}

	@FindBy(id = "password")
	WebElement password_field;

	public LoginVerificationPage enterPassword(String password) {
		Common.enterDataIn(driver, password_field, password);

		return new LoginVerificationPage(driver);
	}

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login_button;

	public LoginVerificationPage clickOnLoginButton() {

		Common.clickOn(driver, login_button);
		return new LoginVerificationPage(driver);
	}

}
