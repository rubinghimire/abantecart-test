package driver;

import java.util.Objects;
import org.openqa.selenium.chrome.ChromeDriver;
import constants.TestConstants;
import utils.PropertyFileReader;

public final class Driver {
	
	private Driver() {
		
	}

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {
			System.setProperty("webdriver.chrome.driver", TestConstants.getChromedriverpath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(PropertyFileReader.get("url"));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
