package com.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Pagefactory.Driverfactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyHooks {
	
	private Driverfactory driveFactory;
	private WebDriver driver;
	private ConfigReader configreader;
	
	@Before(order=0)
	public void launchBrowser()
	{
		String browsername = ConfigReader.init_prop().getProperty("Browser");
		String flipKartURL = ConfigReader.init_prop().getProperty("URL1");
		driveFactory = new  Driverfactory();
		driver = Driverfactory.init_Driver(browsername);
		driver.get(flipKartURL);
		
	}
	
	
	
	
	@After(order=0)
	public void quitBrowser() {
		
		driver.quit();
	}

}
