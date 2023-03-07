package de.javabegin.hibernatetest.dao.interfaces.objects;

import de.javabegin.hibernatetest.dao.interfaces.CommonDAO;
import de.javabegin.hibernatetest.dao.interfaces.FindDAO;
import de.javabegin.hibernatetest.entity.Category;

public interface CategoryDAO extends CommonDAO<Category>, FindDAO<Category> {
    //find(Long userID)
}
