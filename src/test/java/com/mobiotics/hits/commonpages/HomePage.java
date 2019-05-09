package com.mobiotics.hits.commonpages;

import javax.print.attribute.standard.Severity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mobiotics.Product_ReconnectPage.ProductReconnectPage;
import com.mobiotics.hits.AddNxtDegital_AddonsPage.AddNxtDegital_AddonsPage;
import com.mobiotics.hits.CreateCustomer.CreateCustomerPage;
import com.mobiotics.hits.Customer_RefundRequestPage.Customer_Refund_RequestPage;
import com.mobiotics.hits.Customer_SubscriberCornerPage.SubscriberCornerPage;
import com.mobiotics.hits.Device_suspension.DeviceSuspensionPage;
import com.mobiotics.hits.Report_ListPayments.ListPaymentPage;
import com.mobiotics.hits.customer_CustomerModification.CustomerModificationPage;
import com.mobiotics.hits.customer_ListCustomer.ListCustomerPage;

import com.mobiotics.hits.paymentmenu_AddPayment.AddPaymentPage;
import com.mobiotics.hits.paymentmenu_PayForBox.PayForBox;
import com.mobiotics.hits.product_AddProduct_AddBasePackPage.Product_AddProduct_AddBasePackPage;
import com.mobiotics.hits.product_Addproduct_AddALCartePage.AddAla_CartePage;
import com.mobiotics.hits.product_ProductDisconnect.ProductDisconnectPage;

import generic.Property;

public class HomePage extends Navigation_menu {
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(partialLinkText="Dashboard")
	private WebElement dashboardMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Payment')]")
	private WebElement paymentsMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Customer')]")
	private WebElement customersMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Product')]")
	private WebElement productMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Renew')]")
	private WebElement renewMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Report')]")
	private WebElement reportMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Device')]")
	private WebElement deviceMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Ticket')]")
	private WebElement ticketMenu;
	
	@FindBy(xpath="//a[@class='dropdown-toggle' and contains(text(), 'Profile')]")
	private WebElement profileMenu;

	@FindBy(partialLinkText="Logout")
	private WebElement logout;
	
	
	//----------------------------------------This is for Customer_Refund Request---------------------------------
	
	public Customer_Refund_RequestPage navigateTo_refundRequestPage() {
		customersMenu.click();
		waitTillElementIsVisible(customer_RefundRequest);
		customer_RefundRequest.click();
		return new Customer_Refund_RequestPage();
		
	}
	
	
	
	//---------------This is Dash-Bord menu---------------------------------------
	public void nevigateToDashBoard_DashBoard() {
		dashboardMenu.click();
	}
	
	//-----------------------------------This is Payment_List Payment-----------------------
	public AddPaymentPage navigateToPaymentMenu_AddPayment() {
		paymentsMenu.click();
		waitTillElementIsVisible(payment_AddPayment);
		payment_AddPayment.click();
		
		return new AddPaymentPage();
	}
	
	
	//---------------------This is payment_List Payment-----------------------------------
	
	public ListPaymentPage navigateToPaymentMenu_ListPayment()
	{
		reportMenu.click();// here we need to modified in the code
		waitTillElementIsVisible(Report_List_Payment);
		Report_List_Payment.click();
		return new ListPaymentPage();
	}
	
	//---------------------This is the Payment_menu PayForBox--------------------------------
	public PayForBox navigateToPaymentMenu_PayForBoxPage() {
		paymentsMenu.click();
		waitTillElementIsVisible(payment_PayForBox);
		payment_PayForBox.click();
		return new PayForBox();
	}
	
	public CreateCustomerPage navigateToCustomerMenu_CreateCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_createCustomer);
		customer_createCustomer.click();
		return new CreateCustomerPage();
		
	}
	
	//--------------------------This is the List Customer Page-----------------------
	
	public ListCustomerPage navigateToCustomerMenu_ListCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_ListCustomer);
		customer_ListCustomer.click();
		return new ListCustomerPage();
	}
	
	//----------------------------This is modification of customer--------------------
	
	public CustomerModificationPage navigateToCustomerMenu_ModifyCustomer() {
		customersMenu.click();
		waitTillElementIsVisible(customer_Modify_Customer);
		customer_Modify_Customer.click();
		return new CustomerModificationPage();
		
	}
	
	
	public SubscriberCornerPage navigateToCustomerMenu_SubscriberCornerPage()
	{
		customersMenu.click();
		waitTillElementIsVisible(customer_Subscriber_Corner);
		customer_Subscriber_Corner.click();
		return new SubscriberCornerPage();
	}
	
	//---------------This is Product_AddBasePackPage-----------------------
	
	public Product_AddProduct_AddBasePackPage navigateToProductMenu_AddBasePackPage() {
		productMenu.click();
		waitTillElementIsVisible(product_AddProduct);
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(addProdoct_AddBasePack);
		addProdoct_AddBasePack.click();
		return new Product_AddProduct_AddBasePackPage();
	}
	
	//---------------This is Product_AddAlACartePackPage-----------------------

	
	public AddAla_CartePage nevigateToProductMenu_AddAl_A_CtrePage() {
		productMenu.click();
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(add_product_Add_Al_A_carte);
		
		add_product_Add_Al_A_carte.click();
		return new AddAla_CartePage();
	}
	
	
	//-----------------------------This is Product_AddNxtPayBouquet----------------------------------------------

	public AddNxtDegital_AddonsPage navigateToProductMenu_AddAddons() {
		productMenu.click();
		Property.action_Move_To_Element(driver, product_AddProduct);
		waitTillElementIsVisible(addProduct_AddNxtDegitalAddOns);
		addProduct_AddNxtDegitalAddOns.click();
		return new AddNxtDegital_AddonsPage();
	}

	/*
	public AddAla_CartePage navigateToProductMenu_AddAlaCartePage() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
	//-----------------------------------This is for Product_Disconnect-------------------------------
	
	public ProductDisconnectPage navigateToProductMenu_ProductDisconnectPage() {
		productMenu.click();
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(DisconnectLink);
		DisconnectLink.click();
		return new ProductDisconnectPage();
		
	}
	
	
	//-------------------------------This is for Product_Reconnect-Page--------------------------------------
	
	
	public ProductReconnectPage navigateToProductMenue_ProductReconnectPage() {
		productMenu.click();
		
		waitTillElementIsVisible(product_connections);
		Property.action_Move_To_Element(driver, product_connections);
		waitTillElementIsVisible(product_Reconnect);
		
		product_Reconnect.click();
		return new ProductReconnectPage();
		
	}
	
	//-------------------------------This for Device > Suspension Page------------------------------
	public DeviceSuspensionPage navigateToSuspensionPage()
	{
		deviceMenu.click();
		waitTillElementIsClickable(Device_Suspension);
		Device_Suspension.click();
		return new DeviceSuspensionPage();
	}
	
	
	
	
}
