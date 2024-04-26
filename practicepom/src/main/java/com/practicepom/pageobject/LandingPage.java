package com.practicepom.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practicepom.util.AbstractComponent;

public class LandingPage extends AbstractComponent{  //extends AbstractComponent so that landing page can use AbstractComponent code
	
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;  //initialization
		
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
//	WebElement userPassword = driver.findElement(By.id("userPassword"));
//	WebElement login = driver.findElement(By.id("login"));
	
	//PageFactory
	//WebElements   
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordUser;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalog applicationLogin(String email, String password) {
		userEmail.sendKeys(email);
		passwordUser.sendKeys(password);
		submit.click();
		return new ProductCatalog(driver);
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
