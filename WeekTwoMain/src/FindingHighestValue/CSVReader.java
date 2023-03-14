package FindingHighestValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
public static List<CSVRecord> readCSV(String filePath) throws IOException {
	List<CSVRecord> records = new ArrayList<>();

	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		String line;
		boolean isFirstLine = true;

		while ((line = br.readLine()) != null) {
			if (isFirstLine) {
				isFirstLine = false;
				continue;
			}

			String[] fields = line.split(",");

			if (isNumeric(fields[1]) && isNumeric(fields[8].replace("$", "").replace(",", ""))) {
				int year = Integer.parseInt(fields[1]);
				String country = fields[4];
				String commodity = fields[5];
				String transportMode = fields[6];
				long value = Long.parseLong(fields[8].replace("$", "").replace(",", ""));

				CSVRecord record = new CSVRecord(year, country, commodity, transportMode, value);
				records.add(record);
			}
		}
	}

	return records;
}

private static boolean isNumeric(String str) {
	try {
		Long.parseLong(str);
		return true;
	} catch (NumberFormatException e) {
		return false;
	}
}
}


