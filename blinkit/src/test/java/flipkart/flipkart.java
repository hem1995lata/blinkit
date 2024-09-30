package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {
	
	public static void main() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
//		driver.findElement(By.className(".Pke_EE")).click();
		
		}
	

}
