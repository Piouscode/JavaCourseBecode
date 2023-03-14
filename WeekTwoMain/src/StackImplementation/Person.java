package StackImplementation;

import java.time.LocalDate;
import java.util.List;

public record Person(String name, LocalDate birthday, String favoriteColor,
                     List<String> hobbies, String catOrDog, String gender) {

// @Override annotation is optional here because the compiler will generate
// it for us automatically since we are overriding a method from the Object class.
@Override
public String toString() {
	return "Person{" +
			"name='" + name + '\'' +
			", birthday=" + birthday +
			", favoriteColor='" + favoriteColor + '\'' +
			", hobbies=" + hobbies +
			", catOrDog='" + catOrDog + '\'' +
			", gender='" + gender + '\'' +
			'}';
}

public String getName() {
	return name;
}

public String generateOutput() {
	String pronoun = gender.equalsIgnoreCase("male") ? "he" : "she";
	String preference = catOrDog.equalsIgnoreCase("cat") ? "cats" : "dogs";
	return name + ", " + pronoun + " likes " + preference;
}
}



/* It is use in java to indicate that a method in a subclass is intended to
* override a method in its superclass. It serves two main purposes
*
* Readability: It makes the code more readable by signaling the intention
* of the method. When other developers read the code, they can easily
* understand that the annotated method is meant to override a method
* from its superclass.

 Compile-time checking: It helps the compiler to verify that the method
 * is actually overriding a method from its superclass. If the method
 * signature in the subclass does not match any method in its superclass,
 * the compiler will generate an error. This prevents potential bugs caused
 * by accidental typos or signature mismatch. */
