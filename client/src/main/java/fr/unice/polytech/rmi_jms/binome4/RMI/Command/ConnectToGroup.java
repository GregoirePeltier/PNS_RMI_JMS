package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.Messaging.GroupComunicator;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import java.rmi.RemoteException;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

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
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("org.apache.activemq.test,org.apache.camel.test,fr.unice.polytech.rmi_jms.binome4.RMI.Messaging,fr.unice.polytech.rmi_jms.binome4.RMI.Messaging.GroupMessage,java.lang.reflect.Proxy,java.rmi.server.RemoteObjectInvocationHandler,java.rmi.server.RemoteObject,fr.unice.polytech.rmi_jms.binome4.RMI,java.rmi.server.RemoteObjectInvocationHandler".split(","))));
        connectionFactory.setTrustAllPackages(true);
        try {
            Connection connection = connectionFactory.createConnection();
            GroupComunicator comunicator = new GroupComunicator(group, environment.user, connection);
            connection.start();
            boolean run = true;
            System.out.println("You are connected to the " + group.getName() + " group");
            System.out.println("You can leave at any time by typing /exit, /e, /quit or /q");
            System.out.println("Type a message directly in the console to speak to others connected to the channel");
            Scanner scanner = new Scanner(System.in);
            comunicator.subscribe();
            Set<String> exitCommands = new HashSet<String>();
            exitCommands.add("/exit");
            exitCommands.add("/e");
            exitCommands.add("/q");
            exitCommands.add("/quit");

            while (run) {
                String message = scanner.nextLine();
                if (exitCommands.contains(message))
                    run = false;
                else
                    comunicator.sendMessage(message);
            }
            comunicator.leave();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "JoinGroup";
    }

    @Override
    public String getDescription() {
        return "JoinGroup [GroupName] allow to join a discution group";
    }
}
