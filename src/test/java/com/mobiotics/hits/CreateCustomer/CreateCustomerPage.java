package com.mobiotics.hits.CreateCustomer;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mobiotics.hits.commonpages.BasePage;

import com.mobiotics.hits.utilities.DemoExcelLibrary3;

public class CreateCustomerPage extends BasePage {

	String path="D:\\mobiotics_imcl_automation\\HITS_LCO\\ExcelPages\\TestData.xlsx";
	static final Logger logger = Logger.getLogger(CreateCustomerPage.class);

	public CreateCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='deviceserialno']/input")
	private WebElement device_SerialNo;
	
	@FindBy(xpath="//*[@id=\'postalcodeno\']/input")
	private WebElement postalCode;
	
	@FindBy(id="customertypeid")
	private WebElement customerType;
	
	@FindBy(xpath="//*[@id=\"hardwarelist\"]")
	private WebElement hardware_Select;
	
	@FindBy(xpath="//*[@id=\"basepacklist\"]")
	private WebElement select_BasePack_Select;
	
	@FindBy(xpath="//*[@id=\"smallcity\"]")
	private WebElement selectArea;
	
	@FindBy(xpath="//*[@id=\"createcustomer\"]/div[7]/div/input")
	private WebElement Address1;
	
	@FindBy(xpath="//*[@id=\"createcustomer\"]/div[8]/div/input")
	private WebElement Address2;
	
	@FindBy(xpath="//*[@id=\"titleid\"]")
	private WebElement selectTitle;
	
	@FindBy(xpath="//*[@id=\"createcustomer\"]/div[10]/div/input")
	private WebElement firstname;
	
	@FindBy(xpath="//*[@id=\"createcustomer\"]/div[11]/div/input")
	private WebElement Lastname;
	
	@FindBy(xpath="//input[@name='mobileno']")
	private WebElement MobileNumber;
	
	@FindBy(xpath="//*[@id=\"create\"]")
	private WebElement create;
	
	@FindBy(xpath="//*[@id=\"deviceserialno-status\"]")
	WebElement deviceSerialNoStatus;
	
	
	
	public void selectHardware() {
	
		selectValue(hardware_Select	, "Standard STB");
		
	}
	
	public void selectBasePack() {
		selectValue(select_BasePack_Select, "Foundation Pack - Rs. 35.4");
	}
	
	public void selectArea() {
		selectValue(selectArea, "Mumbai");
	}
	
	public void selectValue(WebElement element, String value)
	   {
		   Select selectValue =  new Select(element);
		   selectValue.selectByVisibleText(value);
	   }
	
	public void enterDeviceSerialNo(String deviceSrNo) {
		device_SerialNo.sendKeys(deviceSrNo);
	}
	
	public void enterPostalCode(String pinCode) {
		
		postalCode.sendKeys(pinCode);
	}
	
	public void selectCustomerType(String custType) {
		selectValue(customerType, custType);
	}
	
	public void enterAdd1() {
		
		//String path="D:\\mobiotics_imcl_automation\\HITS_LCO\\ExcelPages\\TestData.xlsx";
		String add1=DemoExcelLibrary3.getexcelData("create customer", 1, 1, path);
		Address1.sendKeys(add1);
		
		
	}
	
	public void enterAdd2() {
		//String path="D:\\mobiotics_imcl_automation\\HITS_LCO\\ExcelPages\\TestData.xlsx";
		String add2=DemoExcelLibrary3.getexcelData("create customer", 1, 2, path);
		Address2.sendKeys(add2);
	}
	
	public void SelectTitle(String title) {
		selectValue(selectTitle, title);
	}
	
	public void enterFirstName() {
		//String path="D:\\mobiotics_imcl_automation\\HITS_LCO\\ExcelPages\\TestData.xlsx";
		String firstName=DemoExcelLibrary3.getexcelData("create customer", 1, 3, path);
		firstname.sendKeys(firstName);
	}
	
	public void enterLastName() {
		//String path=System.getProperty("user.dir")+"/HITS_LCO/ExcelPages/TestData.xlsx";
		String lastName=DemoExcelLibrary3.getexcelData("create customer", 1, 4, path);
		waitTillElementIsVisible(Lastname);
		Lastname.sendKeys(lastName);
	}
	
	public void enterMobileNo(String mobNo) {
		waitTillElementIsVisible(MobileNumber);
		MobileNumber.sendKeys(mobNo);
		
	}
	
	public void clickCreateBtn() {
		waitTillElementIsVisible(create);
		create.click();
	}
	
	public void enterCustomerDetails(String deviceNo,String pinCode,String MobNo) {
		enterDeviceSerialNo(deviceNo);
		logger.info("user enters "+deviceNo+" as a device No");
		String SerialNoStatus=deviceSerialNoStatus.getText();
		if(SerialNoStatus=="Already Subscribed Device Serial Number") {
			logger.warn("user Already Subscribed Device Serial Number");
		}
		else {
			enterPostalCode(pinCode);
			logger.info("user enters "+pinCode+" as a pincode");
			
			selectCustomerType("Normal");
			logger.info("user selected the customer Type");
			selectHardware();
			logger.info("customer selected the Hardware type");
			selectBasePack();
			logger.info("customer selected Basepack");
			enterAdd1();
			logger.info("user enters Address1");
			enterAdd2();
			logger.info("user enters Address2");
			SelectTitle("Mr.");
			logger.info("user selected the customer Title");
			enterFirstName();
			logger.info("user enters the First Name");
			enterLastName();
			logger.info("user enters the Last Name");
			enterMobileNo(MobNo);
			logger.info("user enters mobile No");
			clickCreateBtn();
			logger.info("user click on the Create button");
		}
		
		
		
		
	}
	
	
	

	
}
