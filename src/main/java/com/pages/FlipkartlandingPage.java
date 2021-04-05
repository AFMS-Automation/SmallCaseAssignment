package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WaitUtility;


public class FlipkartlandingPage {
	
	
	WaitUtility utility= new WaitUtility();
	WebDriver driver;
	// 1. By Locators

	private By flipkartSearchTextBox = By.xpath("//input[@title='Search for products, brands and more']");
	private By flipkartSearchButton =  By.xpath("//button[@type='submit']");
	private By clearLoginPopUp =  By.xpath("//button[@class='_2KpZ6l _2doB4z']");
	
	
	// 2. Constructor of Page class

	public FlipkartlandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions: features of the page in the form of methods
	
	public void clearLoginPopUp() {
		
		utility.explicitWait(clearLoginPopUp, 10);
		driver.findElement(clearLoginPopUp).click();
		
			
		
	}
	
	public void enterProduct(String product) {
		
		driver.findElement(flipkartSearchTextBox).sendKeys(product);
	}

	public void clickSearch() {
		utility.explicitWait(flipkartSearchButton, 10);
		driver.findElement(flipkartSearchButton).click();
		
	}
	public void switchTab() {

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));

	}

	public  void closeTab() {
		
		ArrayList<String> tab2 = new ArrayList<String> (driver.getWindowHandles());
		 driver.close();
	     driver.switchTo().window(tab2.get(0));	
	}  
	
	
	

}


