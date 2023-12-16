package view.commands;

import view.ConsoleUI;

public class StartNewProject extends Command {

    public StartNewProject(ConsoleUI console) {
        super(console);
        description = "Начать новый проект";
    }

    @Override
    public void execute() {
        console.startNewProject();
    }
}
