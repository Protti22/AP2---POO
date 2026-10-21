public class ContaCorrente extends Conta {
    private double limite;

    // Construtor utilizando o super()
    public ContaCorrente(int numero, String titular, double limite) {
        super(numero, titular);
        this.limite = limite;
    }

    // Permite sacar utilizando o saldo + limite disponível
    public boolean sacarComLimite(double valor) {
        if (valor > 0 && valor <= (this.saldo + this.limite)) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }
}