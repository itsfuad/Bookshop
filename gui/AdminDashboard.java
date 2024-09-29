package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import src.Main;

public class AdminDashboard extends JFrame {
    private JTextField bookTitleField;
    private JTextField bookAuthorField;
    private JTextField bookPriceField;
    private JTextArea inventoryArea;
    private JTextField customerNameField;
    private JTextField customerEmailField;
    private JTextArea customerArea;

    // Array to store books and customers
    private String[] books = new String[100];
    private String[] customers = new String[100];
    private int bookCount = 0;
    private int customerCount = 0;

    public AdminDashboard() {
        setTitle("Admin Dashboard - Bookshop Management");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Creating tabs for Book Inventory and Customer Management
        JTabbedPane tabbedPane = new JTabbedPane();

        // Book Inventory Panel
        JPanel bookInventoryPanel = new JPanel();
        bookInventoryPanel.setLayout(new BorderLayout());

        JPanel addBookPanel = new JPanel();
        addBookPanel.setLayout(new GridLayout(4, 2, 10, 10));

        addBookPanel.add(new JLabel("Book Title:"));
        bookTitleField = new JTextField();
        addBookPanel.add(bookTitleField);

        addBookPanel.add(new JLabel("Author:"));
        bookAuthorField = new JTextField();
        addBookPanel.add(bookAuthorField);

        addBookPanel.add(new JLabel("Price:"));
        bookPriceField = new JTextField();
        addBookPanel.add(bookPriceField);

        JButton addBookButton = new JButton("Add Book");
        addBookPanel.add(addBookButton);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        addBookPanel.add(logoutButton);

        bookInventoryPanel.add(addBookPanel, BorderLayout.NORTH);

        inventoryArea = new JTextArea();
        JScrollPane bookScrollPane = new JScrollPane(inventoryArea);
        bookInventoryPanel.add(bookScrollPane, BorderLayout.CENTER);

        addBookButton.addActionListener((ActionEvent e) -> {
            try {
                addBook();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(AdminDashboard.this, "Error saving book data: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Action listener for the Logout button
        logoutButton.addActionListener(e -> {
            AdminDashboard.this.dispose();  // Close the AdminDashboard window
            new Main();  // Open Main window
        });

        tabbedPane.add("Manage Inventory", bookInventoryPanel);

        // Customer Management Panel
        JPanel customerManagementPanel = new JPanel();
        customerManagementPanel.setLayout(new BorderLayout());

        JPanel addCustomerPanel = new JPanel();
        addCustomerPanel.setLayout(new GridLayout(3, 2, 10, 10));

        addCustomerPanel.add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        addCustomerPanel.add(customerNameField);

        addCustomerPanel.add(new JLabel("Customer Email:"));
        customerEmailField = new JTextField();
        addCustomerPanel.add(customerEmailField);

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerPanel.add(addCustomerButton);

        customerManagementPanel.add(addCustomerPanel, BorderLayout.NORTH);

        customerArea = new JTextArea();
        JScrollPane customerScrollPane = new JScrollPane(customerArea);
        customerManagementPanel.add(customerScrollPane, BorderLayout.CENTER);

        addCustomerButton.addActionListener((ActionEvent e) -> {
            try {
                addCustomer();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(AdminDashboard.this, "Error saving customer data: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        tabbedPane.add("Manage Customers", customerManagementPanel);

        add(tabbedPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Method to add books to the inventory and save to a file
    private void addBook() throws IOException {
        String title = bookTitleField.getText();
        String author = bookAuthorField.getText();
        String price = bookPriceField.getText();

        if (title.isEmpty() || author.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            books[bookCount] = "Title: " + title + ", Author: " + author + ", Price: " + price;
            bookCount++;
            updateInventoryDisplay();
            clearBookFields();
            saveBookToFile(title, author, price);
        }
    }

    // Method to save book details to a file
    private void saveBookToFile(String title, String author, String price) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write("Title: " + title + ", Author: " + author + ", Price: " + price);
            writer.newLine();
        }
    }

    // Method to update the inventory display
    private void updateInventoryDisplay() {
        inventoryArea.setText("");
        for (int i = 0; i < bookCount; i++) {
            inventoryArea.append(books[i] + "\n");
        }
    }

    // Method to clear the book input fields
    private void clearBookFields() {
        bookTitleField.setText("");
        bookAuthorField.setText("");
        bookPriceField.setText("");
    }

    // Method to add customers and save to a file
    private void addCustomer() throws IOException {
        String name = customerNameField.getText();
        String email = customerEmailField.getText();

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            customers[customerCount] = "Name: " + name + ", Email: " + email;
            customerCount++;
            updateCustomerDisplay();
            clearCustomerFields();
            saveCustomerToFile(name, email);
        }
    }

    // Method to save customer details to a file
    private void saveCustomerToFile(String name, String email) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customers.txt", true))) {
            writer.write("Name: " + name + ", Email: " + email);
            writer.newLine();
        }
    }

    // Method to update the customer display
    private void updateCustomerDisplay() {
        customerArea.setText("");
        for (int i = 0; i < customerCount; i++) {
            customerArea.append(customers[i] + "\n");
        }
    }

    // Method to clear the customer input fields
    private void clearCustomerFields() {
        customerNameField.setText("");
        customerEmailField.setText("");
    }
}
