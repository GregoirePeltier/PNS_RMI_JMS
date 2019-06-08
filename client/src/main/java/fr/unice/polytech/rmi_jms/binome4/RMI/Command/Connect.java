package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;
import java.rmi.RemoteException;
import java.util.List;

public class Connect extends Command {
    public Connect(Environment environment) {
        super(environment);
    }

    @Override
    void run(List<String> args) {
        if(args.size() == 2) {
            String username = args.get(0);
            String mdp = args.get(1);
            IUser user;
            try {
                user = environment.server.login(username, mdp);
                environment.user = user;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Pour se connecter veuillez entrer votre nom d'utilisateur suivi de votre mot de passe.");
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
