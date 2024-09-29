package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import src.Main;

public class LoginFrame {
    // Arrays for usernames and passwords for admin and customers
    private String[] adminUsers = {"admin"};
    private String[] adminPasswords = {"admin123"};
    private String[] customerUsers = {"customer"};
    private String[] customerPasswords = {"cust123"};

    public LoginFrame() {
        JFrame j = new JFrame("Login");
        j.setSize(800, 600);
        j.setLayout(null);

        // JLayeredPane for the background image and components layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        j.add(layeredPane);

        // Background image
        ImageIcon img = new ImageIcon("resource/Login.jpg"); // image path
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(imgLabel, Integer.valueOf(0)); // Background image in the bottom layer

        // Login Label
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(350, 100, 150, 50);
        loginLabel.setFont(new Font("Serif", Font.BOLD, 40));
        loginLabel.setForeground(Color.WHITE);  // font color
        layeredPane.add(loginLabel, Integer.valueOf(1));  // Add to top layer

        // Username Label
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(330, 200, 100, 30);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 15));
        usernameLabel.setForeground(Color.WHITE);  // font color
        layeredPane.add(usernameLabel, Integer.valueOf(1));  // Add to top layer

        // Username Field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(330, 240, 150, 30);
        layeredPane.add(usernameField, Integer.valueOf(1));  // Add to top layer

        // Password Label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(330, 280, 100, 30);
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 15));
        passwordLabel.setForeground(Color.WHITE);  // font color
        layeredPane.add(passwordLabel, Integer.valueOf(1));  // Add to top layer

        // Password Field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(330, 320, 150, 30);
        layeredPane.add(passwordField, Integer.valueOf(1));  // Add to top layer

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(240, 380, 100, 30);
        layeredPane.add(loginButton, Integer.valueOf(1));  // Add to top layer

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(480, 380, 100, 30);
        layeredPane.add(backButton, Integer.valueOf(1));  // Add to top layer

        // Action listener for Login button
        loginButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(j, "Please enter both username and password!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // To Check if the user is an admin
                if (isAdmin(username, password)) {
                    JOptionPane.showMessageDialog(j, "Admin login successful!");
                    j.dispose(); // Close the login window
                    AdminDashboard adminDashboard = new AdminDashboard(); // Open admin dashboard
                    adminDashboard.setVisible(true);
                }
                // To Check if the user is a customer
                else if (isCustomer(username, password)) {
                    JOptionPane.showMessageDialog(j, "Customer login successful!");
                    j.dispose(); // Close the login window
                    LeafShop2 leafShop2 = new LeafShop2(); // Open LeafShop2 window for customers
                    leafShop2.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(j, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener for Back button
        backButton.addActionListener((ActionEvent e) -> {
            j.dispose();  // Close the login window
            new Main(); // Open the Welcome Frame
        });

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }

    // Method to check if the user is an admin
    private boolean isAdmin(String username, String password) {
        for (int i = 0; i < adminUsers.length; i++) {
            if (adminUsers[i].equals(username) && adminPasswords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Method to check if the user is a customer
    private boolean isCustomer(String username, String password) {
        for (int i = 0; i < customerUsers.length; i++) {
            if (customerUsers[i].equals(username) && customerPasswords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }
}
