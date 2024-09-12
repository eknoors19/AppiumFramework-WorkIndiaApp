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

public class SelectLanguageScreen extends ScreenBase {
	
	public static final String pkg_name = Constants.PKG_NAME;
	private Logger log;
	
	// -------------select language Page Objects---------------------

		@AndroidFindBy(id = pkg_name + ":id/toolbar")
		public WebElement languageSelectionHeading;

		@AndroidFindBy(id = pkg_name + ":id/btn_english")
		public WebElement languageEnglish;

		@AndroidFindBy(id = pkg_name + ":id/btn_hindi")
		public WebElement languageHindi;
	
	/*
	 * Initialization of the class
	 */

	public SelectLanguageScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
	// -------------select language Screen Page Methods---------------------

		public void selectLanguage(String language) throws InterruptedException {
			if (language.equalsIgnoreCase("English")) {
				languageEnglish.click();
			} else {
				languageHindi.click();
			}
			log.info(
					"*****************************************Language selected***********************************************");

		}

		public boolean checkLanguageSelectionScreen() throws Exception {
			Thread.sleep(3000);
			return languageSelectionHeading.isEnabled();
		}

}
