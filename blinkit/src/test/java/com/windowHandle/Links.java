package com.windowHandle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	public static void main(String s[]) {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

	driver.get("https://rahulshettyacademy.com/AutomationPractice/");

	driver.manage().window().maximize();
	
	//count of total link in the page
	System.out.println(driver.findElements(By.tagName("a")).size());
	
	//count of total links in footer
	WebElement footerdriver =  driver.findElement(By.cssSelector("#gf-BIG"));
	System.out.println(footerdriver.findElements(By.tagName("a")).size());
	
	//find the links =of 1st column
	WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	System.out.println(coloumndriver.findElements(By.tagName("a")).size());
	
	//click on the each links and the check the windows(pages) are open
	
	for(int i=1; i<coloumndriver.findElements(By.tagName("a")).size(); i++) {
//		coloumndriver.findElements(By.tagName("a")).get(i).click();
//		WebElement element=coloumndriver.findElements(By.tagName("a")).get(i);
//	 
		String clickLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
	}
	

}
}