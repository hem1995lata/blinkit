package com.rahulshettypom.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rahulshettypom.components.AbstractComponent;

public class CartPage extends AbstractComponent{
WebDriver driver;

@FindBy(css = ".totalRow button")
WebElement checkoutele;

@FindBy(css = ".cartSection h3")
private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

	public CheckoutPage goToCheckout() {
		checkoutele.click();
		return new CheckoutPage(driver);
		
	}

}
