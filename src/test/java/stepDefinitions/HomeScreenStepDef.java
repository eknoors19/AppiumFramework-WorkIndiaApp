package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import base.TestBase;
import driver.AppDriver;
import io.cucumber.datatable.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import screens.ChooseCityScreen;
import screens.HomeScreen;
import utility.CommonUtils;

public class HomeScreenStepDef extends TestBase {
	
	HomeScreen homescr;
	public Scenario scenario;

	@Before
	public void launchAndInstallApp(Scenario scenario) throws Exception {
		
		CommonUtils obj_enrol = new CommonUtils();
	
		if (loadPropertyFile.startsWith("Android")) {
			obj_enrol.loadAndroidConfProp(loadPropertyFile);
			obj_enrol.setAndroidCapabilities();
			driver = obj_enrol.getAndroidDriver();
			this.scenario = scenario;
			System.out.println("Executing the scenario" + scenario.getName());
			
		} else if (loadPropertyFile.startsWith("IOS")) {
			/*
			 * CommonUtils.loadIOSConfProp(loadPropertyFile);
			 * CommonUtils.setIOSCapabilities(); driver = CommonUtils.getIOSDriver();
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			 */
		}

	}
	
	  @After 
	  public void afterScenario(Scenario scenario) throws IOException 
	  {
		  if(scenario.isFailed())
	      {
			  File scrFile = (driver).getScreenshotAs(OutputType.FILE);
			  byte[] fileContent = FileUtils.readFileToByteArray(scrFile);
			  //Image is attached to report 
			  scenario.attach(fileContent, "image/png", "image");
	       }
		  driver.removeApp("in.workindia.nileshdungarwal.workindiaandroid"); 
		  driver.quit(); 
	  }
	
	
	@Given("^Work India app is installed$")
	public void work_India_app_is_installed() throws Throwable {
		Thread.sleep(10000);
		if(!Objects.isNull(driver))
		{
			System.out.println("object is not null, setting it again");
			homescr = new HomeScreen(driver);
			if(!Objects.isNull(homescr)) {
				System.out.println("Home screen object: "+ homescr);
			}
		}	
		System.out.println("Setting Home Screen Object");
	}
	
	@When("^user enter full_name, mobile_number$")
	public void user_enter_full_name_mobile_number(DataTable data_table) throws Throwable {
		//logger.info("User is entering full name and mobile number on first screen");
		for (Map<String, String> data : data_table.asMaps(String.class, String.class)) {
			homescr.enterFullNameAndMobileNumber(data.get("full_name"), data.get("mobile_number"));
		}
	}
	
	@Then("^user clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		homescr.clickSubmitButton();
	}

	@Then("^user lands on choosecity screen$")
	public void user_lands_on_choosecity_screen() throws Throwable {
		ChooseCityScreen chooseCityScreen = new ChooseCityScreen(driver);
		Assert.assertEquals(chooseCityScreen.chooseCityTitle(), true);
	}
	
	@Then("^user clicks on referral code link$")
	public void user_clicks_on_referral_code_link() throws Throwable {
		homescr.clickReferralLink();
	}

	@Then("^user enters the referral code \"([^\"]*)\"$")
	public void user_enters_the_referral_code(String arg1) throws Throwable {
		homescr.enterReferralCode(arg1);
	}
	
	@Then("^user clicks apply button$")
	public void user_clicks_apply_button() throws Throwable {
		homescr.clickApplyButton();
	}
	
	@Then("^user should see invalidcode message$")
	public void user_should_see_invalidcode_message() throws Throwable {
		Assert.assertEquals(homescr.checkInvalidCodeMessage(), true);
	}
}
