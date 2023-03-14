package FindingHighestValue;

public class CSVRecord {
private int year;
private String country;
private String commodity;
private String transportMode;
private long value;

public CSVRecord(int year, String country, String commodity, String transportMode, long value) {
	this.year = year;
	this.country = country;
	this.commodity = commodity;
	this.transportMode = transportMode;
	this.value = value;
}

public int getYear() {
	return year;
}

public String getCountry() {
	return country;
}

public String getCommodity() {
	return commodity;
}

public String getTransportMode() {
	return transportMode;
}

public long getValue() {
	return value;
}
}

