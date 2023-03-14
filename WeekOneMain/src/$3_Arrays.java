package src;

import java.util.Random;

public class $3_Arrays {
public static void main(String[] args) {

	Random randomlyGeneratedNumber = new Random();

	Integer[] randomNumbers = new Integer[10];

	for (int i = 0; i < randomNumbers.length; i++) {
		randomNumbers[i] = randomlyGeneratedNumber.nextInt(10);
	}

	for (Integer integer : randomNumbers) {
		System.out.print(integer + " ");
	}
}
}
