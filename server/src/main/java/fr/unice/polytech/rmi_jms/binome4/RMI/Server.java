package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer {


    private List<User> users = new ArrayList<User>();


    public Server() throws RemoteException {
        users.add(new User("Greg"));
        users.add(new User("Francois"));
        users.add(new User("Alexandre"));
        users.add(new User("Coline"));
        users.add(new User("Camille"));
        users.add(new User("Agathe"));
    }


    @Override
    public void test() {
        System.out.println("Yolo");
    }

    @Override
    public IUser login(String username, String mdp) throws RemoteException {
        System.out.println(username);
        System.out.println(users.size());
        for(User u : users){
            if(u.getName().equals(username)) {
                System.out.println(username + " connecté");
                return new User(username);
            }
        }
        return null;
    }
}
