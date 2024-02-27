import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaSeatingArrangement {
    private static List<Integer> bookedSeats = new ArrayList<>();
    private static List<JButton> seatButtons = new ArrayList<>();
    private static final double SEAT_PRICE = 10.0; // Assuming each seat costs $10

    public static void main(String[] args) {
        // Connect to the MySQL database
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

            // Query to retrieve booked seats from the database
            String query = "SELECT seat_number FROM booked_seats";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                bookedSeats.add(resultSet.getInt("seat_number"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Cinema Seating Arrangement");
        frame.setSize(500, 750); // Set initial size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel to hold seat labels and buttons
        JPanel seatPanel = new JPanel(new GridLayout(5, 5, 2, 2)); // Add an extra row for the header
        seatPanel.add(new JLabel("Seats")); // Add header label
        for (int i = 1; i <= 40; i++) {
            JButton seatButton = new JButton(Integer.toString(i));
            seatButton.setPreferredSize(new Dimension(10, 10)); // Adjust button size here
            seatButton.setEnabled(!bookedSeats.contains(i));
            seatButton.addActionListener(new SeatActionListener(i));
            seatButtons.add(seatButton);
            seatPanel.add(seatButton);
        }

        // Add seat panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(seatPanel);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel to hold book button
        JPanel buttonPanel = new JPanel();
        JButton bookButton = new JButton("BOOK SEATS");
        buttonPanel.add(bookButton); // Moved button to the button panel
        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numSeatsBooked = bookedSeats.size();
                double totalPrice = numSeatsBooked * SEAT_PRICE;
                String bookedSeatsStr = bookedSeats.toString();
                JOptionPane.showMessageDialog(frame,
                        "Number of seats booked: " + numSeatsBooked + "\n" +
                                "Seats booked: " + bookedSeatsStr + "\n" +
                                "Total Price: $" + totalPrice,
                        "Seats Booked",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add button panel to frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        frame.setVisible(true);
    }

    static class SeatActionListener implements ActionListener {
        private int seatNumber;

        public SeatActionListener(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        public void actionPerformed(ActionEvent e) {
            if (!bookedSeats.contains(seatNumber)) {
                JButton seatButton = (JButton) e.getSource();
                if (seatButtons.contains(seatButton)) {
                    bookedSeats.add(seatNumber);
                    seatButton.setEnabled(false);
                    seatButton.setBackground(Color.BLACK);
                }
            }
        }
    }
}
