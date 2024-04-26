package com.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.practicepom.pageobject.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	 
	public WebDriver initializeDriver() throws IOException{
		
		//properties class
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//resources//GlobalData.properties" );
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
//		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
		//firefox
	}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			//edge
			System.setProperty("webdriver", "edge.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    driver.manage().window().maximize();
	    return driver;
		
		}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
//		landingPage.goTo();
		return landingPage;
	}

	private LandingPage landingPage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
