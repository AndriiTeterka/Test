package org.maven.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	// WebElements
	By usernameLocator = By.cssSelector(("input[value='Username']"));
	By passwordLocator = By.xpath(("//*[@value='Password']"));
	By loginbuttonLocator = By.xpath(("//*[@class='login_btn']"));
	String baseURL = "https://jetbull.stage.everymatrix.com/";

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

	public HomePage typeUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
		return this;
	}

	public HomePage typePassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
		return this;
	}

	public void submitLogin() {
		driver.findElement(loginbuttonLocator).click();
	}

	// func test
	public HomePage loginTry(String username, String password) {
		click(usernameLocator);
		typeUsername(username);
		click(passwordLocator);
		typePassword(password);
		return this;
	}

}
