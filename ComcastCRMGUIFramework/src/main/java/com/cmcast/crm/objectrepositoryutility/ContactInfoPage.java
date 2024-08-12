package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement viewContactName;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgnName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement viewStartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement viewEndDate;
	
	
	public WebElement getViewContactLastName() {
		return viewContactName;
	}
	
	public WebElement getViewOrgName() {
		return orgnName;
	}
	
	public WebElement getViewStartDate() {
		return viewStartDate;
	}
	
	public WebElement getViewEndDate() {
		return viewEndDate;
	}
}
