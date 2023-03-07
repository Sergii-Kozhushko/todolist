package de.javabegin.hibernatetest.dao.interfaces.objects;

import de.javabegin.hibernatetest.dao.interfaces.CommonDAO;
import de.javabegin.hibernatetest.dao.interfaces.FindDAO;
import de.javabegin.hibernatetest.entity.Task;

import java.util.List;

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {

    //поиск всех завершенных, незавершенных задач пользоватедя
    List<Task> find(boolean completed, String email);
}
