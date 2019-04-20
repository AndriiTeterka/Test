package utilities;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataProviderClass {
	@DataProvider(name = "Test")
	public static Object[][] invalidTestCreds() {
		return new Object[][] { { "Los", "Sants" } };
	}

	@DataProvider(name = "Login")
	public static Object[][] invalidCreds() {
		return readListData("/Test/resources/LoginCreds.csv");
	}

	@DataProvider(name = "reportListDataForFiltering")
	public static Object[][] chooseFilterOptionForColumn() {
		return readData("/Test/resources/LoginCreds.csv");
	}

	private static Object[][] readData(String path) {
		String[][] data = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			List<String[]> list = bufferedReader.lines().map(line -> line.split(";")).collect(Collectors.toList());
			data = list.toArray(new String[list.size()][]);

		} catch (FileNotFoundException e) {
			// log.info("Oops, fle is not found");
		}
		return data;
	}

	private static Object[][] readListData(String path) {
		Object[][] data = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			data = new Object[][] { bufferedReader.lines().map(line -> Arrays.asList(line.split(";"))).toArray() };
		} catch (FileNotFoundException e) {
			// log.info("Oops, fle is not found");
		}
		return data;
	}

	private static Object[][] readDataAsMap(String path) {
		Object[][] data = null;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
			data = new Object[][] { bufferedReader.lines().map(line -> {
				Map<String, String> indicators = new HashMap<>();
				for (String pair : line.split(";")) {
					String[] keyAndValue = pair.split(":");
					indicators.put(keyAndValue[0], keyAndValue[1]);
				}
				return indicators;
			}).toArray() };
		} catch (FileNotFoundException e) {
			// log.info("Oops, fle is not found");
		}
		return data;
	}
}