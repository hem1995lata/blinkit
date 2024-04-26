package com.rahulshettypom.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.rahulshettypom.components.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver); 
		a.sendKeys(country, countryName).build().perform();
		waitElementToAppear(results);
		selectCountry.click();
	}
	
//	public CheckoutPage goToCheckout() {
//		submit.click();
//		return new CheckoutPage(driver);
//		
//	}

//
//	private void waitForElementToAppear(By cssSelector) {
//		// TODO Auto-generated method stub
//		
//	}



	public ConfirmationPage sumitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
}
