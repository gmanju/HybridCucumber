package com.testcases1;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass1.Library;
import com.pages1.FacebookRegisterpage;

public class RegisterTestcase extends Library
{
@BeforeClass
public void startup() throws IOException
{
	launchApplication();
	
}
@Test
		public void signup() {
			FacebookRegisterpage regpage=new FacebookRegisterpage(driver);
			regpage.fname("manju");
			regpage.lname("Aravind");
			regpage.mno("123456");
			regpage.newpwd("abcde");
			regpage.birthday("Feb", 14, "2007");
		}
		@AfterClass
		public void close() throws IOException {
			sreenshot("src/test/resources/Screenshots1.png");
			quit();
					
				
		}
		
			
		}



	

