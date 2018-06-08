package com.Actitime.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogIn {
	
	@FindBy(name="username")
	private WebElement usrnameinput;
	
	@FindBy(name="pwd")
	private WebElement passwordinput;
	
	@FindBy(id="loginButton")
	private WebElement loginbtn;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement checkbx;
	
	@FindBy(xpath="//span[text()='Username or Password is invalid. Please try again.']")
	private WebElement errormsg;

	public WebElement getUsrnameinput() {
		return usrnameinput;
	}

	public WebElement getPasswordinput() {
		return passwordinput;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getCheckbx() {
		return checkbx;
	}
	
	public WebElement getErrormsg() {
		return errormsg;
	}

	
	public void Login(String username,String password) {
		usrnameinput.sendKeys(username);
		passwordinput.sendKeys(password);
		loginbtn.click();
		
	}
	
	public void Login() {
		usrnameinput.sendKeys("admin");
		passwordinput.sendKeys("manager");
		loginbtn.click();
	}

}
