package de.javabegin.hibernatetest.dao.interfaces;

import java.util.List;

public interface FindDAO <T>{
    List<T> findAll();

    // получить все значения по фильтру почты
    List<T> findAll(String email);
}
