/**
 * Task.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 02-Mar-2023 23:16
 */

package de.javabegin.hibernatetest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;

@Entity
@Table(name = "task")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "id", nullable = false)
   private Long id;

   private String title;

   @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
   private boolean completed;

   @Column(name = "task_date")
   private Date taskDate;

   // Задача имеет только один приоритет, один приоритет имеет много задач
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "priority_id", referencedColumnName = "id")
   private Priority priority;

   // Задача может иметь только одну категорию. Одна катгеория может иметь много задач
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "category_id", referencedColumnName = "id")
   private Category category;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "user_id", referencedColumnName = "id")
   private User user;

   @Override
   public String toString() {
      return "Task{" +
              "id=" + id +
              ", title='" + title + '\'' +
              ", completed=" + completed +
              ", taskDate=" + taskDate +
              ", priority=" + priority +
              ", category=" + category +
              ", user=" + user +
              '}';
   }
}
