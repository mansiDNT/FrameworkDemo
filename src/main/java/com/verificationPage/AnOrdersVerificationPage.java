package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.init.AbstractPage;
import com.init.Common;


public class AnOrdersVerificationPage extends AbstractPage{
	Boolean bool;
	public AnOrdersVerificationPage(WebDriver driver) {
		super(driver);
		
	}
	
public boolean verifySuccessfulLogin() {
		
		Common.pause(2);
		
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

public boolean SuccessfulOrders() {
		
		Common.pause(2);
		
		WebElement var = driver.findElement(By.xpath("//*[@id=\"orderTypeMenuContainer\"]/ul/li[5]/span/a"));
		//WebElement var = driver.findElement(By.xpath("//span[text()='Cancelled Orders']"));
		if(null!=var && var.isDisplayed()){
			extentTest.log(Status.PASS, "Orders history is seen successfully.");
			bool=true;
			}else {
				extentTest.log(Status.FAIL,"Orders history is not seen.");
				bool=false;
			}
		return bool;
	}
	

}
