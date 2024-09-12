package screens;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class DashboardScreen extends ScreenBase{
	public static final String pckg_name = Constants.PKG_NAME;
	private Logger log;
	
	// -------------workindia dashboard Page Objects---------------------

		@AndroidFindBy(id = pckg_name + ":id/navigation_ham_menu")
		public WebElement profileMenu;
		
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"My Profile\"]")
		public WebElement myProfile;
		
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upload Your Own Resume\"]")
		public WebElement uploadYourResume;
		
		@AndroidFindBy(id = pckg_name + ":id/et_inputSearch")
		public WebElement searchBox;

		@AndroidFindBy(id = pckg_name + ":id/navigation_ham_menu")
		public WebElement iconProfile;
	
	/*
	 * Initialization of the class
	 */

	public DashboardScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
	}
	
		
		public void clickMyProfile() {
			myProfile.click();
			log.info(
					"****************************************My profile clicked***********************************************");

		}
		
		public void clickUploadYourResume() {
			uploadYourResume.click();
			log.info(
					"****************************************My profile clicked***********************************************");

		}
		
		public void clickProfileMenu() throws Exception {
			Thread.sleep(4000);
			profileMenu.click();
			Thread.sleep(4000);
			clickUploadYourResume();
			log.info(
					"****************************************Profile Menu clicked***********************************************");

		}
		
		public void enterInSearchBox(String jobSearch) throws InterruptedException {
			
			driver.findElement(By.xpath("in.workindia.nileshdungarwal.workindiaandroid:id/et_inputSearch")).sendKeys(jobSearch);
			
		}
	
}
