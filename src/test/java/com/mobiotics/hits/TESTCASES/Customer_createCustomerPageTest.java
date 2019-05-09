package com.mobiotics.hits.TESTCASES;

import org.testng.annotations.Test;

import com.mobiotics.hits.CreateCustomer.CreateCustomerPage;
import com.mobiotics.hits.commonpages.HomePage;
import com.mobiotics.hits.constants.BaseTest;



public class Customer_createCustomerPageTest extends BaseTest {

	
	@Test
	public void testCustomer_CreateCustomerPageTest() throws Exception {
		preCondition();
		CreateCustomerPage homePage = new HomePage().navigateToCustomerMenu_CreateCustomer();
		homePage.enterCustomerDetails("010125172211907346","400004", "7724083836");
		
	}
}
