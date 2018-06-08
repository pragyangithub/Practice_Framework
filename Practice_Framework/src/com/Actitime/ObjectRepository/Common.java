package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Common {
	
	@FindBy(id="logoutLnk")
	private WebElement logoutlnk;

	public WebElement getLogoutlnk() {
		return logoutlnk;
	}
	
	public void Logout() {
		logoutlnk.click();
	}

}
