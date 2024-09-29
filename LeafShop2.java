package com.bookshop.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LeafShop2 extends JFrame {
    private JTextField titleField, genreField;
    private ImageIcon img;
    private JLabel imgLabel;

    public LeafShop2() {
        setTitle("Homepage");
        setSize(800, 600); // Frame Size
        setLayout(null);

        // LayeredPane to handle background image and components layering
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 800, 600);
        add(layeredPane);

        // Background Image
        img = new ImageIcon("C:\\Users\\masiy\\Book.jpg.jpg");
        imgLabel = new JLabel(img);
        imgLabel.setBounds(0, 0, 800, 600);
        
        // Adding background image to the bottom layer
        layeredPane.add(imgLabel, Integer.valueOf(0));

         // Leaf Shop Label 
        JLabel leafshopLabel = new JLabel("Leaf Shop");
        leafshopLabel.setBounds(250, 20, 250, 100);
        leafshopLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));  // font size and style
        leafshopLabel.setForeground(Color.BLACK);  // font color
        layeredPane.add(leafshopLabel, Integer.valueOf(1));  // Add to the top layer

        // Bookstore Label 
        JLabel bookstoreLabel = new JLabel("Bookstore");
        bookstoreLabel.setBounds(250, 80, 280, 100);
        bookstoreLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 50));  // font size and style
        bookstoreLabel.setForeground(Color.BLACK);  // font color
        layeredPane.add(bookstoreLabel, Integer.valueOf(1));  // Add to the top layer

        // Title Label 
        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(335, 220, 100, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));  // font size and style
        titleLabel.setForeground(Color.BLACK);  // font color
        layeredPane.add(titleLabel, Integer.valueOf(1));  // Add to the top layer

        // Title Field
        titleField = new JTextField();
        titleField.setBounds(280, 245, 150, 30);
        layeredPane.add(titleField, Integer.valueOf(1));  // Add to the top layer

        // Genre Label 
        JLabel yearLabel = new JLabel("Genre:");
        yearLabel.setBounds(330, 275, 100, 30);
        yearLabel.setFont(new Font("Arial", Font.BOLD, 16));  // font size and style
        yearLabel.setForeground(Color.BLACK);  // font color
        layeredPane.add(yearLabel, Integer.valueOf(1));  // Add to the top layer

        // Genre Field
        genreField = new JTextField();
        genreField.setBounds(280, 300, 150, 30);
        layeredPane.add(genreField, Integer.valueOf(1));  // Add to the top layer

        // Search Button
        JButton addButton = new JButton("Search");
        addButton.setBounds(305, 350, 100, 30);
        layeredPane.add(addButton, Integer.valueOf(1));  // Add to the top layer

        // Add ActionListener for the button
        ActionListener addActionListener = new AddBookActionListener();
        addButton.addActionListener(addActionListener);

        // Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(700, 0, 100, 30);
        layeredPane.add(logoutButton, Integer.valueOf(1));  // Add to the top layer

        // ActionListener for Logout button
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // To Close the homepage
                new WelcomeFrame(); // To Open the Welcome frame
            }
        });

        // View Books Button
        JButton viewBooksButton = new JButton("View Books");
        viewBooksButton.setBounds(280, 400, 150, 30);
        layeredPane.add(viewBooksButton, Integer.valueOf(1));  // Add to the top layer

        // ActionListener for View Books button
        viewBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current homepage frame
                BookList bookList = new BookList(); // Open BookList frame
                bookList.setVisible(true);
            }
        });

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ActionListener for Search button
    class AddBookActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String genre = genreField.getText();
            System.out.println("Book Added: Title = " + title + ", Genre = " + genre);
        }
    }

    public static void main(String[] args) {
        LeafShop2 leafshop2 = new LeafShop2();
        leafshop2.setVisible(true);
    }
}

class BookList extends JFrame {
    private JLabel note;
    private Font myFont;
    private ImageIcon img;
    private JLabel picture;
    private JButton button;
    private JPanel panel;

    public BookList() {
        super("Books' List");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE); 
        add(panel);

        note = new JLabel("Book Item's");
        note.setBounds(60, 20, 406, 200);
        note.setForeground(Color.BLACK);
        myFont = new Font("Calibri", Font.BOLD, 50);
        note.setFont(myFont);
        panel.add(note);

        // Book 1
        img = new ImageIcon("3.png");
        picture = new JLabel(img);
        picture.setBounds(140, 205, 129, 200);
        panel.add(picture);
        
