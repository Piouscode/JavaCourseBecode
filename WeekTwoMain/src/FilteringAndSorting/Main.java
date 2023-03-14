package FilteringAndSorting;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
public static void main(String[] args) {
	String csvFile = "src/effects-of-covid-19-on-trade.csv";

	try {
		List<CSVRecord> records = CSVReader.readCSV(csvFile);
		System.out.println("Prints out for the sorted list of the import values of the year 2018:");

		List<CSVRecord> filteredRecords = records.stream()
				.filter(record -> record.getYear() == 2018)
				.sorted(Comparator.comparingLong(CSVRecord::getValue))
				.toList();

		filteredRecords.forEach(record -> System.out.println(record.getValue()));

		System.out.println("Number of records in the list: " + filteredRecords.size());
	} catch (IOException e) {
		System.out.println("Error reading CSV file: " + e.getMessage());
	}
}
}
