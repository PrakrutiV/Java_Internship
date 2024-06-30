package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField textField;
    private String currentInput = "";
    private String operator = "";
    private double num1 = 0.0;
    private JLabel operatorLabel; // Added label to display the operator

    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel topPanel = new JPanel(); // Create a top panel to hold the operator label
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        operatorLabel = new JLabel(); // Create the operator label
        operatorLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // Center-align the operatorLabel vertically within its cell
        constraints.fill = GridBagConstraints.WEST;
        constraints.gridx = (int) 0.05;
        constraints.gridy = (int) 0.5;
        topPanel.add(operatorLabel, constraints); // Add operator label to the top panel

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        topPanel.add(textField, constraints); // Add the text field to the top panel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
           // button.setBackground(Color.LIGHT_GRAY); // Set the background color
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH); // Add the top panel to the top of the main frame
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (Character.isDigit(command.charAt(0)) || command.equals(".")) {
            currentInput += command;
            textField.setText(currentInput);
        } else if (command.equals("=")) {
            calculateResult();
        } else {
            if (!currentInput.isEmpty()) {
                num1 = Double.parseDouble(currentInput);
                operator = command;
                currentInput = "";
                operatorLabel.setText(operator); // Display the operator
            }
        }
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double num2 = Double.parseDouble(currentInput);
            double result = 0.0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error: Division by zero");
                        return;
                    }
                    break;
            }

            textField.setText(Double.toString(result));
            currentInput = "";
            operator = "";
            operatorLabel.setText(""); // Clear the operator label
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}



