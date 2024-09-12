package utility;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumServer {
	
	public static AppiumDriverLocalService service;

	public static void start() {
		// starting the Appium server code
		service = AppiumDriverLocalService.buildDefaultService().withBasePath("/wd/hub/");
        service.start();
	}
	
	public static void stop() {
		service.stop();
	}

}
