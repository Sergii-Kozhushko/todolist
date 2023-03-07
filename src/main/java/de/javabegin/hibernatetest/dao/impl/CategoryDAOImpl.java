/**
 * CategoryDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 05-Mar-2023 22:24
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.CommonDAO;
import de.javabegin.hibernatetest.dao.interfaces.FindDAO;
import de.javabegin.hibernatetest.entity.Category;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDAOImpl implements CommonDAO<Category>, FindDAO<Category> {

   @Override
   public List<Category> findAll() {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Category> query = session.createQuery("FROM Category ", Category.class);
      List<Category> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public List<Category> findAll(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Category> query = session.createQuery("From Category c where c.user.email like :text", Category.class);
      query.setParameter("text", "%" + email + "%");
      List<Category> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public Category get(long id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Category result = session.get(Category.class, id);
      session.close();
      return result;
   }

   @Override
   public void update(Category obj) {
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
      Category category = new Category();
      category.setId(id);
      session.remove(category);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void add(Category obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.persist(obj);
      session.getTransaction().commit();
      session.close();
   }

}
