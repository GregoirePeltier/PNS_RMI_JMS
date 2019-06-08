package fr.unice.polytech.rmi_jms.binome4.RMI;

import fr.unice.polytech.rmi_jms.binome4.RMI.Command.Environment;
import fr.unice.polytech.rmi_jms.binome4.RMI.Command.MainMenu;
import org.apache.activemq.ActiveMQConnection;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Client{

    private Client() {}

    public static void main(String[] args) {
        Environment environement = new Environment();
        IServer d = null;
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            d = (IServer)reg.lookup("hello");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        if (d != null) {
            environement.server = d;
            MainMenu mainMenu = new MainMenu(environement);
            mainMenu.run();
        }
    }
}