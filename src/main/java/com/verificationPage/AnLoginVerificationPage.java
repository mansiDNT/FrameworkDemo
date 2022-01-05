package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.init.AbstractPage;
import com.init.Common;


public class AnLoginVerificationPage extends AbstractPage{
	Boolean bool;
	public AnLoginVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
public boolean verifySuccessfulLogin() {
		
		Common.pause(2);
		//WebElement var = driver.findElement(By.id("signInSubmit"));
		WebElement var = driver.findElement(By.xpath("//a[text()='Buy Again']"));
		if(null!=var && var.isDisplayed()){
			extentTest.log(Status.PASS, "Login is successful.");
			bool=true;
			}else {
				extentTest.log(Status.FAIL,"Login not successful.");
				bool=false;
			}
		return bool;
	}

	public boolean verifyNegativeLogin() {
		
		Common.pause(2);
		if(driver.findElement(By.id("signInSubmit")).isDisplayed()){
			extentTest1.log(Status.PASS,"Login is successful.");
			bool=true;
			}else {
				extentTest1.log(Status.FAIL,"Login not successful.");
				bool=false;
			}
		return bool;
	}

}
