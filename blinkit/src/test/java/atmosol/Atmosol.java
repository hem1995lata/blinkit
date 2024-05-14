package atmosol;

import static org.junit.Assert.assertEquals;

import java.awt.Component;
import java.awt.Window;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Atmosol {
	
	
	public static void main(String a[]) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/index.php");
		String title = driver.getTitle();
		if(title == "Welcome to the Simple Travel Agency!") {
			System.out.print("Title matched");
		}
		else {
			System.out.println("Title are different"); 
		}
//		Assert.assertEquals(title, "Welcome to the Simple Travel Agency!");
//		driver.findElement(By.partialLinkText("destination of the week!")).click();
//		
//		driver.findElement(By.linkText("destination of the week! The Beach!")).click();
//		
//		Set<String> windows = driver.getWindowHandles();  //parentId, childId
//		Iterator<String>it = windows.iterator();
//		String parentId = it.next();
//		String childId = it.next();
//		
//		driver.switchTo().window(childId);
//		Thread.sleep(2000);
//		driver.switchTo().window(parentId);
		
		driver.findElement(By.partialLinkText("destination of the week!")).click();
		Thread.sleep(1000);
		String url = driver.getCurrentUrl();
		if(url.contains("vacation")) {
			driver.navigate().back();
		}
		
		
	    WebElement element = driver.findElement(By.xpath("//select[@class='form-inline'][1]"));
	    Select dropdown = new Select(element);
	    element.click();
	    dropdown.selectByValue("Mexico City");
	    
	    Thread.sleep(2000);
	    
	    WebElement element1 = driver.findElement(By.xpath("//select[@class='form-inline'][2]"));
	    Select dropdown1 = new Select(element1);
	    element1.click();
	    dropdown1.selectByValue("London");
	    
	    driver.findElement(By.xpath("//input[@class=\'btn btn-primary\']")).click();
	    
	    driver.findElement(By.xpath("//tbody/tr[3]/td[1]")).click();
	    
	    driver.findElement(By.xpath("//input[@placeholder='First Last']")).sendKeys("Hemlata kumari");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	   String text= driver.findElement(By.tagName("h1")).getText();
	   System.out.println(text);
		if(text.equals("Thank you for your purchase today!")) {
			System.out.println("Purchase Confirmation page");
	    
	}
		String orderId= driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		System.out.println(orderId);
		driver.close();
	
	}

}
