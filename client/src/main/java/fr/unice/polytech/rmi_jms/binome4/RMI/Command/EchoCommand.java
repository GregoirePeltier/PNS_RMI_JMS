package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.List;

public class EchoCommand extends Command {
    String value;

    public EchoCommand(String value) {
        this.value = value;
    }

    @Override
    void run(List<String> args) {
        System.out.println(value);
    }
}
