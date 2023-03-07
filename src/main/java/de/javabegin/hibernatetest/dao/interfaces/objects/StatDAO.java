package de.javabegin.hibernatetest.dao.interfaces.objects;

import de.javabegin.hibernatetest.entity.Stat;
import de.javabegin.hibernatetest.entity.User;

public interface StatDAO {
    //  получение статистики конкретного пользователя по емейл или по объетку
    Stat getByUser(String email);
    Stat getByUser(User user);

}
