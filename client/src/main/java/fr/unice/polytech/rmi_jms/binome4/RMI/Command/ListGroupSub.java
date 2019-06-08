package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;

import java.rmi.RemoteException;
import java.util.List;

public class ListGroupSub extends Command{
    public ListGroupSub(Environment environment) {
        super(environment);
    }

    @Override
    void run(List<String> args) {
        if(environment.user != null){
            try{
                System.out.println("Groupes auxquels vous etes abonné :");
                for (IGroup g : environment.server.getGroups()){
                    for (IUser u : g.getUsers()){
                        if(u.getName().equals(environment.user.getName())){
                            System.out.println(g.getName());
                        }
                    }
                }
            }catch (RemoteException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Vous devez etre connecté");
        }

    }

    @Override
    public String getName() {
        return "ListGroupSub";
    }

    @Override
    public String getDescription() {
        return "Liste les groupes auxquels l'utilisateur est abonné. Vous devez etre connecté.";
    }
}
