package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitUtility;

public class AmazonCartPage {

	WebDriver driver;
	WaitUtility utility= new WaitUtility();

	private By amazonAddToCart = By.xpath("//input[@id='add-to-cart-button']");
	private By amazonCart =  By.xpath("//a[@class='nav-a nav-a-2 nav-progressive-attribute']");
	private By amazonCart2 = By.xpath("(//input[@class='a-button-input'])[2]");
	private By amazonCartPrice = By.xpath("//span[@id='sc-subtotal-amount-buybox']/span");

	// 2. Constructor of Page class

	public AmazonCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions: features of the page in the form of methods

	public void addtocartAmazon() {
		
		utility.explicitWait(amazonAddToCart, 20);
		driver.findElement(amazonAddToCart).click();
		driver.navigate().refresh();

	}

	public void clickAmazonCart() {

		utility.explicitWait(amazonCart, 20);
		if (driver.findElement(amazonCart).isDisplayed()) {
			driver.findElement(amazonCart).click();
		} else if ((driver.findElement(amazonCart2).isDisplayed())) {

			driver.findElement(amazonCart2).click();
		} else {

		}
	}

	public double getCartPrice() {
		String strPrice =driver.findElement(amazonCartPrice).getText().trim();
		System.out.println(strPrice);
		double price = Double.parseDouble(strPrice.replace(",", ""));

		return price;

	}

	
}
