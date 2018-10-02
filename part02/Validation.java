package part02;
import java.util.Scanner;
public class Validation {
	static Scanner sc = new Scanner(System.in);
	
	public static int validateInts() {
		if (sc.hasNextInt()) {
			int userInput = sc.nextInt();
			sc.nextLine();
			return userInput;
		} else {
			System.out.println("That is not a valid entry - make sure you have entered a number");
			sc.next();
			return validateInts();
		}
	}
	public static String validateStrings() {
		if (sc.hasNextLine()) {
			String userInput = sc.nextLine();
			if (userInput.matches("^[a-zA-Z0-9_ ]*$")) {
				return userInput;
			} else {
				System.out.println("That is not a valid entry - make sure it only contains letters");
				return validateStrings();
			}
		} else {
			System.out.println("That is not a valid entry - make sure you have entered a string");
			return validateStrings();
		}
	}
	public static double validateDoubles() {
		if (sc.hasNextDouble()) {
			double userInput = sc.nextDouble();
			return userInput;
		} else {
			System.out.println("That is not a valid entry - make sure you have entered a number");
			return validateDoubles();
		}
	}
	public static boolean validateBooleans() {
		if (sc.hasNextBoolean()) {
			boolean userInput = sc.nextBoolean();
			return userInput;
		} else {
			System.out.println("That is not a valid entry - make sure you have entered a true or false value");
			return validateBooleans();
		}
	}
	public static String validatePostcodes() {
		if (sc.hasNextLine()) {
			String userInput = sc.nextLine();
			if (userInput.matches("^[a-zA-Z0-9_ ]{7}$")) {
				return userInput;
			} else {
				System.out.println("That is not a valid entry - make sure it is only 7 characters long");
				return validatePostcodes();
			}
		} else {
			System.out.println("That is not a valid entry - make sure you have entered a valid postcode");
			return validatePostcodes();
		}
	}
}
