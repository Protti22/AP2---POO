
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO AP2 ===\n");

        // Criar um Banco
        Banco banco = new Banco("Banco Central AP2");

        // Criar uma conta de cada tipo
        Conta contaComum = new Conta(101, "Ana Silva");
        ContaPoupanca contaPoupanca = new ContaPoupanca(102, "Carlos Oliveira", 0.05); // 5% de taxa
        ContaCorrente contaCorrente = new ContaCorrente(103, "Mariana Souza", 500.0); // R$ 500 de limite

        // Adicionar as três contas ao banco
        banco.adicionarConta(contaComum);
        banco.adicionarConta(contaPoupanca);
        banco.adicionarConta(contaCorrente);

        // Fazer alguns depósitos e saques
        System.out.println("--- Depósitos e Saques Iniciais ---");
        contaComum.depositar(200.0);
        contaPoupanca.depositar(1000.0);
        contaCorrente.depositar(300.0);

        boolean saqueComumSucesso = contaComum.sacar(50.0);
        System.out.println("Saque de R$ 50,00 na Conta Comum realizado? " + saqueComumSucesso);

        // falha por saldo insuficiente
        System.out.println("\n--- Teste de Saque com Saldo Insuficiente ---");
        boolean saqueFalhou = contaComum.sacar(500.0); // Saldo atual é R$ 150.0
        System.out.println("Tentativa de saque de R$ 500,00 na Conta Comum deu certo? " + saqueFalhou);

        // Aplicar rendimento na poupança e mostrar saldo antes e depois
        System.out.println("\n--- Aplicando Rendimento na Poupança ---");
        System.out.println("Saldo da Poupança ANTES do rendimento: R$ " + contaPoupanca.getSaldo());
        contaPoupanca.aplicarRendimento();
        System.out.println("Saldo da Poupança DEPOIS do rendimento (5%): R$ " + contaPoupanca.getSaldo());

        // Sacar usando o limite na conta corrente (saldo fica negativo)
        System.out.println("\n--- Saque com Limite na Conta Corrente ---");
        System.out.println("Saldo da Conta Corrente antes: R$ " + contaCorrente.getSaldo());
        boolean saqueLimiteSucesso = contaCorrente.sacarComLimite(600.0); // Possui R$ 300 de saldo + R$ 500 de limite
        System.out.println("Saque de R$ 600,00 realizado usando limite? " + saqueLimiteSucesso);
        System.out.println("Saldo da Conta Corrente depois (deve ser negativo): R$ " + contaCorrente.getSaldo());

        // Listar todas as contas e imprimir o saldo total do banco
        System.out.println("\n--- Listagem Final e Saldo Total ---");
        banco.listarContas();
        System.out.println("\nSaldo Total no Banco: R$ " + String.format("%.2f", banco.saldoTotal()));
    }
}