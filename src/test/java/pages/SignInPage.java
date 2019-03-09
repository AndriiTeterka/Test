package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
	// WebElements
	By loginField = By.id(("userid"));
	By passwordField = By.id(("pass"));
	By signInButton = By.id(("sgnBt"));

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public SignInPage Login(String username, String password) {
		click(loginField);
		writeText(loginField, username);
		click(passwordField);
		writeText(passwordField, password);
		click(loginField);
		return this;
	}
}
