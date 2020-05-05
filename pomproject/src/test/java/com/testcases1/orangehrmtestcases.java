package com.testcases1;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseclass1.Library;
import com.excelutility.excelutlity;
import com.pages1.orangehrmlogin;

public class orangehrmtestcases extends Library {
	@BeforeClass
	public void startup() throws IOException {
		
		launchApplication();
		
	}
	@Test
	public void loginpage() throws IOException {
		orangehrmlogin hrm=new orangehrmlogin(driver);
		excelutlity util=new excelutlity();
		//call from excel
		//hrm.(util.excel_username(2));
		//hrm.pwd(util.excel_password(2));
		hrm.login(util.excel_username(1),util.excel_password(1));
	}
@AfterClass
public void close() throws IOException {
	sreenshot("src/test/resources/Screenshots1/orangehrmloginpage.png");
}

}
