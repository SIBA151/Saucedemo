package com.saucedemo.qa.Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtility {

	
	static XSSFWorkbook wb;
    
	
	
	public static Object[][] getTestData(String sheetTabName) {
		
		try {
			FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\testData\\saucedemoData.xlsx");
			wb=new XSSFWorkbook(fis);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet=wb.getSheet(sheetTabName);
		
		Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
	
	

}
