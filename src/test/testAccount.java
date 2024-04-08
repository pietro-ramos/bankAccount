package test;

import entities.Account;
import entities.Client;
import entities.Enum.ClientType;

public class testAccount {

    public static void main(String[] args) {
        // Onde o resultado for de sucesso deixa sem comentário para poder testar as linhas seguintes

        /* -------------- TESTE 1 -------------- */
        Client cli = new Client("Ana", "070.670.480-01", ClientType.PRATA);
        Account c1 = null;
        try {
            // c1 = new Account (100, 3526, -100, "abc", cli); // Saldo não pode ser negativo
            // c1 = new Account (100, 0, 200, "abc", cli); // Numero da conta deve ser positivo
            // c1 = new Account (0, 3526, 200, "abc", cli); // Numero da agencia deve ser positivo
            // c1 = new Account (100, 3526, 200, "abc", null); // Cliente não pode ser nulo
            // c1 = new Account (100, 3526, 200, null, cli); // Senha não pode ser nula ou vazia
            // c1 = new Account (100, 3526, 200, "", cli); // Senha não pode ser nula ou vazia
            c1 = new Account(cli, 100, 3526, 200.00, "Abc", cli.getClientType()); // Sucesso!

        } catch (IllegalArgumentException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("erro desconhecido!");
        }

        /* -------------- TESTE 2 -------------- */
        Account c2 = null;
        try {
            Client cli2 = new Client("Maria", "260.733.450-03", ClientType.OURO);
            c2 = new Account(cli2, 100, 3526, 200.00, "abc", cli2.getClientType());

            // double saldo = c1.creditar(-100); // Valor a ser creditado deve ser maior ou igual a zero
            // double saldo = c1.creditar(0); // Valor a ser creditado deve ser maior ou igual a zero
            c1.withdraw(100);
            System.out.println("Saldo resultante = " + c1.getBalance()); // Saldo = 300
        } catch (IllegalArgumentException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }

        /* -------------- TESTE 3 -------------- */
        try {
            // double saldo2 = c1.debitar(-100); // Valor a ser debitado deve ser maior ou igual a zero
            // double saldo2 = c1.debitar(0); // Valor a ser debitado deve ser maior ou igual a zero
            c1.withdraw(100); // Sucesso!
            // System.out.println("Saldo resultante = " + saldo2); // Saldo = 100
        } catch (IllegalArgumentException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
    }
}
