package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote, Serializable {
    String getName() throws RemoteException;
}
