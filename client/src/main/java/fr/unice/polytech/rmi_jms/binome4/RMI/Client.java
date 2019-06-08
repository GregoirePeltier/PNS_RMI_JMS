package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost",2001);
            IClient stub = (IClient) registry.lookup("hello");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}