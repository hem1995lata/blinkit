package com.rahulshettypom.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettypom.components.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	 
	@FindBy(id="login")
	WebElement submit;
	 
	
	@FindBy(css="[class*=flyInOut]")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		return new ProductCatalogue(driver);

	}
	
	public void getErrorMessage() {
		waitForWebEElementToAppear(errorMessage);
		errorMessage.getText();
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
