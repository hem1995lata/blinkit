package RahulShettyPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AutomationPractice {

	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		
		
		WebDriver driver = new FirefoxDriver();
		
//		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		AutomationPractice ap = new AutomationPractice();
			String pass = ap.getPassword(driver);
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("hemlatak56@gmail.com");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pass);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
		
	
		
		public String getPassword(WebDriver driver) throws InterruptedException {
			
			//Parse String to get the password text dynamically
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.linkText("Forgot your password?")).click();
//			Thread.sleep(2000);	
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
			By b=By.xpath("//button[@class='reset-pwd-btn']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(b));
			driver.findElement(b).click();
		    String passwordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
			System.out.print(passwordText);
			
			String[] passwordArray = passwordText.split("'");
		    //0th index - Please use temporary password '
		    //1 index - rahulshettyacademy' to Login.
		    
//		   String[] passwordArray2 = passwordArray[1].split("'");
//		   passwordArray2[0];
		    
		    String passwordArray2 = passwordArray[1].split("'")[0];
            return passwordArray2;
			
		}

}
