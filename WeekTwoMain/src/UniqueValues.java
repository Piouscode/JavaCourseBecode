package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
public class UniqueValues {

	public static void main(String[] args) throws IOException {
		// Open the CSV file
		BufferedReader reader = new BufferedReader(new FileReader("src/effects-of-covid-19-on-trade.csv"));

		// Ignore the first line
		reader.readLine();
		String line;

		// Set up sets for each column
		Set<String> directions = new HashSet<>();
		Set<Integer> years = new HashSet<>();
		Set<String> dates = new HashSet<>();
		Set<String> weekdays = new HashSet<>();
		Set<String> countries = new HashSet<>();
		Set<String> commodities = new HashSet<>();
		Set<String> transportModes = new HashSet<>();
		Set<String> measures = new HashSet<>();
//		Set<Integer> values = new HashSet<>();
//		Set<Integer> cumulatives = new HashSet<>();

		Set<Long> values = new HashSet<>();
		Set<Long> cumulatives = new HashSet<>();

		// Read each line of the file
		while ((line = reader.readLine()) != null) {
			String[] valuesArr = line.split(","); // the caluesArr is an array of strings that are separated by commas in the csv file

			// Add each value to its corresponding set
			directions.add(valuesArr[0]);
			try {
				years.add(Integer.parseInt(valuesArr[1]));
			} catch (NumberFormatException e) {
				// Skip non-numeric values
			}
			dates.add(valuesArr[2]);
			weekdays.add(valuesArr[3]);
			countries.add(valuesArr[4]);
			commodities.add(valuesArr[5]);
			transportModes.add(valuesArr[6]);
			measures.add(valuesArr[7]);
/*		values.add(Integer.parseInt(valuesArr[8]));
		cumulatives.add(Integer.parseInt(valuesArr[9])); */
			try {
				values.add(Long.parseLong(valuesArr[8]));
			} catch (NumberFormatException e) {
				// Skip non-numeric values
			}
			try {
				cumulatives.add(Long.parseLong(valuesArr[9]));
			} catch (NumberFormatException e) {
				// Skip non-numeric values
			}
		}

// Print out the unique values for each column
        System.out.println("Directions: " + directions);
        System.out.println("Years: " + years);
        System.out.println("Dates: " + dates);
        System.out.println("Weekdays: " + weekdays);
        System.out.println("Countries: " + countries);
        System.out.println("Commodities: " + commodities);
        System.out.println("Transport Modes: " + transportModes);
        System.out.println("Measures: " + measures);
        System.out.println("Values: " + values);
        System.out.println("Cumulatives: " + cumulatives);

// Close the file
        reader.close();
}

}
