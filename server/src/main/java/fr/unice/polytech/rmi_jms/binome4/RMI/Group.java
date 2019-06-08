package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Group extends UnicastRemoteObject implements IGroup{
    private final String name;
    List<IUser> subscribed_user;

    public Group(String name, List<IUser> users) throws RemoteException{
        this.name = name;
        this.subscribed_user = users;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public List<IUser> getUsers() throws RemoteException {
        return subscribed_user;
    }

    @Override
    public void register(IUser user) throws RemoteException {

    }

    @Override
    public void unRegister(IUser user) throws RemoteException {

    }
}
