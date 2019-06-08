package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.Messaging.GroupComunicator;

import javax.jms.JMSException;
import java.rmi.RemoteException;
import java.util.List;

public class ConnectToGroup extends Command {
    public ConnectToGroup(Environment environment) {
        super(environment);
    }

    @Override
    void run(List<String> args) {
        String groupName = args.get(0);
        IGroup group = null;
        try {
            group = environment.server.getGroupByName(groupName);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            GroupComunicator comunicator = new GroupComunicator(group,environment.user,environment.connection);
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
