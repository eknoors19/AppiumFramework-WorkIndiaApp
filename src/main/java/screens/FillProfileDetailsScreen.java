package screens;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.CommonUtils;

public class FillProfileDetailsScreen extends ScreenBase {
	
	private static Logger log = Logger.getLogger(FillProfileDetailsScreen.class.getName());

	public static final String pckg_name = "in.workindia.nileshdungarwal.workindiaandroid";
	CommonUtils commonUtils;

	// -------------Fill Profile Details Page Objects---------------------

	@AndroidFindBy(id = pckg_name + ":id/btn_done")
	public WebElement fillProfileDetailsSubmitButton;

	@AndroidFindBy(id = "android:id/alertTitle")
	public WebElement profileNotFilledErrorMessage;

	@AndroidFindBy(id = pckg_name + ":id/rg_male")
	public WebElement genderMale;

	@AndroidFindBy(id = pckg_name + ":id/rg_female")
	public WebElement genderFemale;

	@AndroidFindBy(id = pckg_name + ":id/rb_below_tenth")
	public WebElement qualificationBelowTenth;

	@AndroidFindBy(id = pckg_name + ":id/rb_ssc")
	public WebElement qualificationSSC;

	@AndroidFindBy(id = pckg_name + ":id/rb_hsc")
	public WebElement qualificationHSC;

	@AndroidFindBy(id = pckg_name + ":id/rb_graduate")
	public WebElement qualificationGraduate;

	@AndroidFindBy(id = pckg_name + ":id/cb_hindi")
	public WebElement schoolMediumHindi;

	@AndroidFindBy(id = pckg_name + ":id/cb_other")
	public WebElement schoolMediumOther;

	@AndroidFindBy(id = pckg_name + ":id/cb_english")
	public WebElement schoolMediumEnglish;

	@AndroidFindBy(id = pckg_name + ":id/rg_eng_level_2")
	public WebElement englishFrequencyLevel2;

	@AndroidFindBy(id = pckg_name + ":id/rg_eng_level_3")
	public WebElement englishFrequencyLevel3;

	@AndroidFindBy(id = pckg_name + ":id/rg_eng_level_4")
	public WebElement englishFrequencyLevel4;

	@AndroidFindBy(id = pckg_name + ":id/cb_fresher")
	public WebElement experienceFresher;

	@AndroidFindBy(id = pckg_name + ":id/cb_experience")
	public WebElement experienceExperienced;

	@AndroidFindBy(id = pckg_name + ":id/et_age")
	public WebElement selectAge;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Counter Sales\"]")
	public WebElement interestCounterSales;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement interestSelectionValues;

	@AndroidFindBy(id = pckg_name + ":id/btn_sector_filter_button")
	public WebElement interestSelection;

	/*
	 * Initialization of the class
	 */

	public FillProfileDetailsScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// -------------Fill Profile Details Page Methods---------------------

	public void clickChooseCitySubmitButton() {
		fillProfileDetailsSubmitButton.click();
		log.info(
				"*****************************************Choose city submit button clicked***********************************************");

	}

	public boolean checkProfileNotFilledErrorMessage() {
		return profileNotFilledErrorMessage.isEnabled();
	}

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("Male")) {
			genderMale.click();
		} else {
			genderFemale.click();
		}
		log.info(
				"*****************************************Gender selected***********************************************");

	}

	public void selectQualification(String qualification) {
		if (qualification.equalsIgnoreCase("Belowtenth")) {
			qualificationBelowTenth.click();
		} else if (qualification.equalsIgnoreCase("SSC")) {
			qualificationSSC.click();
		} else if (qualification.equalsIgnoreCase("HSC")) {
			qualificationHSC.click();
		} else if (qualification.equalsIgnoreCase("Graduate")) {
			qualificationGraduate.click();
		}
		log.info(
				"*****************************************Qualification selected***********************************************");

	}

	public void selectSchoolMedium(String medium) {
		if (medium.equalsIgnoreCase("English")) {
			schoolMediumEnglish.click();
		} else if (medium.equalsIgnoreCase("Hindi")) {
			schoolMediumHindi.click();
		} else if (medium.equalsIgnoreCase("Other")) {
			schoolMediumOther.click();
		}
		log.info(
				"*****************************************School Medium selected***********************************************");

	}

	public void selectEnglishSpeakingLevel(String speakinglevel) {
		if (speakinglevel.equalsIgnoreCase("ThodaEnglish")) {
			englishFrequencyLevel2.click();
		} else if (speakinglevel.equalsIgnoreCase("GoodEnglish")) {
			englishFrequencyLevel3.click();
		} else if (speakinglevel.equalsIgnoreCase("FluentEnglish")) {
			englishFrequencyLevel4.click();
		}
		log.info(
				"*****************************************speaking level selected***********************************************");

	}
	
	public void selectFresherOrExperience(String type) {
		ScreenBase.scroll(ScrollDirection.DOWN, 0.2);
		
		if (type.equalsIgnoreCase("Fresher")) {
			experienceFresher.click();
		} else if (type.equalsIgnoreCase("Experienced")) {
			experienceExperienced.click();
		}
		log.info(
				"*****************************************Fresher or experience selected***********************************************");

	}

	public void selectAge(String age) throws Exception {
		ScreenBase.scroll(ScrollDirection.UP, 0.1);
		ScreenBase.scroll(ScrollDirection.DOWN, 0.5);
		Thread.sleep(2000);
		selectAge.click();
		Thread.sleep(3000);
		//scrollUpToAge(age);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + age + "\"]")).click();
		
		log.info(
				"*****************************************Age selected***********************************************");

	}
	
	public Boolean scrollUpToAge(String age)
	{
		Boolean scrollUpToAge=false;
		
		try {
			log.info("Scrolling Up To Element "+ age );
			Boolean status = CommonUtils.scrollUptoElement(age); 
			scrollUpToAge= status;
			System.out.println("Scroll Up to Country status is: "+ status);
			Assert.assertTrue(true, "Age is not found");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scrollUpToAge;
	}

	public void selectInterest(String interest) throws InterruptedException {

		List<WebElement> listOfCheckbox = driver.findElements(By.className("android.widget.CheckBox"));
		for (int i = 0; i < listOfCheckbox.size(); i++) {
			if (listOfCheckbox.get(i).getText().equalsIgnoreCase(interest)) {
				listOfCheckbox.get(i).click();
			}
		}
		log.info(
				"*****************************************Interest selected***********************************************");

	}
}
