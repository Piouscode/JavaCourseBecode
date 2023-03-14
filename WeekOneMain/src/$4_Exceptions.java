package src;

import java.util.Random;

public class $4_Exceptions {

public static void main(String[] args) {
	int arrayMaxSize = 10;
	Integer[] randomArrayNumbers = new Integer[arrayMaxSize];

	Random randomNumberGenerator = new Random();
	for (int i = 0; i < randomArrayNumbers.length; i++) {
		randomArrayNumbers[i] = randomNumberGenerator.nextInt(10);
	}

	for (int i = 0; i < randomArrayNumbers.length; i++) {
		try {
			if (i == 0) {
				System.out.println(randomArrayNumbers[i]);
			} else {
				Integer current_To_Previous_Result = randomArrayNumbers[i] / randomArrayNumbers[i - 1];
				System.out.println(current_To_Previous_Result);
			}
		} catch (ArithmeticException e) { // Catch division by zero
			System.out.println("Error: Can't divide by zero");
		}
	}
}
}
