package com.stepdefinition;

import org.openqa.selenium.WebDriver;
import com.Pagefactory.Driverfactory;
import com.pages.AmazonCartPage;
import com.pages.AmazonLandingPage;
import com.pages.AmazonSearchPage;
import com.pages.FlipkartCartPage;
import com.pages.FlipkartSearchListpage;
import com.pages.FlipkartlandingPage;
import com.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSstepdefintion {
	
	
	double priceFlipkart;
	double priceAmazon;
	private ConfigReader configreader = new ConfigReader();
	private WebDriver driver = Driverfactory.getDriver();
	private FlipkartlandingPage landingPage = new FlipkartlandingPage(Driverfactory.getDriver());
	private FlipkartSearchListpage SearchPage = new FlipkartSearchListpage(Driverfactory.getDriver());
	private FlipkartCartPage cartPage = new FlipkartCartPage(Driverfactory.getDriver());
	private AmazonLandingPage aLandingPage = new AmazonLandingPage(Driverfactory.getDriver());
	private AmazonSearchPage aSearchPage = new AmazonSearchPage(Driverfactory.getDriver());
	private AmazonCartPage aCartPage = new AmazonCartPage(Driverfactory.getDriver());
	
	
	

	@Given("Browser is launched navigate to Flipkart")
	public void browser_is_launched_navigate_to_flipkart() {
		
		landingPage.clearLoginPopUp();
	}
	@When("Search for {string} click on the first item")
	public void search_for_click_on_the_first_item(String searchProduct) {
		
		landingPage.enterProduct(searchProduct);
		landingPage.clickSearch();
	}
	@Then("click on the first item and Print Price of the Item")
	public void click_on_the_first_item_and_print_price_of_the_item() throws InterruptedException {

		
		SearchPage.clickFirstItem();
		landingPage.switchTab();
		priceFlipkart= SearchPage.printPrice();
		System.out.println(priceFlipkart);
	
	}
	@When("Add to cart in guest mode and Go to Cart Page")
	public void add_to_cart_in_guest_mode_and_go_to_cart_page() {

		SearchPage.clickAddToCart();
	}
	@When("Increase Quantity by one")
	public void increase_quantity_by_one() throws InterruptedException {
		
		Thread.sleep(3000); 
		cartPage.addQuantity();

	}

	@When("Print the Price after addition of Quantity")
	public void print_the_price_after_addition_of_quantity() {

		System.out.println(cartPage.printFinalPrice());
		
	}
	@Given("Naviagted to Amazon Landing page")
	public void naviagted_to_amazon_landing_page() throws InterruptedException {
		landingPage.closeTab();
		driver.get(configreader.init_prop().getProperty("URL2"));
			
	}
	@When("searched the {string} and click on the first link")
	public void searched_the_and_click_on_the_first_link(String string) {

		aLandingPage.enterProduct(string);
		aLandingPage.clickSearch();
		}
	@When("Print the Price and Add to Cart")
	public void print_the_price_and_add_to_cart() {
		
		System.out.println(aSearchPage.printAmazonPrice());
		aSearchPage.clickAmazonLink();
	}	
	
	@When("Go to cart and Print the Price")
	public void go_to_cart_and_print_the_price()  {
		
		
		landingPage.switchTab();
		aCartPage.addtocartAmazon();
		aCartPage.clickAmazonCart();
		priceAmazon = aCartPage.getCartPrice();
		System.out.println(priceAmazon);

	}

	@Then("Compare the flipkart and Amazon Price and Print the lower Price")
	public void compare_the_flipkart_and_amazon_price_and_print_the_lower_price() {
		
		if (priceAmazon>priceFlipkart) {
			
			System.out.println("Flipkart price is cheaper for the same product");
		}
		else if(priceAmazon<priceFlipkart) {
			System.out.println("Amazon price is cheaper for the same product");
		}
		else {
			System.out.println("Prices in Amazon and Flipkart are same");
		}
	}
}
