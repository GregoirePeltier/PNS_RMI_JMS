package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

    public static void main(String args[]) throws Exception{

        try {
            IServer test = new Server(1001);
            Registry reg= LocateRegistry.createRegistry(2001);
            reg.rebind("hello",test);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
