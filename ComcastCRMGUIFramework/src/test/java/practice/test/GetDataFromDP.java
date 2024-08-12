package practice.test;

import org.testng.annotations.Test;

public class GetDataFromDP {
	@Test(dataProviderClass=ByHavingMultipleDataUsingDP.class,dataProvider ="getDataForProduct")
		public void getDataFromDP(String mobileName, String brandName) {
		System.out.println("mobileName:"+mobileName+"brandName:"+brandName);
		
		
	}

}
