package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.amazon.qa.util.Utility;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Hello, sign in']//ancestor::a")
	private WebElement helloSignIn;
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement enterMobNumber;
	@FindBy(xpath="//span[@id='continue']")
	private WebElement continueButton;
	@FindBy(xpath="//span[contains(text(),'Show password')]")
	private WebElement showPassword;
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement enterPassword;
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signInbutton;
	@FindBy(xpath="//input[@id='auth-signin-button']")
	private WebElement OTPSignInButton;
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	private WebElement userName;
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signOutButton;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void clickOnHelloSign()
	{
		Reporter.log("clicking on hello sign in", true);
		helloSignIn.click();
	}
	public void enterMobileNumber() throws IOException
	{
		Reporter.log("Entering mobile Number", true);
		enterMobNumber.sendKeys(Utility.readConfigProp("mobileNumber"));
	}
	public void clickOnContinue()
	{
		Reporter.log("clicking on continue", true);
		continueButton.click();
	}
	/*public void clickOnShowPasswordCheckBox()
	{
		boolean result=showPassword.isSelected();
		Reporter.log("is show password check box selected", result);
		//System.out.println(" is show password check box selected"+ result);
		Reporter.log("clicking on showPassword checkBox", true);
		showPassword.click();
		boolean result1=showPassword.isSelected();
		Reporter.log("is show password check box selected", result1);

		//System.out.println(" is show password check box selected"+ result1);


	}*/
	public void enterPassword() throws InterruptedException, IOException
	{
		Reporter.log("entering password", true);
		enterPassword.sendKeys(Utility.readConfigProp("password"));
		Thread.sleep(3000);
		//boolean result=enterPassword.isDisplayed();
		//Reporter.log("is enter password display", result);

	}
	public void clickOnSignInButton()
	{
		Reporter.log("clicking on sign in button", true);
		signInbutton.click();
	}
	public void enterOTPAndClickonSignIn() throws InterruptedException
	{
		Reporter.log("entering the OTP manually", true);
		Thread.sleep(30000);
		Reporter.log("clicking on OTPSignInButton", true);
		OTPSignInButton.click();
	}
	public String getUserName()
	{
		Reporter.log("getting the user Name", true);
		String actualName=userName.getText();
		return actualName;
	}
	public void clickOnSignOut()
	{
		Reporter.log("clicking on sign out ", true);
		Actions act=new Actions(driver);
		act.moveToElement(userName).click(signOutButton).build().perform();
	}
	

}
