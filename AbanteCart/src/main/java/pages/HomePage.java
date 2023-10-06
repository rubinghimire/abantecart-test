package pages;
import org.openqa.selenium.By;

import static driver.DriverManager.*;

public final class HomePage {

	private By navLogin = By.xpath("/html/body/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li/a");
	
	// Click login from header of homepage
	public void clickNavLogin() {
		getDriver().findElement(navLogin).click();
	}
	
	
	
	
	
	
	
	
}
