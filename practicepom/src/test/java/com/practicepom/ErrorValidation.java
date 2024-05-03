

	package com.practicepom;

	import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TestComponent.BaseTest;
import com.practicepom.pageobject.CartPage;
import com.practicepom.pageobject.LandingPage;
import com.practicepom.pageobject.ProductCatalog;

	public class ErrorValidation extends BaseTest{
		
		@Test(groups= {"ErrorHandaling"})
		public void LoginErrorValidation() throws IOException, InterruptedException
		{
		
	        String productName="ZARA COAT 3";
			LandingPage landingPage = launchApplication();
		    landingPage.goTo();
            landingPage.applicationLogin("hem1995lata@gmail.com", "Hemlata17@@@");
			Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
         }
		
		
		@Test
		public void StandAloneTest() throws IOException, InterruptedException
		{
		String productName="ZARA COAT 3";
		LandingPage landingPage = null;
		ProductCatalog productCatalog=landingPage.applicationLogin("hemlatak56@gmail.com",  "Hemlata17@@");
		List<WebElement> products=productCatalog.getProductList();
		productCatalog.addToCart(productName);
		CartPage cartPage=productCatalog.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertFalse(match);

	}
	
	}

