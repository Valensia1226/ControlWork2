import animals.Cats;
import animals.Dogs;
import animals.Hamster;

import java.time.LocalDate;
import java.util.List;

public class Registry {
    List<Cats> catsList;
    List<Dogs> dogsList;
    List<Hamster> hamsterList;
    public void addNewAnimal(String name, LocalDate birth) throws Exception {
        boolean flag;
        if (name != null && birth != null) flag = true;
        else flag = false;
        try (Counter counter = new Counter()){
            counter.add(flag);
        }
    }

}

