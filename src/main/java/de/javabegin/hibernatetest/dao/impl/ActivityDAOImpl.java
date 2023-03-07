/**
 * ActivityDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 06-Mar-2023 14:25
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.objects.ActivityDAO;
import de.javabegin.hibernatetest.entity.Activity;
import de.javabegin.hibernatetest.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class ActivityDAOImpl implements ActivityDAO {


   @Override
   public Activity get(long id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Activity result = session.get(Activity.class, id);
      session.close();
      return result;
   }

   @Override
   public void update(Activity obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      obj = session.merge(obj);
      session.persist(obj);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void delete(long id) {
      throw new IllegalStateException("You can not delete activity by yourself, only DB can");
   }

   @Override
   public void add(Activity obj) {
      throw new IllegalStateException("You can not add activity by yourself, only DB-trigger can");
   }

   @Override
   public Activity getByUser(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Activity> query = session.createQuery("From Activity a where a.user.email like :text", Activity.class);
      query.setParameter("text", "%" + email + "%");
      Activity result = query.uniqueResult();
      session.close();
      return result;
   }

   @Override
   public Activity getByUser(User user) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Activity> query = session.createQuery("From Activity a where a.user.email like :text", Activity.class);
      query.setParameter("text", "%" + user.getEmail() + "%");
      Activity result = query.uniqueResult();
      session.close();
      return result;
   }

}
