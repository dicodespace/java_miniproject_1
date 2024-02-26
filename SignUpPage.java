import java.awt.*;
import java.awt.event.*;

public class SignUpPage extends Frame implements ActionListener {
    private TextField userIdField;
    private TextField emailField;
    private TextField passwordField;
    private TextField nameField;

    public SignUpPage() {
        setTitle("Cinema Booking - Sign Up");
        setSize(500, 750);
        setLayout(null); // Using null layout for simplicity

        // Adding heading
        Label headingLabel = new Label("Sign Up Here");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setBounds(180, 50, 200, 30);
        add(headingLabel);

        // Adding user ID field
        userIdField = new TextField();
        userIdField.setBounds(100, 100, 300, 30);
        userIdField.setText("User ID");
        add(userIdField);

        // Adding email field
        emailField = new TextField();
        emailField.setBounds(100, 150, 300, 30);
        emailField.setText("Email");
        add(emailField);

        // Adding password field
        passwordField = new TextField();
        passwordField.setBounds(100, 200, 300, 30);
        passwordField.setEchoChar('*');
        passwordField.setText("Password");
        add(passwordField);

        // Adding name field
        nameField = new TextField();
        nameField.setBounds(100, 250, 300, 30);
        nameField.setText("Name");
        add(nameField);

        // Adding sign up button
        Button signUpButton = new Button("Sign Up");
        signUpButton.setBounds(200, 300, 100, 30);
        signUpButton.addActionListener(this);
        add(signUpButton);

        // Adding sign in back button
        Button signInBackButton = new Button("Sign In Back");
        signInBackButton.setBounds(180, 350, 140, 30);
        signInBackButton.addActionListener(this);
        add(signInBackButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sign Up")) {
            // Perform sign-up logic
            String userId = userIdField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String name = nameField.getText();
            // Implement sign-up logic here
            System.out.println("User ID: " + userId + ", Email: " + email + ", Password: " + password + ", Name: " + name);
        } else if (e.getActionCommand().equals("Sign In Back")) {
            // Navigate back to the sign-in page
            dispose(); // Close the current sign-up page
            new SignInPage(); // Open the sign-in page
        }
    }

    public static void main(String[] args) {
        new SignUpPage();
    }
}
