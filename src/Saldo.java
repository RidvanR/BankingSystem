import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo implements ActionListener {

    private JFrame window = new JFrame();
    private JButton backButton = new JButton("Zurueck");
    private String loggedInUsername;

    Saldo(String loggedInUsername) {
        window.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.loggedInUsername = loggedInUsername;
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel(loggedInUsername + " Ihr Saldo ist:");
        text.setFont(new Font("DIALOG", Font.BOLD, 16));
        text.setVerticalAlignment(SwingConstants.CENTER);

        JLabel filler = new JLabel("");
        filler.setPreferredSize(new Dimension(400, 40));

        JLabel saldo = new JLabel(String.valueOf(Main.giro1.getCurrentSaldo()));
        saldo.setFont(new Font("DIALOG", Font.BOLD, 13));
        saldo.setVerticalAlignment(SwingConstants.CENTER);
        if (Main.giro1.getCurrentSaldo() > 0) {
            saldo.setForeground(Color.blue);
        } else {
            saldo.setForeground(Color.red);
        }


        JLabel filler2 = new JLabel("");
        filler2.setPreferredSize(new Dimension(400, 70));

        this.backButton.setPreferredSize(new Dimension(150,40));
        this.backButton.setVerticalAlignment(SwingConstants.CENTER);
        this.backButton.addActionListener(this);


        centerPanel.add(text);
        centerPanel.add(filler);
        centerPanel.add(saldo);
        centerPanel.add(filler2);
        centerPanel.add(this.backButton);
        window.add(centerPanel, BorderLayout.CENTER);

        // Nutze einen Layout-Manager (FlowLayout) anstelle von null
        window.setSize(400, 500);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.backButton) {
            window.dispose();
            new Gui(this.loggedInUsername);
        }
    }
}


