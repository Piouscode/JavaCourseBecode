package MoreFileringAndTransForming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TradeReader {
private static final String CSV_DELIMITER = ",";

public List<Trade> readTrades(String filePath) throws IOException {
	List<Trade> trades = new ArrayList<>();

	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		// Skip the header line
		reader.readLine();

		String line;
		int[] lineNumber = {1};
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split(CSV_DELIMITER);
			if (fields.length != 10) {
				throw new IOException("Invalid number of fields in line " + lineNumber[0]);
			}

			String direction = fields[0];
			int year = validateYear(fields[1], lineNumber[0]);
			String date = fields[2];
			String weekday = fields[3];
			String country = fields[4];
			String commodity = fields[5];
			String transportMode = fields[6];
			String measure = fields[7];

			line = reader.lines().skip(lineNumber[0] - 1).findFirst().orElse(null);
			System.out.printf("Line %d: %s%n", lineNumber[0], line);

			BigDecimal value = validateBigDecimal(fields[8], lineNumber[0]);
			BigDecimal cumulative = validateBigDecimal(fields[9], lineNumber[0]);

			trades.add(new Trade(direction, year, date, weekday, country, commodity, transportMode, measure, value, cumulative));
			lineNumber[0]++;
		}

	}

	return trades;
}



private int validateYear(String yearString, int lineNumber) throws IOException {
	try {
		return Integer.parseInt(yearString);
	} catch (NumberFormatException e) {
		throw new IOException("Invalid year in line " + lineNumber);
	}
}

static BigDecimal validateBigDecimal(String decimalString, int lineNumber) throws IOException {
	try {
		return new BigDecimal(decimalString);
	} catch (NumberFormatException e) {
		throw new IOException(String.format("Invalid decimal value in line %d: %s", lineNumber, e.getMessage()));
	}
}

}
