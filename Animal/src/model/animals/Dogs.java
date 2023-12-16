package model.animals;

import java.time.LocalDate;

public class Dogs extends Animals{
    public Dogs(String name, LocalDate birth) {
        super(name, birth);
    }
    @Override
    public void say(){
        System.out.println("гав");
    }
}
