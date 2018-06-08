package com.Actitime.GenericLibrary;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileDataLib {
	
	public Properties getpropertyObj() throws IOException {
		FileInputStream fis=new FileInputStream("./testData/config.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		return pObj;
		
	}
	
	public String getExcelData(String SheetName,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream("./testData/testData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row r=sh.getRow(rownum);
		String data=r.getCell(cellnum).getStringCellValue();
		return data;
		
	}

}
