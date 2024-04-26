package com.rahulshettypom;

import java.io.IOException;
import org.testng.annotations.Test;

import com.rahulshettypom.TestComponent.BaseTest;
import com.rahulshettypom.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void submitOrder() throws IOException {

		String productName="ZARA COAT 3";

		ProductCatalogue productCatalogue= landingPage.loginApplication("hem1995lat@"
				+ "gmail.com", "Hemlata17@@");
		
		//.ng-tns-c4-11.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		
	}

}
