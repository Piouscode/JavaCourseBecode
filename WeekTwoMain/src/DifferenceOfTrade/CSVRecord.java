package DifferenceOfTrade;

public class CSVRecord {
private int year;
private String month;
private String country;
private long value;

public CSVRecord(int year, String month, String country, long value) {
	this.year = year;
	this.month = month;
	this.country = country;
	this.value = value;
}

public int getYear() {
	return year;
}

public String getMonth() {
	return month;
}

public String getCountry() {
	return country;
}

public long getValue() {
	return value;
}
}

