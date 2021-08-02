package com.companyName.projectName.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

	protected static Properties prop;

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
	public void openTestBrowser() {
		PageBase.initialize(prop);
	}

	/**
	 * This method will quit the browser for test
	 * 
	 */
	public void quitTestBrowser() {
		PageBase.quitBrowser();
	}

}
