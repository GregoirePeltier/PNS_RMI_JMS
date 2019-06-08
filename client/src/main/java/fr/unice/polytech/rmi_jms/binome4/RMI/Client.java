package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client{

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            IServer d = (IServer)reg.lookup("hello");
            d.test();
            System.out.println("Après appel à test");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}