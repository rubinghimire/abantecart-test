package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private static final By usernameInput = By.id("loginFrm_loginname");
	private static final By passwordInput = By.id("loginFrm_password");
	private static final By loginButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/button");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterUserName(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginButton).click();
	}
	
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginBtn();
	}
	
	
}

