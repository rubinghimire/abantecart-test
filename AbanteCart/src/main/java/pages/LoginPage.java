package pages;

import org.openqa.selenium.By;

import static driver.DriverManager.*;

public final class LoginPage {

	private static final By usernameInput = By.id("loginFrm_loginname");
	private static final By passwordInput = By.id("loginFrm_password");
	private static final By loginButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/button");
	
	public void enterUserName(String username) {
		getDriver().findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		getDriver().findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		getDriver().findElement(loginButton).click();
	}
	
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginBtn();
	}
	
	
}

