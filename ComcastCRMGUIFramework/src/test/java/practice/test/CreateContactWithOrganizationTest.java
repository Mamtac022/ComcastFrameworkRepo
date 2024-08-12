package practice.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.cmcast.crm.objectrepositoryutility.ContactInfoPage;
import com.cmcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.cmcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.cmcast.crm.objectrepositoryutility.HomePage;
import com.cmcast.crm.objectrepositoryutility.LoginPage;
import com.cmcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.cmcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrganizationTest extends BaseClass{

	@Test
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
	   // driver.quit();
		
		
		
		

	}

}
