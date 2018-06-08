package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.Actitime.ObjectRepository.Common;
import com.Actitime.ObjectRepository.LogIn;

public class BaseClass {
	public static WebDriver driver;
	FileDataLib flib=new FileDataLib();
	Properties pObj;
	
	@BeforeClass
	public void configBC() throws IOException {
		pObj=flib.getpropertyObj();
		String bName=pObj.getProperty("browser");
		if(bName.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(bName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./resource/chromedriver.exe");
				driver=new ChromeDriver();
			}
	}
		
	 @BeforeMethod
	 public void configBM() {
		 String url=pObj.getProperty("url");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get(url);
		 
		 LogIn lpage=PageFactory.initElements(driver, LogIn.class);
		 lpage.Login();
		 
	 
		}
 
	 @AfterMethod
	 public void configAM() {
		 Common cpage=PageFactory.initElements(driver, Common.class);
		 cpage.Logout();
	 }
	 
	 @AfterClass
	 public void configAC() {
		 driver.close();
	 }
}


