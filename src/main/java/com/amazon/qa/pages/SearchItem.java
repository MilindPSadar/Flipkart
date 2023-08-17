package com.amazon.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SearchItem {
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;
	@FindBy(id = "nav-search-submit-button")
	private WebElement searchButton;
	@FindBy(xpath = "(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")
	private WebElement displayResult;

	public SearchItem(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendProductNameInSearchBox(String productName) {
		Reporter.log("entering product name in search box", true);
		searchBox.sendKeys(productName);
	}

	public void clickOnSearchButton() {
		Reporter.log("clicking on searchButton", true);
		searchButton.click();
	}

	public String showNumberOfResult() {
		String result = displayResult.getText();
		return result;
	}

	public void clearSearchBox() {
		Reporter.log("clearing the search box", false);
		searchBox.clear();
	}

}
