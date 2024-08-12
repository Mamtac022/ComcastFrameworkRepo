package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {
	public void getDataFromJsonFile() throws FileNotFoundException{
		FileReader fileR = new FileReader("./configAppData/appCommonData.json");
	}

}
