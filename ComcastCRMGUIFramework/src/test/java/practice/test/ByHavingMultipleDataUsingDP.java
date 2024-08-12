package practice.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ByHavingMultipleDataUsingDP {

	@DataProvider
	public Object[][] getDataForProduct() throws Throwable, IOException
	{
		ExcelUtility eLib = new ExcelUtility();
		int rowCount =eLib.getRowcount("Sheet1");
		
		
		Object[][] objArr = new Object[3][2];
		
		for(int i=0;i<rowCount;i++) {
			
			objArr[i][0]=eLib.getDataFromExcel("Sheet1", i+1,0);
			objArr[i][1]=eLib.getDataFromExcel("Sheet1", i+1,1);
		
		}
		
		return objArr;
	}
	
	@DataProvider
	public Object[][] getDataForUser() throws Throwable, IOException
	{
		ExcelUtility eLib = new ExcelUtility();
		int rowCount =eLib.getRowcount("Sheet2");
		
		
		Object[][] objArr = new Object[3][2];
		
		for(int i=0;i<rowCount;i++) 
		{
			
			objArr[i][0]=eLib.getDataFromExcel("Sheet2", i+1,0);
			objArr[i][1]=eLib.getDataFromExcel("Sheet2", i+1,1);
		}
		return objArr;
	}
	
}
