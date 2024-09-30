package com.windowHandle;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Scanner sc=new Scanner(System.in);
		String captcha=sc.next();
		driver.findElement(By.id("captchacharacters")).sendKeys(captcha);
		driver.findElement(By.className("a-button-text")).click();
		Thread.sleep(6000);
		driver.findElement(By.linkText("Your Account")).click();
		
		Actions a = new Actions(driver);
		WebElement dropdown =driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		a.moveToElement(dropdown).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Browsing History")).click();
//		driver.findElement(By.xpath("span[@class='nav-text']")).click();
//	    Select s =new Select(dropdown);
//		s.selectByIndex(5);
//		System.out.println(s.getFirstSelectedOption().getText());
		
//		a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
		

	}

}
