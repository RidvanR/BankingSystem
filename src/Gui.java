import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JFrame window = new JFrame();
    JButton saldoButton = new JButton("Saldo ansehen");
    JButton einzahlenButton = new JButton("Einzahlen");
    JButton auszahlenButton = new JButton("Auszahlen");

    Gui() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Willkommen auf Ihrem Bankkonto");
        text.setBounds(100,10,300,40);


        this.saldoButton.setBounds(10,100,200,40);
        this.saldoButton.addActionListener((ActionListener) this);


        this.einzahlenButton.setBounds(10,200,100,40);
        this.einzahlenButton.addActionListener((ActionListener) this);


        auszahlenButton.setBounds(10,300,100,40);
        this.auszahlenButton.addActionListener((ActionListener) this);

        window.add(this.saldoButton);
        window.add(einzahlenButton);
        window.add(auszahlenButton);
        window.add(text);

        window.setSize(400,500);
        window.setLayout(null);
        window.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.saldoButton) {
            window.dispose();
            new Saldo();
        } else if (e.getSource() == this.einzahlenButton) {
            window.dispose();
            new Einzahlen();
        } else {
            window.dispose();
            new Auszahlen();
        }
    }


}
