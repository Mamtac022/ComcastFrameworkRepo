package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;
	public CreateNewContactPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement saveBtn;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement contactBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(id ="1")
	private WebElement orgname;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	public WebElement getStartDate() {
		return startDate;
	}
	public WebElement getEndDate() {
		return endDate;
	}
	
	
	
	
	public WebElement getContactLastName() {
		return lastnameEdt;
			
	}
	
	

	public WebElement  getSaveBtn()
{
		return	saveBtn;	}
	
	public WebElement getContactBtn() {
		return contactBtn;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getOrganization() {
		return orgname;
	}
	
 
	
	
	public void getContactName(String lastName) {
		lastnameEdt.sendKeys(lastName);
		
		
	}
	
	public void getOrgName(String orgName)
	{
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		orgname.click();
		
	}
	
	
	
}
