import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class PhonebookSystem {
    private JFrame frame;
    private JTextField nameField, phoneField;
    private JTextArea contactArea;
    private HashMap<String, String> phonebook;

    public PhonebookSystem() {
        frame = new JFrame("Phonebook");
        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        contactArea = new JTextArea(10, 30);
        phonebook = new HashMap<>();
        setupUI();
        loadContacts();
    }

    private void setupUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Phone:"));
        frame.add(phoneField);

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(e -> addContact());
        JButton deleteButton = new JButton("Delete Contact");
        deleteButton.addActionListener(e -> deleteContact());
        JButton searchButton = new JButton("Search Contact");
        searchButton.addActionListener(e -> searchContact());
        JButton updateButton = new JButton("Update Contact");
        updateButton.addActionListener(e -> updateContact());

        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.add(updateButton);

        contactArea.setEditable(false);
        frame.add(new JScrollPane(contactArea));

        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        phonebook.put(name, phone);
        saveContacts();
        displayContacts();
    }

    private void deleteContact() {
        String name = nameField.getText();
        phonebook.remove(name);
        saveContacts();
        displayContacts();
    }

    private void searchContact() {
        String name = nameField.getText();
        String phone = phonebook.get(name);
        if (phone != null) {
            contactArea.setText("Contact Found: " + name + " - " + phone);
        } else {
            contactArea.setText("Contact not found.");
        }
    }

    private void updateContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        if (phonebook.containsKey(name)) {
            phonebook.put(name, phone);
            saveContacts();
            displayContacts();
        } else {
            contactArea.setText("Contact not found.");
        }
    }

    private void loadContacts() {
        try (BufferedReader br = new BufferedReader(new FileReader("contacts.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    phonebook.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            contactArea.setText("Error loading contacts.");
        }
    }

    private void saveContacts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contacts.txt"))) {
            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            contactArea.setText("Error saving contacts.");
        }
    }

    private void displayContacts() {
        contactArea.setText("");
        for (Map.Entry<String, String> entry : phonebook.entrySet()) {
            contactArea.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhonebookSystem());
    }
}
