
package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pagefactory.Driverfactory;

public class WaitUtility {
	
	WebDriver driver = Driverfactory.getDriver();
	
	public void explicitWait(By element,long time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}
}
