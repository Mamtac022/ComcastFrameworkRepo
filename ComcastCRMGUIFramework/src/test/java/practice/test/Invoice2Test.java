package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class Invoice2Test extends BaseClass{
	
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTEst");
		String actTitle =driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceTEst");
		String actTitle =driver.getTitle();
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	

}
