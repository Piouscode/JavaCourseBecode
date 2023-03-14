// CSVUniqueValuesStreamReader.java
package GettingUniqueValue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVUniqueValuesStreamReader {

private final String filePath;

public CSVUniqueValuesStreamReader(String filePath) {
	this.filePath = filePath;
}

public List<Set<String>> readUniqueValues() throws IOException {
	try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
		List<Set<String>> uniqueValuesList = new ArrayList<>();

		// Skip the header line, and process the streamline by line
		List<String[]> allValues = lines
				.skip(1)
				.map(line -> line.split(","))
				.toList();

		int columns = allValues.get(0).length;

		for (int i = 0; i < columns; i++) {
			int index = i;
			Set<String> uniqueValues = allValues.stream()
					.map(values -> values[index])
					.collect(Collectors.toCollection(HashSet::new));
			uniqueValuesList.add(uniqueValues);
		}

		return uniqueValuesList;
	}
}
}

