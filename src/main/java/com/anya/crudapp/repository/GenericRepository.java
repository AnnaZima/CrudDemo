package com.anya.crudapp.repository;

import com.anya.crudapp.model.Label;

import java.util.List;

public interface GenericRepository<T, ID> {
    T get(ID id);

    void delete(ID id);

    T update(T newObject);

    T insert(T obj);

    List<T> getAll();

    ID generateID(List<T> listT);


}
