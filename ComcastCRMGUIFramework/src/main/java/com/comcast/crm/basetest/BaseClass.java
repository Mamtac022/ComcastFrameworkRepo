package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cmcast.crm.objectrepositoryutility.HomePage;
import com.cmcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class BaseClass {
	
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib =new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver =null;
	public static WebDriver sdriver =null;
	
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void configBS() throws Throwable {
		System.out.println("====connect to dB and report config=====");
		dbLib.getDbconnection();	
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC() throws Throwable {		
		System.out.println("====Launch the Browser=====");
		//String BROWSER= browser;
			String BROWSER=fLib.getDataFromPropertiesFile("browser");	
	    if(BROWSER.equals("chrome"))
	    {
	    	driver = new ChromeDriver();
        }
	    else if(BROWSER.equals("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    else if(BROWSER.equals("edge"))
	    {
	    	driver = new EdgeDriver();
	    }
	    else
	    {
	    	driver= new ChromeDriver();
	    }
	    sdriver = driver;
//	    UtilityClassObject.setDriver(driver);
		
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("====Login====");
		String URL=fLib.getDataFromPropertiesFile("url");
		
		String USERNAME= fLib.getDataFromPropertiesFile("username");
		String PASSWORD= fLib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME, PASSWORD,URL);;
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	
		public void configAM() {
			System.out.println("===Logout====");
			HomePage hp = new HomePage(driver);
			hp.logout(wLib);
			
			
		}
	
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("====close the browser=====");
		driver.quit();
	}
	
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("=====close to dB and report backup");
		dbLib.closeDbconnection();
		
	}

}
