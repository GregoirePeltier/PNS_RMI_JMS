package fr.unice.polytech.rmi_jms.binome4.RMI.Command;

import java.util.*;

import static fr.unice.polytech.rmi_jms.binome4.RMI.Messaging.ColorCode.*;

public class Menu extends Command {
    private List<Command> commands;

    public Menu(List<Command> commands,String name, String description,Environment environment)
    {
        super(name,description,environment);
        this.commands = commands;
    }

    @Override
    void run(List<String> args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while(run){
            System.out.println("You are in the "+name+" menu");
            System.out.println("type ? for available commands or q to leave");
            List<String> line = Arrays.asList(scanner.nextLine().split(" "));

            String commandName = line.get(0);
            if(commandName.equals("q") || commandName.equals("quit") || commandName.equals("exit")){
                run = false;
            }
            else if(commandName.equals("?")){
                displayHelp();
            }
            else {

                List<String> args1 = new ArrayList<String>();
                if(line.size()>1)
                    args1 = line.subList(1, line.size());

                Command finalCommand = findCommand(commandName);
                if(finalCommand != null) {
                    finalCommand.run(args1);
                }else{
                    System.out.println("Commande non reconnue");
                }
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private void displayHelp() {
        System.out.println("Commands available in the menu are listed with ");
        System.out.println(ANSI_BLUE+"Command Name"+ANSI_RESET+": Description");
        System.out.println("Type the Command Name to trigger one of the command");
        for (Command command :
                commands) {
            System.out.println(ANSI_BLUE+command.getName()+ANSI_RESET + " : "+ command.getDescription());
        }
    }

    private Command findCommand(String commandName) {
        return commands.stream().filter(command -> command.getName().equals(commandName)).findFirst().orElse(null);
    }
}
