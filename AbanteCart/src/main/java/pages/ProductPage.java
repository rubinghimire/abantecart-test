package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.*;


public final class ProductPage {
	private static final By addToCartBtn = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[4]/div/a[1]");

	public ShoppingCartPage addToCart() {
	    getDriver().findElement(addToCartBtn).click();
	    return new ShoppingCartPage();
	}

}
