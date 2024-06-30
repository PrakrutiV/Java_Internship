package calculator;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        System.out.println("Welcome to the Temperature Converter!");
        
        while (continueConversion) {
            System.out.println("------------------------------------");
            System.out.println("Options:");
            System.out.println("1. Convert from Celsius to Fahrenheit");
            System.out.println("2. Convert from Fahrenheit to Celsius");
            System.out.print("Please choose an option (1 or 2): ");

            int choice = scanner.nextInt();

            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please choose either 1 or 2.");
                continue;
            }

            System.out.print("Enter the temperature value: ");
            double temperature = scanner.nextDouble();

            if (choice == 1) {
                double fahrenheit = (temperature * 9 / 5) + 32;
                System.out.println(temperature + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
            } else {
                double celsius = (temperature - 32) * 5 / 9;
                System.out.println(temperature + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius.");
            }

            System.out.print("Do you want to convert another temperature? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                continueConversion = false;
            }
        }

        System.out.println("Thank you for using the Temperature Converter!");
        scanner.close();
    }
}

