package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.Device_suspension.DeviceSuspensionPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;

public class TC_Device_Suspension extends BaseTest {
	
	@Test
	public void deviceSuspensionTestMethod() throws Exception
	{
		preCondition();
		Thread.sleep(1000);
		DeviceSuspensionPage ds = new HomePage().navigateToSuspensionPage();
		ds.testSuspension();
		
	}

}
