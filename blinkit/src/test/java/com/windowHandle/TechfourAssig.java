package com.windowHandle;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TechfourAssig {

	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat2-ui-mavibiometricsales.innov.co.in/login");
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Welcome@123");
        driver.findElement(By.tagName("button")).click();
         
        
        

//        driver.findElement(By.xpath("//div[@class='form-group-custom']")).sendKeys("a");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Please enter the otp");
//        Sting a=sc.nextInt();
	}

}
