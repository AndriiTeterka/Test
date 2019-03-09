package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	// WebElements
	By myEbayButton = By.xpath(("//*[@_sp='m570.l2919']"));
	String baseURL = "https://www.ebay.com/";

	public HomePage(WebDriver driver) {
		super(driver);
		// if (!"Login".equals(driver.getTitle())) {
		// throw new IllegalStateException("This is not the login page");
		// }
	}

	// Methods
	public HomePage gotoHomePage() {
		driver.get(baseURL);
		return this;
	}

	public SignInPage gotoSignInPage() {
		click(myEbayButton);
		return new SignInPage(driver);
	}
}
