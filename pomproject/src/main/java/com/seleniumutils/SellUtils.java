package com.seleniumutils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.baseclass1.Library;

public class SellUtils extends Library {
	WebDriver driver;
	//constructor
	public SellUtils(WebDriver driver) {
		this.driver=driver;
		
	}
	
//to take screenshot
	public void sreenshot(String path)  {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(source,new File(path));
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
		public void getTitle() {
			String title=driver.getTitle();
			System.out.println(driver.getTitle());
			
		
			
		}
		//explicit wait
		public void Explicitlywait(String Locator) {
			WebDriverWait wait= new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(Locator))));
			
			
		}
		
	}

