package com.saucedemo.qa.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.saucedemo.qa.Utility.ExtentReporter;

public class Listeners extends BaseTest implements ITestListener{

	
	ExtentReports extent=ExtentReporter.getReport();
	ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed testcase is: "+result.getName(), ExtentColor.GREEN));
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed testcase is: "+result.getName(), ExtentColor.RED));
		test.fail(result.getThrowable());
		
		String screenShotPath=takeScreenshot(result.getName());
		
		test.addScreenCaptureFromPath(screenShotPath);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip testcase is: "+result.getName(), ExtentColor.ORANGE));
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
