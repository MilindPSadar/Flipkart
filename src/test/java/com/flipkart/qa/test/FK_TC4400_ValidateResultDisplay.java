package com.flipkart.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.SearchItemTest;
import com.amazon.qa.util.Utility;

public class FK_TC4400_ValidateResultDisplay extends BaseClass {
	SearchItemTest st;
	
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		BaseClass.launchBrowser();
		st=new SearchItemTest(driver);
	}
	@BeforeMethod
	public void logIn() throws IOException
	{
		Utility.impliciteWait(driver, 5);
		st.sendProductNameInSearchBox(Utility.readConfigProp("searchItem"));
		st.clickOnSearchButton();	
		
	}
  @Test
  public void validateIsResultDisplay()
  {
	  boolean result=st.showNumberOfResult();
	  System.out.println(result);
	    
  }
  
  @AfterMethod
  public void logout()
  {
	System.out.println("No logout");  
  }
  @AfterClass
  public void tearDown()
  {
	 BaseClass.closeBrowser();
  }
  }

