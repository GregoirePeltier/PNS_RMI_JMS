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

        MainMenu mainMenu = new MainMenu(environement);
        mainMenu.run();
        try {
            Registry reg = LocateRegistry.getRegistry(2001);
            IServer d = (IServer)reg.lookup("hello");
            d.test();
            IUser user = d.login("Camille","1");
            System.out.println("Bienvenue " + user.getName());
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}