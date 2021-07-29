package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver openBrowserWithUrl(String browserName, String url, WebDriver driver) {

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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		return driver;

	}

	public static WebDriver openBrowserWithUrl(String browserName, String url, WebDriver driver, String version) {

		if ("chrome".equalsIgnoreCase(browserName)) {
			WebDriverManager.chromedriver().browserVersion(version).setup();
		} else if ("firefox".equalsIgnoreCase(browserName)) {
			WebDriverManager.firefoxdriver().browserVersion(version).setup();
		} else if ("edge".equalsIgnoreCase(browserName)) {
			WebDriverManager.edgedriver().browserVersion(version).setup();
		} else if ("ie".equalsIgnoreCase(browserName)) {
			WebDriverManager.iedriver().browserVersion(version).setup();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		return driver;

	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
