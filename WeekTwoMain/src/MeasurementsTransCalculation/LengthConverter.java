package MeasurementsTransCalculation;

public class LengthConverter {
// TODO: Implement the convert method
public static double convert(String measurement, MeasurementUnit targetUnit) {
	// TODO: Validate the input and throw an IllegalArgumentException if the input is invalid
	String[] parts = measurement.trim().split("\\s+");
	if (parts.length != 2) {
		throw new IllegalArgumentException("Invalid measurement format.");
	}

	// TODO: Convert the measurement to meters and then to the target unit
	// TODO: Validate the input and throw an IllegalArgumentException if the input is invalid
	double value;
	try {
		value = Double.parseDouble(parts[0]);
	} catch (NumberFormatException e) {
		throw new IllegalArgumentException("Invalid numeric value in the measurement.");
	}

	// TODO: Check if the value is negative and throw an IllegalArgumentException if it is
	if (value < 0) {
		throw new IllegalArgumentException("Measurement value cannot be negative.");
	}

	// TODO: Validate the input and throw an IllegalArgumentException if the input is invalid
	MeasurementUnit sourceUnit;
	try {
		sourceUnit = MeasurementUnit.fromString(parts[1]);
	} catch (IllegalArgumentException e) {
		throw new IllegalArgumentException("Invalid measurement unit.");
	}

	// TODO: Convert the measurement to meters and then to the target unit
	double valueInMeters = value * sourceUnit.getMultiplier();
	double valueInTargetUnit = valueInMeters / targetUnit.getMultiplier();

	// TODO: Check if the value is infinite or NaN and throw an IllegalStateException if it is
	if (Double.isInfinite(valueInTargetUnit) || Double.isNaN(valueInTargetUnit)) {
		throw new IllegalStateException("Overflow occurred during unit conversion.");
	}

	return valueInTargetUnit;
}
}
