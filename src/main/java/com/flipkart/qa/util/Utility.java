package com.flipkart.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Utility {
	
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
		FileInputStream file=new FileInputStream("C:\\Users\\ahirr\\git\\Flipkart\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
		prop.load(file);
		return prop.getProperty(propName);
	}
		
		public static void waitTime(int waitTimeSec) throws InterruptedException
		{
		Thread.sleep(waitTimeSec);
		Reporter.log("waiting for "+waitTimeSec+" milisec", true);
		}	
	

}
