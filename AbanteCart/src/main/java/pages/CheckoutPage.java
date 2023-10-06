package pages;

import org.openqa.selenium.By;
import static driver.DriverManager.*;

public final class CheckoutPage {
	private static final By deliveryOption = By.xpath("/html/body/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/fieldset/form/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/label/div");
	private static final By orderBtn = By.id("checkout_btn");

	public CheckoutPage selectDelivery() {
	    getDriver().findElement(deliveryOption).click();
	    return this;
	}
	
	public void confirmOrder() {
		getDriver().findElement(orderBtn).click();
	}

}
