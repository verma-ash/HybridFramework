package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultOutput {

	WebDriver driver;
	
	/**
	 * Constructor overloaded with web driver.
	 * @param driver
	 */
	public SearchResultOutput(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Web elements on search result output page.
	 */
	@FindBy(xpath = "(//a[contains(@class,'a-link-normal a-text-normal') and @target='_blank'])[1]") WebElement firstResultElement;
	
	/**
	 * this method will click on the first element on result page.
	 */
	public void clickOnFirstResult() {
		firstResultElement.click();
	}
	
}
