/**
 * TaskDAOImpl.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 05-Mar-2023 20:06
 */

package de.javabegin.hibernatetest.dao.impl;

import de.javabegin.hibernatetest.HibernateUtil;
import de.javabegin.hibernatetest.dao.interfaces.objects.TaskDAO;
import de.javabegin.hibernatetest.entity.Task;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {

   // поиск всех завершенных-незавершенных задач по конкретному пользователю
   @Override
   public List<Task> find(boolean completed, String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Task> query = session.createQuery("From Task t where t.user.email like :text and t.completed=:completed", Task.class);
      query.setParameter("text", "%" + email + "%");
      query.setParameter("completed", completed);
      List<Task> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public List<Task> findAll() {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Task> query = session.createQuery("FROM Task ", Task.class);
      List<Task> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public List<Task> findAll(String email) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Query<Task> query = session.createQuery("From Task t where t.user.email like :text", Task.class);
      query.setParameter("text", "%" + email + "%");
      List<Task> list = query.getResultList();
      session.close();
      return list;
   }

   @Override
   public Task get(long id) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Task result = session.get(Task.class, id);
      session.close();
      return result;
   }

   @Override
   public void update(Task obj) {
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
      Task task = new Task();
      task.setId(id);
      session.remove(task);
      session.getTransaction().commit();
      session.close();
   }

   @Override
   public void add(Task obj) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      session.beginTransaction();
      session.persist(obj);
      session.getTransaction().commit();
      session.close();
   }


}
