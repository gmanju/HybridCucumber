package com.excelutility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class readwriteexcel {
	
		    WebDriver driver;
		    WebDriverWait wait;
		    XSSFWorkbook workbook;
		    XSSFSheet sheet;
		    XSSFCell cell;
		 
		 @BeforeTest
		 public void TestSetup()
		{
		    // Set the path of the Firefox driver.
		    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aravind_2\\Desktop\\Selenium\\Software\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		     
		    // Enter url.
		    driver.get("https://opensource-demo.orangehrmlive.com/");
		    driver.manage().window().maximize();
		     
		    wait = new WebDriverWait(driver,30);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		  
		 @Test
		 public void ReadData(String uname,String pword) throws IOException
		 {
		     // Import excel sheet.
		     File src=new File("C:\\Users\\Aravind_2\\Desktop\\Selenium\\training.xlsx");
		      
		     // Load the file.
		     FileInputStream finput = new FileInputStream(src);
		      
		     // Load he workbook.
		    workbook = new XSSFWorkbook(finput);
		      
		     // Load the sheet in which data is stored.
		     sheet= workbook.getSheetAt(0);
		     int rownum=sheet.getLastRowNum();
		     
		      
		     for(int i=1; i<=rownum ; i++)
		     {
		         // Import data for Email.
		         cell = sheet.getRow(i).getCell(1);
		         cell.setCellType(CellType.STRING);
		         uname=cell.getStringCellValue();
		       
		          
		         // Import data for password.
		         cell = sheet.getRow(i).getCell(2);
		         cell.setCellType(CellType.STRING);
		         driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
		          
		         // Write data in the excel.
		       FileOutputStream foutput=new FileOutputStream(src);
		         
		        // Specify the message needs to be written.
		        String message = "Data Imported Successfully.";
		         
		        // Create cell where data needs to be written.
		        sheet.getRow(i).createCell(3).setCellValue(message);
		          
		        // Specify the file in which data needs to be written.
		        FileOutputStream fileOutput = new FileOutputStream(src);
		         
		        // finally write content
		        workbook.write(fileOutput);
		         
		         // close the file
		        fileOutput.close();
		             
		     }
		 }
}