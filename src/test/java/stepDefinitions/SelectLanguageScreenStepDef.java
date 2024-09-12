package stepDefinitions;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Then;
import screens.SelectLanguageScreen;

public class SelectLanguageScreenStepDef extends TestBase {
	
	SelectLanguageScreen selectLanguageScreen = new SelectLanguageScreen(driver);

	@Then("^user lands on select language screen$")
	public void user_lands_on_select_language_screen() throws Throwable {
		Assert.assertEquals(selectLanguageScreen.checkLanguageSelectionScreen(), true);
	}
	
	@Then("^user select language \"([^\"]*)\"$")
	public void user_select_language(String arg1) throws Throwable {
		selectLanguageScreen.selectLanguage(arg1);
	}

}
