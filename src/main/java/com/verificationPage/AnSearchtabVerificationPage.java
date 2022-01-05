package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.init.AbstractPage;
import com.init.Common;

public class AnSearchtabVerificationPage extends AbstractPage{
	
	public AnSearchtabVerificationPage(WebDriver driver) {
		super(driver);
		
	}
	
public boolean verifySuccessfulLogin() {
		
		Common.pause(2);
		
		WebElement var = driver.findElement(By.xpath("//a[text()='Buy Again']"));
		return (null!=var && var.isDisplayed());
	}

public boolean SuccessfulOrders() {
		
		Common.pause(2);
		WebElement var = driver.findElement(By.xpath("//a[contains(text(),'Cancelled')]"));
		return (null!=var && var.isDisplayed());
	}

public boolean Searchtab() {
	
	Common.pause(2);
	
	WebElement var = driver.findElement(By.xpath("//a[text()='Order details']"));
	return (null!=var && var.isDisplayed());
}

public boolean verifyNegativeLogin() {
	Boolean bool;
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
