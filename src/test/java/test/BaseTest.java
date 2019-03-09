package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

	protected WebDriver driver;

	/**
	 * Create instance of WebDriver, open browser and go to opencart
	 */
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			throw new RuntimeException("ERROR: Chromedriver not Found");
		}
	}

	/**
	 * Destroying instance of WebDriver It closes all Browser Windows and safely
	 * ends the session
	 */
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
	}
}
