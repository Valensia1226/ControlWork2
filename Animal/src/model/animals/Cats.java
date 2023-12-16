package model.animals;

import java.io.Console;
import java.time.LocalDate;

public class Cats extends Animals{

    public Cats(String name, LocalDate birth) {
        super(name, birth);
    }

    @Override
    public void say(){
        System.out.println("мяу");
    }


}
