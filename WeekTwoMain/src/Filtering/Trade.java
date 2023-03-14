package Filtering;

public class Trade {
String direction;
int year;
String date;
String weekday;
String country;
String commodity;
String transportMode;
String measure;
long value;
long cumulative;

public Trade(String[] values) {
	direction = values[0];
	year = Integer.parseInt(values[1]);
	date = values[2];
	weekday = values[3];
	country = values[4];
	commodity = values[5];
	transportMode = values[6];
	measure = values[7];
	try {
		value = Long.parseLong(values[8]);
		cumulative = Long.parseLong(values[9]);
	} catch (NumberFormatException e) {
		value = 0;
		cumulative = 0;
	}
}

public String getDate() {
	return date;
}

public long getValue() {
	return value;
}
}

