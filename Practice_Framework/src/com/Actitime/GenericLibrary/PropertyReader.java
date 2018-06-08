package com.Actitime.GenericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyReader {
	
	public static void reader() {
		
		try {
			Properties prop=new Properties();
			
			File f=new File("./testData/config.properties");
			FileInputStream fis=new FileInputStream(f);
			prop.load(fis);
			
			String browsername=prop.getProperty("browsername");
			System.out.println(browsername);
		}catch(Exception e) {
			System.out.println("reading failed due to "+e);
		}
	}
	
	@Test
	public void read() {
		 
		try {
			reader();
		}catch(Exception e){
			System.out.println("failed due to "+e);
			throw e;
			
		}
	}

}
