package com.flipkart.qa.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.BaseClass;
import com.flipkart.qa.pages.ProductPage;
import com.flipkart.qa.pages.SearchPage;
import com.flipkart.qa.util.Utility;

public class FK_TC4401_getProductRatingReview extends BaseClass {
	//WebDriver driver;
	SearchPage Sp;
	ProductPage Pp;
	@BeforeClass
	public void openingBrowser() throws Throwable
	{	
		launchBrowser();
		Sp=new SearchPage(driver);
		Pp=new ProductPage(driver);
	}
	@BeforeMethod
	public void logIn() throws IOException, InterruptedException
	{
		//lp.clickOnLoginButton();
		Utility.impliciteWait(driver, 5);
		Sp.clickOnclosebutton();
		Sp.SearchBox();
		Utility.waitTime(3000);
		Sp.clickOnsearchButton();
		Utility.waitTime(3000);
		Sp.clickOnProduct();
		
	}
  @Test
  public void validateUserName() throws InterruptedException
  {
	  	Set<String> allID = driver.getWindowHandles();
		ArrayList<String>al= new ArrayList<>(allID);
		String mainTabID = al.get(0);
		String childTabID = al.get(1);
		driver.switchTo().window(childTabID);
		Utility.waitTime(3000);
		Pp.getRating();
		
  }
  
  @AfterMethod
  public void CloseCurrentWindow() throws InterruptedException
  {
	  Utility.waitTime(3500);
	  driver.close();
  }
  @AfterClass
  public void tearDown() throws InterruptedException
  {
	 closeBrowser();
	 Utility.waitTime(4000);
  }
  }

