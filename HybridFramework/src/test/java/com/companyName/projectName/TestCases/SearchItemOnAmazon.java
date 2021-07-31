package com.companyName.projectName.TestCases;

import org.testng.annotations.*;

import com.companyName.projectName.Base.TestBase;
import com.companyName.projectName.Pages.AmazonHome;
import com.companyName.projectName.Pages.SearchResultOutput;

/**
 * This is Test class used for search given item on amazon.in
 * 
 * @author Ashish
 *
 */
public class SearchItemOnAmazon extends TestBase {

	/**
	 * This method will perform the search operation test and click on the first
	 * result found.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void searchItem() throws InterruptedException {
		AmazonHome amazonHome = new AmazonHome();
		amazonHome.searchItem("fire tv stick 2021");
		SearchResultOutput searchResultOutput = amazonHome.clickOnSearch();
		searchResultOutput.clickOnFirstResult();

	}

}
