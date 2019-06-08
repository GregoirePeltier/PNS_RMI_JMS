package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IServer {


    Server(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void test() {
        System.out.println("Yolo");
    }
}
