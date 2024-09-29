package src;

import gui.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Main {

    public Main() {
        // JFrame
        JFrame frame = new JFrame("Welcome");
        frame.setSize(800, 600);
        frame.setLayout(null);

        // JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        frame.add(layeredPane);

        // Background image
        ImageIcon background = new ImageIcon("resource/SignUp.jpg"); // Path to background image
        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0, 800, 600);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));  // Background image in the lowest layer

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Leaf Shop");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setBounds(230, 50, 400, 50);
        layeredPane.add(welcomeLabel, Integer.valueOf(1));  // Add to the top layer

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(300, 200, 150, 40);
        layeredPane.add(loginButton, Integer.valueOf(1));  // Add to the top layer

        // ActionListener to open the Login Frame when clicking the Login button
        loginButton.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Close the welcome frame
            new LoginFrame(); // Open the Login Frame
        });

        // SignUp button
        JButton signupButton = new JButton("SignUp");
        signupButton.setBounds(300, 300, 150, 40);
        layeredPane.add(signupButton, Integer.valueOf(1));  // Add to the top layer

        // ActionListener to open the SignUp Frame when clicking the SignUp button
        signupButton.addActionListener((ActionEvent e) -> {
            frame.dispose(); // Close the welcome frame
            new SignUp1(); // Open the SignUp Frame
        });

        // Set frame properties
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();  // Launch Main
    }
}

   
   