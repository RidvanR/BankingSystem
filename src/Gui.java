import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ActionListener {
    JFrame window = new JFrame();
    JButton saldoButton = new JButton("Saldo ansehen");
    JButton einzahlenButton = new JButton("Einzahlen");
    JButton auszahlenButton = new JButton("Auszahlen");

    Gui() {

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       // Header
        JLabel text = new JLabel("Willkommen auf Ihrem Bankkonto");
        centerPanel.add(text);
        text.setPreferredSize(new Dimension(300,60));
        text.setFont(new Font("DIALOG", Font.BOLD, 18));
        // Space
        JLabel spaceOne = new JLabel("");
        spaceOne.setPreferredSize(new Dimension(300,50));
        centerPanel.add(spaceOne);
        // SaldoButton
        this.saldoButton.addActionListener((ActionListener) this);
        centerPanel.add(this.saldoButton);
        saldoButton.setPreferredSize(new Dimension(150, 40));
        // Space
        JLabel space = new JLabel("");
        space.setPreferredSize(new Dimension(300,20));
        centerPanel.add(space);
        // EinzahlenButton
        this.einzahlenButton.addActionListener((ActionListener) this);
        centerPanel.add(einzahlenButton);
        einzahlenButton.setPreferredSize(new Dimension(150, 40));
        // Space
        JLabel spaceTwo = new JLabel("");
        spaceTwo.setPreferredSize(new Dimension(300,20));
        centerPanel.add(spaceTwo);
        // AuszahlenButton
        this.auszahlenButton.addActionListener((ActionListener) this);
        centerPanel.add(auszahlenButton);
        auszahlenButton.setPreferredSize(new Dimension(150, 40));
        window.add(centerPanel, BorderLayout.CENTER);

        // Panel Config
        window.setSize(400,500);
        window.setLocationRelativeTo(null);
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
