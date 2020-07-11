package com.crm.genericLib;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.ObjectRerpo.LoginPage;

public class Baseclass {

	WebDriver webDriver;
	Filelibrary filelibrary1;

	@BeforeClass
	public void configBerforClass() throws Throwable {

		filelibrary1 = new Filelibrary();

		String BROWSER_NAME = filelibrary1.getPropertiesObect().getProperty("browser");

		if (BROWSER_NAME.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
			webDriver = new ChromeDriver();

		} else {
			System.out.println("Try After Sometiem");
		}
	}

	@BeforeMethod
	public void configBeforMethod() throws Throwable {
		
		filelibrary1 =new Filelibrary();
		WebdriverCommonLib commonLib=new WebdriverCommonLib();
		
		webDriver.manage().window().maximize();
		commonLib.waitToPageLoad(webDriver);
		webDriver.navigate().to(filelibrary1.getPropertiesObect().getProperty("url"));
		LoginPage loginPage=PageFactory.initElements(webDriver, LoginPage.class);
		loginPage.LogInToApp();

	}

	@AfterMethod
	public void configAfterMethod() {
		
	 System.out.println("Logout done sucessfully");

	}

	@AfterClass
	public void configAfterClass() {
      
		//webDriver.close();
	}

}
