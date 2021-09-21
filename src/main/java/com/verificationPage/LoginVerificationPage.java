package com.verificationPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.relevantcodes.extentreports.LogStatus;
import java.util.List;

public class LoginVerificationPage extends AbstractPage {
	Boolean bool;

	public LoginVerificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifySuccessfulLogin() {

		Common.pause(2);

		List<WebElement> AllUser = driver.findElements(By.xpath("//span/a/span"));
		for (WebElement user : AllUser) {
			String userName = user.getText();

			if (userName.equals(Common.getCellValue("Sheet1", 1, 3))) {
				test.log(LogStatus.PASS, "Login is successful.");
				bool = true;
			}

		}

		return bool;
	}

	public boolean verifyNegativeLogin() {

		Common.pause(2);
		if (driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3")).isDisplayed()) {
			test1.log(LogStatus.PASS, "Username and password do not match any user in this service");
			bool = true;
		} else {
			test1.log(LogStatus.FAIL, "Login is successful.");
			bool = false;
		}
		return bool;
	}

	public boolean verifyInvalidEmailID(String error) {

		Common.pause(2);

		return driver.findElement(By.xpath("//span[contains(text(),'" + error + "')]")).isDisplayed();
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
