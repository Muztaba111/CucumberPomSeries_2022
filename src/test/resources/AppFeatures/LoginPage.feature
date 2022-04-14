Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot password link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "muztaba5star@gmail.com"
And user enters passwprd "Muztaba@111"
And user click on login button
Then user gets the title of the page
And page title should be "My account - My Store"




