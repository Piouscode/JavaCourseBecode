package MoreFileringAndTransForming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class TradeAnalyzer {

public static void main(String[] args) throws IOException {
	// Open the CSV file
	BufferedReader reader = new BufferedReader(new FileReader("src/effects-of-covid-19-on-trade.csv"));

	// Skip the header line
	reader.readLine();

	// Parse each line into a Trade object
	int[] lineNumber = {1};
	List<Trade> trades = reader.lines()
			.map(line -> line.split(","))
			.map(fields -> {
				String direction = fields[0];
				int year = Integer.parseInt(fields[1]);
				String date = fields[2];
				String weekday = fields[3];
				String country = fields[4];
				String commodity = fields[5];
				String transportMode = fields[6];
				String measure = fields[7];
				BigDecimal value = null;
				try {
					value = TradeReader.validateBigDecimal(fields[8], lineNumber[0]);
				} catch (IOException e) {
					// If there's an error parsing the decimal value, set it to zero instead of throwing an exception
					value = BigDecimal.ZERO;
				}
				BigDecimal cumulative = null;
				try {
					cumulative = TradeReader.validateBigDecimal(fields[9], lineNumber[0]);
				} catch (IOException e) {
					// If there's an error parsing the decimal value, set it to zero instead of throwing an exception
					cumulative = BigDecimal.ZERO;
				}

				try {
					return new Trade(direction, year, date, weekday, country, commodity, transportMode, measure, value, cumulative);
				} catch (IOException e) {
					throw new RuntimeException(e);
				} finally {
					lineNumber[0]++;
				}
			})
			.collect(Collectors.toList());

	// Close the file
	reader.close();

	// Analyze the trades and print the results
	analyzeTrades(trades);
}

public static void analyzeTrades(List<Trade> trades) {
	// Compute import and export values for each day
	BigDecimal[] importValues = new BigDecimal[366];
	BigDecimal[] exportValues = new BigDecimal[366];

	for (Trade trade : trades) {
		int dayOfYear = trade.getDayOfYear();
		BigDecimal rate = trade.getMeasure().equals("$") ? new BigDecimal("0.85") : BigDecimal.ONE;

		if (trade.getDirection().equals("Imports")) {
			importValues[dayOfYear - 1] = importValues[dayOfYear - 1] == null ? trade.getValue().multiply(rate) : importValues[dayOfYear - 1].add(trade.getValue().multiply(rate));
		} else if (trade.getDirection().equals("Exports")) {
			exportValues[dayOfYear - 1] = exportValues[dayOfYear - 1] == null ? trade.getValue().multiply(rate) : exportValues[dayOfYear - 1].add(trade.getValue().multiply(rate));
		}
	}

	// Print the results
	System.out.println("Daily Import and Export Values in EUR for the Year 2016:");

	for (int dayOfYear = 1; dayOfYear <= 366; dayOfYear++) {
		BigDecimal importValueInEuros = importValues[dayOfYear - 1] == null ? BigDecimal.ZERO : importValues[dayOfYear - 1];
		BigDecimal exportValueInEuros = exportValues[dayOfYear - 1] == null ? BigDecimal.ZERO : exportValues[dayOfYear - 1];

		System.out.printf("Day %d: %.2f EUR of imports, %.2f EUR of exports%n", dayOfYear, importValueInEuros.doubleValue(),
				exportValueInEuros.doubleValue());
	}
}


}
