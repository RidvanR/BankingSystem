public class Konto {
    //Attribute
    private double saldo, einzahlung, auszahlung;

    // Konstruktor
    Konto() {
    }

    // Setter Methoden
    public void setEinzahlung(double einzahlung ) {
        this.einzahlung = einzahlung;
        this.saldo = this.saldo + einzahlung;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setAuszahlung(double auszahlung) {
        this.auszahlung = auszahlung;
        this.saldo = this.saldo - auszahlung ;
    }

    // Getter Methoden

    public double getCurrentSaldo() {
        return this.saldo;
    }

    public double getCurrentEinzahlung() {
        return this.einzahlung;
    }

    public double getCurrentAuszahlung() {
        return this.auszahlung;
    }


}
