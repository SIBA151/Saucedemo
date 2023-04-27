package com.saucedemo.qa.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtility {

	static String path=System.getProperty("user.dir")+"\\testData\\saucedemoData.xlsx";
	static XSSFWorkbook wb;
    
	//Take Screenshot method
	public static void takeScreenshotAtEndOfTest(WebDriver driver, String screenShotName) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./ScreenShot/"+screenShotName+".png"));  //System.currentTimeMillis()+
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
