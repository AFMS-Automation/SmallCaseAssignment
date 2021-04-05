package com.utils;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.Pagefactory.Driverfactory;

	

public class TabFunctions {
	
	public static WebDriver driver = Driverfactory.getDriver();
	

	public static  void switchTab() {
		
		ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tab.get(1));
	   
	    
	}
	
	public static  void closeTab() {
		
		ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.close();
	     driver.switchTo().window(tab2.get(0));		
		
	}
	
	
	
}
