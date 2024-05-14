package com.windowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles1 {
	
	public static void main(String s[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		
//		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hemlatak56@gmail.com");
//		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hemlata17@@");
//		driver.findElement(By.className("customradio")).click();
//		WebElement select = driver.findElement(By.xpath("//select[@class='form-control']"));
//		Select dropdown = new Select(select);
//		dropdown.selectByValue("Student");
//		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		
		Set<String> windowsId = driver.getWindowHandles(); //driver.getWindowHandles method grab the id's of window(parentId Ans childId)
		
		//use iterator method to pull out required id
		Iterator<String> it = windowsId.iterator();
		String parentId =  it.next();
		String childId =  it.next();
		
		//use switch to method for switching window from one window to another window
		driver.switchTo().window(childId);
		
		String element = driver.findElement(By.xpath("//p[@class='im-para red']")).getText();
		
		System.out.println(element);
		
		
		
	}

}
