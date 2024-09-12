package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.Then;
import screens.ChooseCityScreen;


public class ChooseCityScreenStepDef extends TestBase{
	
	ChooseCityScreen chooseCityScreen = new ChooseCityScreen(driver);

	@Then("^user selects city \"([^\"]*)\"$")
	public void user_selects_city(String arg1) throws Throwable {
		chooseCityScreen.chooseCity(arg1);
	}

	@Then("^user enters nearest place \"([^\"]*)\"$")
	public void user_enters_nearest_place(String arg1) throws Throwable {
		chooseCityScreen.enterNearestLocation(arg1);
	}

	@Then("^user clicks on submit button on choose city screen$")
	public void user_clicks_on_submit_button_on_choose_city_screen() throws Throwable {
		chooseCityScreen.clickSubmit();
	}

}
