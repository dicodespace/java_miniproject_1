import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Background with Text");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Load the image
        ImageIcon backgroundImage = new ImageIcon("background_image.jpg");

        // Create a JLabel with the image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());

        // Set the layout to overlay
        backgroundLabel.setLayout(new OverlayLayout(backgroundLabel));

        // Add the background label to the content pane
        frame.setContentPane(backgroundLabel);

        // Add text label on top of the image
        JLabel textLabel = new JLabel("Movie Mate");
        textLabel.setFont(new Font("SansSerif Bold italic", Font.BOLD, 100));
        textLabel.setForeground(Color.RED); // setting text color to black
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align the text
        backgroundLabel.add(textLabel);

        // Center the JFrame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
