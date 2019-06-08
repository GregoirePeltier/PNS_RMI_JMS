package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote{

    String getName()throws RemoteException;

}
