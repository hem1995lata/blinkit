package ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport1 {
	
	ExtentReports extent;
	
	@BeforeTest
	public void configration() {
		
		String path = System.getProperty("user.dir")+"\\report1\\index1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Result");
		reporter.config().setReportName("Web Automation Test");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hemlata lumari");
		
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
