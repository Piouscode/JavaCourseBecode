package MoreFileringAndTransForming;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trade {
private final String direction;
private final int year;
private final LocalDate date;
private final String weekday;
private final String country;
private final String commodity;
private final String transportMode;
private final String measure;
private final BigDecimal value;
private final BigDecimal cumulative;

public Trade(String direction, int year, String date, String weekday, String country, String commodity, String transportMode, String measure, BigDecimal value, BigDecimal cumulative) throws IOException {
	this.direction = direction;
	this.year = year;
	this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	this.weekday = weekday;
	this.country = country;
	this.commodity = commodity;
	this.transportMode = transportMode;
	this.measure = measure;
	if (value == null) {
		throw new IOException("Invalid value in Trade object");
	}
	this.value = value;
	if (cumulative == null) {
		throw new IOException("Invalid cumulative value in Trade object");
	}
	this.cumulative = cumulative;
}

public String getDirection() {
	return direction;
}

public String getMeasure() {
	return measure;
}

public int getYear() {
	return year;
}

public LocalDate getDate() {
	return date;
}

public String getWeekday() {
	return weekday;
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

public BigDecimal getValue() {
	return value;
}

public int getDayOfYear() {
	return date.getDayOfYear();
}

public BigDecimal getCumulative() {
	return cumulative;
}

}