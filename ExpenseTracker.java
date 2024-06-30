package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Expense {
    private String description;
    private double amount;
    private String category;
    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public double getAmount() {
        return amount;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}
class ExpenseTracker {
    private List<Expense> expenses = new ArrayList<>();
    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    public double getTotalExpense() {
        double totalExpense = 0.0;
        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();
        while (true) {
            System.out.println("Expense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    expenseTracker.addExpense(description, amount, category);
                    System.out.println("Expense added successfully.");
                    break;
                case 2:
                    List<Expense> expenses = expenseTracker.getExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded.");
                    } else {
                        System.out.println("Expenses:");
                        for (Expense expense : expenses) {
                            System.out.println(expense);
                        }
                    }
                    break;
                case 3:
                    double totalExpense = expenseTracker.getTotalExpense();
                    System.out.println("Total Expenses: $" + totalExpense);
                    break;
                case 4:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
