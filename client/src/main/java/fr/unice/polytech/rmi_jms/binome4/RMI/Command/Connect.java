package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;

import java.rmi.RemoteException;
import java.util.List;

public class Connect extends Command {
    public Connect(Environment environment) {
        super(environment);
    }

    @Override
    void run(List<String> args) {
        String username = args.get(0);
        String mdp = args.get(1);
        IUser user;
        try {
            user = environment.server.login(username, mdp);
            System.out.println(user.getName() + " connecté !");
            System.out.println("Groupes disponibles :");
            for (IGroup g : environment.server.getGroups()){
                System.out.println(g.getName());
            }
            System.out.println("Groupes auxquels vous etes abonné :");
            for (IGroup g : environment.server.getGroups()){
                for (IUser u : g.getUsers()){
                    if(u.getName().equals(user.getName())){
                        System.out.println(g.getName());
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "Connect";
    }

    @Override
    public String getDescription() {
        return null;
    }
}
