package entities;

import entities.Enum.ClientType;

public class Account extends Client {
    private Integer agency;
    private Integer number;
    private Double balance;
    private String password;

    public Account(ClientType clientType, String name, String cpf, Integer agency, Integer number, Double balance, String password) {
        super(name, cpf, clientType);
        setAgency(agency);
        setNumber(number);
        setBalance(balance);
        setPassword(password);
    }

    
    
    public Integer getAgency() {
        return agency;
    }

    private void setAgency(Integer agency) throws IllegalArgumentException {
        if (agency <= 0) {
            throw new IllegalArgumentException("Agency can't be negative");
        }
        this.agency = agency;
    }

    public Integer getNumber() {
        return number;
    }

    private void setNumber(Integer number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("Number can't be negative");
        }
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    private void setBalance(Double balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance can't be negative");
        }
        this.balance = balance;
    }

    private boolean isEmpty() {
        return balance <= 0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive for deposit");
        }
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive for withdraw");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Insufficient funds for withdraw");
        }
        if (balance - amount < 0) {
            throw new IllegalStateException("Insufficient funds for withdraw");
        }
        setBalance(getBalance() - amount);
    }

    @Override
    public String toString() {
        return "Account owner: " +
                getName() +
                ", Agency: " +
                getAgency() +
                ", Number: " +
                getNumber() +
                ", Balance: " +
                String.format("R$ %.2f", getBalance());
    }
}