package com.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
	//ExtentsReport, ExtentsparkReporter
	
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Report");
	reporter.config().setDocumentTitle("Test Result");	
			

	        
	extent = new ExtentReports();
    extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Hemlata kumari");
	
	}
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		System.out.println(driver.getTitle());
		
		driver.close();
//		test.fail("Result do not match");
		
		extent.flush();
	}

}
