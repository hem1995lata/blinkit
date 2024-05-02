package com.blinkit;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {
//	public WebDriver driver;

	public static void main(String a[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://blinkit.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

//	driver.findElement(By.className(".LocationBar__ArrowContainer-sc-x8ezho-3")).click();
		driver.findElement(By.className("mask-button")).click();
//	Thread.sleep(3000);
//	driver.findElement(By.cssSelector(".ProfileButton__Text-sc-975teb-2")).click();
		Thread.sleep(2000);
//	driver.findElement(By.className("login-phone__input"
//			+ "")).sendKeys("7048992185");
//	
//	
//	driver.findElement(By.className("PhoneNumberLogin__LoginButton-sc-1j06udd-4 ")).click();
//	Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
				driver.findElement(By.cssSelector("img[alt='3 - Fruits & Vegetables']")));
//	driver.findElement(By.cssSelector("img[alt='3 - Fruits & Vegetables']")).click();
		Thread.sleep(2000);
		List<WebElement> elements = driver
				.findElements(By.cssSelector("div[class*='Product__UpdatedPlpProductContainer']"));

		// List<WebElement> elements =
		// driver.findElements(By.className("section-right"));
		System.out.println(elements.size());

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().contains("Onion 1 kg (Pyaz)")) {
				WebElement element = elements.get(i);
				element.findElement(By.cssSelector("div[class*='AddToCart__UpdatedButtonContainer']")).click();

			}
		}

		driver.findElement(By.className("CartButton__Button-sc-1fuy2nj-5")).click();
		driver.findElement(By.cssSelector("div[class*='CheckoutStrip__StripContainer']")).click();
		driver.findElement(By.className("login-phone__input")).sendKeys("7048992185");
		Thread.sleep(2000);
		driver.findElement(By.className("PhoneNumberLogin__LoginButton-sc-1j06udd-4")).click();
		Thread.sleep(5000);
		Scanner sc=new Scanner(System.in);
		String otp=sc.next();
		driver.findElement(By.className("otp__input")).sendKeys(otp);
		Thread.sleep(2000);
		driver.findElement(By.className("CheckoutStrip__TitleText-sc-1fzbdhy-9")).click();
//		System.out.println();
//		System.out.println();
		
		

//	List<WebElement> elements = driver.findElements(By.className("SliderProductList__Wrapper-sc-14wck6y-0"));
//	for(WebElement w:elements)
//		System.out.println(w.getText());
//	Thread.sleep(2000);
//	WebElement prod = elements.stream().filter(product->
//	driver.findElement(By.className("Product__UpdatedTitle-sc-11dk8zk-9")).getText().equals("English Oven Brown Bread")).findFirst().orElse(null);
//	prod.findElement(By.className("AddToCart__UpdatedButtonContainer-sc-17ig0e3-0")).click();
//	driver.findElement(By.cssSelector("img[alt='3 - Fruits & Vegetables']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("AddressList__AddressDetails-sc-zt55li-3")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("CheckoutStrip__StripContainer-sc-1fzbdhy-8")).click();
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",
		driver.findElement(By.className("sc-rbbb40-0")));
//		driver.close();
	}
}
