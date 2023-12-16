package model.save_in_file;

import java.io.IOException;
import java.io.Serializable;

public interface WriteAndRead<E extends Serializable> {
    void write(String path, E obj) throws IOException;
    Object read(String path) throws IOException, ClassNotFoundException;
}
