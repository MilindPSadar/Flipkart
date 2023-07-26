package com.flipkart.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	@FindBy(xpath="//*[@class='_2KpZ6l _2doB4z']")private WebElement closeButton;
	@FindBy(xpath="//*[@class='_3704LK']")private WebElement searchbox;
	@FindBy(xpath="//*[@class='L0Z3Pu']")private WebElement searchbutton;
	@FindBy(xpath="(//*[@loading='eager'])[5]")private WebElement productsearch;
	public SearchPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnclosebutton ()
	{
		closeButton.click();
	}
	
	public void SearchBox()
	{
		searchbox.sendKeys("phy men body wash");
	}

	public void clickOnsearchButton()
	{
		searchbutton.click();
	}
	
	public void clickOnProduct()
	{
		productsearch.click();
	}
}
