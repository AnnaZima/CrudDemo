package repository;

import java.io.IOException;
import java.util.List;

public interface GenericRepository<T, ID> {
    T get(ID id) throws IOException;

    void delete(ID id) throws IOException;

    void update(ID id, T newObject) throws IOException;

    void insert(T obj) throws IOException;

    List<T> getAll() throws IOException;


}
