package model.commands;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    private List<Commands> commandList;
    public CommandList(){
        commandList = new ArrayList<>();
        commandList.add(new Voice());
        commandList.add(new GiveMeYourPaw());

    }
    public String getList(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commandList.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    public int getSize(){
        return commandList.size();
    }

    public List<Commands> getCommandList() {
        return commandList;
    }

    public void setCommandList(List<Commands> commandList) {
        this.commandList = commandList;
    }
}
