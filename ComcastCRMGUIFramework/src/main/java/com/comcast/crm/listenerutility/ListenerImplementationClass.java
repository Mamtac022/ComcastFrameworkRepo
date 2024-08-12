package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	
	public  ExtentReports report;
	
	public  ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time =	new Date().toString().replace(" ","_").replace(":","_");
		///spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM test suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env information and create test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"===START====");
		test =report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"===START====");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"=======END=====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"===COMPLETED====");
	}
	
	public void onTestFailure(ITestResult result) {
		String testName =result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot)BaseClass.sdriver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64); 
			String time =	new Date().toString().replace(" ","_").replace(":","_");
			test.addScreenCaptureFromBase64String(filePath,testName+"_"+time);
			test.log(Status.FAIL,result.getMethod().getMethodName()+"===FAILED====");
			test.log(Status.FAIL, result.getThrowable());
	}	
	public void onTestSkipped(ITestResult result) {
		System.out.println("======"+result.getMethod().getMethodName()+"=======SKIPPED=====");
		test.log(Status.SKIP,result.getThrowable());
		
	}
}
