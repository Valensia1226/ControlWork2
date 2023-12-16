package view.commands;

import view.ConsoleUI;

public class PetCommand extends Command {
    public PetCommand(ConsoleUI console) {
        super(console);
        description = "Покажи список команд, которые выполняет животное";
    }
    public void execute(){
        console.petCommand();
    }

}
