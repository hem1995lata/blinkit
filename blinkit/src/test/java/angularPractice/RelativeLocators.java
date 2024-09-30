package angularPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
//		System.out.println(driver.findElement(By.xpath("//form/div[1]/label")).getText());
//		System.out.println(driver.findElement(By.xpath("//form/div[7]/label")).getText());
		
	    WebElement nameEditBox = driver.findElement(By.className("form-control")); //write locator of textBox 
	    System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText()); //the by using relative locator method, find required text
	    
	    
	   WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
	   driver.findElement(with(By.tagName("input")).below(dob)).click();
	    
       WebElement iceCream = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
       
       WebElement radioButton = driver.findElement(By.xpath("//input[@value='option1']"));
       System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());
	   
	}

}
