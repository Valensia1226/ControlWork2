package model.animals;

import model.commands.CommandList;
import model.commands.Commands;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animals {
    private String name;
    private LocalDate birth;
    private List<Commands> commands;

    public Animals(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
        this.commands = new ArrayList<>();
    }
    public void say(){

    }

    public String getList(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "name='" + name + ',' + "birth=" + birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public List<Commands> getCommands() {
        return commands;
    }

    public void setCommands(List<Commands> commands) {
        this.commands = commands;
    }
}
