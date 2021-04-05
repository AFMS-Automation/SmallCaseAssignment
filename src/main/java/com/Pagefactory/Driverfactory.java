package com.Pagefactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public static ThreadLocal<WebDriver> tlocal = new ThreadLocal<WebDriver>();
	private ConfigReader configreader;

	/**
	 * This method is used to initialize the thread local driver on the basis of
	 * given browser
	 * 
	 * @pram browser
	 * @return WeDriver
	 **/
	public static WebDriver init_Driver(String browser) {

		if (browser.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();
			tlocal.set(new ChromeDriver());
		} else if (browser.equals("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tlocal.set(new FirefoxDriver());
		} else if (browser.equals("Safari")) {

			tlocal.set(new SafariDriver());

		} else {
			System.out.println("Pass the relevent Browser Value" + browser);
		}

		// getDriver().get(browser);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// getDriver().get("https://www.flipkart.com/");
		return getDriver();

	}

	/**
	 * This is used to get the driver with thread local
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {

		return tlocal.get();
	}

}
