package DifferenceOfTrade;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
public static void main(String[] args) {
	String csvFile = "src/effects-of-covid-19-on-trade.csv"; // Replace with your CSV file path

	try {
		List<CSVRecord> records = CSVReader.readCSV(csvFile);

		Map<String, Long> exports2019 = records.stream()
				.filter(record -> record.getYear() == 2019)
				.filter(record -> "European Union".equals(record.getCountry()))
				.collect(Collectors.groupingBy(
						CSVRecord::getMonth,
						HashMap::new,
						Collectors.summingLong(CSVRecord::getValue)));

		Map<String, Long> exports2020 = records.stream()
				.filter(record -> record.getYear() == 2020)
				.filter(record -> "European Union".equals(record.getCountry()))
				.collect(Collectors.groupingBy(
						CSVRecord::getMonth,
						HashMap::new,
						Collectors.summingLong(CSVRecord::getValue)));

		System.out.println("Comparison of export values for European Union (2019 vs 2020):");
		for (int i = 1; i <= 12; i++) {
			String month = String.format("%02d", i);
			long value2019 = exports2019.getOrDefault(month, 0L);
			long value2020 = exports2020.getOrDefault(month, 0L);

			System.out.printf("Month %s: %,d (2019) vs %,d (2020)\n", month, value2019, value2020);
		}

	} catch (IOException e) {
		System.out.println("Error reading CSV file: " + e.getMessage());
	}
}
}

