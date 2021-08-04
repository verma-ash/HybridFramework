package com.companyName.projectName.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.companyName.projectName.Base.TestBase;
import com.companyName.projectName.Pages.AmazonHome;
import com.companyName.projectName.Pages.SearchResultOutput;
import com.companyName.projectName.Utility.Utility;

/**
 * This is Test class used for search given item on amazon.in
 * Every test case should create a test case for Extent reports and do the logging then and there only.
 * 
 * @author Ashish
 *
 */
public class SearchItemOnAmazonTest extends TestBase {
	
	String sheetName = "TestProducts";
	
	/**
	 * this is a before method to set up the browser for test.
	 */
	@BeforeMethod
	public void setUp() {
		openTestBrowser();
	}
	
	/**
	 * this is data provider method of testNG and it is calling Utility class getDataFromExcel method.
	 * @return
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] getProucts(){
		Object objData[][] = null;
		try {
			objData = Utility.getDataFromExcel(sheetName);
		} catch (IOException e) {
			System.out.println("Excel sheet not loaded ---"+e.getMessage());
		}
		return objData;
	}

	/**
	 * this method will perform the search operation test and click on the first
	 * result found.
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, dataProvider = "getProucts")
	public void searchItemTest(String productName) throws InterruptedException {
		
		testLogger = reports.createTest("search Item Test");
		
		AmazonHome amazonHome = new AmazonHome();
		testLogger.info("Open the Amazon website");
		
		amazonHome.searchItem(productName);
		testLogger.info("Search Item in search input box");
		
		SearchResultOutput searchResultOutput = amazonHome.clickOnSearch();
		testLogger.info("Click on search button");
	
		searchResultOutput.clickOnFirstResult();
		testLogger.info("Click on fisrt result");

		Assert.assertEquals(0, (int)searchResultOutput.getItemsFromCart());
		
		
	}
	
	/**
	 * this is a after method to quit the browser for test.
	 */
	@AfterMethod(dependsOnMethods = {"afterMethod"})
	public void tearDown() {
		quitTestBrowser();
	}

}
