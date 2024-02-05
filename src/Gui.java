import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JFrame window = new JFrame();
    JButton saldoButton = new JButton("Saldo ansehen");
    JButton einzahlenButton = new JButton("Einzahlen");
    JButton auszahlenButton = new JButton("Auszahlen");
    JButton logoutButton = new JButton("Logout");
    private String loggedInUsername; // Neue Instanzvariable für den Benutzernamen


    Gui(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername; // Setze den eingeloggten Benutzernamen

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       // Header
        JLabel text = new JLabel("Willkommen auf Ihrem Bankkonto " + loggedInUsername);
        centerPanel.add(text);
        text.setVerticalAlignment(SwingConstants.CENTER);
        text.setForeground(Color.white);
        text.setFont(new Font("DIALOG", Font.BOLD, 14));
        // Space
        JLabel spaceOne = new JLabel("");
        spaceOne.setPreferredSize(new Dimension(300,50));
        centerPanel.add(spaceOne);
        // SaldoButton
        this.saldoButton.addActionListener((ActionListener) this);
        saldoButton.setBackground(Color.RED);
        saldoButton.setForeground(Color.white);
        centerPanel.add(this.saldoButton);
        saldoButton.setPreferredSize(new Dimension(150, 40));
        // Space
        JLabel space = new JLabel("");
        space.setPreferredSize(new Dimension(300,20));
        centerPanel.add(space);
        // EinzahlenButton
        this.einzahlenButton.addActionListener((ActionListener) this);
        einzahlenButton.setBackground(Color.RED);
        einzahlenButton.setForeground(Color.white);
        centerPanel.add(einzahlenButton);
        einzahlenButton.setPreferredSize(new Dimension(150, 40));
        // Space
        JLabel spaceTwo = new JLabel("");
        spaceTwo.setPreferredSize(new Dimension(300,20));
        centerPanel.add(spaceTwo);
        // AuszahlenButton
        this.auszahlenButton.addActionListener((ActionListener) this);
        auszahlenButton.setBackground(Color.RED);
        auszahlenButton.setForeground(Color.white);
        centerPanel.add(auszahlenButton);
        auszahlenButton.setPreferredSize(new Dimension(150, 40));
        // Space
        JLabel spaceTri = new JLabel("");
        spaceTri.setPreferredSize(new Dimension(300,20));
        centerPanel.add(spaceTri);
        // LogoutButton
        this.logoutButton.addActionListener((ActionListener) this);
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.white);
        centerPanel.add(logoutButton);
        logoutButton.setPreferredSize(new Dimension(150, 40));

        window.add(centerPanel, BorderLayout.CENTER);
        // Panel Config
        window.setSize(400,500);
        window.setLocationRelativeTo(null);
        centerPanel.setBackground(Color.DARK_GRAY);
        window.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.saldoButton) {
                window.dispose();
                new Saldo(loggedInUsername); // Übergebe den Benutzernamen an die nächste GUI
            } else if (e.getSource() == this.einzahlenButton) {
                window.dispose();
                new Einzahlen(loggedInUsername); // Übergebe den Benutzernamen an die nächste GUI
            } else if (e.getSource() == this.auszahlenButton) {
                window.dispose();
                new Auszahlen(loggedInUsername); // Übergebe den Benutzernamen an die nächste GUI
            } else  {
                window.dispose();
                new Start();
            }
    }

    public static void main(String[] args) {
        new Gui("Test");
    }


}
