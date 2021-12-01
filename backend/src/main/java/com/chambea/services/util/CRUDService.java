package com.chambea.services.util;

import java.util.List;

public interface CRUDService <T, ID> {

    T create(T object);
    List<T> getAll();
    T get(ID id);
    T update(T object);
    void delete(ID id);

}
