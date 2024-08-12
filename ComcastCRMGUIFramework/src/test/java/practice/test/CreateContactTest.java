package practice.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateContactTest extends BaseClass{
	
	@Test
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
		 
	    // Verify lastName  Expected Result
		   ContactInfoPage cip = new ContactInfoPage(driver);
		   
	    
	    String actLastName =cip.getViewContactLastName().getText();
	    if(actLastName.equals(lastName)) {
	    	System.out.println(lastName +"is available"); }
	    else {
	    	System.out.println(lastName +"is not available"); 
	    	}
	}
	    // Step: logout
	    //   driver.quit();
	   
		

	}



