/**
 * HibernateUtil.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 08-Feb-2023 21:41
 */
package de.javabegin.hibernatetest;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
   private static final SessionFactory sessionFactory = buildSessionFactory();

   //Метод вызывает
   private static SessionFactory buildSessionFactory(){
      try {
         return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
      }
      catch (Throwable ex){
         System.err.println("Initial SessionFactory creation failed," + ex);
         throw new ExceptionInInitializerError(ex);
      }
   }

   public static SessionFactory getSessionFactory(){
      if (sessionFactory == null) buildSessionFactory();
      return sessionFactory;
   }

   public static void close(){
      getSessionFactory().close();
   }

}
