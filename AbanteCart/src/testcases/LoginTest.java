package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginTest {
	
	private WebDriver driver;
	private Logger logger = Logger.getLogger(LoginTest.class.getName());
	private static final String VALUE = "hello4";
	  
	@Test
	public void loginUser() {
		try {
		  HomePage home = new HomePage(driver);
		  LoginPage login = new LoginPage(driver);
		  
		  home.clickNavLogin();
		  login.login(VALUE, VALUE);
	
		  Thread.sleep(5000);
		  String expected = "MY ACCOUNT";
		  String result = driver.findElement(By.className("maintext")).getText();
		  Assert.assertEquals(expected, result, "This has not passed");
	  			}
	  			catch(InterruptedException E) {
	  			  logger.log(Level.WARNING, E.toString());
	  			  Thread.currentThread().interrupt();
	  			}
	  		}
		  
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.abantecart.com");
	}

	@BeforeMethod
	public void setUp() {
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterTest
	public void afterTest() {
	  driver.close();
	}

}
