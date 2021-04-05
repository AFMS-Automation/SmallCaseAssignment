package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.WaitUtility;

public class FlipkartCartPage {

	WaitUtility utility= new WaitUtility();
	WebDriver driver;
	// 1. By Locators

	private By addQunatity = By.xpath("(//button[text()='+'])[1]");
	private By addQuantityPrice = By.xpath("(//span[@class='_2-ut7f _1WpvJ7'])[1]");

	// 2. Constructor of Page class

	public FlipkartCartPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Actions: features of the page in the form of methods

	public void addQuantity()  {
		
		
			driver.findElement(addQunatity).click();
		
	}

	public int printFinalPrice() {

		utility.explicitWait(addQuantityPrice, 20);
		String finalPrice = driver.findElement(addQuantityPrice).getText().substring(1).replace(",", "");
		driver.close();
		return Integer.parseInt(finalPrice);

	}

}
