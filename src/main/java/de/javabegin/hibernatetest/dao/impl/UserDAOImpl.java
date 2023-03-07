/**
 * UserDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 04-Mar-2023 21:33
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.objects.UserDAO;
import de.javabegin.hibernatetest.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

   @Override
   public List<User> findAll() {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<User> query = session.createQuery("FROM User ", User.class);
      List<User> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public List<User> findAll(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<User> query = session.createQuery("From User u where u.email like :text", User.class);
      query.setParameter("text", "%" + email + "%");
      List<User> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public User get(long id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      User result = session.get(User.class, id);
      session.close();
      return result;
   }

   @Override
   public void update(User obj) {
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
      User user = new User();
      user.setId(id);
      session.remove(user);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void add(User obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.persist(obj);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public User getByEmail(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<User> query = session.createQuery("From User u where u.email like :text", User.class);
      query.setParameter("text", "%" + email + "%");
      User result = query.uniqueResult();
      session.close();
      return result;
   }
}
