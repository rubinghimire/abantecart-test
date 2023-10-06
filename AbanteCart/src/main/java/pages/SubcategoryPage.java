package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;

public final class SubcategoryPage {
	private Actions actions;
	private static final By category = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/a");
	private static final By subcategory = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/div/ul[1]/li[1]/a");
	private static final By product = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/a/img");
	

	public SubcategoryPage() {
		this.actions = new Actions(DriverManager.getDriver());
	}
	
	private void moveToCategory() {
	    actions.moveToElement(DriverManager.getDriver().findElement(category)).build().perform();
	}

	private void clickSubcategory() {
		DriverManager.getDriver().findElement(subcategory).click();
	}

	private void clickProduct() {
		DriverManager.getDriver().findElement(product).click();
	}
	
	public ProductPage selectProduct() {
	    moveToCategory();
	    clickSubcategory();
	    clickProduct();
	    return new ProductPage();
	}
	
	
}

