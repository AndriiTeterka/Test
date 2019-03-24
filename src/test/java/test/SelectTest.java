package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectTest {
	public WebDriver driver;

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

	@Test
	public void DropDown() {
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		WebElement multiSelect = driver.findElement(By.xpath("//*[@id='gh-cat']"));
		List<WebElement> selectList = multiSelect.findElements(By.tagName("option"));
		WebElement searchButton = driver.findElement(By.id("gh-btn"));

		selectList.get(3).click();
		searchButton.click();
	}

}
