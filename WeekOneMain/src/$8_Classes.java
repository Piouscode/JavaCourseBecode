package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $8_Classes {
public static void main(String[] args) {
	String inputCsvFilePath = "src/$8_Classes.csv";
	String currentLine;
	String commaDelimiter = ",";
	List<HospitalRecord> hospitalRecords = new ArrayList<>();
	try (BufferedReader reader = new BufferedReader(new FileReader(inputCsvFilePath))) {
		while ((currentLine = reader.readLine()) != null) {
			if (currentLine.startsWith("Date,Department,Visitors")) {
				continue;
			}
			String[] columns = currentLine.split(commaDelimiter);
			String firstColumn = columns[0];
			String secondColumn = columns[1];
			int thirdColumn;
			try {
				thirdColumn = Integer.parseInt(columns[2]);
			} catch (NumberFormatException exception) {
				System.err.println("Invalid value for visitors: " + columns[2]);
				continue;
			}
			HospitalRecord hospitalRecord = new HospitalRecord(firstColumn, secondColumn, thirdColumn);
			hospitalRecords.add(hospitalRecord);

		}
	} catch (IOException exceptionObject) {
		exceptionObject.printStackTrace();
	}

	Map<String, Map<String, Integer>> monthlyReportMap = new HashMap<>();
	for (HospitalRecord hospitalRecord : hospitalRecords) {
		String recordDate = hospitalRecord.getDate();
		String[] dateParts = recordDate.split("-");
		String month = dateParts[1];
		String department = hospitalRecord.getDepartment();
		int visitors = hospitalRecord.getVisitors();
		if (!monthlyReportMap.containsKey(month)) {
			monthlyReportMap.put(month, new HashMap<>());
		}
		Map<String, Integer> departmentReportMap = monthlyReportMap.get(month);
		if (!departmentReportMap.containsKey(department)) {
			departmentReportMap.put(department, visitors);
		} else {
			int totalVisitors = departmentReportMap.get(department) + visitors;
			departmentReportMap.put(department, totalVisitors);
		}
	}

	try (FileWriter fileWriter = new FileWriter("src/$8_Classes_monthly_report.csv")) {
		fileWriter.write("Month,Department,Visitors\n");
		for (String month : monthlyReportMap.keySet()) {
			Map<String, Integer> departmentReportMap = monthlyReportMap.get(month);
			for (String department : departmentReportMap.keySet()) {
				int visitor = departmentReportMap.get(department);
				fileWriter.write(month + "," + department + "," + visitor + "\n");
			}
		}
	} catch (IOException exception) {
		exception.printStackTrace();
	}
}
}

class HospitalRecord {
private String date;
private String department;
private int visitors;

public HospitalRecord(String date, String department, int visitors) {
	this.date = date;
	this.department = department;
	this.visitors = visitors;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public int getVisitors() {
	return visitors;
}

public void setVisitors(int visitors) {
	this.visitors = visitors;
}
}

