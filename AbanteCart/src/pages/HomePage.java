package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maximize() {
		driver.manage().window().maximize();
	}
	
	private By navLogin = By.xpath("/html/body/div/header/div[1]/div/div[2]/div/div[2]/div/ul/li/a");
	
	// Click login from header of homepage
	public void clickNavLogin() {
		driver.findElement(navLogin).click();
	}
	
	
	
	
	
	
	
	
}
