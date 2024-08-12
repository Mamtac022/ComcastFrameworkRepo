package practice.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

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

public class CreateOrganization1Test extends BaseClass{
@Test
public void createOrganizationTest() throws Throwable, Throwable
{
		// read testscript data from excel file
		
		String orgName = eLib.getDataFromExcel("Orgtestcase", 1, 2)+ jLib.getRandomNumber();
		
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
	    // Verify Header orgname Expected Result
	    
	    String actOrganame =oip.getViewOrgName().getText();
	    if(actOrganame.equals(orgName))
	    {
	    	System.out.println(orgName +"is available");
	    }
	    else
	    {
	    	System.out.println(orgName +"is not available"); 
	    }}

	    
	   
	   
	}


