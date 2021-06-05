package resources;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNg {
	
	public static ExtentReports extent;
	
	public static ExtentReports configExtentReports() {
		
		String path = System.getProperty("user.dir")+"\\reports\\"+"index.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setDocumentTitle("Queue Codes Test Result");
		reporter.config().setReportName("Queue Codes Technology");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sandeep Gaikwad");
		return extent;
	}

}
