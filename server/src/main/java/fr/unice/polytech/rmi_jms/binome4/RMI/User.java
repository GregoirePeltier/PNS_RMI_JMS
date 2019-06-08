package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject implements IUser {
    private final String username;


    public User(String username) throws RemoteException {
        this.username = username;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return username;
    }
}
