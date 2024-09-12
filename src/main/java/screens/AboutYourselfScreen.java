package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class AboutYourselfScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	// -------------About Yourself Page Objects---------------------

		@AndroidFindBy(id = pkg_name + ":id/tv_profile_heading")
		public WebElement aboutYourselfScreenHEading;

		@AndroidFindBy(id = pkg_name + ":id/et_course")
		public WebElement selectDegree;

		@AndroidFindBy(id = pkg_name + ":id/btn_done")
		public WebElement selectDegreeSubmitButton;

	/*
	 * Initialization of the class
	 */

	public AboutYourselfScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	// -------------about yourself screen Page Methods---------------------

		public boolean checkAboutYourselfScreenHeading() throws Exception {
			Thread.sleep(3000);
			return aboutYourselfScreenHEading.isEnabled();
		}
		
		public void selectDegree(String degree) throws Exception {
			selectDegree.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text=\"" + degree + "\"]")).click();
			log.info(
					"*****************************************Degree Selected***********************************************");
		}

		public void clickSelectDegreeSubmitButton() {
			
			selectDegreeSubmitButton.click();
			log.info(
					"*****************************************Select Degree Submit Button Clicked***********************************************");

		}

}
