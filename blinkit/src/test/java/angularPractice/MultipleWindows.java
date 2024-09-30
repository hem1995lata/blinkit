package angularPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
	    driver.get("https://rahulshettyacademy.com/angularpractice/");
	    driver.manage().window().maximize();
	    
	    driver.switchTo().newWindow(WindowType.TAB); //open new blank tab but control remains in previous page
	   
	    Set<String> handles = driver.getWindowHandles();
	    Iterator<String> it = handles.iterator();
	    String parentId = it.next();
	    String childId = it.next();
	    driver.switchTo().window(childId); //put handle name on which you want to do operation
	    driver.get("https://rahulshettyacademy.com/");
	    String courseName = driver.findElement(By.xpath("//h2/a[@href='https://courses.rahulshettyacademy.com/p/core-java-for-automation-testers-interview-programs']")).getText();
	    driver.switchTo().window(parentId);
	    driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
	}

}
