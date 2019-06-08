package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServer extends Remote {
    void test() throws RemoteException;

    IUser login(String username, String mdp)throws RemoteException;
    IGroup getGroupByName(String groupName) throws RemoteException;

    List<Group> getGroups() throws RemoteException;

}
