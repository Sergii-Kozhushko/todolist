/**
 * PriorityDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 06-Mar-2023 14:19
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.objects.PriorityDAO;
import de.javabegin.hibernatetest.entity.Priority;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PriorityDAOImpl implements PriorityDAO {

    @Override
    public List<Priority> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("FROM Priority ", Priority.class);
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Priority> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Priority> query = session.createQuery("From Priority c where c.user.email like :text", Priority.class);
        query.setParameter("text", "%" + email + "%");
        List<Priority> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Priority get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Priority result = session.get(Priority.class, id);
        session.close();
        return result;
    }

    @Override
    public void update(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        obj = session.merge(obj);
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Priority category = new Priority();
        category.setId(id);
        session.remove(category);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Priority obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
        session.close();
    }
}
