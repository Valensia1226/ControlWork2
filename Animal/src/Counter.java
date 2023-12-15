import java.time.LocalDate;

public class Counter implements AutoCloseable {
    private int count = 0;
    public void add(boolean flag){
        if (flag) count ++;
        else throw new RuntimeException("Не хватает данных");
    }

    @Override
    public void close() throws Exception {

    }
}
