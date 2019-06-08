package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
    String sayHello() throws RemoteException;
}
