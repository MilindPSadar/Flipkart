package com.amazon.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.LoginPage;
@Listeners(com.amazon.qa.listener.Listener.class)
public class LoginPageTest extends BaseClass {
	LoginPage lp;
	@BeforeClass
	public void openBrowser () throws IOException
	{
		BaseClass.launchBrowser();
		lp=new LoginPage(driver);
		
	}
	@BeforeMethod
	public void signIn() throws IOException, InterruptedException
	{
		lp.clickOnHelloSign();
		lp.enterMobileNumber();
		lp.clickOnContinue();
		//lp.clickOnShowPasswordCheckBox();
		lp.enterPassword();
		lp.clickOnSignInButton();
		lp.enterOTPAndClickonSignIn();
		
	}
	
	@Test
	public void ValidateUserName() 
	{
		String actualResult=lp.getUserName();
		String expectedResult="Hello, milind";
		Assert.assertEquals(actualResult, expectedResult," actual and expected name not matching");
		
	}
	@AfterMethod
	public void SignOut()
	{
		lp.clickOnSignOut();
	}
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		BaseClass.closeBrowser();
		Thread.sleep(5000);
	}
}
