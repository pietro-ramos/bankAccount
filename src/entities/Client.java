package entities;

import entities.Enum.ClientType;

public class Client {
    private String name;
    private String cpf;
    private ClientType clientType;

    public Client() {
    }

    public Client(String name, String cpf, ClientType clientType) {
        setName(name);
        setCpf(cpf);
        setClientType(clientType);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }
}
