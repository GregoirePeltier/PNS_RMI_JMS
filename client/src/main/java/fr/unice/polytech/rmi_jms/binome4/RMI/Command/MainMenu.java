package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu{


    public MainMenu() {

        super(Arrays.asList(
                new EchoCommand("Hello")
        ));
    }
}
