package com.mobiotics.hits.Device_suspension;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mobiotics.hits.Customer_SubscriberCornerPage.SubscriberCornerPage;
import com.mobiotics.hits.commonpages.BasePage;
import com.mobiotics.hits.utilities.DemoExcelLibrary3;

import generic.DateHelper;

public class DeviceSuspensionPage extends BasePage{
	
	String fromDateXp1 = "/html/body/div[4]/div[1]/div[2]/div/div/div[1]/div[2]/table/tbody/tr[";
	String fromDateXp2 = "]/td[";
	
	String path="./ExcelPages/TestData.xlsx";
	
	DateHelper dh = new DateHelper();
	
	public DeviceSuspensionPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	static final Logger logger = Logger.getLogger(SubscriberCornerPage.class);
	
	@FindBy(xpath = "//h1[text()='Suspension']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-calendar'])[1]")
	private WebElement fromDateCal;
	
	@FindBy(xpath = "(//a[@class='previous']/following-sibling::span)[1]")
	private WebElement fromMonth;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[1]")
	private WebElement previousMnthShftFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	private WebElement nxtShftMnthFrm;
	
	@FindBy(xpath = "(//a[@class='previous'])[2]/following-sibling::span")
	private WebElement yearFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-left'])[2]")
	private WebElement previousShftYearFrom;
	
	@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[2]")
	private WebElement nxtShftYEARFrom;
	
	@FindBy(id = "refresh")
	private WebElement goDateBtn;
	
	@FindBy(name = "customerid")
	private WebElement customerIdTxtFld;
	
	@FindBy(xpath = "//input[@name='customerid']/following-sibling::button")
	private WebElement goBtnCustId;
	
	@FindBy(id = "activitystatus")
	private WebElement activityStatus;
	
	@FindBy(id = "bulksuspensionmodal")
	private WebElement suspensionBtn;
	
	@FindBy(id = "customerno")
	private WebElement custIdTxtFieldInPopup;
	
	@FindBy(id = "uploadSingleSuspension")
	private WebElement submitBtnPopUp;
	
	@FindBy(xpath = "//*[@id=\"suspensionmessage\"]/p[1]/div/strong")
	private WebElement suspensionMsg;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement uploadFile;
	
	@FindBy(id = "uploadBulk")
	private WebElement uploadBtn;
	
	@FindBy(xpath = "//label[text()='Upload success']")
	private WebElement uploadSuccessMsg;
	
	@FindBy(id = "myModalLabel")
	private WebElement popupTitle;
	
	@FindBy(id = "uploadtype")
	private WebElement uploadTypeDropDown;
	
	@FindBy(id = "close")
	private WebElement closeBtn;
	
	@FindBy(xpath = "//button[text()='Suspension Download']")
	private WebElement suspensionDownloadBtn;
	
	@FindBy(xpath = "//td[text()='undefined']")
	private WebElement unDefinedMsg;
	
	@FindBy(xpath = "//td[text()='No Data Found']")
	private WebElement noDataMsg;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[2]")
	private WebElement customerIdDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[8]")
	private WebElement activityStatusDisplaying;
	
	@FindBy(xpath = "//table[@class='table table-striped']/thead/tr")
	private WebElement headerRow;
	
	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]")
	private WebElement firstRow;
	

	
	public void selectDates(String fromDate) throws InterruptedException
	{
		waitTillElementIsClickable(fromDateCal);
		fromDateCal.click();
		Thread.sleep(3000);
		String fromDateArr[] = fromDate.split("-");
		dh.selectYear(previousShftYearFrom, nxtShftYEARFrom, Integer.parseInt(yearFrom.getText()), Integer.parseInt(fromDateArr[2]));
		dh.selectMonth(previousMnthShftFrom, nxtShftMnthFrm, fromMonth.getText(), Integer.parseInt(fromDateArr[1]));
		dh.selectDate(fromDateXp1, fromDateXp2, Integer.parseInt(fromDateArr[0]));	
		Thread.sleep(1000);
		goDateBtn.click();
		Thread.sleep(1000);
	}
	
	public void enterCustomerId(String customerId)
	{
		customerIdTxtFld.clear();
		customerIdTxtFld.sendKeys(customerId);
		waitTillElementIsClickable(goBtnCustId);
		goBtnCustId.click();
	}
	
	public void  selectStatus(String status)
	{
		Select statusList = new Select(activityStatus);
		statusList.selectByVisibleText(status);
	}
	
	public void createSuspension(String uploadType) throws InterruptedException
	{
		waitTillElementIsClickable(suspensionBtn);
		Thread.sleep(6000);
		suspensionBtn.click();
		Select listUploadType = new Select(uploadTypeDropDown);
		listUploadType.selectByVisibleText(uploadType);
		if(uploadType.equalsIgnoreCase("Single"))
		{
			String customerIoBeSuspend = DemoExcelLibrary3.getexcelData("modify customer", 1, 10, path);
			custIdTxtFieldInPopup.sendKeys(customerIoBeSuspend);
			submitBtnPopUp.click();
			
			try {
				if(suspensionMsg.isDisplayed())
				{
					logger.info(suspensionMsg.getText());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			closeBtn.click();
				
		}
		
		else {
			Thread.sleep(2000);
			uploadFile.sendKeys("C:/Users/Sakshi/eclipse-workspace/HITS_LCO/ExcelPages/bulksuspension_reactivatetemplate.csv");
			waitTillElementIsClickable(uploadBtn);
			uploadBtn.click();
			if(uploadSuccessMsg.isDisplayed())
			{
				logger.info(uploadSuccessMsg.getText());
				Assert.assertTrue(uploadSuccessMsg.isDisplayed());
			}
			else
			{
				logger.info("Bulk Upload is failed");
			}
			Thread.sleep(1000);
			closeBtn.click();
			
		}
		
	}
	
	public void testSuspension() throws InterruptedException
	{
		String fromDate = DemoExcelLibrary3.getexcelData("modify customer", 1, 6, path);
		selectDates(fromDate);
		
		String customerId = DemoExcelLibrary3.getexcelData("modify customer", 1, 7, path);
		enterCustomerId(customerId);
		
		String status = DemoExcelLibrary3.getexcelData("modify customer", 1, 8, path);
		selectStatus(status);
		
		String customerIoBeSuspend = DemoExcelLibrary3.getexcelData("modify customer", 1, 10, path);
		createSuspension("Single");
		
		Thread.sleep(3000);
		
		createSuspension("Bulk");
		Thread.sleep(5000);
		if(suspensionDownloadBtn.isEnabled())
		{
			suspensionDownloadBtn.click();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
