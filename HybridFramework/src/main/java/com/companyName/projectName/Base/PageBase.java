package com.companyName.projectName.Base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageBase {
	
	protected static WebDriver driver;

	public static WebDriver initialize(Properties prop) {
		String browserName = prop.getProperty("browser");
		String testUrl = prop.getProperty("url");
		long pageTimeout = Long.parseLong(prop.getProperty("pageTimeout"));
		long implicitWait = Long.parseLong(prop.getProperty("implicitWait"));

		if ("chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ("firefox".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if ("edge".equalsIgnoreCase(browserName)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if ("ie".equalsIgnoreCase(browserName)) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageTimeout));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.get(testUrl);

		return driver;
	}

	public static void quitBrowser() {
		driver.quit();
	}

}