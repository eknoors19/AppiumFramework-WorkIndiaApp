package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {
	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_ACTIVITY;
	public static String APP_WAIT_ACTIVITY;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static String APPIUM_SERVER;
	public static String EXTENT_REPORT_CONFIG_PATH;
	public static URL serverURL;
	public static String AUTOMATION_NAME;

	public static Properties prop = new Properties();
	private static DesiredCapabilities capabilties = new DesiredCapabilities();

	// Abstract class
	public static AndroidDriver driver;

	// loadAndroidConfProp
	public void loadAndroidConfProp(String propertyFileName) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
		prop.load(fis);
		
		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APPIUM_PORT = prop.getProperty("appium.server.port");
		APPIUM_SERVER= prop.getProperty("appium_server");
		DEVICE_NAME = prop.getProperty("device.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		PLATFORM_NAME = prop.getProperty("platform.name");
		APP_ACTIVITY = prop.getProperty("application.activity");
		BASE_PKG = prop.getProperty("base.pkg");
		AUTOMATION_NAME= prop.getProperty("appium.automationName");
	}

	// SetAndroidCapabilties
	public void setAndroidCapabilities() {
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
		capabilties.setCapability(MobileCapabilityType.APP, Constants.APK_FILE_PATH);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,AUTOMATION_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
		
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.boopathy.raja.tutorial");
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.boopathy.raja.tutorial.SplashActivity");
		//Update the app file location in Constants java class
		capabilities.setCapability("app", Constants.APK_FILE_PATH);		
		
	}
	
	
	public AndroidDriver getAndroidDriver() throws MalformedURLException {
		//serverURL = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");serverURL = new URL("http://localhost:"+4723+"/wd/hub");
		serverURL = new URL(APPIUM_SERVER);
		driver = new AndroidDriver(serverURL, capabilties);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIME));
		return driver;
	}
	
	public static Boolean scrollUptoElement(String uptoScroll) throws InterruptedException
	{
		Boolean scrooled=false;
		WebElement toScrollElement=null;
		
		for(int i=1;i<30;i++)
		{
			scrooled=false;
			try
			{
				toScrollElement=  driver.findElement(By.xpath("//android.widget.TextView[@text=\"" + uptoScroll + "\"]"));
				if(toScrollElement.isDisplayed())
				{
					scrooled=true;
					System.out.println("Breaking out of For loop");
					break;
				}
			}catch(Exception e)
			{
				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();
				int x = width/2;
				int starty = (int)(height*0.70);
				int endy = (int)(height*0.20);
				CommonUtils.swipe(new Point(x,starty),new Point(x, endy),Duration.ofSeconds(1));
			}
		}
		
		if(scrooled)
		{
			toScrollElement.click();
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	 public static void swipe(Point start, Point end, Duration duration) {

	        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	        Sequence swipe = new Sequence(input, 0);
	        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
	        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
	        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        ((AppiumDriver) driver).perform(ImmutableList.of(swipe));
	    }
	 
	 /*
		 * 
		 * @Description = 'Method to read data from Excel sheet based on sheet name'
		 */
		public static Object[][] getTestDatafromExcel(String sheetName)
		{
			//File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\redbus\\testdata\\RedBusTestData.xlsx"); 
			File excelFile = new File(Constants.TEST_DATA_PATH); 
			XSSFWorkbook workbook = null;
			
			try {
				FileInputStream fisExcel= new FileInputStream(excelFile);
				workbook = new XSSFWorkbook(fisExcel);
			}catch(Throwable e)
			{
				e.printStackTrace();
			}
			
			XSSFSheet sheet= workbook.getSheet(sheetName);
			int rows= sheet.getLastRowNum();
			int cols= sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[rows][cols];
			
			for(int i=0; i< rows; i ++)
			{
				XSSFRow row= sheet.getRow(i+1);
				for (int j=0; j< cols; j++)
				{
					XSSFCell cell= row.getCell(j);
					CellType cellType= cell.getCellType();
					 
					switch(cellType) {
					
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;	
			
					}	
				}
			}
			return data;
		}

}
