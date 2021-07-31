package com.companyName.projectName.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	protected Properties prop;

	public TestBase() {
		String userDir = System.getProperty("user.dir");
		try {
			FileInputStream fis = new FileInputStream(userDir + "/Configuration/config.properties");
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will initialize the driver with required browser type.
	 */
	@BeforeClass
	public void openTestBrowser() {
		PageBase.initialize(prop);
	}

	/**
	 * This method will quit the browser for test
	 * 
	 * @param driver
	 */
	@AfterClass
	public void quitTestBrowser() {
		PageBase.quitBrowser();
	}

}
