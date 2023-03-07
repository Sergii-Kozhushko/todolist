package de.javabegin.hibernatetest.dao.interfaces;

/*
Основные операции для всех entity-объектов:
CRUD: Create, Read, Update, Delete
 */
public interface CommonDAO<T> {
    //  получить все значения


    // получить одно значние по айди
    T get(long id);

    // обновить
    void update(T obj);

    void delete(long id);

    void add(T obj);
}
