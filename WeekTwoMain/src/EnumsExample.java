package src;

import java.util.Scanner;

public class EnumsExample {

public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.println("Welcome to the surface area calculator");
	System.out.println();

	System.out.println("The units of measurement supported are: m, cm, mm.");
	System.out.println();

	System.out.println("They should be entered as a number followed by a space and the unit of measurement.");
	System.out.println("For example, 1 m, 100 cm, or 1000 mm.");
	System.out.println();

	System.out.print("Please Enter the length: ");
	String lengthString = scanner.nextLine().trim();

	System.out.print("Please Enter the width: ");
	String widthString = scanner.nextLine().trim();

	double lengthInMeters = convertToMeters(lengthString);
	double widthInMeters = convertToMeters(widthString);

	double surfaceArea = lengthInMeters * widthInMeters;

	System.out.printf("\nThe surface area is %.2f square meters", surfaceArea);
	System.out.println("\nThank you for using the surface area calculator");
	System.out.println("\nGoodbye");

}

// convertToMeters method converts a measurement to meters
public static double convertToMeters(String measurementString) {
	String[] parts = measurementString.split("\\s+");

	if (parts.length != 2) {
		throw new IllegalArgumentException("Invalid measurement: " + measurementString);
	}

	double value = Double.parseDouble(parts[0]);
	Unit unit = Unit.valueOf(parts[1].toUpperCase());

	return switch (unit) {
		case M -> value;
		case CM -> value / 100;
		case MM -> value / 1000;
	};
}

// enum Unit defines the units of measurement
// that are supported by the program.
// It also defines the conversion factor
// to meters for each unit in the enum constant.
public enum Unit {
	M("m", 1),
	CM("cm", 0.01),
	MM("mm", 0.001);

	private final String symbol;
	private final double metersPerUnit;

	Unit(String symbol, double metersPerUnit) {
		this.symbol = symbol;
		this.metersPerUnit = metersPerUnit;
	}

}
}
