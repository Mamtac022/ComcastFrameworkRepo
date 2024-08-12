package com.comcast.crm.contactest;

import org.testng.AssertJUnit;
/**
 * @author mamta
 */
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cmcast.crm.objectrepositoryutility.ContactInfoPage;
import com.cmcast.crm.objectrepositoryutility.ContactPage;
import com.cmcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.cmcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.cmcast.crm.objectrepositoryutility.HomePage;
import com.cmcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.cmcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.basetest.BaseClass;

public class CreateContactTest1 extends BaseClass {
	@Test(groups= "smokeTest")
	public void createContactTest() throws EncryptedDocumentException, IOException {

		String lastName = eLib.getDataFromExcel("contact", 1, 2)+ jLib.getRandomNumber();
	    // Step: Navigate to Contact module
		   
		   HomePage hp = new HomePage(driver);
		   hp.getContactlnk().click();
	    
	    // Step: Click on "create Contact" Button
		   OrganizationPage op = new OrganizationPage(driver);
		   op.getContactImg().click();
	  
	    // Step: Enter all the details and create new Contact
		   CreateNewContactPage cp = new CreateNewContactPage(driver);
		   cp.getContactName(lastName);
		   cp.getSaveBtn().click();
		   
		   //Verify Header message
		   ContactPage cpp = new ContactPage(driver);
		   
		   String actHeader = cpp.getHeaderMsg().getText();
		   boolean status= actHeader.contains(lastName);
		   SoftAssert soft1 = new SoftAssert();
		   soft1.assertEquals(status, true);
		 
	    // Verify lastName  Expected Result
		   
		   ContactInfoPage cip = new ContactInfoPage(driver);
		   
	    String actLastName =cip.getViewContactLastName().getText();
	    
	    SoftAssert soft = new SoftAssert();
	    soft.assertEquals(actLastName, lastName);
	   
	}
	    
	
	@Test(groups= "regressionTest")
	public void createContactwithOrganizationTest() throws Throwable 
	{
		// read testscript data from excel file
		
		String orgName = eLib.getDataFromExcel("Contact", 7, 2)+jLib.getRandomNumber();
		
		String contactLastName =eLib.getDataFromExcel("Contact", 7, 3);
		
	    // Step: Navigate to Organization module
		   HomePage hp = new HomePage(driver);
		   hp.getOrganizationlnk().click();
	     
	    
	    // Step: Click on "create Organizatin" Button
		   
		   OrganizationPage op = new OrganizationPage(driver);
		    op.getOrganizationImg().click();
	   
	    
	    // Step: Enter all the details and create new organization
		    
		    CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		    cp.newOrgName(orgName);
		   
	    
	    //Verify Header message Expected Result
		    
		    OrganizationInfoPage oip = new OrganizationInfoPage(driver); 
		    
		    String headermsg=	oip.getHeaderMsg().getText();
		    if(headermsg.contains(orgName)) {
		    	System.out.println(orgName+ "is created");
		    }
		    else
		    {
		    	System.out.println(orgName + "is not created");
		    }
	    
	    //Step: Navigate to contact module
	    
		   
			   hp.getContactlnk().click();
       
	    
	    // Step: Click on "create Contact" Button
			   
			   op.getContactImg().click();
	    
	    // Step: Enter all the details and create new Contact
			   
			   CreateNewContactPage cnp = new CreateNewContactPage(driver);
			   cnp.getContactName(contactLastName);
			   cnp.getContactBtn().click();
			   
	    
	    
	    //Switch to child window
	    
	    wLib.switchToTabOnURL(driver, "module=Accounts");
	    
	    cnp.getOrgName(orgName);
	    cnp.getOrganization().click();
	 
	    //switch to parent window
	    
	    wLib.switchToTabOnURL(driver,"Contacts&action" );
	    
	    cnp.getSaveBtn().click();
	    
	    
	    
	    // Verify  contactlastname Expected Result
	    
	    ContactInfoPage cip = new ContactInfoPage(driver);
	    String actOrganame =cip.getViewContactLastName().getText();
	    if(actOrganame.equals(contactLastName))
	    {
	    	System.out.println(contactLastName +"is available");
	    }
	    else
	    {
	    	System.out.println(contactLastName +"is not available"); 
	    }
	  
	    
	  
	    // Verify  orgname Expected Result
	    
	    actOrganame =cip.getViewOrgName().getText();
	    actOrganame =driver.findElement(By.id("mouseArea_Organization Name")).getText();
	    if(actOrganame.equals(orgName))
	    {
	    	System.out.println(orgName +"is available");
	    }
	    else
	    {
	    	System.out.println(orgName +"is not available"); 
	    }
	   
	}
		
	    @Test(groups= "regressionTest")
		public void createContactWithSupportDateTest() throws Throwable, IOException
		{// read testscript data from excel file
			
			String lastName = eLib.getDataFromExcel("Contactcase", 4, 2)+jLib.getRandomNumber();
		// Step: Navigate to Contact module
			   
			   HomePage hp = new HomePage(driver);
			   hp.getContactlnk().click(); 
		    
		    // Step: Click on "create Contact" Button
			   OrganizationPage op = new OrganizationPage(driver);
			   op.getContactImg().click();
			   
			   
		      String startDate= jLib.getSystemDateYYYYDDMM();
		      String endDate=jLib.getRequiredDateYYYYDDMM(30);
		    
		    // Step: Enter all the details and create new Contact
		      
		      CreateNewContactPage cp = new CreateNewContactPage(driver);
			   cp.getContactName(lastName);
			   cp.getStartDate().clear();
			   cp.getStartDate().sendKeys(startDate);
			   cp.getEndDate().click();
			   cp.getEndDate().sendKeys(endDate);
		  
			   cp.getSaveBtn().click();
		    // Verify lastName  Expected Result
			   
			   ContactInfoPage cip = new ContactInfoPage(driver);
		    
		    String actLastName =cip.getViewContactLastName().getText();
		    if(actLastName.equals(lastName))
		    {
		    	System.out.println(lastName +"is available");
		    }
		    else
		    {
		    	System.out.println(lastName +"is not available"); 
		    }
		    
		    //Verify StartDate
		    
		    
		    String actStartDate =cip.getViewStartDate().getText();
		    if(actStartDate.equals(startDate))
		    {
		    	System.out.println(startDate +"is available");
		    }
		    else
		    {
		    	System.out.println(startDate +"is not available"); 
		    }
		    
		    //Verify endDate
		    String actEndDate =cip.getViewEndDate().getText();
		    if(actEndDate.equals(endDate))
		    {
		    	System.out.println(endDate +"is available");
		    }
		    else
		    {
		    	System.out.println(endDate +"is not available"); 
		    }
		    
		    // Step: logout
		    
		  
		   
		    //driver.quit();
			
			

		}

		

	}