        note = new JLabel("The reign of queen victoria");
        note.setBounds(280, 220, 250, 30);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setForeground(Color.BLACK);
        note.setFont(myFont);
        panel.add(note);

        note = new JLabel("by Hector Bolitho");
        note.setBounds(282, 240, 250, 30);
        note.setForeground(Color.BLACK);
        panel.add(note);
        
        note = new JLabel("5000 BDT");
        note.setBounds(283, 280, 250, 30);
        note.setForeground(Color.BLACK);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setFont(myFont);
        panel.add(note);

        // Book 2
        img = new ImageIcon("2.png");
        picture = new JLabel(img);
        picture.setBounds(530, 205, 129, 200);
        panel.add(picture);

        note = new JLabel("The bike guy");
        note.setBounds(670, 220, 180, 30);
        note.setForeground(Color.BLACK);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setFont(myFont);
        panel.add(note);

        note = new JLabel("by Bob Deans");
        note.setForeground(Color.BLACK);
        note.setBounds(672, 240, 250, 30);
        panel.add(note);
        
        note = new JLabel("2000 BDT");
        note.setBounds(673, 280, 250, 30);
        note.setForeground(Color.BLACK);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setFont(myFont);
        panel.add(note);

        // Book 3
        img = new ImageIcon("Padpro.png");
        picture = new JLabel(img);
        picture.setBounds(880, 205, 129, 200);
        panel.add(picture);

        note = new JLabel("Atomic love");
        note.setBounds(1020, 220, 180, 30);
        note.setForeground(Color.BLACK);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setFont(myFont);
        panel.add(note);

        note = new JLabel("by Jennie Fields");
        note.setBounds(1020, 240, 250, 30);
        note.setForeground(Color.BLACK);
        panel.add(note);
        
        note = new JLabel("1500 BDT");
        note.setBounds(1020, 280, 250, 30);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setFont(myFont);
        note.setForeground(Color.BLACK);
        panel.add(note);

        // Book 4
        img = new ImageIcon("1.png");
        picture = new JLabel(img);
        picture.setBounds(140, 480, 129, 200);
        panel.add(picture);

        note = new JLabel("In Other Words");
        note.setBounds(280, 500, 180, 30);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setForeground(Color.BLACK);
        note.setFont(myFont);
        panel.add(note);

        note = new JLabel("by Jhumpa Lahiri");
        note.setBounds(282, 520, 250, 30);
        note.setForeground(Color.BLACK);
        panel.add(note);
        
        note = new JLabel("990 BDT");
        note.setBounds(282, 570, 250, 30);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setForeground(Color.BLACK);
        note.setFont(myFont);
        panel.add(note);

        // Book 5
        img = new ImageIcon("pad.png");
        picture = new JLabel(img);
        picture.setBounds(530, 480, 129, 200);
        panel.add(picture);

        note = new JLabel("When The Lion Feeds");
        note.setBounds(670, 500, 180, 30);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setForeground(Color.BLACK);
        note.setFont(myFont);
        panel.add(note);

        note = new JLabel("by Wilbur Smith");
        note.setBounds(672, 520, 250, 30);
        note.setForeground(Color.BLACK);
        panel.add(note);
        
        note = new JLabel("1490 BDT");
        note.setBounds(672, 570, 250, 30);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setFont(myFont);
        note.setForeground(Color.BLACK);
        panel.add(note);

        img = new ImageIcon("4.jpg");
        picture = new JLabel(img);
        picture.setBounds(880, 480, 129, 200);
        panel.add(picture);

        note = new JLabel("Moyurakkhi");
        note.setBounds(1020, 500, 180, 30);
        myFont = new Font("Calibri", Font.BOLD, 18);
        note.setFont(myFont);
        note.setForeground(Color.BLACK);
        panel.add(note);

        note = new JLabel("by Humayun Ahmed");
        note.setBounds(1022, 520, 250, 30);
        note.setForeground(Color.BLACK);
        panel.add(note);
        
        note = new JLabel("490 BDT");
        note.setBounds(1022, 570, 250, 30);
        myFont = new Font("Calibri", Font.BOLD, 20);
        note.setFont(myFont);
        note.setForeground(Color.BLACK);
        panel.add(note);

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 700, 100, 30);
        panel.add(backButton);

         // ActionListener for Back Button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the BookList frame
                LeafShop2 leafShop2 = new LeafShop2(); // Open the LeafShop2 frame
                leafShop2.setVisible(true);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
    }

    public static void main(String[] args) {
        BookList list = new BookList();
        list.setVisible(true);
    }
}
