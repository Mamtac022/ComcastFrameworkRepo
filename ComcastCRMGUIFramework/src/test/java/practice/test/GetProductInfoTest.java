package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest{
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//search product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div/div/div/div/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable, Throwable{
		
		ExcelUtility eLib = new ExcelUtility();
		int rowCount =eLib.getRowcount("product");
		
		
		Object[][] objArr = new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++) {
		
		objArr[i][0]=eLib.getDataFromExcel("product", i+1,0);
		objArr[i][1]=eLib.getDataFromExcel("product", i+1,1);
		}
		
		
		
		
		return objArr;
	}

}
