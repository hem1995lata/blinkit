package com.rahulshettypom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
        
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
        
		driver.findElement(By.id("userEmail")).sendKeys("hem1995lata@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemlata17@@");
		driver.findElement(By.id("login")).click();	
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		int s = products.size();
		System.out.println(s);
		
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		System.out.println(prod.getText());
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
		Thread.sleep(2000);
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		
		String productName = "ZARA COAT 3";
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		
		if(match==true) {
			System.out.println("Pass");
			
		}
		else {
			System.out.println("False");
		}
		
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		Thread.sleep(2000);
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		if(confirmMessage.equalsIgnoreCase("ThankYou For The Order.")) {
			System.out.println("Order Pass");
		}
		
		else {
			System.out.println("Order Fail");
		}
		driver.close();

	}

}
