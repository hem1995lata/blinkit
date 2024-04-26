package rahulshetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	
//	@Test
//	public void testing() {
//		    
//	}
	
	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		
        driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("hem1995lata@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemlata17@@");
		driver.findElement(By.id("login")).click();
	
	}

}
