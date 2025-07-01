package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.utils.UtilKit;

import comexceptions.InvalidBrowserException;

public class BaseTest {

	public static UtilKit util = new UtilKit();
	public static WebDriver driver = null;

	public void launchApplication() {

		driver = getDriver();
		driver.get(util.getProperty("url"));
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static WebDriver getDriver() {

		if (driver == null) {

			String browserName = util.getProperty("browser");
			switch (browserName) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				try {
					throw new InvalidBrowserException();
				} catch (InvalidBrowserException e) {
					e.getMessage();
				}
				break;
			}
		}

		return driver;
	}
}
