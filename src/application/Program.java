package application;

import java.util.Scanner;

import entities.Account;
import entities.Client;
import entities.CompanyAccount;
import entities.Enum.ClientType;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = null;
        CompanyAccount companyAccount = null;

        System.out.println("Enter client details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Client Type (PRATA / BRONZE / OURO / DIAMANTE): ");
        String clientTypeStr = sc.nextLine();
        ClientType clientType = ClientType.valueOf(clientTypeStr.toUpperCase());

        Client client = new Client(name, cpf, clientType);

        System.out.println("\nEnter account details:");
        System.out.print("Agency: ");
        int agency = sc.nextInt();
        sc.nextLine();
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        try {
            account = new Account(client, agency, number, balance, password, clientType);

            System.out.print("\nEnter deposit amount: ");
            double depositAmount = sc.nextDouble();
            account.deposit(depositAmount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }

        System.out.println("\nEnter company account details:");
        System.out.print("Loan limit: ");
        double loanLimit = sc.nextDouble();
        sc.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = sc.nextLine();
        System.out.print("Company Name: ");
        String companyName = sc.nextLine();

        try {
            companyAccount = new CompanyAccount(client, agency, number, balance, password, loanLimit, cnpj, companyName, clientType);

            System.out.print("\nEnter loan amount: ");
            double loanAmount = sc.nextDouble();
            sc.nextLine();
            companyAccount.addLoan(loanAmount);
            System.out.println("Loan added successfully. New loan amount: " + companyAccount.getLoan());
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating company account: " + e.getMessage());
        }

        System.out.println(account);
        System.out.println();
        System.out.println(companyAccount);
        
        sc.close();
    }

}
