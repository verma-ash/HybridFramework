package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHome {
	
	WebDriver driver;
	
	/**
	 * Constructor method for this class, this is overloaded.
	 * @param driver
	 */
	public AmazonHome(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * These are web elements for amazon home page.
	 */
	@FindBy(id = "twotabsearchtextbox") WebElement searchBox;
	@FindBy(id = "nav-search-submit-button") WebElement searchButton;
	
	/**
	 * this method for searching any item on home page.
	 * @param itemName
	 */
	public void searchItem(String itemName) {
		searchBox.sendKeys(itemName);
		searchButton.click();
	}
}
