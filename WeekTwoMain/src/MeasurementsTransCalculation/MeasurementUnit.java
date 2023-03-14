package MeasurementsTransCalculation;

// TODO: Implement the MeasurementUnit enum
public enum MeasurementUnit {
	METERS("m"),
	CENTIMETERS("cm"),
	MILLIMETERS("mm");

// TODO: private if it is only used inside the enum
private final String unit;

// TODO: Use the constructor to initialize the unit field
MeasurementUnit(String unit) {
	this.unit = unit;
}

// TODO: Use the getter to access the unit field
public String getUnit() {
	return unit;
}

// TODO: Use the fromString method to convert a string to a MeasurementUnit
// TODO: Use the getUnit method to get the unit string
// TODO: Use the equalsIgnoreCase method to compare the unit string with the text
// TODO: Use the IllegalArgumentException to throw an exception if the text is invalid
public static MeasurementUnit fromString(String text) {
	for (MeasurementUnit unit : MeasurementUnit.values()) {
		if (unit.getUnit().equalsIgnoreCase(text)) {
			return unit;
		}
	}
	throw new IllegalArgumentException("Invalid unit: " + text);
}

// TODO: Use the getMultiplier method to get the multiplier
// TODO: Use the switch expression to return the multiplier
// TODO: Use the -> operator to specify the case, return value, default case and break
public double getMultiplier() {
	return switch (this) {
		case METERS -> 1;
		case CENTIMETERS -> 0.01;
		case MILLIMETERS -> 0.001;
	};
}
}