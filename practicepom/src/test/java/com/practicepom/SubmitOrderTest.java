package com.practicepom;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestComponent.BaseTest;
import com.practicepom.pageobject.CartPage;
import com.practicepom.pageobject.CheckoutPage;
import com.practicepom.pageobject.ConfirmationPage;
import com.practicepom.pageobject.LandingPage;
import com.practicepom.pageobject.OrderPage;
import com.practicepom.pageobject.ProductCatalog;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";
	
	@Test
	public void SubmitOrder () throws IOException, InterruptedException
	{
	
        
		
		 
		LandingPage landingPage = launchApplication();
	    landingPage.goTo();

		ProductCatalog productCatalog=landingPage.applicationLogin("hem1995lata@gmail.com", "Hemlata17@@");
		List<WebElement> products=productCatalog.getProductList();
		productCatalog.addToCart(productName);
		CartPage cartPage=productCatalog.goToCartPage();

		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmMessage=confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("ThankYou For The Order."));


		driver.close();

	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryTest() {
		LandingPage landingPage = null;
		//"ZARA COAT 3"
		ProductCatalog productCatalog=landingPage.applicationLogin("hem1995lata@gmail.com", "Hemlata17@@");
		OrderPage orderPage = productCatalog.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		
	}

}
