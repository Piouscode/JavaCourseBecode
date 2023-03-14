package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueValuesStreams {

public static void main(String[] args) throws IOException {
	// Read file into stream and skip the header line
	Stream<String> lines = Files.lines(Paths.get("src/effects-of-covid-19-on-trade.csv")).skip(1);

	// Split each line into an array of values
	Stream<String[]> values = lines.map(line -> line.split(","));

	// Collect values into a list
	List<String[]> valuesList = values.toList();

	// Create a stream for each set of unique values
	Set<String> directions = valuesList.stream().map(array -> array[0]).collect(Collectors.toSet());
	Set<Integer> years = valuesList.stream().map(array -> {
		try {
			return Integer.parseInt(array[1]);
		} catch (NumberFormatException e) {
			// Skip non-numeric values
			return null;
		}
	}).filter(Objects::nonNull).collect(Collectors.toSet());
	Set<String> dates = valuesList.stream().map(array -> array[2]).collect(Collectors.toSet());
	Set<String> weekdays = valuesList.stream().map(array -> array[3]).collect(Collectors.toSet());
	Set<String> countries = valuesList.stream().map(array -> array[4]).collect(Collectors.toSet());
	Set<String> commodities = valuesList.stream().map(array -> array[5]).collect(Collectors.toSet());
	Set<String> transportModes = valuesList.stream().map(array -> array[6]).collect(Collectors.toSet());
	Set<String> measures = valuesList.stream().map(array -> array[7]).collect(Collectors.toSet());
	Set<Long> valuesSet = valuesList.stream().map(array -> {
		try {
			return Long.parseLong(array[8]);
		} catch (NumberFormatException e) {
			// Skip non-numeric values
			return null;
		}
	}).filter(Objects::nonNull).collect(Collectors.toSet());
	Set<Long> cumulatives = valuesList.stream().map(array -> {
		try {
			return Long.parseLong(array[9]);
		} catch (NumberFormatException e) {
			// Skip non-numeric values
			return null;
		}
	}).filter(Objects::nonNull).collect(Collectors.toSet());

	// Print out the unique values for each column
	System.out.println("Directions: " + directions);
	System.out.println("Years: " + years);
	System.out.println("Dates: " + dates);
	System.out.println("Weekdays: " + weekdays);
	System.out.println("Countries: " + countries);
	System.out.println("Commodities: " + commodities);
	System.out.println("Transport Modes: " + transportModes);
	System.out.println("Measures: " + measures);
	System.out.println("Values: " + valuesSet);
	System.out.println("Cumulatives: " + cumulatives);

	// Close the stream
	lines.close();
}

}
