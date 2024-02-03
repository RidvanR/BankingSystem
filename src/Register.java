import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

public class Register implements ActionListener {

    JFrame window = new JFrame();
    JLabel text = new JLabel("Willkommen im Registrierungsbereich");
    JButton confirmButton = new JButton("Bestätigen");
    JTextField firstnameField = new JTextField(30);
    JTextField lastnameField = new JTextField(30);
    JTextField usernameField = new JTextField(30);
    JTextField passField = new JTextField(30);

    Register() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        centerPanel.add(text);
        text.setFont(new Font("DIALOG", Font.BOLD, 16));
        text.setPreferredSize(new Dimension(290, 60));

        centerPanel.add(new JLabel("Geben Sie Ihren Vornamen ein:"));
        firstnameField.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(firstnameField);

        centerPanel.add(new JLabel("Geben Sie Ihren Nachnamen ein:"));
        lastnameField.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(lastnameField);

        centerPanel.add(new JLabel("Geben Sie Ihren Anmeldenamen ein:"));
        usernameField.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(usernameField);

        centerPanel.add(new JLabel("Geben Sie Ihr neues Passwort ein:"));
        passField.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(passField);

        confirmButton.setPreferredSize(new Dimension(150, 40));
        centerPanel.add(confirmButton);
        confirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmButton.addActionListener(this);

        window.add(centerPanel, BorderLayout.CENTER);

        window.setSize(400, 500);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String enteredUsername = usernameField.getText();
            String enteredPassword = passField.getText();
            String enteredFirstname = firstnameField.getText();
            String enteredLastname = lastnameField.getText();

            try {
                Connection connection = DatabaseConnection.getConnection();
                String query = "INSERT INTO accounts (vorname, nachname, passwort, username) VALUES (?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, enteredFirstname);
                    preparedStatement.setString(2, enteredLastname);
                    preparedStatement.setString(3, enteredPassword);
                    preparedStatement.setString(4, enteredUsername);

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Registrierung erfolgreich!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registrierung fehlgeschlagen. Überprüfen Sie Ihre Daten.");
                    }
                }

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(null, "Vielen Dank für die Registrierung!");
                        window.dispose();
                        new Gui(usernameField.getText());
                    }
                };
                timer.schedule(task, 3000);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection();
            }
        }
    }
}
