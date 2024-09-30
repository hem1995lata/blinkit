package com.windowHandle;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method 
		  // Initialize the WebDriver (make sure to set the correct path to your WebDriver executable)
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  //we are telling webdriver to get screenshot as a file format
        FileUtils.copyFile(screenshot, new File("C://Screenshot.png"));
        
        // Locate the checkbox using XPath and click it
        WebElement checkBox = driver.findElement(By.xpath("//div/div[4]/fieldset/label[2]/input"));
        checkBox.click();
        
        // Get the value of the selected checkbox
        String checkboxValue = checkBox.getAttribute("value");
        
        // Print the value
        System.out.println("Selected checkbox value: " + checkboxValue);
        
        WebElement value = driver.findElement(By.xpath("//div/div[3]/fieldset/select"));
        value.click();
       Select s = new Select(value);
        s.selectByValue(checkboxValue);
        
       driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkboxValue);
       driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
       
      String message = driver.switchTo().alert().getText();
        System.out.println(message);
        
        
        
//        if(value==message) {
//        	System.out.println("")
        	
//        }
//       driver.switchTo().alert().accept();
//       
        
        // Close the driver
//        driver.quit();

		
  
	}

}
