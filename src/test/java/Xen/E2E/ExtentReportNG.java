package Xen.E2E;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	
	{
		gettimestamp ts= new gettimestamp();
		String formatted_date=ts.get_timestamp();
		//String path =System.getProperty("user.dir")+"\\reports\\automationreports"+formatted_date+".html";
		String path =System.getProperty("user.dir")+"\\reports\\automationreports"+".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Syamantak Chakraborty");
		
		return extent;
	}
	
	

}

