Feature: Login page feature


Scenario: Login into Shopify and the product
Given user is on login page
When user enters username "chiraggupta@cedcommerce.com"
Then user click on continue with email button
And user enters passwprd "SeleniumTest"
Then user click on login button
When user click on the products link
Then user click on Add product button
And user enter title "T-shirt"
And user enter product type "Apparel & Accessories"
Then click on Save button






