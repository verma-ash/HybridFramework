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
<<<<<<< HEAD
	 * this is data provider of testNG and we are calling Utility method getDataFromExcel
=======
	 * this is data provider method of testNG and it is calling Utility class getDataFromExcel method.
>>>>>>> refs/heads/Data_driven_branch
	 * @return
	 * @throws IOException
	 */
	@DataProvider
	public Object[][] getProucts() throws IOException{
		Object objData[][] = Utility.getDataFromExcel(sheetName);
		return objData;
	}

	/**
	 * this method will perform the search operation test and click on the first
	 * result found.
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getProucts")
	public void searchItemTest(String productName) throws InterruptedException {
		AmazonHome amazonHome = new AmazonHome();
		amazonHome.searchItem(productName);
		SearchResultOutput searchResultOutput = amazonHome.clickOnSearch();
		searchResultOutput.clickOnFirstResult();
		Assert.assertEquals(0, (int)searchResultOutput.getItemsFromCart()); 
	}
	
	/**
	 * this is a after method to quit the browser for test.
	 */
	@AfterMethod
	public void tearDown() {
		quitTestBrowser();
	}

}
