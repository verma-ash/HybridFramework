package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import Pages.AmazonHome;
import Pages.SearchResultOutput;
import Utility.BrowserFactory;


/**
 * This is Test class used for search given item on amazon.in
 * @author Ashish
 *
 */
public class SearchItemOnAmazon {
	
	WebDriver driver;
	
	/**
	 * This method will initialize the driver with required browser type. 
	 */
	@BeforeClass
	public void openChromeBrowser() {
		driver = BrowserFactory.openBrowserWithUrl("Chrome", "https://www.amazon.in/", driver);
	}
	
	/**
	 * This method will perform the search operation test and click on the first result found.
	 * @throws InterruptedException
	 */
	@Test
	public void searchItem() throws InterruptedException {
		AmazonHome amazonHome = PageFactory.initElements(driver, AmazonHome.class);
		amazonHome.searchItem("fire tv stick 2021");
		SearchResultOutput searchResultOutput = PageFactory.initElements(driver, SearchResultOutput.class);
		searchResultOutput.clickOnFirstResult();
		
		BrowserFactory.quitBrowser(driver);
	}
	

}
