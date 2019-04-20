package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class SignInPage extends BasePage {
	// WebElements
	By loginField = By.id(("userid"));
	By passwordField = By.id(("pass"));
	By signInButton = By.id(("sgnBt"));

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	@Step("Login step with username: {0}, password: {1}")
	public SignInPage Login(String username, String password) {
		click(loginField);
		writeText(loginField, username);
		click(passwordField);
		writeText(passwordField, password);
		click(signInButton);
		return this;
	}
}
