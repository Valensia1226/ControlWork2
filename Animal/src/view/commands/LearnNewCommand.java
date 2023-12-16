package view.commands;

import view.ConsoleUI;

public class LearnNewCommand extends Command {
    public LearnNewCommand(ConsoleUI console) {
        super(console);
        description = "Обучить животное новой команде";
    }

    @Override
    public void execute() {
        console.learnNewCommand();
    }
}
