Feature: Fill Profile Details Functionality
Description: The purpose is to check fill profile details screen

Background: 
Given Work India app is installed 
When user enter full_name, mobile_number
|full_name|mobile_number|
|Eknoor|9888888888|
Then user clicks on submit button
Then user lands on choosecity screen

@FillProfileDetails @Regression
Scenario Outline: Fill profile Details
Then user selects city "<City>"
Then user enters nearest place "<Place>"
Then user clicks on submit button on choose city screen
Then user fills the profile detials "<Gender>" "<Qualification>" "<SchoolMedium>" "<EnglishLevel>" "<FresherOrExperienced>" "<Age>" "<Interest>"
Then user clicks on submit button on fill profile details screen
Then user lands on about yourself screen
Then user selects the degree"<Degree>"
Then user clicks on submit button on about yourself screen
Then user lands on select language screen
Then user select language "<language>"

Examples:
|City |Place    |Gender|Qualification|SchoolMedium|EnglishLevel|FresherOrExperienced|Age     |Interest     |TextDisplayedonPopup|Degree|language|
|PUNE|Aundh|Male  |Graduate     |English     |GoodEnglish |Fresher             |27 Years|Counter Sales|Profile Not Filled  |BCom  |English |