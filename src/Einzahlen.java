import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Einzahlen implements ActionListener {

    JFrame window = new JFrame();
    JButton backButton = new JButton("Zurueck");
    JButton confirm = new JButton("Bestaetigen");

    JTextField einzahlenField = new JTextField();
    JLabel eingezahlt = new JLabel();
    private String loggedInUsername;


    Einzahlen(String loggedInUsername) {
        this.loggedInUsername = loggedInUsername;
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Welche Summe wollen Sie einzahlen?");
        text.setBounds(100,10,250,40);

        this.einzahlenField.setBounds(130,70,100,30);

        this.confirm.setBounds(130,120,130,40);
        this.confirm.addActionListener(this);

        this.eingezahlt.setBounds(130,170,400,30);

        this.backButton.setBounds(100,300,200,40);
        this.backButton.addActionListener((ActionListener) this);


        window.add(this.backButton);
        window.add(text);
        window.add(einzahlenField);
        window.add(this.eingezahlt);
        window.add(confirm);

        window.setSize(400,500);
        window.setLayout(null);
        window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.backButton) {
            window.dispose();
            new Gui(this.loggedInUsername);
        }

        if (e.getSource() == this.confirm) {
            String data = this.einzahlenField.getText();
            try {
                Main.giro1.setEinzahlung(Double.parseDouble(data));
                this.eingezahlt.setText("Sie haben eingezahlt: " + Main.giro1.getCurrentEinzahlung());
            } catch (NumberFormatException ignore) {
                this.eingezahlt.setText("Bitte Zahlen eingeben!");
            }

        }
    }
}
