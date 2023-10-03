package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SubcategoryPage {
	private WebDriver driver;
	private Actions actions;
	private static final By category = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/a");
	private static final By subcategory = By.xpath("/html/body/div/div[1]/div[1]/section/nav/ul/li[4]/div/ul[1]/li[1]/a");
	private static final By product = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div[1]/div[2]/a/img");
	

	public SubcategoryPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}
	
	private void moveToCategory() {
	    actions.moveToElement(driver.findElement(category)).build().perform();
	}

	private void clickSubcategory() {
	    driver.findElement(subcategory).click();
	}

	private void clickProduct() {
	    driver.findElement(product).click();
	}
	
	public void selectProduct() {
	    moveToCategory();
	    clickSubcategory();
	    clickProduct();
	}
	
	
}

