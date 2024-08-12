package practice.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.cmcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.basetest.BaseClass;

/**
 * test class for contact module
 * @author mamta
 * 
 */
public class SearchContactTest extends BaseClass {
	/*
	 * scenario : login()==>navigateContact==>createcontact()=verify
	 */
	@Test
	public void searchcontactTest() {
		/*Step 1: Login to application*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url","username", "password");
		
	}

}
