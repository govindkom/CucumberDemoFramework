Feature: Login

@sanity
Scenario: Successful Login with Valid Credentils
Given user Launch Chrome Broswer
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and password as "admin".
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When user click on Logout
Then Page Title should be "Your store. Login"
And close Browser


@regression
Scenario Outline: Login Data Driver
Given user Launch Chrome Broswer
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "<email>" and password as "<password>"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When user click on Logout
Then Page Title should be "Your store. Login"
And close Browser

Examples:
| email | password |
| admin@yourstore.com | admin |
| admin1@yourstore.com | admin123 |