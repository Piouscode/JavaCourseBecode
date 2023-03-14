package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class $7_Classes {
public static void main(String[] args) {
	String csvFilePath = "src/$7_Classes.csv";
	String currentLine;
	String delimitComma = ",";

	PersonsRestrictedModel classPerson = null;
	PersonsRestrictedModel classPerson2 = null;
	try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
		boolean isFirstLine = true;
		while ((currentLine = reader.readLine()) != null) {
			if (isFirstLine) {
				isFirstLine = false;
				continue;
			}
			String[] data = currentLine.split(delimitComma);

			String name = data[0];
			int age = Integer.parseInt(data[1]);

			String email = data[2];

			classPerson = new PersonsRestrictedModel(name, age, email);

			if (classPerson.getName().equals("Bob Johnson")) {
				System.out.println(classPerson.getEmail());
			}

			classPerson2 = new PersonsRestrictedModel(name, age, email);
			int age2 = classPerson2.getAge();
			if (age2 > 30 && age2 < 40) {
				System.out.println(classPerson2.getAge());
			}


		}

		classPerson2.setAge(50);
		classPerson2.setName("Mary Smith");
		classPerson2.setEmail("jane.doe@example.com");

		System.out.println(classPerson2.getAge());
		System.out.println(classPerson2.getName());
		System.out.println(classPerson2.getEmail());
		System.out.println(classPerson.getEmail());

	} catch (IOException errorMessage) {
		errorMessage.printStackTrace();
	}
}
}

class PersonsRestrictedModel { // class
private String name;
private int age;
private String email;

public PersonsRestrictedModel(String name, int age, String email) { // class constructor
	this.name = name;
	this.age = age;
	this.email = email;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
}
