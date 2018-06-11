package com.Actitime.TestScript;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.FileDataLib;
import com.Actitime.ObjectRepository.LogIn;

public class Asdf {

	 FileDataLib flib=new FileDataLib();
	 WebDriver driver;
	 Properties pObj;
	 
	 @BeforeClass
		public void configBC() throws Throwable {
			pObj=flib.getpropertyObj();
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	 
	 
	  @Test
	  public void verifyInvalidUsername() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  
		  String InvalidUsername=flib.getExcelData("Sheet1", 3, 2);
		  String Errormsg=flib.getExcelData("Sheet1", 3, 3);
		  String Password=pObj.getProperty("password");
		  
		  driver.get(pObj.getProperty("url"));
		  LogIn lpage=PageFactory.initElements(driver, LogIn.class);
		  
		  lpage.getUsrnameinput().sendKeys(InvalidUsername);
		  lpage.getPasswordinput().sendKeys(Password);
		  lpage.getLoginbtn().click();
		  
		  String actmsg=lpage.getErrormsg().getText();
		  
		  Assert.assertEquals(Errormsg, actmsg);
		  
		  
		  
		  
		  
	  }

	  
	  @Test
	  public void verifyInvalidPassword() throws EncryptedDocumentException, InvalidFormatException, IOException {
		  
		  String InvalidPassword=flib.getExcelData("Sheet1", 4, 2);
		  String Errormsg=flib.getExcelData("Sheet1", 4, 3);
		  
		  String username=pObj.getProperty("username");
		  
		  driver.get(pObj.getProperty("url"));
		  LogIn lpage=PageFactory.initElements(driver, LogIn.class);
		  
		  lpage.getUsrnameinput().sendKeys(username);
		  lpage.getPasswordinput().sendKeys(InvalidPassword);
		  lpage.getLoginbtn().click();
		  
		  String actmsg=lpage.getErrormsg().getText();
		  
		  Assert.assertEquals(Errormsg, actmsg);
		  
		  
		 }
	  
	  @AfterClass
		public void configAC() {
			driver.close();
		}


}
