package animals;

import commands.Commands;

import java.time.LocalDate;
import java.util.List;

public abstract class Animals {
    String name;
    LocalDate birth;
    List<Commands> commands;

    public Animals(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }
}
