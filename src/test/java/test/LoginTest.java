package test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pages.HomePage;
import utilities.Log;
import utilities.DataProviderClass;

public class LoginTest extends BaseTest {
	@BeforeClass
	public void setup() {
		Log.startLog("Test is starting");
		initilize();
	}

	@Test(dataProvider = "Test", dataProviderClass = DataProviderClass.class)
	public void LogIn(String username, String password) {
		Log.info("Opening home page");
		HomePage homePage = new HomePage(driver);
		// Methods
		homePage.gotoHomePage()
				.gotoSignInPage()
				.Login(username, password);
		String errorMsg = driver.findElement(By.id("errf")).getText();
		Log.info("Asserting error msg");
		assertEquals(errorMsg, "Oops, that's not a match.");
	}

	@AfterClass
	public void tearDown() {
		Log.endLog("Test is ending");
		quit();
	}
}
