package practice.test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateOrganizationWithPhoneNumberTest extends BaseClass{

	@Test
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
	    
	    
	    // Step: logout
	    
	  
	   
	    //driver.quit();
		
		
	}

}
