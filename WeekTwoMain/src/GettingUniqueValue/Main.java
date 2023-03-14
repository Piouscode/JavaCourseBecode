// Main.java
package GettingUniqueValue;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Main {
public static void main(String[] args) {
	String csvFilePath = "src/effects-of-covid-19-on-trade.csv";
	CSVUniqueValuesStreamReader reader = new CSVUniqueValuesStreamReader(csvFilePath);

	try {
		List<Set<String>> uniqueValuesList = reader.readUniqueValues();
		for (int i = 0; i < uniqueValuesList.size(); i++) {
			System.out.println("Unique values for column " + (i + 1) + ":");
			for (String value : uniqueValuesList.get(i)) {
				System.out.println(value);
			}
			System.out.println("--------------------");
		}
	} catch (IOException e) {
		System.out.println("Error reading the CSV file: " + e.getMessage());
	}
}
}