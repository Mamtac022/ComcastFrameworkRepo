package practice.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import com.cmcast.crm.objectrepositoryutility.HomePage;
import com.cmcast.crm.objectrepositoryutility.LoginPage;
import com.cmcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
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
