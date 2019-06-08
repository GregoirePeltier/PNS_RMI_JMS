package fr.unice.polytech.rmi_jms.binome_4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {


    public Server() throws RemoteException {
    }


    @Override
    public void test() {
        System.out.println("Yolo");
    }
}
