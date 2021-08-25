package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.init.AbstractPage;
import com.init.Common;
import com.relevantcodes.extentreports.LogStatus;

public class CartVerificationPage extends AbstractPage {
	Boolean bool;

	public CartVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyCartCount() {
		
		Common.pause(2);
		WebElement var = driver.findElement(By.xpath("//span[contains(text(),'1')]"));
		if(null!=var && var.isDisplayed()){
		test4.log(LogStatus.PASS, "Product added to cart successfully.");
		bool=true;
		}else {
			test4.log(LogStatus.FAIL,"Product is not added.");
			bool=false;
		}
		return bool;
	}

}
