package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IGroup extends Remote {
    String getName() throws RemoteException;
    List<IUser> getUsers() throws RemoteException;
    void register(IUser user) throws RemoteException;
    void unRegister(IUser user) throws RemoteException;
}
