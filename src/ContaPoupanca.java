public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    // Construtor utilizando o super()
    public ContaPoupanca(int numero, String titular, double taxaRendimento) {
        super(numero, titular);
        this.taxaRendimento = taxaRendimento;
    }

    // Aplica a taxa de rendimento ao saldo atual
    public void aplicarRendimento() {
        this.saldo += this.saldo * this.taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }
}

