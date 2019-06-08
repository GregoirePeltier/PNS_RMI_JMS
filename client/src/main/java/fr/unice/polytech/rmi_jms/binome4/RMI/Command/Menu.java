package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu extends Command {
    private List<Command> commands;

    public Menu(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    void run(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        System.out.println("You are in the "+name+" menu");
        System.out.println("type ? for available commands or q to leave");
        while(run){
            List<String> line = Arrays.asList(scanner.nextLine().split(" "));

            String commandName = line.get(0);
            if(commandName.equals("q") || commandName.equals("quit") || commandName.equals("exit")){
                run = false;
            }
            else if(commandName.equals("?")){
                displayHelp();
            }
            else {
                findCommand(commandName).run(line.subList(1,line.size()-1));
            }
        }
    }

    private void displayHelp() {


    }

    private Command findCommand(String commandName) {
        return commands.stream().filter(command -> command.name.equals(commandName)).findFirst().orElse(null);
    }
}
