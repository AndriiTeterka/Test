package org.maven.test;

import static org.testng.Assert.assertEquals;

import org.maven.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	String ErrorMsg = "Please enter username and password.";

	// @DataProvider(name = "LogPass")
//	public Object[][] testData() {
//		return new Object[][] { new Object[] { "Asdfgsas", "4234234232345" },
	// new Object[] { "TestMMAussEUR", "TestMMAussEUR1!" }, };
//	}

	@Test
	public void emptyValuesLogIn() {
		HomePage homePage = new HomePage(driver);
		// Methods
		homePage.gotoHomePage()
				.loginTry("asdasd", "password");
		String alertMsg = driver.switchTo().alert().getText();
		assertEquals(ErrorMsg, alertMsg);
		homePage.gotoHomePage()
				.loginTry("TestMMAussEUR", "TestMMAussEUR1");
		String expLoginSuccess = "Welcome TestMMAussEUR";
		String actLoginSuccess = driver.findElement(By.id(("welcome"))).getText();
		assertEquals(expLoginSuccess, actLoginSuccess);
	}
}
