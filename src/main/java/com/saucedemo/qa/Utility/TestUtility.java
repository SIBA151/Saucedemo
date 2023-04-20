package com.saucedemo.qa.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtility {


	public static void takeScreenshotAtEndOfTest(WebDriver driver, String screenShotName) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("./ScreenShot/"+screenShotName+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
