import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auszahlen implements ActionListener {

    JFrame window = new JFrame();
    JButton backButton = new JButton("Zurueck");
    JButton confirm = new JButton("Bestaetigen");

    JTextField auszahlenField = new JTextField(30);
    JLabel ausgezahlt = new JLabel();

    private String loggedInUsername;

    Auszahlen(String loggedInUsername) {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        this.loggedInUsername = loggedInUsername;
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel text = new JLabel(loggedInUsername + ". Welche Summe wollen Sie Auszahlen?");
        text.setFont(new Font("DIALOG", Font.BOLD, 16));
        text.setVerticalAlignment(SwingConstants.CENTER);

        JLabel filler = new JLabel("");
        filler.setPreferredSize(new Dimension(400, 40));

        this.auszahlenField.setPreferredSize(new Dimension(200,30));

        JLabel filler2 = new JLabel("");
        filler2.setPreferredSize(new Dimension(400, 40));

        this.confirm.setPreferredSize(new Dimension(150,40));
        this.confirm.setVerticalAlignment(SwingConstants.CENTER);
        this.confirm.addActionListener(this);

        JLabel filler3 = new JLabel("");
        filler3.setPreferredSize(new Dimension(400, 40));

        this.ausgezahlt.setBounds(130,170,400,30);

        this.backButton.setPreferredSize(new Dimension(150,40));
        this.backButton.setVerticalAlignment(SwingConstants.CENTER);
        this.backButton.addActionListener((ActionListener) this);


        centerPanel.add(text);
        centerPanel.add(filler);
        centerPanel.add(auszahlenField);
        centerPanel.add(filler2);
        centerPanel.add(this.ausgezahlt);
        centerPanel.add(filler3);
        centerPanel.add(confirm);
        centerPanel.add(this.backButton);
        window.add(centerPanel, BorderLayout.CENTER);

        window.setSize(400, 500);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.backButton) {
            window.dispose();
            new Gui(this.loggedInUsername);
        }

        if (e.getSource() == this.confirm) {
            String data = this.auszahlenField.getText();
            try {
                Main.giro1.setAuszahlung(Double.parseDouble(data));
                this.ausgezahlt.setText("Sie haben ausgezahlt: " + Main.giro1.getCurrentAuszahlung());
                this.confirm.setEnabled(false);
            } catch (NumberFormatException ignore) {
                this.ausgezahlt.setText("Zahlen eingeben!");
            }
        }
    }

    public static void main(String[] args) {
        new Auszahlen("Hallo");
    }
}