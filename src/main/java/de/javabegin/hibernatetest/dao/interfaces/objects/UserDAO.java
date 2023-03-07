package de.javabegin.hibernatetest.dao.interfaces.objects;

import de.javabegin.hibernatetest.dao.interfaces.CommonDAO;
import de.javabegin.hibernatetest.dao.interfaces.FindDAO;
import de.javabegin.hibernatetest.entity.User;

public interface UserDAO extends CommonDAO<User>, FindDAO<User> {
    User getByEmail(String email);
}
