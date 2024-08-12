package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./testscriptdata/VitegarTestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String data =book.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		book.close();
		return data;
		
		
	}
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testscriptdata/VitegarTestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		int rowCount = book.getSheet(sheetName).getLastRowNum();
		book.close();
		return rowCount;
		
	}
	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./testscriptdata/VitegarTestScriptData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos = new FileOutputStream("./testscriptdata/OrangeHrmTestData.xlsx");
		book.write(fos);
	    book.close();
	}
}
