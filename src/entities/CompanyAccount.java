package entities;

import entities.Enum.ClientType;

public class CompanyAccount extends Account {
    private Double loan;
    private Double loanLimit;
    private String cnpj;
    private String companyName;
    
    public String getCnpj() {
        return cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyAccount(Client owner, Integer agency, Integer number, Double balance, String password,
            Double loanLimit, String cnpj, String companyName, ClientType clientType) throws IllegalArgumentException {
        super(clientType, owner.getName(), owner.getCpf(), agency, number, balance, password);
        setLoanLimit(loanLimit);
        this.loan = 0.0;
        this.cnpj = cnpj;
        this.companyName = companyName;
    }
    
    public Double getLoanLimit() {
        return loanLimit;
    }

    private void setLoanLimit(Double loanLimit) {
        if (loanLimit < 0) {
            throw new IllegalArgumentException("Loan limit can't be negative");
        }
        this.loanLimit = loanLimit;
    }

    public Double getLoan() {
        return loan;
    }

    private boolean setLoan(Double loan) {
        if (loan < 0) {
            throw new IllegalArgumentException("Loan amount can't be negative");
        } else if (loan > getLoanLimit()) {
            throw new IllegalArgumentException("Exceeded loan limit");
        } else {
            this.loan = loan;
            return true;
        }
    }

    public boolean addLoan(Double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount must be positive");
        }
        Double newLoan = getLoan() + loanAmount;

        try {
            return setLoan(newLoan);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    @Override
    public String toString() {
        return "Account owner: " +
                getName() +
                ", Company Name: " +
                getCompanyName() +
                ", CNPJ: " +
                getCnpj() +
                ", Agency: " +
                getAgency() +
                ", Number: " +
                getNumber() +
                ", Balance: " +
                String.format("R$ %.2f", getBalance()) +
                ", Loan: " +
                String.format("R$ %.2f", getLoan());
    }
}
