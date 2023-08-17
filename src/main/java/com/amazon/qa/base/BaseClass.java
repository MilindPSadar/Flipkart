package com.amazon.qa.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.qa.util.Utility;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	public static WebDriver driver=null;
	//static ChromeOptions opt;
	//@Parameters("browserName")
	//@Test
	public static void launchBrowser(String bName) throws IOException
	{
		//String bName=Utility.readConfigProp("browserName");
		if(bName.equalsIgnoreCase("chrome"))
		{
			//opt=new ChromeOptions();
			//opt.addArguments("incognito");  
 
			Reporter.log("launching chromeBrowser", true);
			 driver=new ChromeDriver();
			 
		}
		else if(bName.equalsIgnoreCase("firefox"))
		{
			Reporter.log("launching FireFoxBrowser", true);
		     driver=new FirefoxDriver();
		}
		Reporter.log("Entering url in browser", true);
		driver.get(Utility.readConfigProp("url"));
		driver.manage().window().maximize();
		Utility.impliciteWait(driver, 5);
			
	}
	
	public static void closeBrowser()
	{
		driver.quit();
		//Utility.impliciteWait(driver, 5);
	}
	
}
