package stepDefinitions;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Then;
import screens.DashboardScreen;


public class DashboardScreenStepDef extends TestBase{
	
	DashboardScreen workIndiaHomeScreen = new DashboardScreen(driver);

	@Then("^user selects profile from menu of workindia dashboard screen$")
	public void user_selects_profile_from_menu_of_workindia_home_screen() throws Throwable {
		workIndiaHomeScreen.clickProfileMenu();
	}
	
	@Then("^user selects my profile tab$")
	public void user_selects_my_profile_tab() throws Throwable {
		workIndiaHomeScreen.clickMyProfile();
	}
	
	@Then("^user searches for a perticular job \"([^\"]*)\"$")
	public void user_searches_for_a_perticular_job(String arg1) throws Throwable {
		workIndiaHomeScreen.enterInSearchBox(arg1);
	}
	
}
