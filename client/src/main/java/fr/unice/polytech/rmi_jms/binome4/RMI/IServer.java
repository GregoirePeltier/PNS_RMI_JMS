package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    void test() throws RemoteException;

    IGroup getGroupByName(String groupName);
}
