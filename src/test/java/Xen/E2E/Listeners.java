package Xen.E2E;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.base;

public class Listeners extends base implements ITestListener {
	ExtentReports extent=ExtentReportNG .getReportObject();
	ExtentTest test ;
	
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getName());
		tl.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS, "Test got passed");
		tl.get().log(Status.PASS, "Test got passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//test.fail(result.getThrowable());
		//tl.get().fail(result.getThrowable());
        WebDriver driver= null;
		
		String failedtestmethodname=result.getName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		gettimestamp ts= new gettimestamp();
		String formatted_date=ts.get_timestamp();
		 
		try {
			String screenshot_path=getscreenshot(failedtestmethodname,driver,formatted_date);
			tl.get().fail(result.getThrowable());
			tl.get().addScreenCaptureFromPath(screenshot_path, result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

	
}
