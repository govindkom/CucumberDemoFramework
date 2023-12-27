
Feature: Cutomers

 Background: Below are the some common steps for every scenario
 Given user Launch Chrome Broswer
When user opens URL "https://admin-demo.nopcommerce.com/login"
And user enters Email as "admin@yourstore.com" and password as "admin".
And Click on Login
Then User can view Dashboard

@sanity
Scenario: Add a  New Customer
When user click on customers Menu
And click on customers Menu Item
And click on Add new Button
Then user can view Add new customer page
When user enter customer info
And click on save button
Then User can view confirmation message "The new customer has been added successfully."
And close Browser

@regression
Scenario: Search Customer by using EMail Id
When user click on customers Menu
And click on customers Menu Item
And Enter customer Email
When Click on search button
Then user should found Email in the Search table
And close Browser

@regression
Scenario: Search Customer by Name
When user click on customers Menu
And click on customers Menu Item
And Enter customer FirstName
And enter customer LastName
When Click on search button
Then user should found Name in the Search table
And close Browser