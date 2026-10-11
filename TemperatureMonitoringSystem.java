import java.util.Scanner;

/**
 * TemperatureMonitoringSystem.java
 * 
 * Terminal-based Temperature Monitoring and Conversion System.
 * This is the CORE implementation of the project.
 * 
 * PS Requirements Demonstrated:
 *   - Scanner       → Accept temperature input from the user
 *   - switch        → Select the temperature unit for conversion
 *   - Methods       → Conversion formulas in TemperatureConverter class
 *   - Operators     → Mathematical calculations in conversion formulas
 *   - if-else       → Classify temperature based on predefined ranges
 * 
 * Expected Modules (from PS):
 *   1. Temperature Input
 *   2. Unit Selection
 *   3. Conversion
 *   4. Condition Classification
 *   5. Result Display
 */
public class TemperatureMonitoringSystem {

    public static void main(String[] args) {

        // Create Scanner object for user input (PS: "use Scanner to accept temperature values")
        Scanner scanner = new Scanner(System.in);

        // Program header
        System.out.println("=========================================================");
        System.out.println("    Temperature Monitoring and Conversion System");
        System.out.println("=========================================================");

        // Loop allows the user to perform multiple conversions (Optional enhancement)
        boolean continueProgram = true;

        while (continueProgram) {

            // --- Module 2: Unit Selection ---
            System.out.println("\nSelect the temperature unit:");
            System.out.println("1. Celsius");
            System.out.println("2. Fahrenheit");
            System.out.println("3. Kelvin");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice (1-4): ");
y
            // Read user's unit choice
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\nError: Invalid input. Please enter a number (1-4).");
                scanner.nextLine(); // Clear invalid input from buffer
                continue;
            }

            // Exit option
            if (choice == 4) {
                System.out.println("\nThank you for using the Temperature Monitoring System!");
                System.out.println("Goodbye!");
                break;
            }

            // Validate choice range
            if (choice < 1 || choice > 4) {
                System.out.println("\nError: Invalid choice. Please select 1, 2, 3, or 4.");
                continue;
            }

            // --- Module 1: Temperature Input ---
            System.out.print("Enter the temperature value: ");

            double temperature;
            try {
                temperature = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("\nError: Invalid input. Please enter a valid numeric value.");
                scanner.nextLine(); // Clear invalid input from buffer
                continue;
            }

            // Variables to store conversion results
            double celsius;
            double fahrenheit;
            double kelvin;

            // --- Module 2 (continued): Unit Selection using switch ---
            // --- Module 3: Conversion using methods ---
            // --- Module 4: Condition Classification using if-else ---
            // --- Module 5: Result Display ---

            // PS: "switch statement to select the required conversion"
            switch (choice) {

                case 1: // Input is in Celsius
                    celsius = temperature;
                    fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
                    kelvin = TemperatureConverter.celsiusToKelvin(celsius);

                    System.out.println("\n----- Conversion Results -----");
                    System.out.printf("%.2f °C = %.2f °F%n", celsius, fahrenheit);
                    System.out.printf("%.2f °C = %.2f K%n", celsius, kelvin);
                    System.out.println("\nTemperature Condition: " + TemperatureConverter.classifyTemperature(celsius));
                    System.out.println("------------------------------");
                    break;

                case 2: // Input is in Fahrenheit
                    fahrenheit = temperature;
                    celsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
                    kelvin = TemperatureConverter.fahrenheitToKelvin(fahrenheit);

                    System.out.println("\n----- Conversion Results -----");
                    System.out.printf("%.2f °F = %.2f °C%n", fahrenheit, celsius);
                    System.out.printf("%.2f °F = %.2f K%n", fahrenheit, kelvin);
                    System.out.println("\nTemperature Condition: " + TemperatureConverter.classifyTemperature(celsius));
                    System.out.println("------------------------------");
                    break;

                case 3: // Input is in Kelvin
                    kelvin = temperature;
                    celsius = TemperatureConverter.kelvinToCelsius(kelvin);
                    fahrenheit = TemperatureConverter.kelvinToFahrenheit(kelvin);

                    System.out.println("\n----- Conversion Results -----");
                    System.out.printf("%.2f K = %.2f °C%n", kelvin, celsius);
                    System.out.printf("%.2f K = %.2f °F%n", kelvin, fahrenheit);
                    System.out.println("\nTemperature Condition: " + TemperatureConverter.classifyTemperature(celsius));
                    System.out.println("------------------------------");
                    break;

                default:
                    System.out.println("\nError: Invalid choice.");
                    break;
            }
        }

        // Close Scanner
        scanner.close();
    }
}
