package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class $9_CsvFactory {
private static final String[] FIRSTNAMES = {"Jules", "Emma", "Lucas", "Louise", "Felix", "Marie", "Arthur", "Lina", "Isabella", "Victor", "Lena", "Liam", "Oscar", "Nathan", "Elise", "Peter", "Leon", "Anaïs", "Samuel", "Thomas", "Ursula", "Gustave", "William", "Xavier", "Yvonne", "Zachary", "Annabelle", "Benjamin", "Caroline", "Daniel"};
private static final String[] LASTNAMES = {"De Smet", "Peeters", "Dubois", "Van Damme", "Mertens", "Claes", "Vandenberghe", "Dupont", "Dierckx", "Lemaire", "Willems", "Dubois", "Van den Bossche", "Lambert", "De Vos", "Van den Bossche", "Van den Berghe", "Willems", "Verstraete", "Jansens", "Jacobs", "Vandenbroeck", "Demeester", "Vandevelde", "Declerck", "Vermeersch", "Flores", "De Noël", "De Becker", "Evans"};
private static final String[] REASONS = {"Appointment", "Visit"};
private static final String[] DEPARTMENTS = {"Cardiology", "Radiology", "Pediatrics", "Geriatrics", "Pulmonology"};
private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
private static final int RECORDS_LIMITS = 10;

public static void main(String[] args) {

	try {
		FileWriter fileWritten = new FileWriter("src/$9_CsvFactory_PatientsDatabase.csv");
		fileWritten.append("First-Name,Last-Name,Reason,Department,Date-Of-Visit,Year\n");
		Random dateOfVisits = new Random();

		for (int i = 0; i < RECORDS_LIMITS; i++) {
			String firstname = FIRSTNAMES[dateOfVisits.nextInt(FIRSTNAMES.length)];
			String lastname = LASTNAMES[dateOfVisits.nextInt(LASTNAMES.length)];
			String reason = REASONS[dateOfVisits.nextInt(REASONS.length)];
			String department;
			if (reason.equals("Appointment")) {
				department = DEPARTMENTS[dateOfVisits.nextInt(DEPARTMENTS.length)];
			} else {
				department = "N/A";
			}

			String monthName = MONTHS[dateOfVisits.nextInt(MONTHS.length)];
			int dayOfMonth = dateOfVisits.nextInt(28) + 1;
			String fullDate = monthName + " " + dayOfMonth + ", " + 2023;
			fileWritten.append(firstname).append(",").append(lastname).append(",").append(reason).append(",").append(department).append(",").append(fullDate).append("\n");
		}

		fileWritten.flush();
		fileWritten.close();

	} catch (IOException exception) {
		exception.printStackTrace();
	}
}
}
