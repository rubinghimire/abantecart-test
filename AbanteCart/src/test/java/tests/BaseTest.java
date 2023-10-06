package tests;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.Driver;
import driver.DriverManager;

public class BaseTest {

	protected BaseTest() {
		
	}
	
	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
