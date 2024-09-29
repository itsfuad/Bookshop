package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import src.Main;

public class SignUp1 {
    public SignUp1() {
        JFrame j = new JFrame("Register");
        j.setSize(800, 600);
        j.setLayout(null);

        // A JLayeredPane to handle the background image and components layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        j.add(layeredPane);

        // Background image
        ImageIcon img = new ImageIcon("resource/LeafShop.jpg");  // Ensure the path to the image is correct
        JLabel imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 800, 600);
        
        // background image in the bottom layer
        layeredPane.add(imgLabel, Integer.valueOf(0));

        // Sign Up Label
        JLabel signupLabel = new JLabel("Sign Up");
        signupLabel.setBounds(340, 20, 160, 80);
        signupLabel.setFont(new Font("Serif", Font.BOLD, 40));
        signupLabel.setForeground(Color.WHITE);  // Font color
        layeredPane.add(signupLabel, Integer.valueOf(1));  // Add to top layer

        // Username Label
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(330, 100, 100, 30);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 15));
        usernameLabel.setForeground(Color.BLACK);  // Font color
        layeredPane.add(usernameLabel, Integer.valueOf(1));  // Add to top layer

        // Username Field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(330, 140, 150, 30);
        layeredPane.add(usernameField, Integer.valueOf(1));  // Add to top layer

        // Email Label
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(330, 180, 100, 30);
        emailLabel.setFont(new Font("Serif", Font.BOLD, 15));
        emailLabel.setForeground(Color.BLACK);  // Font color
        layeredPane.add(emailLabel, Integer.valueOf(1));  // Add to top layer

        // Email Field
        JTextField emailField = new JTextField();
        emailField.setBounds(330, 220, 150, 30);
        layeredPane.add(emailField, Integer.valueOf(1));  // Add to top layer

        // Password Label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(330, 260, 100, 30);
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 15));
        passwordLabel.setForeground(Color.BLACK);  // Font color
        layeredPane.add(passwordLabel, Integer.valueOf(1));  // Add to top layer

        // Password Field
        JPasswordField pass1 = new JPasswordField();
        pass1.setBounds(330, 300, 150, 30);
        layeredPane.add(pass1, Integer.valueOf(1));  // Add to top layer

        // Confirm Password Label
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(330, 340, 140, 30);
        confirmPasswordLabel.setFont(new Font("Serif", Font.BOLD, 15));
        confirmPasswordLabel.setForeground(Color.BLACK);  // Font color
        layeredPane.add(confirmPasswordLabel, Integer.valueOf(1));  // Add to top layer

        // Confirm Password Field
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(330, 380, 150, 30);
        layeredPane.add(confirmPasswordField, Integer.valueOf(1));  // Add to top layer

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(240, 450, 100, 30);
        layeredPane.add(registerButton, Integer.valueOf(1));  // Add to top layer

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(480, 450, 100, 30);
        layeredPane.add(backButton, Integer.valueOf(1));  // Add to top layer

        // Add action listener to Register button
        registerButton.addActionListener((ActionEvent e) -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(pass1.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(j, "Passwords do not match!");
            } else {
                JOptionPane.showMessageDialog(j, "Registration successful!");
            }
            j.dispose(); // Close SignUp
            new LoginFrame(); // Open Login Frame
        });

        // Action listener for Back button
        backButton.addActionListener((ActionEvent e) -> {
            j.dispose();  // Close window
            new Main(); // Open the Welcome Frame
        });

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
    }
}
