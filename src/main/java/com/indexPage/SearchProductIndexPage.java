package com.indexPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.SearchProductVerificationPage;

public class SearchProductIndexPage extends AbstractPage {

	public SearchProductIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[contains(text(),'Search products')]")
	WebElement searchProduct;

	public SearchProductVerificationPage clickOnSearchProduct() {
		Common.pause(5);
		Common.clickOn(driver, searchProduct);
		return new SearchProductVerificationPage(driver);
	}

	@FindBy(xpath = "//input[@id='text']")
	WebElement inputSearch;

	public SearchProductVerificationPage clickOnInputSearchProduct() {
		Common.enterDataIn(driver, inputSearch, "Fellowes Shredder Bags");
		Common.pressEnterKey(driver, inputSearch, Keys.chord(Keys.ENTER));
		return new SearchProductVerificationPage(driver);
	}

	@FindBy(xpath = "//*[@id='scroll-to']/div/div/div/div[4]")
	WebElement sourceElement;

	public SearchProductVerificationPage mouseoverToSource() {
		Common.mouseHover(driver, sourceElement);
		return new SearchProductVerificationPage(driver);
	}

	@FindBy(xpath = "//button[@type='button'])[8]")
	WebElement btnsearchProduct;

	public SearchProductVerificationPage clickOnBtnSearchProduct() {
		Common.clickOn(driver, btnsearchProduct);
		return new SearchProductVerificationPage(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'My products')]")
	WebElement myProduct;

	public SearchProductVerificationPage clickOnMyproduct() {
		Common.clickOn(driver, myProduct);
		return new SearchProductVerificationPage(driver);
	}

}
