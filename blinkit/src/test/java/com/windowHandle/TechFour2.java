package com.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechFour2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://sit2-ui-mavibiometricclaims.innov.co.in/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@1234");
        driver.findElement(By.tagName("button")).click();
        
        Thread.sleep(5000);
        
        driver.findElement(By.tagName("button")).click();
        
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[@title='Claim']")).click();
 

	}

}
