public class Conta {
    private int numero;
    private String titular;
    protected double saldo; // 'protected' permite acesso direto nas subclasses (ContaPoupanca e ContaCorrente)

    // Construtor
    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0; // O saldo inicia em zero
    }

    // Método para depositar
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    // Método para sacar
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    // Getters (Apenas getters, sem setters conforme especificação)
    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método para exibir informações da conta
    public void exibir() {
        System.out.println("Número: " + numero + " | Titular: " + titular + " | Saldo: R$ " + String.format("%.2f", saldo));
    }
}