package FilteringAndSorting;

public class CSVRecord {
private int year;
private long value;

public CSVRecord(int year, long value) {
	this.year = year;
	this.value = value;
}

public int getYear() {
	return year;
}

public long getValue() {
	return value;
}
}

