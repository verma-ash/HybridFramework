package com.companyName.projectName.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.companyName.projectName.Base.PageBase;

public class SearchResultOutput extends PageBase {

	/**
	 * Constructor overloaded with web driver.
	 * 
	 */
	public SearchResultOutput() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Web elements on search result output page.
	 */
	@FindBy(xpath = "(//a[contains(@class,'a-link-normal a-text-normal') and @target='_blank'])[1]")
	WebElement firstResultElement;
	@FindBy(id = "nav-cart-count")
	WebElement itemsInCart;

	/**
	 * this method will click on the first element on result page.
	 */
	public void clickOnFirstResult() {
		firstResultElement.click();
	}

	/**
	 * this method return the number of items present in cart
	 * @return
	 */
	public Integer getItemsFromCart() {
		return Integer.parseInt(itemsInCart.getText());
	}

}
