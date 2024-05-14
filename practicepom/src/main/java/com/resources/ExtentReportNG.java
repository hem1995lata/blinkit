package com.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentReports getReportObject() {
		
	
	String path = System.getProperty("user.dir")+"//reports.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Result");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo(path, path);
	return extent;
	}
}
