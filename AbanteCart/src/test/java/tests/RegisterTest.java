package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverManager;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{
	private static final String VALUE = "hello3";
	private static final String EMAIL = "hello3@hello.com";
	private static final String NUMBER = "12345";
	String[] personalDetails = {VALUE, VALUE, EMAIL, NUMBER};
	String[] address = {VALUE, VALUE, "Texas", NUMBER, "United States"};
	String[] loginDetails = {VALUE, VALUE, VALUE}; 
	Boolean news = true;
 
	private RegisterTest() {
		
	}
	
	@Test
	public void registerUser() {
			new HomePage().clickNavLogin();
			new RegisterPage().goToRegister()
			.register(personalDetails, address, loginDetails, news);
			String expected = "YOUR ACCOUNT HAS BEEN CREATED!";
			String result = DriverManager.getDriver().findElement(By.className("maintext")).getText();
			Assert.assertEquals(expected, result, "This has not passed");
	}
}
