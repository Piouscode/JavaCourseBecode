package StackImplementation;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
public static void main(String[] args) {
	GenericStack<Person> stack = new GenericStack<>();

	Person person1 = new Person("Pious", LocalDate.of(1990, 1, 1), "blue", Arrays.asList("reading", "running"), "Dog", "male");
	Person person2 = new Person("Bob", LocalDate.of(1985, 6, 15), "green", Arrays.asList("painting", "swimming"), "dog", "male");
	Person person3 = new Person("Carol", LocalDate.of(2000, 12, 25), "red", Arrays.asList("guitar", "dancing"), "cat", "female");


	stack.push(person1);
	stack.push(person2);
	stack.push(person3);


	System.out.println("Popped item: " + stack.pop().generateOutput());
	System.out.println("Top item: " + stack.peek().generateOutput());
	System.out.println("Stack is empty: " + stack.isEmpty());

	try {
		CSVExporter.exportToCSV(stack, "src/StackImplementation/classOfFriends_data.csv");
	} catch (IOException e) {
		System.out.println("Error exporting data to CSV: " + e.getMessage());
	}
}
}
