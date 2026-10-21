import java.util.ArrayList;

public class Banco {
    private String nome;
    private ArrayList<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    // Adiciona uma conta à lista
    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    // Busca uma conta pelo seu número
    public Conta buscarPorNumero(int numero) {
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    // Percorre e exibe cada conta cadastrada
    public void listarContas() {
        System.out.println("\n--- Lista de Contas do Banco " + nome + " ---");
        for (Conta c : contas) {
            c.exibir();
        }
    }

    // Calcula e retorna o saldo total acumulado de todas as contas
    public double saldoTotal() {
        double total = 0;
        for (Conta c : contas) {
            total += c.getSaldo();
        }
        return total;
    }
}