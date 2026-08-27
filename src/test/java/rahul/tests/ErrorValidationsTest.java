package rahul.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahul.TestComponents.BaseTest;
import rahul.TestComponents.Retry;
import rahul.pageobjects.CartPage;
import rahul.pageobjects.CheckoutPage;
import rahul.pageobjects.ConfirmationPage;
import rahul.pageobjects.LandingPage;
import rahul.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException {

		
		landingPage.loginApplication("rahul3pr@gmail.com", "R@hul@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
		
		
	}
		
	
		@Test
		public void productErrorValidation() throws IOException, InterruptedException {

			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = landingPage.loginApplication("rahulpr23@gmail.com", "R@hul@123");
			List<WebElement> products = productCatalogue.getProductList();

			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();

			Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
			Assert.assertFalse(match);

		}

}
