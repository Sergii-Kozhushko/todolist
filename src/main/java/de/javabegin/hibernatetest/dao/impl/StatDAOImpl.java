/**
 * StatDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 06-Mar-2023 14:05
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.objects.StatDAO;
import de.javabegin.hibernatetest.entity.Stat;
import de.javabegin.hibernatetest.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StatDAOImpl implements StatDAO {


   @Override
   public Stat getByUser(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Stat> query = session.createQuery("From Stat s where s.user.email like :text", Stat.class);
      query.setParameter("text", "%" + email + "%");
      Stat result = query.uniqueResult();
      session.close();
      return result;
   }

   @Override
   public Stat getByUser(User user) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Stat> query = session.createQuery("From Stat s where s.user.email like :text", Stat.class);
      query.setParameter("text", "%" + user.getEmail() + "%");
      Stat result = query.uniqueResult();
      session.close();
      return result;
   }
}
