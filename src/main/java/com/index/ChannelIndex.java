package com.index;

import com.init.Common;
import com.init.SeleniumInit;
import com.relevantcodes.extentreports.LogStatus;

public class ChannelIndex extends SeleniumInit {

	int stepCount = 1;
	int extentStepCount =1;
	
	public void Create_channel() throws Exception
	{
		
		testStepsLog("Step " + (stepCount++) + " : Click on new channel.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on new channel.");
		channelverificationpage = ChannelindexPage.Clickonnewchannel();
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter Recipient's name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter Recipient's name.");
		channelverificationpage = ChannelindexPage.enteremail(Common.getCellValue("CreateChannel",1,0));
		test.log(LogStatus.PASS, "Entered recipient's name correctly.Entered name is : "+Common.getCellValue("CreateChannel",1,0));
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter company name.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter company name.");
		channelverificationpage = ChannelindexPage.enteremail(Common.getCellValue("CreateChannel",1,1));
		test.log(LogStatus.PASS, "Entered company name correctly.Entered company name is : "+Common.getCellValue("CreateChannel",1,1));
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Enter email address.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Enter email address.");
		channelverificationpage = ChannelindexPage.enteremail(Common.getCellValue("CreateChannel",1,2));
		test.log(LogStatus.PASS, "Entered passcode correctly.Entered passcode is : "+Common.getCellValue("CreateChannel",1,2));
		Thread.sleep(2000);
		
		testStepsLog("Step " + (stepCount++) + " : Click on create button.");
		test.log(LogStatus.PASS, "Step " + (extentStepCount++) + " : Click on create button.");
		channelverificationpage = ChannelindexPage.cliconCreate();
		Thread.sleep(2000);
	}
}
