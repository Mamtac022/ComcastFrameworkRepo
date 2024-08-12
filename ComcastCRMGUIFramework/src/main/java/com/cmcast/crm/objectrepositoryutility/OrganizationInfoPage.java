package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement viewOrgName;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryType;
	
	@FindBy(id="dtlview_Type")
	private WebElement type;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneEdt;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public WebElement getViewOrgName() {
		return viewOrgName;
	}
	
	public WebElement getIndustryType() {
		return industryType;
	}
	
	public WebElement getType()
	{
		return type;
	}
	
	public WebElement getPhoneNumber() {
		return phoneEdt;
	}
	public void organizationInfo() {
		headerMsg.getText();
		viewOrgName.getText();
	}

}
