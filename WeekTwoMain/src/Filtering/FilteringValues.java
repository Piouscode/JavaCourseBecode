package Filtering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FilteringValues {

public static void main(String[] args) throws IOException {

	// Open the CSV file
	BufferedReader reader = new BufferedReader(new FileReader("src/effects-of-covid-19-on-trade.csv"));

	// Skip the header line
	reader.readLine();

	// Parse each line into a Trade object and filter by year and country
	List<Trade> trades = reader.lines()
			.map(line -> line.split(","))
			.map(Trade::new)
			.filter(trade -> trade.year == 2016 && trade.country.equalsIgnoreCase("All"))
			.collect(Collectors.toList());

	// Print import and export values for each day
	trades.stream()
			.collect(Collectors.groupingBy(Trade::getDate))
			.forEach((date, groupedTrades) -> {
				long importValue = groupedTrades.stream()
						.filter(trade -> trade.direction.equalsIgnoreCase("Imports"))
						.mapToLong(Trade::getValue)
						.sum();
				long exportValue = groupedTrades.stream()
						.filter(trade -> trade.direction.equalsIgnoreCase("Exports"))
						.mapToLong(Trade::getValue)
						.sum();
				System.out.println("Date: " + date + ", Imports: " + importValue + ", Exports: " + exportValue);
			});

	// Close the file
	reader.close();
}
}

