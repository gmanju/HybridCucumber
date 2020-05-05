package com.testcases1;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass1.Library;
import com.pages1.Facebooklogin;

public class Logintestcase extends Library {
	@BeforeClass
	public void startup() {
		launchApplication("chrome","https://www.facebook.com/");
	}
	@Test 
	public void login()
	{
		Facebooklogin lpage=new Facebooklogin(driver);
		lpage.loginToApp_username("manjula.ganesan@gmail.com");
		lpage.loginToApp_password("abcde");
		lpage.loginToApp_Loginbutton();
	}
	@AfterClass
	
		public void close() throws IOException {
		sreenshot("src/test/resources/Screenshots/facebook.png");
			quit();
		}
		
	}


