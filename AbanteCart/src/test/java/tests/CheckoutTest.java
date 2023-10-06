package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.SubcategoryPage;

public class CheckoutTest extends BaseTest{
	private static final By orderSuccess = By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/h3");
	private static final String VALUE = "hello3";

	@Test
	public void checkoutOrder() {
			new HomePage().clickNavLogin();
			new LoginPage().login(VALUE, VALUE);
			SubcategoryPage subcategory = new SubcategoryPage();
			subcategory.selectProduct()
				.addToCart()
				.checkout()
				.selectDelivery()
				.confirmOrder();
			String expected = "Order is completed!";
			String result = DriverManager.getDriver().findElement(orderSuccess).getText();
			Assert.assertEquals(expected, result, "This has not passed");
	}
}
