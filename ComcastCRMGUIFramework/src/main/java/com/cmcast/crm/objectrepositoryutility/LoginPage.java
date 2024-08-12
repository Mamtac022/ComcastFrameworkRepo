package com.cmcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
/**
 * @author mamta
 * contains Login page elements and business lib like login ()
 * 
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {//Rule1 create a separate java class
						// Rule2 Object creation
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
						//Rule3 Object Intialization
	
	//Rule 4 Object encapsulation
	
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	              //Rule5 provide action
	/**
	 * login to Application based on username, password and url arguments
	 * @param username
	 * @param password
	 * @param url
	 */
	
	public void loginToapp(String username, String password, String url) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	}


