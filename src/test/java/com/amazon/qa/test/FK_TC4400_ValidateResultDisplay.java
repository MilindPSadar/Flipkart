package com.amazon.qa.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.dataProvider.DataProviderClass;
import com.amazon.qa.pages.SearchItemTest;
import com.amazon.qa.util.Utility;
@Listeners(com.amazon.qa.listener.Listener.class)
public class FK_TC4400_ValidateResultDisplay extends BaseClass {
	SearchItemTest st;
	
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		BaseClass.launchBrowser(); 
		st=new SearchItemTest(driver);
	}
	@BeforeMethod
	public void searchProduct() throws IOException
	{
		Utility.impliciteWait(driver, 5);
			
		
	}
  @Test(dataProvider="TestData1", dataProviderClass=DataProviderClass.class)
  public void validateIsResultDisplay(String productName) 
  {
	  st.sendProductNameInSearchBox(productName);
		st.clickOnSearchButton();
		
	  String actualResult=st.showNumberOfResult();
	  System.out.println(actualResult);
	  
	   
  }
  
  @AfterMethod
  public void logout() throws InterruptedException
  {
	  st.clearSearchBox();
	  Thread.sleep(3000);
	System.out.println("No logout");  
  }
  @AfterClass
  public void tearDown() throws InterruptedException
  {
	 BaseClass.closeBrowser();
	 Thread.sleep(5000);
  }
  }

