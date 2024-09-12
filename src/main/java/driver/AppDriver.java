package driver;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;

public class AppDriver {
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    private static AppDriver instance = null;

    private AppDriver(){

    }
    
    public static AppDriver getInstance(){
        if(instance==null){
            instance = new AppDriver();
        }
        return instance;
    }
    
    public WebDriver getDriver(){
        return driver.get();
    }

    public static WebDriver getCurrentDriver(){
    	return driver.get();
    }

    public static void setDriver(AppiumDriver Driver){
        driver.set(Driver);
        System.out.println("Driver is set");
    }

}
