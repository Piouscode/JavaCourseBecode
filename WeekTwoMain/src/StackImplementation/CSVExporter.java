package StackImplementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

public static <T> void exportToCSV(GenericStack<T> stack, String fileName) throws IOException {
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
		// Write header
		writer.write("Index,Value\n");

		// Create a temporary stack to store items while exporting
		GenericStack<T> tempStack = new GenericStack<>();

		// Export data
		int index = 0;
		while (!stack.isEmpty()) {
			T item = stack.pop();
			writer.write(index + "," + item + "\n");
			tempStack.push(item);
			index++;
		}

		// Restore the original stack
		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}
}
}

