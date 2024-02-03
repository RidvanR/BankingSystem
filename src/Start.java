import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Start implements ActionListener {
    JFrame window = new JFrame();
    JLabel text = new JLabel("Willkommen im Login Bereich");
    JButton confirmButton = new JButton("Bestätigen");

    JTextField loginField = new JTextField(30);

    JLabel rege = new JLabel("Kein Account? Jetzt Registrieren");

    JTextField passField = new JTextField(30);


    Start() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setze das Layout des Frames auf BorderLayout
        window.setLayout(new BorderLayout());

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        // Header
        centerPanel.add(text);
        text.setFont(new Font("DIALOG", Font.BOLD, 18));
        text.setPreferredSize(new Dimension(290,60));
        // Anmeldename
        centerPanel.add(new JLabel("Anmeldename:"));
        loginField.setPreferredSize(new Dimension(200,30));
        centerPanel.add(loginField);
        // Passwort
        centerPanel.add(new JLabel("Passwort:"));
        passField.setPreferredSize(new Dimension(200,30));
        centerPanel.add(passField);
        // Kein Account
        rege.setFont(new Font("DIALOG", Font.BOLD, 14));
        rege.setForeground(Color.red);
        rege.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        centerPanel.add(rege);
        rege.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.dispose();
                new Gui();
            }
        });
        // Button
        confirmButton.setPreferredSize(new Dimension(150, 40));
        centerPanel.add(confirmButton);
        confirmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        confirmButton.addActionListener(this);

        window.add(centerPanel, BorderLayout.CENTER);
        // Layout
        window.setSize(400,500);
        // window.getContentPane().setBackground(Color.black);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String enteredUsername = loginField.getText();
            String enteredPassword = passField.getText();

            try {
                Connection connection = DatabaseConnection.getConnection();
                Statement statement = connection.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + enteredUsername + "' AND password = '" + enteredPassword + "'");

                if (resultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Anmeldung erfolgreich!");
                } else {
                    JOptionPane.showMessageDialog(null, "Anmeldung fehlgeschlagen. Überprüfen Sie Ihre Anmeldedaten.");
                }

                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                DatabaseConnection.closeConnection();
            }
        }
    }

    }
