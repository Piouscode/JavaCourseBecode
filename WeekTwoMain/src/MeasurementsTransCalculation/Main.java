package MeasurementsTransCalculation;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	// TODO: Read the length and width measurements from the console
	System.out.print("Enter the length measurement (e.g., '10 cm'): ");
	String lengthInput = scanner.nextLine();

	System.out.print("Enter the width measurement (e.g., '5 m'): ");
	String widthInput = scanner.nextLine();

	// TODO: Read the target unit from the console
	System.out.print("Enter the target unit for the surface area (m, cm, or mm): ");
	MeasurementUnit targetUnit;
	try {
		targetUnit = MeasurementUnit.fromString(scanner.nextLine());
	} catch (IllegalArgumentException e) {
		System.out.println("Error: " + e.getMessage());
		scanner.close();
		return;
	}

	// TODO: Calculate the surface area and print the result
	try {
		double lengthInMeters = LengthConverter.convert(lengthInput, MeasurementUnit.METERS);
		double widthInMeters = LengthConverter.convert(widthInput, MeasurementUnit.METERS);
		double surfaceAreaInMeters = lengthInMeters * widthInMeters;
		double surfaceAreaInTargetUnit = LengthConverter.convert(surfaceAreaInMeters + " m", targetUnit);

		System.out.println("The surface area is: " + surfaceAreaInTargetUnit + " " + targetUnit.getUnit() + "².");
	} catch (IllegalArgumentException e) {
		System.out.println("Error: " + e.getMessage());
	}

	scanner.close();
}
}
