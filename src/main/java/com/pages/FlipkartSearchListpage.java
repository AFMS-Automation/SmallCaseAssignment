package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitUtility;


public class FlipkartSearchListpage {
	
	
			
	        WaitUtility utility= new WaitUtility();
			WebDriver driver;
			// 1. By Locators

			private By flipkartFirstItem = By.xpath("(//div[@class='_4rR01T'])[1]");
			private By priceProductPage =  By.xpath("//div[@class='_30jeq3 _16Jk6d']");
			private By FlipkartAddtocart=  By.xpath("//button[text()='ADD TO CART']");
			
			
			// 2. Constructor of Page class

			public FlipkartSearchListpage(WebDriver driver) {
				this.driver = driver;
			}

			// 3. Page Actions: features of the page in the form of methods
			
			public void clickFirstItem() {
				
				utility.explicitWait(flipkartFirstItem, 5);
				driver.findElement(flipkartFirstItem).click();
			}
			
			
			public double printPrice() {
				
				utility.explicitWait(priceProductPage, 5);
				String strPrice = driver.findElement(priceProductPage).getText();
				String strPriceReplaced = strPrice.replace(",", "").substring(1);
				double price = Double.parseDouble(strPriceReplaced);
				return price;
				
						
			}
			
			public FlipkartCartPage clickAddToCart() {
				
				utility.explicitWait(FlipkartAddtocart, 5);
				driver.findElement(FlipkartAddtocart).click();
				
				return new FlipkartCartPage(driver);
				
			}
			


}
