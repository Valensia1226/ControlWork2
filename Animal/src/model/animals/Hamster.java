package model.animals;

import java.time.LocalDate;

public class Hamster extends Animals{

    public Hamster(String name, LocalDate birth) {
        super(name, birth);
    }
    @Override
    public void say(){
        System.out.println("хз как говорят хомяки");
    }
}
