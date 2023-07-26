package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage {

	
	@FindBy(xpath="((//div[@class='_3_L3jD'])//span)[4]")private WebElement rating;
	
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getRating()
	{
		String productRating = rating.getText();
		Reporter.log("This is ProductRating "+productRating, true);
	}
}
