package com.windowHandle;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsMethods {
	
	public static void main(String s[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();  //WebDriver is a Interface and Chomedriver is its implementing class. launch chromedriver.
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
	//Hover mouse in any particular element	
		Scanner sc = new Scanner(System.in);
		String captcha = sc.next();
		driver.findElement(By.id("captchacharacters")).sendKeys(captcha);
		driver.findElement(By.className("a-button-text")).click();
		Thread.sleep(4000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
	
	    
		//write test on textbox in capital letter 
		  a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		 
		  
	}

}
