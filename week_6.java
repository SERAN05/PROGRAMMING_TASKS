import java.util.Scanner;

public class week_6 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number (numerator): ");
            int numerator = scanner.nextInt();

            System.out.print("Enter a number (denominator): ");
            int denominator = scanner.nextInt();

            int result = numerator / denominator;
            System.out.println("Result: " + result);

            System.out.print("Enter an array index: ");
            int index = scanner.nextInt();

            int[] numbers = {10, 20, 30, 40, 50};
            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds.");

        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());

        } finally {
            System.out.println("Execution of the try-catch block is complete.");
        }
    }
}
