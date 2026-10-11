import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TemperatureGUI.java
 * 
 * Swing GUI enhancement for the Temperature Monitoring and Conversion System.
 * This is an OPTIONAL enhancement — NOT required by the PS.
 * Added to demonstrate syllabus Module VIII (Swing GUI, Layout Managers, Event Handling).
 * 
 * Syllabus Mapping:
 *   - Module VIII: Introduction to Swing GUI
 *   - Module VIII: Layout Managers
 *   - Module VIII: Event Handling
 * 
 * Uses the same TemperatureConverter class for conversion and classification.
 * Classification ranges are a PROJECT ASSUMPTION (PS does not specify exact ranges).
 */
public class TemperatureGUI extends JFrame implements ActionListener {

    // --- GUI Components ---
    private JTextField inputField;
    private JComboBox<String> unitComboBox;
    private JButton convertButton;
    private JTextArea resultArea;

    // Constructor — sets up the GUI layout
    public TemperatureGUI() {
        // Window settings
        setTitle("Temperature Monitoring and Conversion System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // --- Main Panel with BorderLayout ---
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Title Label (top) ---
        JLabel titleLabel = new JLabel("Temperature Monitoring and Conversion System", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // --- Input Panel (center-top) ---
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));

        // Temperature value input
        inputPanel.add(new JLabel("Temperature Value:"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);

        // Unit selection dropdown
        inputPanel.add(new JLabel("Select Unit:"));
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        unitComboBox = new JComboBox<>(units);
        inputPanel.add(unitComboBox);

        // Convert button
        inputPanel.add(new JLabel("")); // Empty cell for alignment
        convertButton = new JButton("Convert");
        convertButton.addActionListener(this); // Event handling
        inputPanel.add(convertButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // --- Result Area (bottom) ---
        resultArea = new JTextArea(8, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultArea.setBorder(BorderFactory.createTitledBorder("Results"));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    // --- Event Handler ---
    // Called when the "Convert" button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {

        // Clear previous results
        resultArea.setText("");

        // Read the temperature value from the input field
        String inputText = inputField.getText().trim();

        // Simple validation — check if input is empty
        if (inputText.isEmpty()) {
            resultArea.setText("Please enter a temperature value.");
            return;
        }

        // Parse the temperature value
        double temperature;
        try {
            temperature = Double.parseDouble(inputText);
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a numeric value.");
            return;
        }

        // Get selected unit
        String selectedUnit = (String) unitComboBox.getSelectedItem();

        // Variables for results
        double celsius, fahrenheit, kelvin;
        StringBuilder result = new StringBuilder();

        // Perform conversion based on selected unit
        switch (selectedUnit) {

            case "Celsius":
                celsius = temperature;
                fahrenheit = TemperatureConverter.celsiusToFahrenheit(celsius);
                kelvin = TemperatureConverter.celsiusToKelvin(celsius);

                result.append(String.format("%.2f °C = %.2f °F%n", celsius, fahrenheit));
                result.append(String.format("%.2f °C = %.2f K%n", celsius, kelvin));
                result.append(String.format("%nTemperature Condition: %s",
                        TemperatureConverter.classifyTemperature(celsius)));
                break;

            case "Fahrenheit":
                fahrenheit = temperature;
                celsius = TemperatureConverter.fahrenheitToCelsius(fahrenheit);
                kelvin = TemperatureConverter.fahrenheitToKelvin(fahrenheit);

                result.append(String.format("%.2f °F = %.2f °C%n", fahrenheit, celsius));
                result.append(String.format("%.2f °F = %.2f K%n", fahrenheit, kelvin));
                result.append(String.format("%nTemperature Condition: %s",
                        TemperatureConverter.classifyTemperature(celsius)));
                break;

            case "Kelvin":
                kelvin = temperature;
                celsius = TemperatureConverter.kelvinToCelsius(kelvin);
                fahrenheit = TemperatureConverter.kelvinToFahrenheit(kelvin);

                result.append(String.format("%.2f K = %.2f °C%n", kelvin, celsius));
                result.append(String.format("%.2f K = %.2f °F%n", kelvin, fahrenheit));
                result.append(String.format("%nTemperature Condition: %s",
                        TemperatureConverter.classifyTemperature(celsius)));
                break;

            default:
                result.append("Error: Unknown unit selected.");
                break;
        }

        // Display results
        resultArea.setText(result.toString());
    }

    // --- Main Method ---
    public static void main(String[] args) {
        TemperatureGUI gui = new TemperatureGUI();
        gui.setVisible(true);
    }
}
