package com.standalone;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//Login Page
		driver.findElement(By.id("userEmail")).sendKeys("hem1995lata@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemlata17@@");
		driver.findElement(By.id("login")).click();
		
		//Product Page
		List<WebElement> elements = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod=null;
//		for(int i=0; i<elements.size(); i++) {
//		if(elements.get(i).findElement(By.cssSelector("b")).getText().equalsIgnoreCase("ZARA COAT 3")) {
//			 prod=elements.get(i);
//			System.out.println(prod.getText());
//			
//			
//		}
//		}
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebElement prod = elements.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		Thread.sleep(2000);
		
		
		//Add to Cart Page
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Thread.sleep(2000);
		
		//payment page
//		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("india");
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
		
		
		
		driver.close();
		
		
		
		
	}

}