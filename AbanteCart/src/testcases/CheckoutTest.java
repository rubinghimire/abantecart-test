package testcases;

import pages.HomePage;
import pages.LoginPage;
import pages.SubcategoryPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import pages.CheckoutPage;

import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeTest;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CheckoutTest {
	private WebDriver driver;
	private Logger logger = Logger.getLogger(CheckoutTest.class.getName());
	private static final By orderSuccess = By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div/div/h3");
	private static final String VALUE = "hello4";
	 
	@Test
	public void checkoutOrder() {
		try {
		  HomePage home = new HomePage(driver);
		  LoginPage login = new LoginPage(driver);
		  home.clickNavLogin();
		  login.login(VALUE, VALUE);
		  SubcategoryPage subcategory = new SubcategoryPage(driver);
		  ProductPage product = new ProductPage(driver);
		  ShoppingCartPage cart = new ShoppingCartPage(driver);
		  CheckoutPage checkout = new CheckoutPage(driver);
		  subcategory.selectProduct();
		  product.addToCart();
		  cart.checkout();
		  checkout.selectDelivery();
		  checkout.confirmOrder();

		  Thread.sleep(5000);
		  String expected = "Order is completed!";
		  String result = driver.findElement(orderSuccess).getText();
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
