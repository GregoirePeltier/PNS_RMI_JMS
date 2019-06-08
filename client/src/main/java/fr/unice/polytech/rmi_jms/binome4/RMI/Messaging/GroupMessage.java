package fr.unice.polytech.rmi_jms.binome4.RMI.Messaging;

import fr.unice.polytech.rmi_jms.binome4.RMI.IUser;

import java.awt.color.ColorSpace;
import java.io.Serializable;
import java.rmi.RemoteException;

import static fr.unice.polytech.rmi_jms.binome4.RMI.Messaging.ColorCode.ANSI_RESET;

public class GroupMessage implements Serializable {
    String content;
    IUser author;

    public GroupMessage(String content, IUser author) {
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        try {
            return ColorCode.ANSI_BLUE +author.getName() + ANSI_RESET + " : " + content;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
