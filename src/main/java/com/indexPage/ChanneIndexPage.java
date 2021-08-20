package com.indexPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.init.AbstractPage;
import com.init.Common;
import com.verificationPage.ChannelVerificationPage;
import com.verificationPage.RegisterVerificationPage;

public class ChanneIndexPage extends AbstractPage{

	public ChanneIndexPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button[@type = 'button' and (text() = \"New Channel\")]")
	WebElement new_channel;
	public ChannelVerificationPage Clickonnewchannel()
	{
		Common.clickOn(driver, new_channel);
		return new ChannelVerificationPage(driver);		
	}

	@FindBy(id="RecipientName")
	WebElement recipient_name;
	public ChannelVerificationPage entername(String name)
	{
		Common.enterDataIn(driver, recipient_name, name);
		return new ChannelVerificationPage(driver);		
	}
	
	@FindBy(name="companyName")
	WebElement company_name;
	public ChannelVerificationPage enterCompanyname(String companyName)
	{
		Common.enterDataIn(driver, company_name, companyName);
		return new ChannelVerificationPage(driver);		
	}

	@FindBy(id="Emailaddress")
	WebElement email_address;
	public ChannelVerificationPage enteremail(String Email)
	{
		Common.enterDataIn(driver, email_address, Email);
		return new ChannelVerificationPage(driver);		
	}
	
	@FindBy(id="LinkPasscode")
	WebElement passcode;
	public ChannelVerificationPage enterPasscode(String PASSCODE)
	{
		Common.enterDataIn(driver, passcode, PASSCODE);
		return new ChannelVerificationPage(driver);		
	}
	
	@FindBy(xpath="//button[@type = 'button' and (text() = \"Create\")]")
	WebElement Create_button;
	public ChannelVerificationPage cliconCreate()
	{
		Common.clickOn(driver, Create_button);
		return new ChannelVerificationPage(driver);		
	}
}
