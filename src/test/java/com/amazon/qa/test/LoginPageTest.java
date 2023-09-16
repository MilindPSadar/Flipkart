package com.amazon.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.qa.base.BaseClass;
import com.amazon.qa.pages.LoginPage;

@Listeners(com.amazon.qa.listener.Listener.class)
public class LoginPageTest extends BaseClass {
	LoginPage lp;

	@Parameters("browserName")
	@BeforeClass
	public void openBrowser(String bName) throws IOException {
		BaseClass.launchBrowser(bName);
		lp = new LoginPage(driver);

	}

	@BeforeMethod
	public void signIn() throws IOException, InterruptedException {
		lp.clickOnHelloSign();
		lp.enterMobileNumber();
		lp.clickOnContinue();
		// lp.clickOnShowPasswordCheckBox();
		lp.enterPassword();
		lp.clickOnSignInButton();
		lp.enterOTPAndClickonSignIn();

	}

	@Test
	public void ValidateUserName() {
		String actualResult = lp.getUserName();
		String expectedResult = "Hello, milind";
		Assert.assertEquals(actualResult, expectedResult, " actual and expected name not matching");

	}

	@AfterMethod
	public void SignOut() {
		lp.clickOnSignOut();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
		//BaseClass.closeBrowser();
		//Thread.sleep(5000);
	}
}
