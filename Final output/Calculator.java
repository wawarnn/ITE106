import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private StringBuilder input;

    public Calculator() {
        frame = new JFrame("Calculator");
        textField = new JTextField();
        input = new StringBuilder();
        setupUI();
    }

    private void setupUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.PLAIN, 30));
        frame.add(textField, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

        for (String label : buttons) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.equals("=")) {
                try {
                    double result = evaluateExpression(input.toString());
                    textField.setText(String.valueOf(result));
                    input.setLength(0);
                    input.append(result);
                } catch (Exception ex) {
                    textField.setText("Error");
                    input.setLength(0);
                }
            } else {
                input.append(command);
                textField.setText(input.toString());
            }
        }

        private double evaluateExpression(String expr) {
            
            return new ScriptEngineManager().getEngineByName("JavaScript").eval(expr);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}
