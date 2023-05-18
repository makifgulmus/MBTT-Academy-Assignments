import java.util.InputMismatchException;
import java.util.Scanner;

public class AgeValidationPrompter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            validateAge(age);

        } catch (InvalidAgeException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid age input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age <= 18 || age >= 60) {
            throw new InvalidAgeException("Age should be greater than 18 and less than 60.");
        }
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
