package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	public DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Browser.browser) {
			case CHROME:
				driver = new ChromeDriver();
				break;
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			}
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.manage().window().setSize(new Dimension(800, 1000));
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
