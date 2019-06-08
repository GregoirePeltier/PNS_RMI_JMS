package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.List;

/**
 * Command Enumeration
 */
public abstract class Command {
    String name;
    String description;
    abstract void run(List<String> args);

}
