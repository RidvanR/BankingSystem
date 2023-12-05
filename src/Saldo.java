import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saldo implements ActionListener {

    JFrame window = new JFrame();
    JButton backButton = new JButton("Zurueck");


    Saldo() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel text = new JLabel("Ihr Saldo ist;");
        text.setBounds(100,10,300,40);

        this.backButton.setBounds(100,100,200,40);
        this.backButton.addActionListener((ActionListener) this);


        JLabel saldo = new JLabel(String.valueOf(Main.giro1.getCurrentSaldo()));
        saldo.setBounds(100,30,100,40);


        window.add(this.backButton);
        window.add(text);
        window.add(saldo);

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
    }
}
