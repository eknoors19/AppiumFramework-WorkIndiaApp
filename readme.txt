Introduction -
--------------
 
This automation framework is designed to test WorkIndia application with help of BDD cucumber approach.
These scripts takes necessary inputs like device properties user in Android_UIDesign.properties file
This framework generate various reports (Extent, spark, Cucumber) in Html format with screenshots attached in report only for failed test cases.
To update the device or runner information related to application, one needs to update Android_UIDesign.properties file
 
src/main/java:
	- base: Provides the base class reusable methods for the test run
	- listeners: Provides listeners for reporting and screenshots
	- screens: POM for different screens
	- utility: Contains different utilities used in project like:
			Appium server: To start and stop appium
			Commmon utils: For having capabilities defined for appium and basic scrolling methods
			Excel reader: To read excel if required
	- testdata: testdata.properties file for validating some scenarios output during run time	
 
src/test/java:
	 - Features: Contains different features to be tested for application(features have been marked with different tags such as @DragDrop @E2E @MagicalTextView @QuickScrollBar @PopUpMenu tag)
	 - Runner: contains runner required to run test
	 - Step definition: having the actual code for running behind feature files using classes designed for various screens with the help of POM.
	
src/test/resources:
	- app: containing .apk of application (in.workindia)
	- configs: extent report config file
	- properties: containing android properties file
 
Report: Contains the automation report under the folder with date and timestamp, it is generated after run and Screenshots of failure. Report will also have attached screenshot in case of failure.
 
Logging: has been done for each feature in POM files and logs will be printed on console for debugging
 
Running the code:
	- To run the test through command line you can type: mvn clean test
	- Test cases can also be ran through TestRunner and POM file directly.