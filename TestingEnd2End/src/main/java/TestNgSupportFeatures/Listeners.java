package TestNgSupportFeatures;



import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import Log4j.Log;
import Reports.ExtentManager;
import Reports.ExtentTestManager;


public class Listeners extends TestBase implements ITestListener {
	
TestBase b=new TestBase();
	
	//This method invokes every time a test method is called and executed.
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Inside method : onTestStart of Interface class ITestListener");
		Log.startTestCase(result.getName());
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess Method" +result.getName());
		Log.info("Test Success" );
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method" +result.getName());
		Log.error("Test Failed");
		try {
			String path=b.getScreenshotPath(result.getName());
			System.out.println("Screenshot is taken and placed in path: " + path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		Log.info("failed testcase");		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Log.error("Test Skipped");
		System.out.println("onTestSkipped Method" +result.getName());
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage Method" +result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		Log.error("Test onTestFailedWithTimeout");
		System.out.println("onTestFailedWithTimeout Method" +result.getName());
	}

	//OnStart method is called when any Test starts.
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Inside method : onStart of Interface class ITestListener");
		System.out.println(context.getName());
	}

	//onFinish method is called after all Tests are executed.
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Inside method : onFinish of Interface class ITestListener");
		Log.endTestCase(context.getName());
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

}
