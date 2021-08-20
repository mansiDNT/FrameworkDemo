package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.init.AbstractPage;
import com.init.Common;
import com.relevantcodes.extentreports.LogStatus;

public class RegisterVerificationPage extends AbstractPage{
	Boolean bool;
	
	public RegisterVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean VerifyEmailExist() {
		
		Common.pause(2);
		WebElement var = driver.findElement(By.xpath("//div[contains(text(),\"Email already exist\")]"));
		if(null!=var && var.isDisplayed()){
		test.log(LogStatus.PASS, "Email already Exist.");
		bool=true;
		}else {
			test.log(LogStatus.FAIL,"Email not Exist");
			bool=false;
		}
		return bool;
	}

public boolean SucessfullyRegister() {
		
		Common.pause(2);
		WebElement var = driver.findElement(By.xpath("//h3[contains(text(),\"Account created successfully\")]"));
		if(null!=var && var.isDisplayed()){
		test.log(LogStatus.PASS, "Account created Sucessfully");
		bool=true;
		}else {
			test.log(LogStatus.FAIL,"Account not created");
			bool=false;
		}
		return bool;
	}
}
