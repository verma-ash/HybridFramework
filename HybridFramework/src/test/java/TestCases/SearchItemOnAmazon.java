package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Utility.BrowserFactory;

public class SearchItemOnAmazon {
	
	WebDriver driver;
	
	@BeforeClass
	public void openChromeBrowser() {
		driver = BrowserFactory.openBrowserWithUrl("Chrome", "https://www.amazon.in/", driver);
		System.out.println(driver.getTitle());
	}
	

}
