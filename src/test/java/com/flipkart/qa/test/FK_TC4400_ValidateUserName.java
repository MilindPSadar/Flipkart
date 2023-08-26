package com.flipkart.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.util.Utility;

public class FK_TC4400_ValidateUserName extends BaseClass {
	//WebDriver driver;
	LoginPage lp;
	
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		BaseClass.launchBrowser();
		lp=new LoginPage(driver);
	}
	@BeforeMethod
	public void logIn() throws IOException
	{
		//lp.clickOnLoginButton();
		Utility.impliciteWait(driver, 5);
		lp.enterMobileNum();
		lp.clickOnRequestForOTP();
		
	}
  @Test
  public void validateUserName()
  {
	  System.out.println("Hello Team");
  }
  
  @AfterMethod
  public void logout()
  {
	  
  }
  @AfterClass
  public void tearDown()
  {
	 BaseClass.closeBrowser();
  }
  }

