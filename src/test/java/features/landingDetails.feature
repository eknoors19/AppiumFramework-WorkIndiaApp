Feature: Landing Screen Functionality

Description: The purpose is to perform activities on landing screen

@landingScreen @Regression
Scenario Outline: Verify that user is able to proceed on landing screen
Given Work India app is installed 
When user enter full_name, mobile_number
|full_name|mobile_number|
|Eknoor|9888888888|
