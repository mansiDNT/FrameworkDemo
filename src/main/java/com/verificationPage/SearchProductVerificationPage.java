package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.init.AbstractPage;
import com.init.Common;
import com.relevantcodes.extentreports.LogStatus;

public class SearchProductVerificationPage extends AbstractPage {
	Boolean bool;

	public SearchProductVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyProductAdded() {
		Common.pause(2);
		if (driver.findElement(By.xpath("//div[contains(text(),'Product added successfully.')]")).isDisplayed()) {
			test1.log(LogStatus.PASS, "Product added successfully.");
			bool = true;
		} else {
			test1.log(LogStatus.FAIL, "Product not added.");
			bool = false;
		}
		return bool;

	}

}
