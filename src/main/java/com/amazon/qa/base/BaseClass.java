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

import com.amazon.qa.util.Utility;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	public static WebDriver driver;
	static ChromeOptions opt;

	public static void launchBrowser() throws IOException
	{
		opt=new ChromeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		String bName=Utility.readConfigProp("browserName");
		if(bName.equalsIgnoreCase("chrome"))
		{
			
			Reporter.log("launching chromeBrowser", true);
			 driver=new ChromeDriver(opt);
			
		}
		else if(bName.equalsIgnoreCase("firefox"))
		{
			Reporter.log("launching FireFoxBrowser", true);
		     driver=new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		driver.get(Utility.readConfigProp("url"));
		Utility.impliciteWait(driver, 5);
			
	}
	public void takeScreenshot(String FileName) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String random=RandomString.make(3);
		File dest=new File("Screenshot"+FileName+random+".png");
		FileHandler.copy(source, dest);
	}

	public static void closeBrowser()
	{
		driver.quit();
		//Utility.impliciteWait(driver, 7);
	}
	
}
