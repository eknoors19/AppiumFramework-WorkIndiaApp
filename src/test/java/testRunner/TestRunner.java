package testRunner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utility.AppiumServer;

@CucumberOptions(
		features = "src/test/java/features",
		glue = { "stepDefinitions" },
		plugin = { "pretty","html:target/CucumberReport.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true, 
		publish = true,
		dryRun = false
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	
	public static AppiumDriver driver;
	public static String loadPropertyFile = "Android_UIDesign.properties";
	
	
	 //@BeforeSuite public void setUp() throws IOException { AppiumServer.start(); }
	  
	 //@AfterSuite public void tearDown() { AppiumServer.stop(); }
	 
	 
}