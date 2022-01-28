package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.google.errorprone.annotations.Var;
import com.init.AbstractPage;
import com.init.Common;



public class LoginVerificationPage extends AbstractPage{
Boolean bool;
	public LoginVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifySuccessfulLogin() {
		
		Common.pause(2);
		WebElement var = driver.findElement(By.xpath("//div[@class='qb-logodark']"));
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
		if(driver.findElement(By.xpath("//div[@class='qb-logodark']")).isDisplayed()){
			extentTest1.log(Status.FAIL, "Login not successful.");
		bool=false;
		}else {
			extentTest1.log(Status.PASS,"Login is successful.");
			bool=true;
		}
		return bool;
	}
	
	public boolean verifyInvalidEmailID(String error) {
		
		Common.pause(2);
		
		return driver.findElement(By.xpath("//span[contains(text(),'"+error+"')]")).isDisplayed();
	}
	
    @FindBy(xpath = "//button[contains(text(),'LOG IN')]")
	WebElement login_button;
    
    public boolean verifyLoginButtonDisabled() {
		
		Common.pause(2);
		
		return (!login_button.isEnabled());
	}
    
    @FindBy(xpath = "//button[contains(text(),'SEND RESET LINK')]")
   	WebElement resentLinkBtn;
       
       public boolean verifyResetLinkBtnDisabled() {
   		
   		Common.pause(2);
   		
   		return (!resentLinkBtn.isEnabled());
   	}
}
