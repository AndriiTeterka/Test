package test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name = "LogPass")
	public static Object[][] testData() {
		return new Object[][] { { "Adasd", "12312d" }, { "", "" }, };
	}
}
