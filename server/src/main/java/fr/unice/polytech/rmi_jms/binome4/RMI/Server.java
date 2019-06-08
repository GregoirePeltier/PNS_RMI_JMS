package fr.unice.polytech.rmi_jms.binome4.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer {


    private List<User> users = new ArrayList<User>();
    private List<Group> groups = new ArrayList<Group>();


    public Server() throws RemoteException {
        User u1 = new User("Greg");
        User u2 = new User("Francois");
        User u3 = new User("Alexandre");
        User u4 = new User("Coline");
        User u5 = new User("Camille");
        User u6 = new User("Agathe");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);
        users.add(u6);
        List<IUser> groupUsers = new ArrayList<>();
        groupUsers.add(u5);
        groups.add(new Group("test", groupUsers));
    }


    @Override
    public void test() throws RemoteException{
        System.out.println("Yolo");
    }

    @Override
    public IUser login(String username, String mdp) throws RemoteException {
        System.out.println(username);
        System.out.println(users.size());
        for(User u : users){
            if(u.getName().equals(username)) {
                System.out.println(username + " connecté");

                System.out.println("Groupes disponible :");

                return new User(username);
            }
        }
        return null;
    }
    @Override
    public IGroup getGroupByName(String groupName) throws RemoteException{
        return null;
    }

    @Override
    public List<Group> getGroups() throws RemoteException {
        return groups;
    }
}
