package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IGroup;
import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;

import java.rmi.RemoteException;
import java.util.List;

public class ListGroup extends Command{
    public ListGroup(Environment environment) {
        super(environment);
    }

    @Override
    void run(List<String> args) {
        if(environment.user != null){
            try{
                System.out.println("Groupes disponibles :");
                for (IGroup g : environment.server.getGroups()){
                    System.out.println(g.getName());
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
        return "ListGroup";
    }

    @Override
    public String getDescription() {
        return "Liste les groupes existants sur le serveur. Vous devez etre connecté.";
    }
}
