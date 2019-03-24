package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.Log;

public class LoginTest extends BaseTest {

	@Test(dataProvider = "LogPass")
	public void LogIn() {
		HomePage homePage = new HomePage(driver);
		// Methods
		Log.info("Open site and login");
		// ExtentTestManager.getTest().setDescription("Wrong username wrong password");
		homePage.gotoHomePage()
				.gotoSignInPage()
				.Login("Adasd", "12312d");
		String errorMsg = driver.findElement(By.id("errf")).getText();
		Log.info("Asserting error msg");
		assertEquals(errorMsg, "Oops, that's not a match.");
	}

}
