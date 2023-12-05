import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auszahlen implements ActionListener {

    JFrame window = new JFrame();
    JButton backButton = new JButton("Zurueck");
    JButton confirm = new JButton("Bestaetigen");

    JTextField auszahlenField = new JTextField();
    JLabel ausgezahlt = new JLabel();


    Auszahlen() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Welche Summe wollen Sie Auszahlen?");
        text.setBounds(100,10,250,40);

        this.auszahlenField.setBounds(130,70,100,30);

        this.confirm.setBounds(130,120,130,40);
        this.confirm.addActionListener(this);

        this.ausgezahlt.setBounds(130,170,400,30);

        this.backButton.setBounds(100,300,200,40);
        this.backButton.addActionListener((ActionListener) this);


        window.add(this.backButton);
        window.add(text);
        window.add(auszahlenField);
        window.add(this.ausgezahlt);
        window.add(confirm);

        window.setSize(400,500);
        window.setLayout(null);
        window.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.backButton) {
            window.dispose();
            new Gui();
        }

        if (e.getSource() == this.confirm) {
            String data = this.auszahlenField.getText();
            try {
                Main.giro1.setAuszahlung(Double.parseDouble(data));
                this.ausgezahlt.setText("Sie haben ausgezahlt: " + Main.giro1.getCurrentAuszahlung());
            } catch (NumberFormatException ignore) {
                this.ausgezahlt.setText("Zahlen eingeben!");
            }
        }
    }
}