package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLandingPage {

	
	
	WebDriver driver;
	// 1. By Locators

	private By amazonSearchTextBox = By.xpath("//input[@id='twotabsearchtextbox']");
	private By amazonSearchButton =  By.xpath("//input[@id='nav-search-submit-button']");
	
	
	
	// 2. Constructor of Page class

	public AmazonLandingPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions: features of the page in the form of methods
	
	
	public void enterProduct(String product) {

		driver.findElement(amazonSearchTextBox).sendKeys(product);
	}

	public AmazonSearchPage clickSearch() {

		driver.findElement(amazonSearchButton).click();
		return new AmazonSearchPage(driver);
	}
}
