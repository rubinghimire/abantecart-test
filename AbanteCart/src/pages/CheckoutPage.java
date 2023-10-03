package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	private WebDriver driver;
	private static final By deliveryOption = By.xpath("/html/body/div/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/div/fieldset/form/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/label/div");
	private static final By orderBtn = By.id("checkout_btn");
			
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDelivery() {
	    driver.findElement(deliveryOption).click();
	}
	
	public void confirmOrder() {
		driver.findElement(orderBtn).click();
	}

}
