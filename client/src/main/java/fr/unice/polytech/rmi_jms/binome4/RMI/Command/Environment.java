package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IServer;
import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;

import javax.jms.Connection;

public class Environment {
    public IServer server ;
    public IUser user;
    public Connection connection;

}
