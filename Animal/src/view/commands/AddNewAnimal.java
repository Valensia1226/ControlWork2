package view.commands;

import view.ConsoleUI;

public class AddNewAnimal extends Command {
    public AddNewAnimal(ConsoleUI console) {
        super(console);
        description = "Завести новое животное";
    }
    @Override
    public void execute() {
        console.addNewAnimal();
    }
}
