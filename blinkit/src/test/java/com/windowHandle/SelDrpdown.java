package com.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelDrpdown {
	
	public static void main(String a[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//1. Handle static dropdown Select tag show its static dropdown
		
//		WebElement element =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//		element.click();
//		Select s = new Select(element);
//		s.selectByIndex(3);
//	System.out.println(s.getFirstSelectedOption().getText());
	
	//2. Add 5 adult in in passanger
		
	driver.findElement(By.id("divpaxinfo")).click();
	Thread.sleep(4000);
	
//	driver.findElement(By.id("hrefIncAdt")).click();  //instead of finding and clicking element again and again, use while loop. 
//	driver.findElement(By.id("hrefIncAdt")).click();
//	driver.findElement(By.id("hrefIncAdt")).click();
//	driver.findElement(By.id("hrefIncAdt")).click();
//	driver.findElement(By.id("hrefIncAdt")).click();
	
//	int i =1;
//	while(i<6) {
//		driver.findElement(By.id("hrefIncAdt")).click();
//		i++;
//	}
	
	for(int i=1; i<6;i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		
		
	}
	
	
	driver.findElement(By.id("btnclosepaxoption")).click();
	
	System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
