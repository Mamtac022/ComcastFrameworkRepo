 package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.cmcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.cmcast.crm.objectrepositoryutility.HomePage;
import com.cmcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.cmcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateOrganizationTest2 extends BaseClass {
	@Test(groups= "smokeTest")
	public void createOrganizationTest() throws Throwable, Throwable
	{
     		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
			// read testscript data from excel file
			
			String orgName = eLib.getDataFromExcel("Orgtestcase", 1, 2)+jLib.getRandomNumber(); 
			
		    // Step: Navigate to Organization module
			UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		   HomePage hp = new HomePage(driver);
		   hp.getOrganizationlnk().click();
		    
		    // Step: Click on "create Organizatin" Button
		   UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		   OrganizationPage op = new OrganizationPage(driver);
		    op.getOrganizationImg().click();
		    
		    // Step: Enter all the details and create new organization
		    UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		    
		    CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		    cp.newOrgName(orgName);
		    UtilityClassObject.getTest().log(Status.INFO, orgName+ "=====>create a new Org");
		    
		    
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
		    // Verify Header orgname Expected Result
		    
		    String actOrganame =oip.getViewOrgName().getText();
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
	
	public void createOrganizationWithIndustriesTest() throws Throwable, Throwable
	{
		
		// read testscript data from excel file
		
		String orgName = eLib.getDataFromExcel("Orgtestcase", 4, 2)+jLib.getRandomNumber();
		String industry =eLib.getDataFromExcel("Orgtestcase", 4, 3);
		String type =eLib.getDataFromExcel("Orgtestcase", 4, 4);
		
		
	    // Step: Navigate to Organization module
	    HomePage hp = new HomePage(driver);
		   hp.getOrganizationlnk().click();
		    
	    
	    // Step: Click on "create Organizatin" Button
		   OrganizationPage op = new OrganizationPage(driver);
		    op.getOrganizationImg().click();
		    
	    // Step: Enter all the details and create new organization
		    CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
		    cp.newOrgName(orgName, industry, type); 
	    
	    //Verify Industry and type information
		    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		    oip.getIndustryType().getText();
	    String actIndustries=	oip.getIndustryType().getText();
	    if(actIndustries.contains(industry)) {
	    	System.out.println(industry + "is verified");
	    }
	    else
	    {
	    	System.out.println(industry + "is not verified");
	    }
	    
	    String actType =oip.getType().getText();
	    if(actType.equals(type))
	    {
	    	System.out.println(type +"is verified");
	    }
	    else
	    {
	    	System.out.println(type +"is not verified"); 
	    }
	}
@Test(groups= "regressionTest")
public void createOrganizationWithPhoneNumberTest() throws Throwable 
{	// read testscript data from excel file
	
	String orgName = eLib.getDataFromExcel("Orgtestcase", 7, 2)+jLib.getRandomNumber();
	String phoneNumber = eLib.getDataFromExcel("Orgtestcase", 7, 3);
	  // Step: Navigate to Organization module
	   HomePage hp = new HomePage(driver);
	   hp.getOrganizationlnk().click(); 
    
    // Step: Click on "create Organizatin" Button
	   OrganizationPage op = new OrganizationPage(driver);
	    op.getOrganizationImg().click();
    
    // Step: Enter all the details and create new organization
	    
	    CreatingNewOrganizationPage cp = new CreatingNewOrganizationPage(driver);
	    cp.newOrgName(orgName, phoneNumber);
	    
    
    //Verify phone information
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    
    String actphoneNo=	oip.getPhoneNumber().getText();
    if(actphoneNo.contains(phoneNumber)) {
    	System.out.println(phoneNumber+ "is created");
    }
    else
    {
    	System.out.println(phoneNumber + "is not created");
    }
  
}

		    

}
