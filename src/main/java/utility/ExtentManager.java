package utility;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private ExtentManager() {
		
	}
	
	//private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extTest = null;
	
	static ExtentTest getExtentTest() {
		extTest = new ThreadLocal<>();
		return extTest.get();
	}
	
	static void setExtentTest(ExtentTest test) {
		extTest = new ThreadLocal<>(); 
		extTest.set(test);
	}
	
	static void unload() {
		extTest.remove();
	}

}
