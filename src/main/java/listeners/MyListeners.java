package listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utility.TestUtil;

public class MyListeners implements ITestListener, ISuiteListener  {
	
	public void onStart(ISuite suite) {
		System.out.println("Starting Suite");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Finishing Suite");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {

		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Reporter.log("<a target=\"_blank\" href=\""+"screenshots/"+TestUtil.destFile+"\">Screenshot Captured</a>");
		
		Reporter.log("<br><a  target='_blank' href=\""+"screenshots/"+TestUtil.destFile+"\" ><img height=200, width=200, src=\""+"screenshots/"+TestUtil.destFile+"\" alt=\"\"/></img></a>");
		System.out.println("Screenshot Captured");    
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		System.out.println("Starting the test suite");

	}

	public void onFinish(ITestContext context) {

		System.out.println("Ending the test suite");

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
