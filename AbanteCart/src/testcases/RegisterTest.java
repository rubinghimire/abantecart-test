package testcases;

import org.testng.annotations.Test;

import pages.RegisterPage;
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

public class RegisterTest {
	private WebDriver driver;
	private Logger logger = Logger.getLogger(RegisterTest.class.getName());
	private static final String VALUE = "hello4";
	private static final String EMAIL = "hello4@hello.com";
	private static final String NUMBER = "12345";
	String[] personalDetails = {VALUE, VALUE, EMAIL, NUMBER};
	String[] address = {VALUE, VALUE, "Texas", NUMBER, "United States"};
	String[] loginDetails = {VALUE, VALUE, VALUE}; 
	Boolean news = true;
  
	@Test
	public void registerUser() {
		try {
			HomePage home = new HomePage(driver);
			RegisterPage register = new RegisterPage(driver);
			  
			home.clickNavLogin();
			register.goToRegister();
			register.register(personalDetails, address, loginDetails, news);

			Thread.sleep(5000);
			String expected = "YOUR ACCOUNT HAS BEEN CREATED!";
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
