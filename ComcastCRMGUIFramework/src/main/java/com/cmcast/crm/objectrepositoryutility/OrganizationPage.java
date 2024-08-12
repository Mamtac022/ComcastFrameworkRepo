package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createorgimg;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement contactBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	public WebElement  getOrganizationImg()
	{
			return	 createorgimg;	}
	
	public WebElement getContactImg() {
		return contactBtn;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchDD() {
		return searchDD;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
		
}
