package screens;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class ChooseCityScreen extends ScreenBase{
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	@AndroidFindBy(id = pkg_name + ":id/tv_city")
	public WebElement chooseCityTitle;

	@AndroidFindBy(id = pkg_name + ":id/rb_mum")
	public WebElement selectMumbai;

	@AndroidFindBy(id = pkg_name + ":id/rb_pune")
	public WebElement selectPune;

	@AndroidFindBy(id = pkg_name + ":id/rb_delhi")
	public WebElement selectDelhi;

	@AndroidFindBy(id = pkg_name + ":id/rb_bengaluru")
	public WebElement selectBengaluru;

	@AndroidFindBy(id = pkg_name + ":id/act_auto_complete")
	public WebElement enterNearestlocation;

	@AndroidFindBy(id = pkg_name + ":id/btn_done")
	public WebElement submitButton;

	/*
	 * Initialization of the class
	 */
	public ChooseCityScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	// -------------Choose City Screen Page Methods---------------------

		public boolean chooseCityTitle() throws Exception {
			Thread.sleep(2000);
			return chooseCityTitle.isDisplayed();
		}

		public void chooseCity(String city) {

			if (city.equalsIgnoreCase("Mumbai")) {
				selectMumbai.click();
			}
			if (city.equalsIgnoreCase("Pune")) {
				selectPune.click();
			}
			if (city.equalsIgnoreCase("Delhi")) {
				selectDelhi.click();
			}
			if (city.equalsIgnoreCase("Bengaluru")) {
				selectBengaluru.click();
			}
			log.info(
					"*****************************************City Selected***********************************************");

		}

		public void enterNearestLocation(String location) {
			enterNearestlocation.sendKeys(location);
			log.info(
					"*****************************************Nearest Location Entered***********************************************");

		}

		public void clickSubmit() {
			submitButton.click();
			log.info(
					"*****************************************Submit Button Clicked***********************************************");

		}
	

}
