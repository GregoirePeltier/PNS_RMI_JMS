package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainMenu extends Menu{


    public MainMenu(Environment environment) {

        super(Arrays.asList(
                new ConnectToGroup(environment)
        ),"Main Menu","Center of the application",environment);
    }


    public void run() {
        super.run(new ArrayList<>());
    }
}
