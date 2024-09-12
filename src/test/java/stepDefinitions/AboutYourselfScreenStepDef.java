package stepDefinitions;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Then;
import screens.AboutYourselfScreen;

public class AboutYourselfScreenStepDef extends TestBase {
	
	AboutYourselfScreen aboutYourselfScreen = new AboutYourselfScreen(driver);

	@Then("^user lands on about yourself screen$")
	public void user_lands_on_about_yourself_screen() throws Throwable {
		Assert.assertEquals(aboutYourselfScreen.checkAboutYourselfScreenHeading(), true);
	}

	@Then("^user clicks on submit button on about yourself screen$")
	public void user_clicks_on_submit_button_on_about_yourself_screen() throws Throwable {
		aboutYourselfScreen.clickSelectDegreeSubmitButton();
	}

	@Then("^user selects the degree\"([^\"]*)\"$")
	public void user_selects_the_degree(String arg1) throws Throwable {
		aboutYourselfScreen.selectDegree(arg1);
	}
}
