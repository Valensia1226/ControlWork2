package view.commands;

import view.ConsoleUI;

public class FinishAfterWork extends Command{
    public FinishAfterWork(ConsoleUI console){
        super(console);
        description = "Завершить работу";
    }
    @Override
    public void execute() {
        console.finishAfterWork();
    }
}
