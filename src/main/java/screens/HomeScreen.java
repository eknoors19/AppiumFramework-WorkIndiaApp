package screens;

import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ScreenBase;
import io.cucumber.datatable.DataTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utility.Constants;

public class HomeScreen extends ScreenBase{
	
	public static Properties prop = new Properties();
	private Logger log;

	public static final String pkg_name = Constants.PKG_NAME;

	@AndroidFindBy(id = pkg_name + ":id/et_name")
	public WebElement full_Name;

	@AndroidFindBy(id = pkg_name + ":id/et_number")
	public WebElement mobile_Number;
	
	@AndroidFindBy(id = "android:id/home")
	public WebElement selectHomeIcon;
	
	@AndroidFindBy(id = pkg_name + ":id/et_name")
	public WebElement enterFullName;

	@AndroidFindBy(id = pkg_name + ":id/et_number")
	public WebElement enterMobileNumber;

	@AndroidFindBy(id = pkg_name + ":id/btn_submit")
	public WebElement submitButton;

	@AndroidFindBy(id = pkg_name + ":id/tv_referral_code")
	public WebElement referralCodeLink;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement applyReferralButton;

	@AndroidFindBy(id = pkg_name + ":id/et_referral_code")
	public WebElement enterReferralCode;

	@AndroidFindBy(id = pkg_name + ":id/tv_message")
	public WebElement invalidReferralMessage;
	
	public HomeScreen(AppiumDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		log= LogManager.getLogger(this.getClass().getName());
		//PageFactory.initElements(new AppiumFieldDecorator(driver, 20, TimeUnit.SECONDS), this);

	}
	
	// -------------Landing Screen Page Methods---------------------

		public void enterFullNameAndMobileNumber(String fullName, String mobileNumber) {
			enterFullName.sendKeys(fullName);
			enterMobileNumber.sendKeys(mobileNumber);
		}
		
		/*
		 * public void enterFullName(String name) { enterFullName.sendKeys(name); //log.
		 * info("*****************************************Full Name Entered***********************************************"
		 * ); }
		 * 
		 * public void enterMobileNumber(String mobileNumber) {
		 * enterMobileNumber.sendKeys(mobileNumber); //log.
		 * info("*****************************************Mobile Number Entered***********************************************"
		 * ); }
		 * 
		 * public void enterFullname(DataTable dataTable) { for (Map<String, String>
		 * data : dataTable.asMaps(String.class, String.class)) {
		 * enterFullName.sendKeys(data.get("fullname"));
		 * System.out.println("DataTableFullName"); } //log.
		 * info("*****************************************Full Name Entered***********************************************"
		 * ); }
		 * 
		 * public void enterMobilenumber(DataTable dataTable) { for (Map<String, String>
		 * data : dataTable.asMaps(String.class, String.class)) {
		 * System.out.println("Mobile number: "+ data.get("mobilenumber"));
		 * enterMobileNumber.sendKeys(data.get("mobilenumber")); }
		 * System.out.println("enter Mobilenumber completed "); //log.
		 * info("*****************************************Mobile Number Entered***********************************************"
		 * ); }
		 */
		
		public void clickSubmitButton() {
			submitButton.click();
			log.info(
					"*****************************************Submit Button Clicked***********************************************");

		}

		public void clickReferralLink() {
			referralCodeLink.click();
			log.info(
					"*****************************************Referral Link clicked***********************************************");

		}

		public void enterReferralCode(String code) {
			enterReferralCode.sendKeys(code);
			log.info(
					"*****************************************Referral Code Entered***********************************************");

		}

		public void clickApplyButton() {
			applyReferralButton.click();
			log.info(
					"*****************************************Apply Button Clicked***********************************************");

		}
		
		public boolean checkInvalidCodeMessage() throws Exception {
			Thread.sleep(5000);
			return invalidReferralMessage.isEnabled();
		}	

}
