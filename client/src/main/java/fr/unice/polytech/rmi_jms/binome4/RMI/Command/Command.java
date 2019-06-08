package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.List;

/**
 * Command Enumeration
 */
public abstract class Command {
    String name;
    String description;
    Environment environment;
    abstract void run(List<String> args);

    public Command(Environment environment) {
        this.environment = environment;
    }

    public Command(String name, String description,Environment environment) {
        this.name = name;
        this.description = description;
        this.environment = environment;
    }

    abstract public String getName();

    abstract public String getDescription() ;
}
