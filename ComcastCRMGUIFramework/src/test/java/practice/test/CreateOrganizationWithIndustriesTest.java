package practice.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustriesTest extends BaseClass
{

	@Test
	
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

}
