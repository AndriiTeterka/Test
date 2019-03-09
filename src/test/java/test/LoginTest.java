package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;

public class LoginTest extends BaseTest {

	// @DataProvider(name = "LogPass")
//	public Object[][] testData() {
//		return new Object[][] { new Object[] { "Asdfgsas", "4234234232345" },
	// new Object[] { "TestMMAussEUR", "TestMMAussEUR1!" }, };
//	}

	@Test
	public void LogIn() {
		HomePage homePage = new HomePage(driver);
		// Methods
		homePage.gotoHomePage()
				.gotoSignInPage()
				.Login("Adasd", "12312d");
		String errorMsg = driver.findElement(By.id("errf")).getText();
		assertEquals(errorMsg, "Oops, that's not a match.");
	}
}
