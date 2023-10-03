package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage {
	private WebDriver driver;
	private static final By addToCartBtn = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div/div[2]/form/fieldset/div[4]/div/a[1]");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart() {
	    driver.findElement(addToCartBtn).click();
	}

}
