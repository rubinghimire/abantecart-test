package pages;

import org.openqa.selenium.By;
import driver.DriverManager;

public final class ShoppingCartPage {
	private static final By checkoutBtn = By.xpath("//*[@id=\"cart_checkout1\"]");

	public CheckoutPage checkout() {
		DriverManager.getDriver().findElement(checkoutBtn).click();
		return new CheckoutPage();
	}

}
