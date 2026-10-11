# Temperature Monitoring and Conversion System

A simple Java project that accepts a temperature, converts it between **Celsius, Fahrenheit, and Kelvin**, and displays a temperature classification. The project includes a **terminal-based implementation** as the core version and an optional **Java Swing GUI**.

> **Case Study No.:** 167  
> **Course:** Java Programming  
> **Institution:** ITM Skills University

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies and Concepts](#technologies-and-concepts)
- [Project Structure](#project-structure)
- [Temperature Conversion Formulas](#temperature-conversion-formulas)
- [Temperature Classification](#temperature-classification)
- [Requirements](#requirements)
- [How to Run](#how-to-run)
- [Example](#example)
- [How the Program Works](#how-the-program-works)
- [Testing Suggestions](#testing-suggestions)
- [Limitations and Scope](#limitations-and-scope)
- [Author](#author)

## Overview

The Temperature Monitoring and Conversion System demonstrates fundamental Java programming concepts through a practical temperature-conversion task. The user selects an input unit, enters a temperature, and receives the equivalent values in the other two units along with a classification based on the Celsius equivalent.

The terminal application is the **core implementation**. The Swing interface is an optional enhancement that uses the same conversion logic.

## Features

- Accepts a temperature value from the user.
- Supports Celsius, Fahrenheit, and Kelvin as input units.
- Converts between all three temperature scales.
- Displays the converted values with decimal precision.
- Classifies the temperature using `if-else` logic.
- Uses a menu and `switch` statement for unit selection.
- Handles common invalid menu and numeric inputs.
- Provides both a terminal interface and an optional Swing GUI.

## Technologies and Concepts

- **Language:** Java
- **Core input:** `Scanner`
- **Selection:** `switch`, `if`, and `else-if`
- **Methods:** reusable conversion and classification methods
- **Operators:** arithmetic operators for calculations
- **Optional GUI:** Java Swing, layout managers, and event handling
- **Error handling:** `try-catch` for common invalid input

No database, external API, third-party library, or network connection is required.

## Project Structure

```text
Temperature Monitoring and Conversion System/
├── TemperatureConverter.java
├── TemperatureMonitoringSystem.java
├── TemperatureGUI.java
├── Case_Study_167_Temperature_Monitoring_System_Report.docx
└── README.md
```

| File | Purpose |
|---|---|
| `TemperatureConverter.java` | Contains reusable conversion formulas and temperature classification logic. |
| `TemperatureMonitoringSystem.java` | Main terminal application. This is the recommended starting point. |
| `TemperatureGUI.java` | Optional graphical interface built with Java Swing. |
| `Case_Study_167_Temperature_Monitoring_System_Report.docx` | Project documentation, syllabus mapping, and testing information. |

## Temperature Conversion Formulas

The application uses these standard formulas:

| Conversion | Formula |
|---|---|
| Celsius → Fahrenheit | `F = (C × 9 / 5) + 32` |
| Celsius → Kelvin | `K = C + 273.15` |
| Fahrenheit → Celsius | `C = (F − 32) × 5 / 9` |
| Fahrenheit → Kelvin | `K = (F − 32) × 5 / 9 + 273.15` |
| Kelvin → Celsius | `C = K − 273.15` |
| Kelvin → Fahrenheit | `F = (K − 273.15) × 9 / 5 + 32` |

The Java implementation uses floating-point arithmetic so that conversions retain decimal values.

## Temperature Classification

For classification, the entered temperature is first converted to Celsius. The program then applies these ranges:

| Celsius range | Classification |
|---|---|
| Below `0°C` | Freezing |
| `0°C` to `10°C` | Very Cold |
| Above `10°C` to `20°C` | Cold |
| Above `20°C` to `30°C` | Normal |
| Above `30°C` to `40°C` | Hot |
| Above `40°C` | Very Hot |

**Important:** These classification boundaries are a **project assumption** used because the problem statement does not specify exact classification ranges. They are not presented as ranges prescribed by the problem statement.

## Requirements

- Java Development Kit (JDK) installed. JDK 8 or later is suitable for the code used in this project.
- A terminal/command prompt, or an IDE such as IntelliJ IDEA.
- No additional dependencies are needed.

Check your Java installation with:

```bash
java -version
javac -version
```

## How to Run

### Option 1: Run the terminal application

1. Open a terminal in the folder containing the three `.java` files.
2. Compile the source files:

   ```bash
   javac TemperatureConverter.java TemperatureMonitoringSystem.java
   ```

3. Start the terminal application:

   ```bash
   java TemperatureMonitoringSystem
   ```

4. Choose an input unit from the menu, enter a temperature, and read the results. Choose the exit option when finished.

### Option 2: Run the Swing GUI

Compile all three source files:

```bash
javac TemperatureConverter.java TemperatureGUI.java
```

Then launch the GUI:

```bash
java TemperatureGUI
```

A graphical window should open. Enter a temperature, choose the input unit, and use the button in the window to display the converted values and classification.

### Run in IntelliJ IDEA

1. Open the project folder in IntelliJ IDEA.
2. Ensure a JDK is configured for the project.
3. To use the terminal version, open `TemperatureMonitoringSystem.java` and run its `main` method.
4. To use the GUI, open `TemperatureGUI.java` and run its `main` method.

Run **`TemperatureMonitoringSystem`** when you want the non-GUI version.

## Example

For an input of **25°C**, the output should be approximately:

```text
Fahrenheit: 77.00°F
Kelvin: 298.15 K
Classification: Normal
```

Displayed labels and formatting may vary slightly depending on the interface.

## How the Program Works

1. The user selects Celsius, Fahrenheit, or Kelvin.
2. The program reads the temperature value.
3. A `switch` statement identifies the selected unit.
4. The relevant methods in `TemperatureConverter` calculate the other two values.
5. The Celsius equivalent is passed to the classification method.
6. The results and classification are displayed.

```text
User Input
    ↓
Select Unit
    ↓
Read Temperature
    ↓
Convert Using Methods
    ↓
Classify Celsius Equivalent
    ↓
Display Results
```

## Testing Suggestions

Try the following inputs to check normal, boundary, and error-handling behaviour:

| Input unit | Value | Expected check |
|---|---:|---|
| Celsius | `25` | `77°F`, `298.15 K`, Normal |
| Celsius | `-10` | `14°F`, `263.15 K`, Freezing |
| Fahrenheit | `32` | `0°C`, `273.15 K` |
| Fahrenheit | `212` | `100°C`, `373.15 K` |
| Kelvin | `300` | Approximately `26.85°C`, `80.33°F`, Normal |
| Any | Non-numeric text | The program should handle invalid numeric input rather than perform a conversion. |
| Menu | An unavailable option | The program should report an invalid choice. |

Also check classification boundaries at `0°C`, `10°C`, `20°C`, `30°C`, and `40°C`.

## Limitations and Scope

- This is an educational conversion project, not a live environmental monitoring system connected to sensors.
- Classification labels and ranges are illustrative project assumptions.
- The project does not use weather services, external APIs, databases, networking, or third-party frameworks.
- The Swing GUI is an optional interface; the terminal program remains the core implementation.

## Author

**Om Maurya**  
**Roll No.:** 150096725208  
**Cohort:** Jeff Bezos  
**Semester:** III  
**Academic Year:** 2025–29  
**Department:** B.Tech Computer Science and Engineering  
**College/University:** ITM Skills University

---

This project was prepared for academic learning and demonstration of Java Programming concepts.
