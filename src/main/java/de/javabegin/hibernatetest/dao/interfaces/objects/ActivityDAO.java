package de.javabegin.hibernatetest.dao.interfaces.objects;

import de.javabegin.hibernatetest.dao.interfaces.CommonDAO;
import de.javabegin.hibernatetest.entity.Activity;
import de.javabegin.hibernatetest.entity.User;

public interface ActivityDAO extends CommonDAO<Activity>{

    // Получение активности пользователя несколькиими способами
    Activity getByUser(String email);
    Activity getByUser(User user);
}
