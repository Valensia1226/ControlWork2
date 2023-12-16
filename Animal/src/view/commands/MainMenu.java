package view.commands;

import view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;
    ConsoleUI consoleUI;
    public MainMenu(ConsoleUI console){
        this.consoleUI = console;
        commandList = new ArrayList<>();
        commandList.add(new AddNewAnimal(consoleUI)); //Завести новое животное
        commandList.add(new PetCommand(consoleUI));//Показать список команд, которые выполняет животное
        commandList.add(new LearnNewCommand(consoleUI)); //Обучить животное новой команде
        commandList.add(new ReturnToFirstMenu(consoleUI)); //Вернуться к статовому меню
        commandList.add(new FinishAfterWork(consoleUI)); //Завершение работы
    }
    public String getMenu(){
        StringBuilder sb = new StringBuilder("Выберите действие:\n");
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void execute(int choice){
        Command command = commandList.get(choice - 1);
        command.execute();
    }
    public int getSize(){
        return commandList.size();
    }
}
