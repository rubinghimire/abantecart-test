package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	private WebDriver driver;
	private static final By goToRegisterBtn = By.xpath("/html/body/div/div[2]/div/div/div/div/div[1]/div/form/fieldset/button");
	// Personal details inputs
	private static final By firstNameInput = By.id("AccountFrm_firstname");
	private static final By lastNameInput = By.id("AccountFrm_lastname");
	private static final By emailInput = By.id("AccountFrm_email");
	private static final By phoneInput = By.id("AccountFrm_telephone");
	// Address inputs
	private static final By address1Input = By.id("AccountFrm_address_1");
	private static final By cityInput = By.id("AccountFrm_city");
	private static final By regionInput = By.id("AccountFrm_zone_id");
	private static final By zipCodeInput = By.id("AccountFrm_postcode");
	private static final By countryInput = By.id("AccountFrm_country_id");
	// Login details inputs
	private static final By loginNameInput = By.id("AccountFrm_loginname");
	private static final By passwordInput = By.id("AccountFrm_password");
	private static final By passordConfirmInput = By.id("AccountFrm_confirm");
	// Newsletter and privacy policy inputs
	private static final By newsletterYes = By.id("AccountFrm_newsletter1");
	private static final By newsletterNo = By.id("AccountFrm_newsletter0");
	private static final By privacyCheck = By.id("AccountFrm_agree");
	private static final By clickRegisterBtn = By.xpath("/html/body/div/div[2]/div/div/div/div[1]/form/div[5]/div/div/button");

	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToRegister() {
		driver.findElement(goToRegisterBtn).click();
	}
	
	public void enterPersonalDetails(String firstName, String lastName, String email, String phone) {
		driver.findElement(firstNameInput).sendKeys(firstName);
		driver.findElement(lastNameInput).sendKeys(lastName);
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(phoneInput).sendKeys(phone);
	}
	
	public void enterAddress(String address1, String city, String region, String zipCode, String country) {
		driver.findElement(address1Input).sendKeys(address1);
		driver.findElement(cityInput).sendKeys(city);
		new Select(driver.findElement(regionInput)).selectByVisibleText(region);
		driver.findElement(zipCodeInput).sendKeys(zipCode);
		new Select(driver.findElement(countryInput)).selectByVisibleText(country);
	}
	
	public void enterLoginDetails(String loginName, String password) {
		driver.findElement(loginNameInput).sendKeys(loginName);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(passordConfirmInput).sendKeys(password);
	}

	public void enterNewsletter(Boolean selection) {
		if(Boolean.TRUE.equals(selection)) {
			driver.findElement(newsletterYes).click();
		} else {
			driver.findElement(newsletterNo).click();
		}
	}
	
	public void enterPrivacyPolicy() {
		driver.findElement(privacyCheck).click();
	}
	
	public void clickRegisterBtn() {
		driver.findElement(clickRegisterBtn).click();
	}
	
	public void register(String[] personalDetails, String[] address, String[] loginDetails, Boolean news) {
		enterPersonalDetails(personalDetails[0], personalDetails[1], personalDetails[2], personalDetails[3]);
		enterAddress(address[0], address[1], address[2], address[3], address[4]);
		enterLoginDetails(loginDetails[0], loginDetails[1]);
		enterNewsletter(news);
		enterPrivacyPolicy();
		clickRegisterBtn();
	}
}
