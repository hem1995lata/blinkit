package com.windowHandle;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTimeEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	    System.out.println(driver.findElements(By.tagName("a")).size());
	    Thread.sleep(3000);
	    WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
	    System.out.println(footerdriver.findElements(By.tagName("a")).size());
        
	    //to count the no. of links of one col of footer section
	   WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
	   System.out.println(columndriver.findElements(By.tagName("a")).size());
	  
	   
	   for(int i=0; i<=columndriver.findElements(By.tagName("a")).size()-1; i++) {
		   
		  String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		   columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
		   
		    Thread.sleep(6000);
		    
	   }
		   
		   Set<String> abc = driver.getWindowHandles();
		   Iterator<String> it = abc.iterator();
		   
		   while(it.hasNext()) {  //hasNext tells whether next is present or not
			   
			  driver.switchTo().window(it.next());  //next present if next element is present then move
			  System.out.println(driver.getTitle());
		   
		   
	   }
	}

}
