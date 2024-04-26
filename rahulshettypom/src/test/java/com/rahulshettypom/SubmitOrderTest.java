package com.rahulshettypom;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rahulshettypom.TestComponent.BaseTest;
import com.rahulshettypom.components.AbstractComponent;
import com.rahulshettypom.pageobjects.CartPage;
import com.rahulshettypom.pageobjects.CheckoutPage;
import com.rahulshettypom.pageobjects.ConfirmationPage;
import com.rahulshettypom.pageobjects.LandingPage;
import com.rahulshettypom.pageobjects.OrderPage;
import com.rahulshettypom.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productName="ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException {
//		System.setProperty("webdriver.chrome.driver","E:\\driver\\chromedriver\\chromedriver.exe");
//		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		LandingPage landingPage=new LandingPage(driver);
//		landingPage.goTo();
//		LandingPage landingPage=launchApplication();
		ProductCatalogue productCatalogue= landingPage.loginApplication("hem1995lata@gmail.com", "Hemlata17@@");
		
		List<WebElement> products=productCatalogue.getProducts();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.sumitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();;
		assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest() {
		
		ProductCatalogue productCatalogue= landingPage.loginApplication("hem1995lata@gmail.com", "Hemlata17@@");
		OrderPage orderPage=productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}

}
