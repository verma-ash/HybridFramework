package com.companyName.projectName.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.companyName.projectName.Base.PageBase;

public class AmazonHome extends PageBase {

	/**
	 * Constructor method for this class, this is overloaded.
	 * 
	 */
	public AmazonHome() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * These are web elements for amazon home page.
	 */
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	/**
	 * this method for searching any item on home page.
	 * 
	 * @param itemName
	 */
	public void searchItemInput(String itemName) {
		searchBox.sendKeys(itemName);
	}
	
	/**
	 * this method will click on the search button and open new page of SearchResultOutput
	 * @return
	 */
	public SearchResultOutput clickOnSearch() {
		searchButton.click();
		return new SearchResultOutput();
	}
}
