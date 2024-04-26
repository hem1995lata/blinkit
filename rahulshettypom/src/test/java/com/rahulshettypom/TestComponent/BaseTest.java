package com.rahulshettypom.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.rahulshettypom.pageobjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initailizeDriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream("E:\\Automation Workspace\\rahulshettypom\\src\\test\\resources\\application.properties");
		prop.load(fin);
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
		 return driver;
		
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver=initailizeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
		
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//	}

}
