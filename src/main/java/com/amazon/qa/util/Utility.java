package com.amazon.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.qa.base.BaseClass;

import net.bytebuddy.utility.RandomString;

public class Utility extends BaseClass {
	
	public static void impliciteWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void expliciteWait(WebDriver driver, int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		public static String  readConfigProp(String propName) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("configuration\\config.properties");
		prop.load(file);
		return prop.getProperty(propName);
	}
	public String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("excelData\\testData.xlsx");
		String value=WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell)
				.getStringCellValue();
		return value;
	}
	public void takeScreenshot(String FileName) throws IOException
	{
		Date currentDate=new Date();
		String screenShot=currentDate.toString().replace(" ", "-").replace(":", "-");
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String random=RandomString.make(3);
		File dest=new File("TakeScreenshot\\"+screenShot+FileName+".png");
		FileHandler.copy(source, dest);
	}

	

}
