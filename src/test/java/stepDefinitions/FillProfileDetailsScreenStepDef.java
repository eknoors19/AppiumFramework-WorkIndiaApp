package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Then;
import screens.FillProfileDetailsScreen;


public class FillProfileDetailsScreenStepDef extends TestBase {
	FillProfileDetailsScreen fillProfileDetailsScreen = new FillProfileDetailsScreen(driver);

	@Then("^user clicks on submit button on fill profile details screen$")
	public void user_clicks_on_submit_button_on_fill_profile_details_screen() throws Throwable {
		fillProfileDetailsScreen.clickChooseCitySubmitButton();
	}

	@Then("^message is displayed saying profile details not filled \"([^\"]*)\"$")
	public void message_is_displayed_saying_profile_details_not_filled(String arg1) throws Throwable {
		Assert.assertEquals(fillProfileDetailsScreen.checkProfileNotFilledErrorMessage(), true);
	}
	
	@Then("^user fills the profile detials \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void user_fills_the_profile_detials(String gender, String qualification, String schoolmedium,
			String englishlevel, String fresher_experienced, String age, String interest) throws Throwable {
		fillProfileDetailsScreen.selectGender(gender);
		fillProfileDetailsScreen.selectQualification(qualification);
		fillProfileDetailsScreen.selectSchoolMedium(schoolmedium);
		fillProfileDetailsScreen.selectEnglishSpeakingLevel(englishlevel);
		
		//driver.findElement(By.id("in.workindia.nileshdungarwal.workindiaandroid:id/tv_age_message")).click();
		Thread.sleep(2000);
		
		fillProfileDetailsScreen.selectFresherOrExperience(fresher_experienced);
		
		fillProfileDetailsScreen.selectAge(age);
		fillProfileDetailsScreen.selectInterest(interest);
	}

}
