Feature: Test the Add to cart scenarios

Scenario: Filpkart cart
Given Browser is launched navigate to Flipkart  
When Search for "Sony alpha 7M3K" click on the first item
Then click on the first item and Print Price of the Item
When Add to cart in guest mode and Go to Cart Page
And Increase Quantity by one 
And Print the Price after addition of Quantity

Scenario: Amazon Cart and compare with Flipkart
Given Browser is launched navigate to Flipkart
When Search for "Sony alpha 7M3K" click on the first item
Then click on the first item and Print Price of the Item
Given Naviagted to Amazon Landing page
When searched the "Sony alpha 7M3K" and click on the first link
And Print the Price and Add to Cart
And Go to cart and Print the Price
Then Compare the flipkart and Amazon Price and Print the lower Price