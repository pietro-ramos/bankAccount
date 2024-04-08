package test;

import entities.Client;
import entities.Enum.ClientType;

public class testClient {

    public static void main(String[] args) {

        try {
            // Cliente cli1 = new Cliente(null, "070.670.480-01");
            Client cli2 = new Client("Ana", null, ClientType.PRATA);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
