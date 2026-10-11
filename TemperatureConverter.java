/**
 * TemperatureConverter.java
 * 
 * Contains the shared temperature conversion methods and classification logic.
 * Used by both the terminal-based program and the GUI program.
 * 
 * Conversion Formulas:
 *   Celsius to Fahrenheit:  F = (C × 9/5) + 32
 *   Celsius to Kelvin:      K = C + 273.15
 *   Fahrenheit to Celsius:  C = (F - 32) × 5/9
 *   Fahrenheit to Kelvin:   K = (F - 32) × 5/9 + 273.15
 *   Kelvin to Celsius:      C = K - 273.15
 *   Kelvin to Fahrenheit:   F = (K - 273.15) × 9/5 + 32
 * 
 * Classification Ranges (Project Assumption — PS does not specify exact ranges):
 *   Below 0°C    → Freezing
 *   0°C to 10°C  → Very Cold
 *   11°C to 20°C → Cold
 *   21°C to 30°C → Normal
 *   31°C to 40°C → Hot
 *   Above 40°C   → Very Hot
 */

public class TemperatureConverter {

    // --- Conversion Methods ---

    // Celsius to Fahrenheit: F = (C × 9/5) + 32
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        int celsiusInt = (int) fahrenheit;
        return fahrenheit;
    }

    // Celsius to Kelvin: K = C + 273.15
    public static double celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    // Fahrenheit to Celsius: C = (F - 32) × 5/9
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return celsius;
    }

    // Fahrenheit to Kelvin: K = (F - 32) × 5/9 + 273.15
    public static double fahrenheitToKelvin(double fahrenheit) {
        double kelvin = (fahrenheit - 32) * 5.0 / 9.0 + 273.15;
        return kelvin;
    }

    // Kelvin to Celsius: C = K - 273.15
    public static double kelvinToCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        return celsius;
    }

    // Kelvin to Fahrenheit: F = (K - 273.15) × 9/5 + 32
    public static double kelvinToFahrenheit(double kelvin) {
        double fahrenheit = (kelvin - 273.15) * 9.0 / 5.0 + 32;
        return fahrenheit;
    }

    // --- Temperature Classification Method ---
    // Note: Classification is based on Celsius values.
    // These ranges are a Project Assumption (PS does not specify exact boundaries).
    public static String classifyTemperature(double celsius) {
        if (celsius < 0) {
            return "Freezing";
        } else if (celsius >= 0 && celsius <= 10) {
            return "Very Cold";
        } else if (celsius > 10 && celsius <= 20) {
            return "Cold";
        } else if (celsius > 20 && celsius <= 30) {
            return "Normal";
        } else if (celsius > 30 && celsius <= 40) {
            return "Hot";
        } else {
            return "Very Hot";
        }
    }
}
