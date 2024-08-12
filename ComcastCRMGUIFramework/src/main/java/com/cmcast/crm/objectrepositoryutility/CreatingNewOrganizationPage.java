package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement orgnameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDB;
	
	@FindBy(name="accounttype")
	private WebElement typeDB;
	
	@FindBy(name="phone")
	private WebElement phoneEdt;
	
	

	public WebElement  getOrganizationName()
{
		return	 orgnameEdt;	}
	
	public WebElement getIndustry() {
		return industryDB;
	}
	
	public WebElement getType() {
		return typeDB;
	}
	
	public WebElement getPhoneNumber() {
		return phoneEdt;
	}
	

	public WebElement  getSaveBtn()
{
		return	saveBtn;	}
	
	public void newOrgName(String orgName) {
		orgnameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void newOrgName(String orgName, String industry, String type) {
		orgnameEdt.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(typeDB);
		sel1.selectByVisibleText(type);
		saveBtn.click();
		
	}
	
	public void newOrgName(String orgName, String phoneNumber) {
		orgnameEdt.sendKeys(orgName);
		phoneEdt.sendKeys(phoneNumber);
		saveBtn.click();
	}
	
	
}
