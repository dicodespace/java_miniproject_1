import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignInPage extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public SignInPage() {
        setTitle("Cinema Booking Signup");
        setSize(500, 750);
        setLayout(null);

        // Load image
        ImageIcon icon = new ImageIcon("popcorn.jpg");
        Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);

        // Adding image label
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(150, 50, 200, 200);
        add(imageLabel);

        // Adding welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Movie Mate");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setBounds(150, 270, 300, 30);
        add(welcomeLabel);

        // Adding username field
        usernameField = new JTextField();
        usernameField.setBounds(100, 320, 300, 30);
        usernameField.setText("username");
        add(usernameField);

        // Adding password field
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 370, 300, 30);
        passwordField.setText("password");
        add(passwordField);

        // Adding sign-in button
        JButton signinButton = new JButton("Sign In");
        signinButton.setBounds(200, 420, 100, 30);
        signinButton.addActionListener(this);
        add(signinButton);

        // Adding sign-up option
        JLabel SignupLabel = new JLabel("If you are new here.sign up now");
        SignupLabel.setBounds(150, 470, 200, 20);
        add(SignupLabel);

        // Adding sign-up button
        JButton signupButton = new JButton("Sign up");
        signupButton.setBounds(200, 500, 100, 30);
        signupButton.addActionListener(this);
        add(signupButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String usernameText = usernameField.getText();
        String passwordText = new String(passwordField.getPassword());

        if (e.getActionCommand().equals("Sign In")) {
            // Sign-in logic
            System.out.println("Signing in with username: " + usernameText + ", password: " + passwordText);
        } else if (e.getActionCommand().equals("Sign up")) {
            // Sign-up logic
            System.out.println("Signing up with username: " + usernameText + ", password: " + passwordText);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CinemaSignUpPage());
    }
}