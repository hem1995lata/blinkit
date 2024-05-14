package com.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	
    public static void main(String s[]) {
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://jqueryui.com/droppable/");
		driver.findElement(By.id(null));
	}
	
	
	
	
	

}
