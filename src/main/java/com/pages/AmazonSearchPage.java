package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSearchPage {
	
	
	 WebDriver driver;
	
	private By amazonFirstItem = By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]");
	private By priceAmazonProduct = By.xpath("(//span[@class='a-price-whole'])[1]");
	
	
	
	// 2. Constructor of Page class

	public AmazonSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// 3. Page Actions: features of the page in the form of methods
	
	public int printAmazonPrice() {
		
		String strPrice = driver.findElement(priceAmazonProduct).getText();
		String strPriceReplaced = strPrice.replace(",", "");
		int price = Integer.parseInt(strPriceReplaced);
		return price;
		
				
	}

	public void clickAmazonLink() {
		
		driver.findElement(amazonFirstItem).click();
		
	}
	
	

}
