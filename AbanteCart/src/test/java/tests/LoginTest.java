package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	private static final String VALUE = "hello3";
	  
	@Test
	public void loginUser() {
		  new HomePage().clickNavLogin();
		  new LoginPage().login(VALUE, VALUE);
		  String expected = "MY ACCOUNT";
		  String result = DriverManager.getDriver().findElement(By.className("maintext")).getText();
		  Assert.assertEquals(expected, result, "This has not passed");
	}
}