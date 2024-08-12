package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {

	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organiztionlnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	

		
	public WebElement  getOrganizationlnk()
{
		return	 organiztionlnk;	}
	
	public WebElement getContactlnk()
	{
		return contactlnk;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	
	public WebElement getProduct()
	{
		return productLnk;
	}
	
	public void logout(WebDriverUtility wLib) {
		wLib.mousehover(driver, adminImg);
		signOutLnk.click();
	}
	
	
	
	
		
	}


