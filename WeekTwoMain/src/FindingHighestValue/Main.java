package FindingHighestValue;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
public static void main(String[] args) {
	String csvFile = "src/effects-of-covid-19-on-trade.csv"; // Replace with your CSV file path

	try {
		List<CSVRecord> records = CSVReader.readCSV(csvFile);

		// Using the stream API
		Optional<Long> highestExportValue = records.stream()
				.filter(record -> record.getYear() == 2019)
				.filter(record -> "China".equals(record.getCountry()))
				.filter(record -> "All".equals(record.getCommodity()))
				.filter(record -> "All".equals(record.getTransportMode()))
				.map(CSVRecord::getValue)
				.max(Long::compare);

		highestExportValue.ifPresent(value -> System.out.println("Highest export value (using stream API): " + value));

		// Using sorting and finding the highest value
		long highestExportValue2 = records.stream()
				.filter(record -> record.getYear() == 2019)
				.filter(record -> "China".equals(record.getCountry()))
				.filter(record -> "All".equals(record.getCommodity()))
				.filter(record -> "All".equals(record.getTransportMode()))
				.sorted(Comparator.comparingLong(CSVRecord::getValue).reversed())
				.findFirst()
				.map(CSVRecord::getValue)
				.orElse(0L);

		System.out.println("Highest export value (using sorting): " + highestExportValue2);

		// Extra: Sum of the values
		long sumOfValues = records.stream()
				.filter(record -> record.getYear() == 2019)
				.filter(record -> "China".equals(record.getCountry()))
				.filter(record -> "All".equals(record.getCommodity()))
				.filter(record -> "All".equals(record.getTransportMode()))
				.mapToLong(CSVRecord::getValue)
				.sum();

		System.out.println("Sum of export values: " + sumOfValues);

	} catch (IOException e) {
		System.out.println("Error reading CSV file: " + e.getMessage());
	}
}
}

