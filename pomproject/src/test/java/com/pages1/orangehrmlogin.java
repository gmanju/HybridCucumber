package com.pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangehrmlogin {

	WebDriver driver;
	@FindBy(id="txtUsername")
	WebElement username;
	@FindBy(id="txtPassword")
	WebElement pwd;
	@FindBy(className="button")
	WebElement login;
	
	public orangehrmlogin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void login(String u,String p) {
		username.sendKeys(u);
	pwd.sendKeys(p);
	login.click();
	
	}
	
	
	
}
